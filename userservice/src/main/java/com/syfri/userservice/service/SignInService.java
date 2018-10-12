package com.syfri.userservice.service;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.AccountVO;
import com.syfri.userservice.model.RoleVO;
import com.syfri.userservice.model.UserVO;

import java.util.List;
import java.util.Map;

public interface SignInService extends BaseService<AccountVO>{

	List<AccountVO> doSearchListByMail(String mail);

	UserVO doInsertUserRoles(UserVO userVO);

	int doInsertAccountByVO(AccountVO accountVO);

	int doInsertAccountRolesBatch(String userid, List<RoleVO> roles);

	String getUsernameByMail(String mail);

	List<AccountVO> findByPhone(String phone);

	List<AccountVO> findByMail(String mail);

	List<AccountVO> findByUnscid(Map params);

	int doUpdateAccount(AccountVO accountVO);
}