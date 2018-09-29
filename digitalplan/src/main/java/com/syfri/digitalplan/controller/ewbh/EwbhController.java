package com.syfri.digitalplan.controller.ewbh;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.digitalplan.model.ewbh.EwbhVO;
import com.syfri.digitalplan.service.ewbh.EwbhService;
import com.syfri.baseapi.controller.BaseController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("ewbh")
public class EwbhController  extends BaseController<EwbhVO>{

	@Autowired
	private EwbhService ewbhService;

	@Override
	public EwbhService getBaseService() {
		return this.ewbhService;
	}

	/**
	 * @Description:上传文件
	 * @Param: [request, response, yafjxzVO]
	 * @Return: void
	 * @Author: lixiaoayng
	 * @Modified By:
	 * @Date: 2018/4/20 15:49
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public ResultVO save(HttpServletResponse response, EwbhVO ewbhVO) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(this.getBaseService().doInsertByVO(ewbhVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

}
