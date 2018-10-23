package com.syfri.userservice.controller.system;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.model.system.ImgUploadVO;
import com.syfri.userservice.service.system.ImgUploadService;
import com.syfri.userservice.utils.Base64ImageUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("util")
public class UtilController{

	private static final Logger logger  = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ImgUploadService imgUploadService;

	/**
	 * 查询详情页图片
	 * by li.xue 2018/06/06
	 */
	@ApiOperation(value="查询详情页图片",notes="列表")
	@GetMapping("/doFindPhoto/{picType}/{picValue}")
	public @ResponseBody ResultVO doFindPhoto(@PathVariable String picType, @PathVariable String picValue){
		ResultVO resultVO = ResultVO.build();
		try{
			ImgUploadVO imgUploadVO = new ImgUploadVO();
			imgUploadVO.setPicType(picType);
			imgUploadVO.setPicValue(picValue);
			ImgUploadVO vo = imgUploadService.doFindByVO(imgUploadVO);
			if(vo!=null && !StringUtils.isEmpty(vo.getPicBlob())){
				resultVO.setResult(Base64ImageUtil.byteArr2String(vo.getPicBlob()));
			}
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

}
