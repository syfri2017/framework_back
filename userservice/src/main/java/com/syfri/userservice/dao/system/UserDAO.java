package com.syfri.userservice.dao.system;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.system.AccountRoleVO;
import com.syfri.userservice.model.system.UserVO;

import java.util.List;

public interface UserDAO extends BaseDAO<UserVO>{

	/*获取用户，如果userVO为null，则获取所有用户.*/
	List<UserVO> doFindUserRoles(UserVO userVO);
}