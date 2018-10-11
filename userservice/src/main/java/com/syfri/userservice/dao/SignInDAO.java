package com.syfri.userservice.dao;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.userservice.model.AccountVO;

import java.util.List;

public interface SignInDAO extends BaseDAO<AccountVO>{

	List<AccountVO> doSearchListByMail(String mail);

	String getUsernameByMail(String mail);
}