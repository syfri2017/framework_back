package com.syfri.userservice.service.impl.system;

import com.syfri.userservice.model.prediction.QyjbxxVO;
import com.syfri.userservice.model.system.AccountVO;
import com.syfri.userservice.model.system.RoleVO;
import com.syfri.userservice.service.prediction.QyjbxxService;
import com.syfri.userservice.service.system.AccountService;
import com.syfri.userservice.service.system.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syfri.baseapi.service.impl.BaseServiceImpl;
import com.syfri.userservice.dao.system.UserDAO;
import com.syfri.userservice.model.system.UserVO;
import com.syfri.userservice.service.system.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserVO> implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private QyjbxxService qyjbxxService;
	@Override
	public UserDAO getBaseDAO() {
		return userDAO;
	}

	/*--查询：根据用户获取用户及其角色--.*/
	@Override
	public List<UserVO> doFindUserRoles(UserVO userVO) {
		return userDAO.doFindUserRoles(userVO);
	}

	/*--新增：增加用户并为用户赋予角色.--*/
	@Override
	public UserVO doInsertUserRoles(UserVO userVO){

		//向账户表SYS_ACCOUNT插入账户信息
		AccountVO accountVO = new AccountVO(userVO.getUsername(), userVO.getPassword(), userVO.getRealname(), userVO.getCreateId(), userVO.getCreateName());
		accountVO.setUsertype(userVO.getUsertype());
		accountService.doInsertAccountByVO(accountVO);

		//向用户表SYS_USER插入用户信息
		userVO.setUserid(accountVO.getUserid());
		userDAO.doInsertByVO(userVO);
		if(userVO.getOrganizationId() != null && !"".equals(userVO.getOrganizationId())){
			userVO.setOrganizationName(organizationService.doFindById(userVO.getOrganizationId()).getJgjc());
		}

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
		accountService.doInsertAccountRolesBatch(accountVO.getUserid(), userVO.getRoles(), userVO.getCreateId(), userVO.getCreateName());
		return userVO;
	}

	/*--修改：修改用户并修改用户角色.--*/
	@Override
	public UserVO doUpdateUserRoles(UserVO userVO){
		//修改账户表
		String usertype = accountService.doFindById(userVO.getUserid()).getUsertype();
		AccountVO accountVO = new AccountVO(userVO.getUserid(), userVO.getUsername(), userVO.getPassword(), userVO.getRealname());
		accountVO.setUsertype(userVO.getUsertype());
		accountVO.setAlterId(userVO.getAlterId());
		accountVO.setAlterName(userVO.getAlterName());
		accountService.doUpdateAccountByVO(accountVO);

		//修改用户表基本信息
		userDAO.doUpdateByVO(userVO);
		if(userVO.getOrganizationId() != null && !"".equals(userVO.getOrganizationId())){
			userVO.setOrganizationName(organizationService.doFindById(userVO.getOrganizationId()).getJgjc());
		}

		//修改角色中间表信息
		if("ZSYH".equals(userVO.getDeptid())){
			if(!usertype.equals(userVO.getUsertype())) {
				List<RoleVO> roles = new ArrayList<>();
				if("ENG".equals(userVO.getUsertype())){
					roles.add(new RoleVO("8EA749A9ACB84A3490EBF8E31AC3C621"));
				}else{
					roles.add(new RoleVO("5E2EE48C361A4BBB825C4A2E8330102F"));
				}
				accountService.doDeleteAccountRoles(userVO.getUserid());
				accountService.doInsertAccountRolesBatch(accountVO.getUserid(), roles, userVO.getAlterId(), userVO.getAlterName());
			}
		}else{
			accountService.doDeleteAccountRoles(userVO.getUserid());
			accountService.doInsertAccountRolesBatch(accountVO.getUserid(), userVO.getRoles(), userVO.getAlterId(), userVO.getAlterName());
		}
		return userVO;
	}

	/*--删除：删除用户同时删除其角色.--*/
	@Override
	public int doDeleteUserRoles(List<UserVO> list){
		int num = 0;
		for(UserVO vo : list){
			String pkid = vo.getPkid();
			String userid = userDAO.doFindById(pkid).getUserid();
			//删除用户表
			userDAO.doDeleteById(pkid);
			//删除账户表
			accountService.doDeleteById(userid);
			//删除账户角色中间表
			accountService.doDeleteAccountRoles(userid);
			//删除报名信息 add by yushch 20190403
			QyjbxxVO qyjbxxVO = new QyjbxxVO();
			qyjbxxVO.setUserid(userid);
			//通过userid查询企业基本信息数据
			QyjbxxVO result = qyjbxxService.doFindByVO(qyjbxxVO);
			if(result != null){
				qyjbxxVO.setQyid(result.getQyid());
				qyjbxxVO.setDeleteFlag("Y");
				qyjbxxVO.setXgrid(vo.getAlterId());
				qyjbxxVO.setXgrmc(vo.getAlterName());
				List<QyjbxxVO> qyjbxxVOList = new ArrayList<>();
				qyjbxxVOList.add(qyjbxxVO);
				qyjbxxService.doDeleteJbxx(qyjbxxVOList);
			}
			num++;
		}
		return num;
	}

}