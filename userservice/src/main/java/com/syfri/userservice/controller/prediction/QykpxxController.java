package com.syfri.userservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.prediction.QykpxxVO;
import com.syfri.userservice.service.prediction.QykpxxService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qykpxx")
public class QykpxxController  extends BaseController<QykpxxVO>{

	@Autowired
	private QykpxxService qykpxxService;

	@Override
	public QykpxxService getBaseService() {
		return this.qykpxxService;
	}

	//add by yushch 20181010
	@ApiOperation(value="根据VO保存",notes="保存")
	@PostMapping("/doInsertByVo")
	public @ResponseBody
	ResultVO save(@RequestBody QykpxxVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(qykpxxService.doInsertByVO(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return 	resultVO;
	}
	@ApiOperation(value = "根据id更新基本信息", notes = "修改")
	@PostMapping("/doUpdateByVO")
	public @ResponseBody ResultVO doUpdateByVO(@RequestBody QykpxxVO vo) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(qykpxxService.doUpdateByVO(vo));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
