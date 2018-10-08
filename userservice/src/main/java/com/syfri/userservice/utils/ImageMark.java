package com.syfri.userservice.utils;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.ImageIcon;
import java.io.FileOutputStream;
/**
 * @Description:图片水印
 * @Author: lixiaoyang
 * @Modified By:
 * @Date: 2018/10/8 15:45
 */
public class ImageMark {
    /**
     *
     * @param inputImagePath 输入文件路径
     * @param outputPath    输出文件路径
     * @param text          打印文字
     * @throws IOException
     */
    public static void addTextToImage(String inputImagePath,String outputPath
            ,String text) throws IOException {
        //透明度
        float alpha = 0.5f;
        //颜色
        Color color=new Color(255,0,0);
        addTextToImage( inputImagePath, outputPath, text,color,alpha);
    }

    /**
     *
     * @param inputImagePath 输入文件路径
     * @param outputPath    输出文件路径
     * @param text          打印文字
     * @param color         颜色
     * @param alpha         透明度   //
     * @throws IOException
     */
    public static void addTextToImage(String inputImagePath,String outputPath,String text,Color color,float alpha) throws IOException {
        File file = new File(inputImagePath);
        Image image = ImageIO.read(file);
        BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
        g2.setColor(color);
        g2.setFont(new Font("宋体", Font.BOLD, 20));

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                alpha));
        //调整图片位置
        g2.drawString(text, 0, image.getHeight(null)/2);
        g2.dispose();
        ImageIO.write(bi, "JPG", new FileOutputStream(outputPath));
    }
    /*
      给图片添加水印
      @param iconPath 水印图片路径
      @param srcImgPath 源图片路径
      @param targerPath 目标图片路径
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
            String targerPath) {
        markImageByIcon(iconPath, srcImgPath, targerPath, null);
    }

    /*
      给图片添加水印、可设置水印图片旋转角度
      @param iconPath 水印图片路径
      @param srcImgPath 源图片路径
      @param targerPath 目标图片路径
      @param degree 水印图片旋转角度
     */
    public static void markImageByIcon(String iconPath, String srcImgPath,
                                       String targerPath, Integer degree) {
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                    srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 得到画笔对象
            // Graphics g= buffImg.getGraphics();

            Graphics2D g = buffImg.createGraphics();

            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg
                    .getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree),
                        (double) buffImg.getWidth() / 2, (double) buffImg
                                .getHeight() / 2);
            }

            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度

            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 得到Image对象。
            Image img = imgIcon.getImage();

            float alpha = 0.5f; // 透明度

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));

            // 表示水印图片的位置
            g.drawImage(img, 150, 300, null);

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

            g.dispose();

            os = new FileOutputStream(targerPath);

            // 生成图片
            ImageIO.write(buffImg,  "JPG ", os);

            System.out.println( "图片完成添加Icon印章。。。。。。 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException{

        String inputImagePath = "D:/1.jpg";
        String outputPath = "D:/1-add.jpg";
        String text = "这张图片属于LXY！";
        addTextToImage(inputImagePath, outputPath, text);

               /*String srcImgPath =  "d:/test/michael/myblog_01.png ";
        String iconPath =  "d:/test/michael/blog_logo.png ";
        String targerPath =  "d:/test/michael/img_mark_icon.jpg ";
        String targerPath2 =  "d:/test/michael/img_mark_icon_rotate.jpg ";
        // 给图片添加水印
        ImageMarkUtil.markImageByIcon(iconPath, srcImgPath, targerPath);
        // 给图片添加水印,水印旋转-45
        ImageMarkUtil.markImageByIcon(iconPath, srcImgPath, targerPath2,
                -45);*/
    }
}