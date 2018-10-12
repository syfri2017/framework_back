package com.syfri.userservice.dao;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.userservice.model.AccountVO;

import java.util.List;
import java.util.Map;

public interface SignInDAO extends BaseDAO<AccountVO>{

	List<AccountVO> doSearchListByMail(String mail);

	String getUsernameByMail(String mail);

	List<AccountVO> findByUnscid(Map<String,Object> params);
}