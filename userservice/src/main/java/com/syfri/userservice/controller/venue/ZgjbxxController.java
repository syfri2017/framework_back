package com.syfri.userservice.controller.venue;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.model.prediction.QyjbxxVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.venue.ZgjbxxVO;
import com.syfri.userservice.service.venue.ZgjbxxService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("zgjbxx")
public class ZgjbxxController  extends BaseController<ZgjbxxVO>{

	@Autowired
	private ZgjbxxService zgjbxxService;

	@Override
	public ZgjbxxService getBaseService() {
		return this.zgjbxxService;
	}

	/**
	 * 查询画布，若使用画布缩略图需要重新写方法获取zgzwhbtp
	 * @param vo
	 * @return
	 */
	@ApiOperation(value="查询列表",notes="列表信息")
	@ApiImplicitParam(name="vo",value = "业务实体")
	@PostMapping("doSearchHbListByVO")
	public @ResponseBody ResultVO doSearchHbListByVO(@RequestBody ZgjbxxVO vo ) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(zgjbxxService.doSearchHbListByVO(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}
	/**
	 * 只获取数据，不获取二进制文件
	 * @return
	 */
	@PostMapping("doSearchDataListByVO")
	public @ResponseBody ResultVO doSearchDataListByVO() {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(zgjbxxService.doSearchDataListByVO(null));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
		}
		return resultVO;
	}
	@PostMapping("doInsertByVO")
	public @ResponseBody ResultVO doInsertByVO(@RequestBody ZgjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			zgjbxxService.doInsertByVO(vo);
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}

		return 	resultVO;
	}
	/**
	 * 批量逻辑删除
	 * @param voList
	 * @return
	 */
	@ApiOperation(value = "根据id更新基本信息", notes = "删除")
	@PostMapping("/doDeleteJbxx")
	public @ResponseBody
	ResultVO doDeleteJbxx(@RequestBody List<ZgjbxxVO> voList) {
		ResultVO resultVO = ResultVO.build();
		try {
			int sum = 0;
			for(ZgjbxxVO vo :voList){
				vo.setDeleteFlag("Y");
				sum = sum + zgjbxxService.doUpdateByVO(vo);
			}
			resultVO.setResult(sum);
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
	/**
	 * 更新画布和画布缩略图数据
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("doUpdateByVO")
	public @ResponseBody ResultVO doUpdateByVO(@RequestBody ZgjbxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			if(vo.getUuid()!=null&&!"".equals(vo.getUuid())){

				zgjbxxService.doUpdateByVO(vo);
			}
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return 	resultVO;
	}
}
