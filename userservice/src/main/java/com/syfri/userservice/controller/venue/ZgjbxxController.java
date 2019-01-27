//package com.syfri.userservice.controller.venue;
//
//import com.syfri.baseapi.model.ResultVO;
//import com.syfri.baseapi.utils.EConstants;
//import com.syfri.baseapi.utils.MathUtil;
//import com.syfri.userservice.config.properties.MailExportProperties;
//import com.syfri.userservice.config.properties.MailProperties;
//import com.syfri.userservice.model.prediction.QyjbxxVO;
//import com.syfri.userservice.model.system.MailVO;
//import com.syfri.userservice.model.venue.ZgZwmksVO;
//import com.syfri.userservice.model.venue.ZwjbxxVO;
//import com.syfri.userservice.model.venue.ZwmkVO;
//import com.syfri.userservice.service.impl.system.MailServiceImpl;
//import com.syfri.userservice.service.prediction.QyjbxxService;
//import com.syfri.userservice.service.venue.ZwjbxxService;
//import com.syfri.userservice.service.venue.ZwmkService;
//import com.syfri.userservice.utils.Base64ImageUtil;
//import com.syfri.userservice.utils.CurrentUserUtil;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import net.sf.json.JSONArray;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.web.bind.annotation.*;
//
//import com.syfri.userservice.model.venue.ZgjbxxVO;
//import com.syfri.userservice.service.venue.ZgjbxxService;
//import com.syfri.baseapi.controller.BaseController;
//
//import javax.mail.internet.MimeMessage;
//import java.util.List;
//
//@RestController
//@RequestMapping("zgjbxx")
//public class ZgjbxxController  extends BaseController<ZgjbxxVO>{
//
//	@Autowired
//	private ZgjbxxService zgjbxxService;
//	@Autowired
//	private ZwjbxxService zwjbxxService;
//	@Autowired
//	private QyjbxxService qyjbxxService;
//	@Override
//	public ZgjbxxService getBaseService() {
//		return this.zgjbxxService;
//	}
//	@Autowired
//	private JavaMailSenderImpl jms;
//	@Autowired
//	private MailExportProperties mp;
//	@Autowired
//	private MailServiceImpl mailServiceImpl;
//	@Autowired
//	private ZwmkService zwmkService;
//
//	@RequestMapping("doExportTp")
//	public @ResponseBody Object doExportTp(@RequestBody ZgjbxxVO vo
//			){
//		if(vo!=null) {
//			QyjbxxVO qy=new QyjbxxVO();
//			qy.setUserid(CurrentUserUtil.getCurrentUserId());
//			ResultVO resultVO = ResultVO.build();
//			List<ZgjbxxVO> ss = zgjbxxService.doSearchHbTpListByVO(vo);
//			QyjbxxVO qvo=qyjbxxService.doFindByVO(qy);
//			if(ss.size()>0){
//				ZgjbxxVO evo=ss.get(0);
//				String zgzwstr=evo.getZgzwhbtpStr();
//				if(zgzwstr==null){
//					resultVO.setMsg("画布为空！");
//					return resultVO;
//				}
//				if(zgzwstr!=null&&zgzwstr.startsWith("data:image/png;base64,")){
//					zgzwstr=zgzwstr.replace("data:image/png;base64,","");
//				}
//				ZwjbxxVO zwvo=new ZwjbxxVO();
//				zwvo.setQyid(qvo.getQyid());
//				//当前展商所选展位信息
//				List<ZwjbxxVO> dvos=zwjbxxService.doSearchListByVO(zwvo);
//				String yxzgxx="";
//				if(dvos.size()>0) {
//					yxzgxx = "您已选择";
//				}
//				for(ZwjbxxVO dvo:dvos){
//					ZgjbxxVO zgdb=zgjbxxService.doFindById(dvo.getZgid());
//					yxzgxx+="展馆<span style='color:red'>"+zgdb.getZgmc()+"</span>的展位<span style='color:red'>"
//							+dvo.getZwh()+"</span>,";
//				}
//				if(dvos.size()>0) {
//					yxzgxx += "<br><br>";
//				}
//				MimeMessage message = jms.createMimeMessage();
//				MailVO mv=new MailVO();
//				try {
//					//获取可用邮箱
//					mv=mailServiceImpl.setJavaMailSender(jms);
//				} catch (Exception e) {
//					e.printStackTrace();
//					resultVO.setMsg(e.getMessage());
//					return resultVO;
//				}
//				try {
//					//true表示需要创建一个multipart message
//					MimeMessageHelper helper = new MimeMessageHelper(message, true);
//					helper.setFrom(mv.getUsername());
//					helper.setTo(qvo.getDzyx());
//					helper.setSubject(mp.getSubject().replace("s%",evo.getZgmc()));
//					helper.setText(mp.getText().replace("{1}",yxzgxx)
//							.replace("{2}","<span style='color:red'>"+evo.getZgmc()+"</span>"), true);
//					helper.addAttachment(mp.getPicName().replace("s%",evo.getZgmc())
//							, Base64ImageUtil.decodeBase64ToImage(zgzwstr,evo.getUuid()));
//					jms.send(message);
//					resultVO.setCode(EConstants.CODE.SUCCESS);
//					resultVO.setMsg("html格式邮件发送成功");
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("html格式邮件发送失败");
//					resultVO.setCode(EConstants.CODE.FAILURE);
//					return resultVO;
//				}
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 查询画布，若使用画布缩略图需要重新写方法获取zgzwhbtp
//	 * @param vo
//	 * @return
//	 */
//	@ApiOperation(value="查询列表",notes="列表信息")
//	@ApiImplicitParam(name="vo",value = "业务实体")
//	@PostMapping("doSearchHbListByVO")
//	public @ResponseBody ResultVO doSearchHbListByVO(@RequestBody ZgjbxxVO vo ) {
//		ResultVO resultVO = ResultVO.build();
//		try {
//			resultVO.setResult(zgjbxxService.doSearchHbListByVO(vo));
//		} catch (Exception e) {
//			logger.error("{}",e.getMessage());
//		}
//		return resultVO;
//	}
//	/**
//	 * 查询画布，若使用画布缩略图需要重新写方法获取zgzwhbtp和模块信息
//	 * @param vo
//	 * @return
//	 */
//	@ApiOperation(value="查询列表",notes="列表信息")
//	@ApiImplicitParam(name="vo",value = "业务实体")
//	@PostMapping("doSearchHbMKListByVO")
//	public @ResponseBody ResultVO doSearchHbMKListByVO(@RequestBody ZgjbxxVO vo ) {
//		ResultVO resultVO = ResultVO.build();
//		try {
//			ZgZwmksVO zgZwmksVO=new ZgZwmksVO();
//			zgZwmksVO.setZgjbxxVOs(zgjbxxService.doSearchHbListByVO(vo));
//			ZwmkVO mk=new ZwmkVO();
//			mk.setStageUuid(vo.getUuid());
//			List<ZwmkVO> zwmkVOs=zwmkService.doSearchListByVO(mk);
//			JSONArray ja=new JSONArray();
//			for(ZwmkVO zwmkVO:zwmkVOs){
//				ja.add(zwmkVO.getJsonData());
//			}
//			zgZwmksVO.setZwmoJsonDatas(ja);
//			resultVO.setResult(zgZwmksVO);
//		} catch (Exception e) {
//			logger.error("{}",e.getMessage());
//		}
//		return resultVO;
//	}
//	/**
//	 * 只获取数据，不获取二进制文件
//	 * @return
//	 */
//	@PostMapping("doSearchDataListByVO")
//	public @ResponseBody ResultVO doSearchDataListByVO() {
//		ResultVO resultVO = ResultVO.build();
//		try {
//			resultVO.setResult(zgjbxxService.doSearchDataListByVO(null));
//		} catch (Exception e) {
//			logger.error("{}",e.getMessage());
//		}
//		return resultVO;
//	}
//	@PostMapping("doInsertByVO")
//	public @ResponseBody ResultVO doInsertByVO(@RequestBody ZgjbxxVO vo) throws Exception{
//		ResultVO resultVO = ResultVO.build();
//		try {
//			vo.setCjrid(CurrentUserUtil.getCurrentUserId());
//			vo.setCjrmc(CurrentUserUtil.getCurrentUserName());
//			//插入展馆数据
//			zgjbxxService.doInsertByVO(vo);
//		} catch (Exception e) {
//			logger.error("{}",e.getMessage());
//			resultVO.setCode(EConstants.CODE.FAILURE);
//		}
//		return 	resultVO;
//	}
//	/**
//	 * 批量逻辑删除
//	 * @param voList
//	 * @return
//	 */
//	@ApiOperation(value = "根据id更新基本信息", notes = "删除")
//	@PostMapping("/doDeleteJbxx")
//	public @ResponseBody
//	ResultVO doDeleteJbxx(@RequestBody List<ZgjbxxVO> voList) {
//		ResultVO resultVO = ResultVO.build();
//		try {
//			int sum = 0;
//			for(ZgjbxxVO vo :voList){
//				vo.setDeleteFlag("Y");
//				vo.setXgrid(CurrentUserUtil.getCurrentUserId());
//				vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
//				sum = sum + zgjbxxService.doUpdateByVO(vo);
//				//删除展位
//				ZwjbxxVO zw=new ZwjbxxVO();
//				zw.setZgid(vo.getUuid());
//				zwjbxxService.doDeleteByVO(zw);
//			}
//			resultVO.setResult(sum);
//		} catch (Exception e) {
//			logger.error("{}", e.getMessage());
//			resultVO.setCode(EConstants.CODE.FAILURE);
//		}
//		return resultVO;
//	}
//	/**
//	 * 更新画布和画布缩略图数据
//	 * @param vo
//	 * @return
//	 * @throws Exception
//	 */
//	@PostMapping("doUpdateByVO")
//	public @ResponseBody ResultVO doUpdateByVO(@RequestBody ZgjbxxVO vo) throws Exception{
//		ResultVO resultVO = ResultVO.build();
//		try {
//			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){
//				vo.setXgrid(CurrentUserUtil.getCurrentUserId());
//				vo.setXgrmc(CurrentUserUtil.getCurrentUserName());
//				zgjbxxService.doUpdateByVO(vo);
//			}
//		} catch (Exception e) {
//			logger.error("{}",e.getMessage());
//			resultVO.setCode(EConstants.CODE.FAILURE);
//		}
//		return 	resultVO;
//	}
//	/**
//	 * 获取全部展馆名称 add by yushch 20181229
//	 */
//	@ApiOperation(value="获取全部展馆名称",notes="查询")
//	@GetMapping("getZgmc")
//	public @ResponseBody ResultVO getZgmc(){
//		ResultVO resultVO = ResultVO.build();
//		try{
//			resultVO.setResult(zgjbxxService.doSearchZgmc());
//		}catch(Exception e){
//			logger.error("{}",e.getMessage());
//			resultVO.setCode(EConstants.CODE.FAILURE);
//		}
//		return resultVO;
//	}
//}
