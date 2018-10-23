package com.syfri.userservice.service.system;

import com.syfri.baseapi.service.BaseService;
import com.syfri.userservice.model.system.AccountVO;
import com.syfri.userservice.model.system.RoleVO;
import com.syfri.userservice.model.system.UserVO;

import java.util.List;
import java.util.Map;

public interface SignInService extends BaseService<AccountVO>{

	List<AccountVO> doSearchListByMail(String mail);

	List<AccountVO> doSearchListByMailForENG(String mail);

	UserVO doInsertUserRoles(UserVO userVO);

	int doInsertAccountByVO(AccountVO accountVO);

	int doInsertAccountRolesBatch(String userid, List<RoleVO> roles);

	String getUsernameByMail(String mail);

	List<AccountVO> findByUsername(String username);

	List<AccountVO> findByMail(String mail);

	List<AccountVO> findByUnscid(Map params);

	int doUpdateAccount(AccountVO accountVO);
}