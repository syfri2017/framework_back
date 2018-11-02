package com.syfri.userservice.service.impl.prediction;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.jfinal.template.ext.directive.Str;
import com.syfri.userservice.config.properties.CpjsProperties;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.prediction.QyjbxxDAO;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.service.prediction.QyjbxxService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("qyjbxxService")
public class QyjbxxServiceImpl extends BaseServiceImpl<QyjbxxVO> implements QyjbxxService {

	@Autowired
	private QyjbxxDAO qyjbxxDAO;

	@Autowired
	private CpjsProperties cpjsProperties;

	@Override
	public QyjbxxDAO getBaseDAO() {
		return qyjbxxDAO;
	}

	/*--通过用户、企业查询展商信息 by li.xue 2018/10/0 11:13.--*/
	@Override
	public List<QyjbxxVO> doFindZsxxByQyjbxx(QyjbxxVO qyjbxxVO) {
		return qyjbxxDAO.doFindZsxxByQyjbxx(qyjbxxVO);
	}

	public int doDeleteJbxx(List<QyjbxxVO> voList) {
		int sum = 0;
		for (QyjbxxVO vo : voList) {
			sum = sum + qyjbxxDAO.doUpdateByVO(vo);
		}
		return sum;
	}

	@Override
	public QyjbxxVO doInsertJbxxByVO(QyjbxxVO qyjbxxVO) {
		qyjbxxDAO.doInsertByVO(qyjbxxVO);
		return qyjbxxVO;
	}

	//add by yushch 20181018
	@Override
	public int doSearchCountByMail(String mail) {
		return qyjbxxDAO.doSearchCountByMail(mail);
	}

	@Override
	public QyjbxxVO uploadPics(MultipartFile multipartFile, QyjbxxVO vo,String fileName) {
		try {
			InputStream fis = null;
			fis = multipartFile.getInputStream();
			//加水印
			Image image = ImageIO.read(fis);
			BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
			//颜色
			Color color = new Color(105, 105, 105);
			g2.setColor(color);
			//字体大小为图片宽的1/11
			g2.setFont(new Font("宋体", Font.BOLD, image.getWidth(null) / 11));
			//透明度
			float alpha = 0.5f;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			//int degree = -60;
			//g2.rotate(Math.toRadians(degree));//设置水印旋转
			String text = "仅供十八届消防展审核";
			g2.drawString(text, 0, image.getHeight(null) / 2);
			g2.dispose();
			// 文件上传固定的路径
			StringBuffer relativePath = new StringBuffer(cpjsProperties.getSavePath());
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String zzsj = sdf.format(date);
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			//图片重命名eg. yyzz20181031152840.JPG
			String fileName_new = "yyzz" + zzsj + suffixName;
			StringBuffer new_folder = new StringBuffer();
			new_folder = new StringBuffer(vo.getQyid()).append("/");
			String folderName = relativePath.append(new_folder).toString();
			//创建文件夹
			File dir = new File(folderName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			//数据库要存的数据
			String dbPath = new_folder.append(fileName_new).toString();
			//文件全路径
			StringBuffer allPath = new StringBuffer(folderName).append(fileName_new);
			FileOutputStream out = new FileOutputStream(allPath.toString());
			ImageIO.write(bi, "jpg", out);
			out.close();
			fis.close();
			vo.setSrc(dbPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vo;
	}
	@Override
	public int uploadPdfs(MultipartFile multipartFile, QyjbxxVO vo) {
		try {
			// 保存文件
			String path = ((QyjbxxService) AopContext.currentProxy()).savenew(multipartFile);
			// 待加水印的文件
			PdfReader reader = new PdfReader(
					path);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// 加完水印的文件
			PdfStamper stamper = new PdfStamper(reader, bos);
			int total = reader.getNumberOfPages() + 1;
			PdfContentByte content;
			// 设置字体
			BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
					BaseFont.EMBEDDED);
			String waterText = "仅供十八届消防展审核";
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
				BaseColor color = new BaseColor(105, 105, 105);
				content.setColorFill(color);
				// 设置字体及字号
				content.setFontAndSize(base, 18);
				// 设置起始位置
				content.setTextMatrix(400, 780);
				PdfGState gs = new PdfGState();
				float alpha = 0.5f;
				gs.setFillOpacity(alpha);// 设置透明度为0.5
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
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return qyjbxxDAO.doUpdateByVO(vo);
	}
	//保存pdf by huangrui
	@Override
	public String savenew(MultipartFile file) {
		try {
			// 获取文件名
			String fileName = file.getOriginalFilename();
			if ("".equals(fileName)) {
				System.out.print("文件为空！");
				return "";
			}
			// 获取文件的后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			if (suffixName.equalsIgnoreCase("pdf")) {
				System.out.print("格式不正确！");
				return "";
			}
			// 设置文件存储路径
			String basePath = "E://test//upload//pdf";
			Random rand = new Random();
			String childPath = String.valueOf(rand.nextInt(100) + 1);
			String id = UUID.randomUUID().toString();
			id = id.replace("-", "");
			String path = basePath + childPath + id + suffixName;
			File dest = new File(path);
			// 检测是否存在目录
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();// 新建文件夹
			}
			// 文件写入
			file.transferTo(dest);
			System.out.print("上传成功！");
			return path;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("上传失败！");
		return "";
	}
}