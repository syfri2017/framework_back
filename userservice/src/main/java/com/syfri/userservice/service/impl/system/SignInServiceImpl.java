package com.syfri.userservice.service.impl.system;

import com.syfri.baseapi.dao.BaseDAO;
import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.system.AccountDAO;
import com.syfri.userservice.dao.system.SignInDAO;
import com.syfri.userservice.dao.system.UserDAO;
import com.syfri.userservice.model.system.AccountRoleVO;
import com.syfri.userservice.model.system.AccountVO;
import com.syfri.userservice.model.system.RoleVO;
import com.syfri.userservice.model.system.UserVO;
import com.syfri.userservice.service.system.AccountService;
import com.syfri.userservice.service.system.OrganizationService;
import com.syfri.userservice.service.system.SignInService;
import com.syfri.userservice.utils.Constants;
import com.syfri.userservice.utils.JwtUtil;
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
	public List<AccountVO> doSearchListByMailForENG(String mail) {
		return this.signInDAO.doSearchListByMailForENG(mail);
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
			if("ENG".equals(userVO.getUsertype())){
				roles.add(new RoleVO("8EA749A9ACB84A3490EBF8E31AC3C621"));
			}else{
				roles.add(new RoleVO("5E2EE48C361A4BBB825C4A2E8330102F"));
			}
			userVO.setRoles(roles);
		}
		this.doInsertAccountRolesBatch(accountVO.getUserid(), userVO.getRoles());
		return userVO;
	}

	@Override
	public int doInsertAccountByVO(AccountVO accountVO){
		accountVO.setCreateName("Web registration");
		accountVO.setPassword(JwtUtil.md5(accountVO.getPassword() + "-" + Constants.PWD_KEY));
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
	public List<AccountVO> findByUsername(String username) {
		return this.signInDAO.findByUsername(username);
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
			accountVO.setPassword(JwtUtil.md5(accountVO.getPassword() + "-" + Constants.PWD_KEY));
		}
		return this.accountDAO.doUpdateByVO(accountVO);
	}
}