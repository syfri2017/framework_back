package com.syfri.userservice.service;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.AccountVO;
import com.syfri.userservice.model.RoleVO;
import com.syfri.userservice.model.UserVO;

import java.util.List;

public interface SignInService extends BaseService<AccountVO>{

	List<AccountVO> doSearchListByMail(String mail);

	public UserVO doInsertUserRoles(UserVO userVO);

	public int doInsertAccountByVO(AccountVO accountVO);

	public int doInsertAccountRolesBatch(String userid, List<RoleVO> roles);

	public String getUsernameByMail(String mail);
}