package com.syfri.userservice.controller.venue;

import com.github.pagehelper.PageInfo;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.controller.prediction.QyjbxxController;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.venue.ZgjbxxVO;
import com.syfri.userservice.service.prediction.QyjbxxService;
import com.syfri.userservice.service.venue.ZgjbxxService;
import com.syfri.userservice.utils.CurrentUserUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.venue.ZwjbxxVO;
import com.syfri.userservice.service.venue.ZwjbxxService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("zwjbxx")
public class ZwjbxxController  extends BaseController<ZwjbxxVO>{

	@Autowired
	private ZwjbxxService zwjbxxService;
	@Autowired
	private QyjbxxService qyjbxxService;
	@Autowired
	private ZgjbxxService zgjbxxService;
	@Override
	public ZwjbxxService getBaseService() {
		return this.zwjbxxService;
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
				for(ZwjbxxVO vo : zwjbxxVOs){
					if(vo.getUuid()!=null&&!vo.getUuid().equals("")){
						zwjbxxService.doDeleteById(vo.getUuid());
						vo.setUuid(null);
					}

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
						resultVO.setResult(newdbzw);
						resultVO.setMsg("success");
					}else{
						resultVO.setResult(dbzw);
						resultVO.setMsg("展位已经被预定，请重新选择！");
					}
				}
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setMsg("选择展位失败！");
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return 	resultVO;
	}


}
