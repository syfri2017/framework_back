package com.syfri.digitalplan.controller.jxcsplan;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.syfri.digitalplan.model.jxcsplan.JxcsjbxxVO;
import com.syfri.digitalplan.model.jxcsplan.JxcsjzxxVO;
import com.syfri.digitalplan.service.jxcsplan.JxcsjzxxService;
import com.syfri.baseapi.controller.BaseController;

@RestController
@RequestMapping("jxcsjzxx")
public class JxcsjzxxController  extends BaseController<JxcsjzxxVO>{

	@Autowired
	private JxcsjzxxService jxcsjzxxService;

	@Override
	public JxcsjzxxService getBaseService() {
		return this.jxcsjzxxService;
	}

	@ApiOperation(value="根据单位id获取建筑详情集合",notes="列表信息")
	@ApiImplicitParam(name="dwId",value="单位id")
	@GetMapping("/doFindJzxxByDwid/{dwid}")
	public @ResponseBody ResultVO doFindJzxxByDwid(@PathVariable String dwid){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(jxcsjzxxService.doFindJzxxByDwid(dwid));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

}
