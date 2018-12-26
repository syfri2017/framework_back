package com.syfri.userservice.controller.venue;

import com.github.pagehelper.PageInfo;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.baseapi.utils.MathUtil;
import com.syfri.userservice.config.properties.BoothMsgProperties;
import com.syfri.userservice.config.properties.MsgProperties;
import com.syfri.userservice.controller.prediction.QyjbxxController;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.venue.ZgjbxxVO;
import com.syfri.userservice.service.prediction.QyjbxxService;
import com.syfri.userservice.service.venue.ZgjbxxService;
import com.syfri.userservice.utils.CurrentUserUtil;
import com.syfri.userservice.utils.ExcelUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.service.venue.ZwjbxxService;
import com.syfri.baseapi.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.URLEncoder;

@RestController
@RequestMapping("zwjbxx")
public class ZwjbxxController  extends BaseController<ZwjbxxVO>{

	@Autowired
	private ZwjbxxService zwjbxxService;
	@Autowired
	private QyjbxxService qyjbxxService;
	@Autowired
	private ZgjbxxService zgjbxxService;
	@Autowired
	private BoothMsgProperties boothMsgProperties;
	@Override
	public ZwjbxxService getBaseService() {
		return this.zwjbxxService;
	}
	@PostMapping("isInternal")
	public @ResponseBody
	boolean isInternal() {
		QyjbxxVO qy=new QyjbxxVO();
		qy.setUserid(CurrentUserUtil.getCurrentUserId());
		QyjbxxVO qvo=qyjbxxService.doFindByVO(qy);
		if(qvo!=null&&qvo.getReserve3()!=null){
			return true;
		}else{
			return false;
		}
	}
	@PostMapping("getNow")
	public @ResponseBody
	String getNow() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	/**
	 *获取当前用户选择展位信息
	 * @return
	 */
	@PostMapping("getSelectedPos")
	public @ResponseBody
	ResultVO getSelectedPos() {
		ResultVO resultVO = ResultVO.build();
		try {
			QyjbxxVO qy=new QyjbxxVO();
			qy.setUserid(CurrentUserUtil.getCurrentUserId());
			QyjbxxVO qvo=qyjbxxService.doFindByVO(qy);
			if(qvo!=null&&qvo.getQyid()!=null){
				ZwjbxxVO vo=new ZwjbxxVO();
				vo.setQyid(qvo.getQyid());
				List<ZwjbxxVO> dvo=zwjbxxService.doSearchListByVO(vo);
				resultVO.setResult(dvo);
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}
	/**
	 * 获取所有企业信息包含企业名称
	 * @param vo
	 * @return
	 */
	@PostMapping("doSearchListByVO")
	public @ResponseBody
	ResultVO doSearchListByVO(@RequestBody ZwjbxxVO vo ) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(zwjbxxService.doSearchListQyByVO(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 获取带有企业信息的展位信息
	 * 注意：这里通过知否含有zgid判断是否获取真实的展位数据
	 * @param vo
	 * @return
	 */
	@PostMapping("doSearchListQyByVO")
	public @ResponseBody
	ResultVO doSearchListQyByVO(@RequestBody ZwjbxxVO vo ) {
		ResultVO resultVO = ResultVO.build();
		try {
			PageInfo<ZwjbxxVO> pis= zwjbxxService.doSearchQyPage(vo);
			List<ZwjbxxVO> zwjbxxVOs=pis.getList();
			for(ZwjbxxVO zwjbxxVO:zwjbxxVOs){
				//匹配展位状态代码名称
				zwjbxxVO.setZwztmc(zwzt2Mc(zwjbxxVO.getZwzt()));
			}
			resultVO.setResult(pis);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}

	/**
	 * 状态转换，目前使用写死的方式
	 * @param zhzt
	 * @return
	 */
	private String zwzt2Mc(String zhzt){
		if("normal".equals(zhzt)){  //新建展位
			return "新建展位";
		}if("allotted".equals(zhzt)){//已分配展位
			return "已分配展位";
		}if("bespoke".equals(zhzt)){//已预定展位
			return "已预定展位";
		}if("completed".equals(zhzt)){//已确定展位
			return "已确定展位";
		}
		return null;
	}

	/**
	 * 使用先删除后插入的方式修改
	 * @param zwjbxxVOs
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="根据VO保存",notes="注意事项")
	@ApiImplicitParam(name="vo",value = "业务实体")
	@PostMapping("doInsertByVO")
	public @ResponseBody ResultVO doInsertByVO(@RequestBody List<ZwjbxxVO> zwjbxxVOs)throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			if(zwjbxxVOs.size()>0){
				//删除展位
				ZwjbxxVO zw=new ZwjbxxVO();
				zw.setZgid(zwjbxxVOs.get(0).getZgid());
				zwjbxxService.doDeleteByVO(zw);
				for(ZwjbxxVO vo : zwjbxxVOs){
					if(vo.getUuid()!=null&&!vo.getUuid().equals("")){
						vo.setUuid(null);
					}
					vo.setCjrid(CurrentUserUtil.getCurrentUserId());
					vo.setCjrmc(CurrentUserUtil.getCurrentUserName());
					zwjbxxService.doInsertByVO(vo);
				}
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}

		return 	resultVO;
	}
	/**
	 * 选展位
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("doUpdateByVO")
	@Transactional
	public @ResponseBody ResultVO doUpdateByVO(@RequestBody ZwjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			//判断前台是否传过来UUID值
			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){
				String userId=CurrentUserUtil.getCurrentUserId();
				QyjbxxVO qy =new QyjbxxVO();
				qy.setUserid(userId);
				QyjbxxVO qvo=qyjbxxService.doFindByVO(qy);
				//判断是否存在企业信息
				if(qvo.getQyid()!=null&&!"".equals(qvo.getQyid())){
					ZwjbxxVO dbzw=zwjbxxService.doFindById(vo.getUuid());
					//判断是否展位是未预定状态
					if(dbzw.getZwzt()!=null&&"normal".equals(dbzw.getZwzt())){
						vo.setQyid(qvo.getQyid());
						vo.setZwzt("bespoke");
						zwjbxxService.doUpdateByVO(vo);
						ZwjbxxVO newdbzw=zwjbxxService.doFindById(vo.getUuid());
						String phone=qvo.getLxrsj();
						//发短信开始
						if(!(phone.equals("")||null == phone)) {
							SmsSingleSender sender;
							try {
								sender = new SmsSingleSender(boothMsgProperties.getAppId(), boothMsgProperties.getAppKey());
								ArrayList<String> params = new ArrayList<String>();
								params.add(newdbzw.getZwh());
								params.add(newdbzw.getZwmj());
								SmsSingleSenderResult result = sender.sendWithParam("86", phone, boothMsgProperties.getTemplId(), params, "", "", "");
								if (result.result == 0) {
									resultVO.setCode(EConstants.CODE.SUCCESS);
								}
							} catch (Exception e) {
								e.printStackTrace();

							}
						}
						//发短信结束
						resultVO.setResult(newdbzw);
						resultVO.setMsg("success");
					}else{
						resultVO.setResult(dbzw);
						resultVO.setMsg("展位已经被预定，请重新选择！");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setMsg("选择展位失败！");
			resultVO.setCode(EConstants.CODE.FAILURE);
			return 	resultVO;
		}
		return 	resultVO;
	}

	/**
	 * 取消展位选择
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("doCancelByVO")
	@Transactional
	public @ResponseBody ResultVO doCancelByVO(@RequestBody ZwjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			//判断前台是否传过来UUID值
			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){
				vo.setQyid("");
				vo.setZwzt("normal");
				zwjbxxService.doUpdateByVO(vo);
				ZwjbxxVO newdbzw=zwjbxxService.doFindById(vo.getUuid());
				resultVO.setResult(newdbzw);
				resultVO.setMsg("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setMsg("选择展位失败！");
			resultVO.setCode(EConstants.CODE.FAILURE);
			return 	resultVO;
		}
		return 	resultVO;
	}
	@ApiOperation(value = "导出展位基本信息", notes = "导出")
	@RequestMapping(value = "/doExport/{param}", method = RequestMethod.GET)
	public void doExport(HttpServletRequest request, HttpServletResponse response, @PathVariable String [] param) {
		//解析param zwh&zwzt&qymc&zwlb&cklx
		ZwjbxxVO vo = new ZwjbxxVO();
		vo.setZwh(param[0]);
		vo.setZwzt(param[1]);
		vo.setQymc(param[2]);
		vo.setZwlb(param[3]);
		vo.setCklx(param[4]);

		//excel标题
		String[] title = {"展位号","公司名称","展位面积(m²)","展位类型","出口类型","展位状态","联系人名称","联系人电话","联系地址"};
		//excel文件名
		String fileName = "展位管理" + System.currentTimeMillis() + ".xls";
		//sheet名
		String sheetName = "展位管理";

		//获取数据
		List<ZwjbxxVO> dataList = zwjbxxService.doSearchListQyByVO(vo);
		List<String[]> list = new ArrayList<>();
		for (int i = 0; i < dataList.size(); i++) {
			ZwjbxxVO obj = dataList.get(i);
			String[] content = new String[title.length];
			content[0] = obj.getZwh();
			content[1] = obj.getQymc();
			content[2] = obj.getZwmj();
			content[3] = obj.getZwlb();
			content[4] = obj.getCklx();
			content[5] = obj.getZwztmc();
			content[6] = obj.getLxr();
			content[7] = obj.getLxrsj();
			content[8] = obj.getYjdzxx();
			list.add(content);
		}
		this.doExportExcel(request, response, fileName, sheetName, title, list);
		/**
		//解析param zwh&zwzt&qymc&zwlb&cklx
		ZwjbxxVO vo = new ZwjbxxVO();
		vo.setZwh(param[0]);
		vo.setZwzt(param[1]);
		vo.setQymc(param[2]);
		vo.setZwlb(param[3]);
		vo.setCklx(param[4]);
		//excel标题
		String[] title = {};
		//excel文件名
		String fileName = "";
		//sheet名
		String sheetName = "";
		//数据内容
		String[][] content = null;
		//获取数据
		List<ZwjbxxVO> list = zwjbxxService.doSearchListQyByVO(vo);
		for(ZwjbxxVO zwjbxxVO:list){
			//匹配展位状态代码名称
			zwjbxxVO.setZwztmc(zwzt2Mc(zwjbxxVO.getZwzt()));
		}
		String[] str = {"展位号","公司名称","展位面积(m²)","展位类型","出口类型","展位状态","联系人名称","联系人电话","联系地址"};
		title=str;
		fileName = "展位管理" + System.currentTimeMillis() + ".xls";
		sheetName = "展位管理";
		int size = list.size();
		content = new String[size][9];
		for (int i = 0; i < list.size(); i++) {
			content[i] = new String[title.length];
			ZwjbxxVO obj = list.get(i);
			content[i][0] = obj.getZwh();
			content[i][1] = obj.getQymc();
			content[i][2] = obj.getZwmj();
			content[i][3] = obj.getZwlb();
			content[i][4] = obj.getCklx();
			content[i][5] = obj.getZwztmc();
			content[i][6] = obj.getLxr();
			content[i][7] = obj.getLxrsj();
			content[i][8] = obj.getYjdzxx();
		}

		//创建HSSFWorkbook
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

		BufferedInputStream bis = null;
		try {
			response.addHeader("Cache-Control", "no-cache");
			//response.setCharacterEncoding("UTF-8");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			String ua = request.getHeader("user-agent");
			ua = ua == null ? null : ua.toLowerCase();
			if (ua != null && (ua.indexOf("firefox") > 0 || ua.indexOf("safari") > 0)) {
				try {
					fileName = new String(fileName.getBytes(), "ISO8859-1");
					response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					fileName = URLEncoder.encode(fileName, "utf-8");
					response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			wb.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		 **/
	}
}
