package com.syfri.userservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.config.properties.CpjsProperties;
import com.syfri.userservice.utils.Base64ImageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.prediction.QycpjsVO;
import com.syfri.userservice.service.prediction.QycpjsService;
import com.syfri.baseapi.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("qycpjs")
public class QycpjsController extends BaseController<QycpjsVO> {

    @Autowired
    private QycpjsService qycpjsService;

    @Override
    public QycpjsService getBaseService() {
        return this.qycpjsService;
    }

    @Autowired
    private CpjsProperties cpjsProperties;

    /**
     * @Description: 根据企业id获取产品信息
     * @Author: rliu
     * @Date: 2018/10/9 10:35
     */
    @ApiOperation(value = "根据企业id获取产品信息", notes = "vo")
    @RequestMapping("/doFindCpxxById")
    public @ResponseBody ResultVO doFindCpxxById(@RequestBody QycpjsVO qycpjsVO) {
        ResultVO resultVO = ResultVO.build();
        try {
            List<QycpjsVO> result = qycpjsService.doSearchListByVO(qycpjsVO);
            for(QycpjsVO vo:result) {
                //将二进制转为Base64格式字符串
                String photo64 = Base64ImageUtil.byteArr2String(vo.getCptp());
                vo.setCptpBase64(photo64);
            }
            resultVO.setResult(result);
        } catch (Exception e) {
            logger.error("{}", e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);
        }
        return resultVO;
    }

    @RequestMapping(value = "/upload")
    public QycpjsVO upload(HttpServletRequest request, QycpjsVO qycpjsVO) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iterator = multipartRequest.getFileNames();

        while (iterator.hasNext()) {
            MultipartFile multipartFile = multipartRequest.getFile(iterator.next());
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();

            if ("".equals(multipartFile.getOriginalFilename())) throw new RuntimeException("文件为空");
            InputStream is = null;
            try {
                is = multipartFile.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 文件上传固定的路径
            StringBuffer relativePath = new StringBuffer(cpjsProperties.getSavePath());
            //新建的文件夹名称（预案UUID/预案创建时间）

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String zzsj = sdf.format(date);
            StringBuffer new_folder = new StringBuffer();
            new_folder = new StringBuffer(qycpjsVO.getQyid()).append("/").append("pictures").append("/").append(zzsj).append("/");

            String folderName = relativePath.append("cpjs").append("/").append(new_folder).toString();
            //创建文件夹
            File dir = new File(folderName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //数据库要存的数据
            String dbPath = new_folder.append(fileName).toString();
            //文件全路径
            StringBuffer allPath = new StringBuffer(folderName).append(fileName);
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(allPath.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] b = new byte[1024];
            try {
                while ((is.read(b)) != -1) {
                    fos.write(b);
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                fos.close();
                is.close();
                //插入数据
                qycpjsVO.setSrc(dbPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return qycpjsVO;
    }
}
