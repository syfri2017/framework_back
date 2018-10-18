package com.syfri.userservice.controller;

import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.userservice.model.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.syfri.userservice.model.AccountVO;
import com.syfri.userservice.service.AccountService;
import com.syfri.baseapi.controller.BaseController;

@Api(value = "账户管理",tags = "账户管理API",description = "账户管理")
@RestController
@RequestMapping("account")
public class AccountController  extends BaseController<AccountVO>{

	@Autowired
	private AccountService accountService;

	@Override
	public AccountService getBaseService() {
		return this.accountService;
	}

	@ApiOperation(value="根据用户名查询用户数量",notes="查询")
	@ApiImplicitParam(name="username",value="用户名")
	@GetMapping("/getNum/{username}")
	public @ResponseBody ResultVO getNum(@PathVariable String username){
		ResultVO resultVO = ResultVO.build();
		try{
			AccountVO accountVO = new AccountVO();
			accountVO.setUsername(username);
			if(accountService.doSearchListByVO(accountVO).size() == 0){
				resultVO.setResult(0);
			}else{
				resultVO.setResult(1);
			}
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	@ApiOperation(value="根据用户修改用户",notes="修改")
	@ApiImplicitParam(name="vo",value="用户对象")
//	@RequiresPermissions("system/account:edit")
	@PostMapping("/updateByVO")
	public @ResponseBody ResultVO updateByVO(@RequestBody AccountVO accountVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(accountService.doUpdateAccountByVO(accountVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
