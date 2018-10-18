package com.syfri.userservice.service.impl;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.AccountDAO;
import com.syfri.userservice.dao.SignInDAO;
import com.syfri.userservice.dao.UserDAO;
import com.syfri.userservice.model.AccountRoleVO;
import com.syfri.userservice.model.AccountVO;
import com.syfri.userservice.model.RoleVO;
import com.syfri.userservice.model.UserVO;
import com.syfri.userservice.service.AccountService;
import com.syfri.userservice.service.OrganizationService;
import com.syfri.userservice.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("SignInService")
public class SignInServiceImpl extends BaseServiceImpl<AccountVO> implements SignInService {

	@Autowired
	private SignInDAO signInDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private AccountService accountService;
	@Autowired
	private OrganizationService organizationService;


	@Override
	public BaseDAO<AccountVO> getBaseDAO() {
		return null;
	}

	@Override
	public List<AccountVO> doSearchListByMail(String mail) {
		return this.signInDAO.doSearchListByMail(mail);
	}

	@Override
	public UserVO doInsertUserRoles(UserVO userVO){

		//向账户表SYS_ACCOUNT插入账户信息
		AccountVO accountVO = new AccountVO(userVO.getUsername(), userVO.getPassword(), userVO.getRealname());
		accountVO.setUsertype(userVO.getUsertype());
		this.doInsertAccountByVO(accountVO);

		//向用户表SYS_USER插入用户信息
		userVO.setCreateName("Web registration");
		userVO.setUserid(accountVO.getUserid());
		userDAO.doInsertByVO(userVO);

		//向中间表中插入账户角色情况
		if("ZSYH".equals(userVO.getDeptid())){
			List<RoleVO> roles = new ArrayList<>();
			roles.add(new RoleVO("5E2EE48C361A4BBB825C4A2E8330102F"));
			userVO.setRoles(roles);
		}
		this.doInsertAccountRolesBatch(accountVO.getUserid(), userVO.getRoles());
		return userVO;
	}

	@Override
	public int doInsertAccountByVO(AccountVO accountVO){
		accountVO.setCreateName("Web registration");
		accountVO = accountService.getPasswordEncry(accountVO);
		//accountVO = ((AccountService) AopContext.currentProxy()).getPasswordEncry(accountVO);
		return accountDAO.doInsertByVO(accountVO);
	}

	@Override
	public int doInsertAccountRolesBatch(String userid, List<RoleVO> roles){
		List<AccountRoleVO> accountRoles = new ArrayList<>();
		if(roles!=null && roles.size()>0){
			for(RoleVO role : roles){
				AccountRoleVO temp = new AccountRoleVO();
				temp.setUserid(userid);
				temp.setRoleid(role.getRoleid());
				temp.setCreateName("Web registration");
				accountRoles.add(temp);
			}
			return accountDAO.doBatchInsertAccountRoles(accountRoles);
		}else{
			//如果新增用户没有选择角色，则默认给用户一个初始角色
			AccountRoleVO accountRoleVO = new AccountRoleVO();
			accountRoleVO.setUserid(userid);
			accountRoleVO.setRoleid("753803FC34FC4424AB6778B0F3132AAF");
			accountRoleVO.setCreateName("Web registration");
			return accountDAO.doInsertAccoutRoleInitial(accountRoleVO);
		}
	}

	@Override
	public String getUsernameByMail(String mail) {
		return this.signInDAO.getUsernameByMail(mail);
	}

	@Override
	public List<AccountVO> findByUnscid(Map params) {
		return this.signInDAO.findByUnscid(params);
	}

	@Override
	public List<AccountVO> findByPhone(String phone) {
		return this.signInDAO.findByPhone(phone);
	}

	@Override
	public List<AccountVO> findByMail(String mail) {
		return this.signInDAO.findByMail(mail);
	}

	@Override
	public int doUpdateAccount(AccountVO accountVO) {
		accountVO.setAlterName("Web rearrange");
		if(accountVO.getPassword() == null || "".equals(accountVO.getPassword())){
			accountVO.setPassword(null);
		}else{
			accountVO = accountService.getPasswordEncry(accountVO);
			//accountVO = ((AccountService) AopContext.currentProxy()).getPasswordEncry(accountVO);
		}
		return this.accountDAO.doUpdateByVO(accountVO);
	}
}