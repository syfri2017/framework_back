package com.syfri.baseapi.utils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
/**
 * @Description:
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2018/10/15 9:54
 */
public class PdfMark {
    public static void main(String[] args) throws Exception{
        String inputPath="D:/3.pdf";
        String outputPath="D:/2.pdf";
        String iconPath="D:/2.png";

        String waterText="展会系统！！";
        //addTextToPdf(inputPath,outputPath,waterText);
        addIconText2Pdf( iconPath,inputPath, outputPath,"", -45);
    }

    /**
     *pdf添加水印文字
     * @param inputPath  待加水印的文件
     * @param outputPath 加完水印的文件
     * @param waterText  水印文字
     * @throws Exception
     */
    public static void addTextToPdf(String inputPath,String outputPath
            ,String waterText) throws Exception {
        //透明度
        float alpha = 0.5f;
        //颜色
        BaseColor color=new BaseColor(255,0,0);
        addTextToPdf( inputPath, outputPath, waterText,color,alpha);
    }

    /**
     *pdf添加水印文字
     * @param inputPath  待加水印的文件
     * @param outputPath 加完水印的文件
     * @param waterText  水印文字
     * @param color 颜色
     * @param alpha 透明度
     * @throws Exception
     */
    public static void addTextToPdf(String inputPath,String outputPath
            ,String waterText,BaseColor color,float alpha) throws Exception {
        // 待加水印的文件
        PdfReader reader = new PdfReader(
                inputPath);
        // 加完水印的文件
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                outputPath));

        int total = reader.getNumberOfPages() + 1;

        PdfContentByte content;
        // 设置字体
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                BaseFont.EMBEDDED);

        int j = waterText.length(); // 文字长度
        char c = 0;
        int high = 0;// 高度
        // 循环对每页插入水印
        for (int i = 1; i < total; i++) {
            // 水印的起始
            high = 500;
            content = stamper.getUnderContent(i);
            // 开始
            content.beginText();
            // 设置颜色
            content.setColorFill(color);

            // 设置字体及字号
            content.setFontAndSize(base, 18);
            // 设置起始位置
            content.setTextMatrix(400, 780);
            PdfGState gs = new PdfGState();
            gs.setFillOpacity(alpha);// 设置透明度为0.2
            content.setGState(gs);
            // 开始写入水印
            for (int k = 0; k < j; k++) {
                content.setTextRise(14);
                c = waterText.charAt(k);
                // 将char转成字符串
                content.showText(c + "");
                high -= 5;
            }
            content.endText();

        }
        stamper.close();
    }

    /**
     * 给pdf文件添加水印图片和文字
     @param iconPath 水印图片路径
     @param inputFile 源pdf路径
     @param waterMarkName 水印文字（可选，可以为空）
     @param outputFile 目标pdf路径
     @param degree 水印图片旋转角度
     */
    private static void addIconText2Pdf(String iconPath,String inputFile
            , String outputFile,String waterMarkName, Integer degree){
        addIconText2Pdf( iconPath, inputFile,  outputFile,degree
                ,null ,null,waterMarkName, -1);
    }
    /**
     *给pdf文件添加水印
     * @param iconPath
     * @param inputFile
     * @param outputFile
     * @param userPassWord
     * @param ownerPassWord // 所有者密码
     * @param waterMarkName
     * @param permission
     */
    private static void addIconText2Pdf(String iconPath,String inputFile, String outputFile, Integer degree,
                                  String userPassWord, String ownerPassWord, String waterMarkName,
                                  int permission) {
        try {
            PdfReader reader = new PdfReader(inputFile);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
                    outputFile));
            // 设置密码
            //stamper.setEncryption(userPassWord.getBytes(), ownerPassWord.getBytes(), permission, false);
            BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
            int total = reader.getNumberOfPages() + 1;
            Image image = Image.getInstance(iconPath);
            image.setAbsolutePosition(50, 400);//坐标
            image.setRotation(-20);//旋转 弧度
            image.setRotationDegrees(degree);//旋转 角度
//            image.scaleAbsolute(200,100);//自定义大小
            image.scalePercent(50);//依照比例缩放
            PdfContentByte under;
            int j = waterMarkName.length();
            char c = 0;
            int rise = 0;
            for (int i = 1; i < total; i++) {
                rise = 500;
                under = stamper.getUnderContent(i);
                // 添加图片
                under.addImage(image);
                PdfGState gs = new PdfGState();
                gs.setFillOpacity(0.2f);// 设置透明度为0.2
                under.setGState(gs);
                under.beginText();
                under.setColorFill(BaseColor.RED);
                under.setFontAndSize(base, 30);
                // 设置水印文字字体倾斜 开始
                if (j >= 15) {
                    under.setTextMatrix(200, 120);
                    for (int k = 0; k < j; k++) {
                        under.setTextRise(rise);
                        c = waterMarkName.charAt(k);
                        under.showText(c + "");
                        rise -= 20;
                    }
                } else {
                    under.setTextMatrix(180, 100);
                    for (int k = 0; k < j; k++) {
                        under.setTextRise(rise);
                        c = waterMarkName.charAt(k);
                        under.showText(c + "");
                        rise -= 18;
                    }
                }
                // 字体设置结束
                under.endText();
                // 画一个圆
                // under.ellipse(250, 450, 350, 550);
                // under.setLineWidth(1f);
                // under.stroke();
            }
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
