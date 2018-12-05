package com.syfri.userservice.controller.system;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.system.MailVO;
import com.syfri.userservice.service.system.MailService;
import com.syfri.baseapi.controller.BaseController;

import java.util.List;

@RestController
@RequestMapping("mail")
public class MailController  extends BaseController<MailVO>{

	@Autowired
	private MailService mailService;

	@Override
	public MailService getBaseService() {
		return this.mailService;
	}

	/**
	 * 邮箱表格数据获取
	 */
	@ApiOperation(value="邮箱表格数据",notes="列表信息")
	@ApiImplicitParam(name="vo",value="邮箱")
	@RequiresPermissions("system/mail:list")
	@PostMapping("/findByVO")
	public @ResponseBody ResultVO findByVO(@RequestBody MailVO mailVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(mailService.doFindMail(mailVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;

	}


	/**
	 * 删除邮箱表格数据
	 */
	@ApiOperation(value="邮箱表格数据删除",notes="删除")
	@ApiImplicitParam(name="vo",value="邮箱")
	@RequiresPermissions("system/mail:delete")
	@PostMapping("/deleteByList")
	public @ResponseBody ResultVO deleteByList(@RequestBody List<MailVO> list){
		ResultVO resultVO = ResultVO.build();

		try{
			resultVO.setResult(mailService.doDeleteMail(list));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;

	}

	/**
	 * 新增邮箱表格数据
	 * */
	@ApiOperation(value="新增邮箱表格数据",notes="新增")
	@ApiImplicitParam(name="vo",value="邮箱")
	@RequiresPermissions("system/mail:add")
	@PostMapping("/insertByVO")
	public @ResponseBody ResultVO insertByVO(@RequestBody MailVO mailVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(mailService.doInsertMail(mailVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;

	}
}
