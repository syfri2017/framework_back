package com.syfri.userservice.controller.prediction;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.prediction.QywjdcVO;
import com.syfri.userservice.service.prediction.QywjdcService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("qywjdc")
public class QywjdcController  extends BaseController<QywjdcVO>{

	@Autowired
	private QywjdcService qywjdcService;

	@Override
	public QywjdcService getBaseService() {
		return this.qywjdcService;
	}

	//add by yushch 20181010
	@ApiOperation(value="根据VO保存",notes="保存")
	@PostMapping("/doInsertByVo")
	public @ResponseBody
	ResultVO save(@RequestBody QywjdcVO vo) throws Exception{
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(qywjdcService.doInsertByVO(vo));
		} catch (Exception e) {
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return 	resultVO;
	}
	@ApiOperation(value = "根据id更新基本信息", notes = "修改")
	@PostMapping("/doUpdateByVO")
	public @ResponseBody ResultVO doUpdateByVO(@RequestBody QywjdcVO vo) {
		ResultVO resultVO = ResultVO.build();
		try {
			resultVO.setResult(qywjdcService.doUpdateByVO(vo));
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
