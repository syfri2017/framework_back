package com.syfri.portalservice.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2019/5/6 13:10
 */
public class DownloadUtil {
    public static void download(HttpServletRequest request, HttpServletResponse response, String path,String fileName){
        BufferedInputStream bis=null;
        OutputStream os=null;
        try {
            File file=new File(path);
            String ext=fileName.substring(fileName.lastIndexOf(".")+1);
            String agent=(String)request.getHeader("USER-AGENT"); //判断浏览器类型
            if(agent!=null && (agent.indexOf("Fireforx")!=-1||agent.indexOf("Firefox")!=-1)) {
                fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");   //UTF-8编码，防止输出文件名乱码
            }
            else {
                fileName= URLEncoder.encode(fileName,"UTF-8");
            }
            response.reset();
            response.setCharacterEncoding("utf-8");
            if(ext=="docx"||ext=="doc") {
                response.setContentType("application/msword"); // word格式
            }else if(ext=="pdf") {
                response.setContentType("application/pdf"); // word格式
            }else if(ext=="xls") {
                response.setContentType("application/vnd.ms-excel"); // xls格式
            }else if(ext=="ppt") {
                response.setContentType("application/vnd.ms-powerpoint"); // ppt格式
            }else if(ext=="zip") {
                response.setContentType("application/x-zip-compressed"); // zip
            }else if(ext=="rar") {
                response.setContentType("application/octet-stream "); // rar
            }
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            bis=new BufferedInputStream(new FileInputStream(file));
            byte[] b=new byte[bis.available()+1000];
            int i=0;
            os = response.getOutputStream();   //直接下载导出
            while((i=bis.read(b))!=-1) {
                os.write(b, 0, i);
            }
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
