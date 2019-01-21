package com.syfri.userservice.controller.system;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.sun.mail.smtp.SMTPTransport;
import com.syfri.baseapi.controller.BaseController;
import com.syfri.baseapi.model.ResultVO;
import com.syfri.baseapi.utils.EConstants;
import com.syfri.baseapi.utils.MathUtil;
import com.syfri.userservice.config.properties.MailEngProperties;
import com.syfri.userservice.config.properties.MailProperties;
import com.syfri.userservice.config.properties.MsgProperties;
import com.syfri.userservice.model.system.AccountVO;
import com.syfri.userservice.model.system.MailVO;
import com.syfri.userservice.model.system.UserVO;
import com.syfri.userservice.service.impl.system.MailServiceImpl;
import com.syfri.userservice.service.system.AccountService;
import com.syfri.userservice.service.system.SignInService;
import com.syfri.userservice.service.system.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Map;

@Api(value = "账户管理",tags = "账户管理API",description = "账户管理")
@RestController
@RequestMapping("signin")
public class SignInController extends BaseController<AccountVO>{
	@Autowired
	private MsgProperties pMsgProperties;
	@Autowired
	private JavaMailSenderImpl jms;
	@Autowired
	private MailProperties mp;
	@Autowired
	private MailEngProperties mpEng;
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private SignInService signInService;
	@Autowired
	private MailServiceImpl mailServiceImpl;
	@Override
	public AccountService getBaseService() {
		return this.accountService;
	}

	@ApiOperation(value="根据username查询用户数量",notes="查询")
	@ApiImplicitParam(name="username",value="用户名")
	@GetMapping("/getUsernameNum/{username}/static")
	public @ResponseBody ResultVO getUsernameNum(@PathVariable String username){
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

	@ApiOperation(value="根据邮箱查询用户数量",notes="查询")
	@ApiImplicitParam(name="mail",value="邮箱")
	@GetMapping("/getMailNum/{mail}/static")
	public @ResponseBody ResultVO getMailNum(@PathVariable String mail){
		ResultVO resultVO = ResultVO.build();
		try{
			if(signInService.doSearchListByMail(mail).size() == 0){
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

	@ApiOperation(value="根据邮箱查询用户数量",notes="查询")
	@ApiImplicitParam(name="mail",value="邮箱")
	@GetMapping("/getMailNumENG/{mail}/static")
	public @ResponseBody ResultVO getMailNumENG(@PathVariable String mail){
		ResultVO resultVO = ResultVO.build();
		try{
			if(signInService.doSearchListByMailForENG(mail).size() == 0){
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

	/**
	 * 发送邮箱验证码
	 * @param mail 邮箱\
	 * @return
	 */
	@GetMapping("/sendMail")
	public Object sendMail(String mail){
		ResultVO resultVO = ResultVO.build();
		MailVO mv=new MailVO();
		if(!(mail.equals("")||null == mail)) {
			try {
				//获取可用邮箱
				mv=mailServiceImpl.setJavaMailSender(jms);
			} catch (Exception e) {
				e.printStackTrace();
				resultVO.setMsg(e.getMessage());
				return resultVO;
			}
			MimeMessage message = jms.createMimeMessage();
			try {
				//true表示需要创建一个multipart message
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setFrom(mv.getUsername());
				helper.setCc(mv.getUsername());
				helper.setTo(mail);
				helper.setSubject(mp.getSubject());
				String randomStr = MathUtil.getCode(6);
				helper.setText(String.format(mp.getText(), randomStr), true);
				jms.send(message);
				resultVO.setCode(EConstants.CODE.SUCCESS);
				//生成的随机数(可以去掉)
				resultVO.setMsg(randomStr.toString());
				System.out.println("html格式邮件发送成功");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("html格式邮件发送失败");
				resultVO.setCode(EConstants.CODE.FAILURE);
				if(e.getMessage().contains("com.sun.mail.smtp")){
					mailServiceImpl.doDisAbleMail(mv);
				}
				return resultVO;
			}
		}else{
			resultVO.setCode(EConstants.CODE.FAILURE);
			resultVO.setMsg("获取邮箱失败");
		}
		return resultVO;
	}

	/**
	 * 发送英文邮箱验证码
	 * @param mail 邮箱\
	 * @return
	 */
	@GetMapping("/sendMailEng")
	public Object sendMailEng(String mail){
		ResultVO resultVO = ResultVO.build();
		MailVO mv=new MailVO();
		if(!(mail.equals("")||null == mail)) {
			try {
				mv=mailServiceImpl.setJavaMailSender(jms);
			} catch (Exception e) {
				e.printStackTrace();
				resultVO.setMsg(e.getMessage());
				return resultVO;
			}
			MimeMessage message = jms.createMimeMessage();
			try {
				//true表示需要创建一个multipart message
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setFrom(mv.getUsername());
				helper.setCc(mv.getUsername());
				helper.setTo(mail);
				helper.setSubject(mpEng.getSubject());
				String randomStr = MathUtil.getCode(6);
				helper.setText(String.format(mpEng.getText(), randomStr), true);
				jms.send(message);
				resultVO.setCode(EConstants.CODE.SUCCESS);
				//生成的随机数(可以去掉)
				resultVO.setMsg(randomStr.toString());
				System.out.println("html格式邮件发送成功");
			} catch (Exception e) {
				//判断是邮件异常，今天停止邮箱
				if(e.getMessage().contains("com.sun.mail.smtp")){
					mailServiceImpl.doDisAbleMail(mv);
				}
				e.printStackTrace();
				System.out.println("html格式邮件发送失败");
				resultVO.setCode(EConstants.CODE.FAILURE);
				return resultVO;
			}
		}else{
			resultVO.setCode(EConstants.CODE.FAILURE);
			resultVO.setMsg("获取邮箱失败");
		}
		return resultVO;
	}

	/**
	 * 发送短信验证码
	 * @param phone 电话号码
	 * @return
	 */
	@GetMapping("/sendMessage")
	public ResultVO send(String phone){
		ResultVO resultVO = ResultVO.build();
		if(!(phone.equals("")||null == phone)){
			//假设短信模板 id 为 123，模板内容为：测试短信，{1}，{2}，{3}，上学。
			SmsSingleSender sender;
			try {
				sender = new SmsSingleSender(pMsgProperties.getAppId(),pMsgProperties.getAppKey());
				ArrayList<String> params = new ArrayList<String>();
				//6位随机数验证码
				String randomStr=MathUtil.getCode(6);
				params.add(randomStr);
				SmsSingleSenderResult result = sender.sendWithParam("86", phone, pMsgProperties.getTemplId(), params, "", "", "");
				if(result.result==0){
					resultVO.setCode(EConstants.CODE.SUCCESS);
					//生成的随机数(可以去掉)
					resultVO.setMsg( randomStr.toString());
				}else{
					resultVO.setCode(EConstants.CODE.FAILURE);
					resultVO.setMsg( result.errMsg);
				}
			} catch (Exception e) {
				resultVO.setCode(EConstants.CODE.FAILURE);
				resultVO.setMsg(  e.getMessage());
				e.printStackTrace();

				return resultVO;
			}
		}else{

			resultVO.setCode(EConstants.CODE.FAILURE);
			resultVO.setMsg("获取手机号失败");
		}
		return resultVO;
	}

	@ApiOperation(value="根据用户新增用户（包括账户和角色）",notes="新增")
	@ApiImplicitParam(name="vo",value="用户对象")
	@PostMapping("/insertByVO")
	public @ResponseBody ResultVO insertByVO(@RequestBody UserVO userVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(signInService.doInsertUserRoles(userVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}

	@ApiOperation(value="根据邮箱查询用户名",notes="查询")
	@ApiImplicitParam(name="mail",value="邮箱")
	@GetMapping("/getUsernameByMail/{mail}/static")
	public @ResponseBody String getUsernameByMail(@PathVariable String mail){
		String username = null;
		try{
			username = signInService.getUsernameByMail(mail);
		}catch(Exception e){
			logger.error("{}",e.getMessage());
		}
		return username;
	}

    @ApiOperation(value="username",notes="查询")
    @ApiImplicitParam(name="username",value="参数列表")
    @GetMapping("/findByUsername/{username}/static")
    public @ResponseBody ResultVO findByUsername(@PathVariable String username){
        ResultVO resultVO = ResultVO.build();
        try{
            resultVO.setResult(signInService.findByUsername(username));
        }catch(Exception e){
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);

        }
        return resultVO;
    }

    @ApiOperation(value="根据mail查询用户信息",notes="查询")
    @ApiImplicitParam(name="mail",value="参数列表")
    @GetMapping("/findByMail/{mail}/static")
    public @ResponseBody ResultVO findByMail(@PathVariable String mail){
        ResultVO resultVO = ResultVO.build();
        try{
            resultVO.setResult(signInService.findByMail(mail));
        }catch(Exception e){
            logger.error("{}",e.getMessage());
            resultVO.setCode(EConstants.CODE.FAILURE);

        }
        return resultVO;
    }

	@ApiOperation(value="根据unscid查询用户信息",notes="查询")
	@ApiImplicitParam(name="map",value="参数列表")
	@PostMapping("/findByUnscid")
	public @ResponseBody ResultVO findByUnscid(@RequestBody Map params){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(signInService.findByUnscid(params));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);

		}
		return resultVO;
	}

	@ApiOperation(value="根据用户修改用户",notes="修改")
	@ApiImplicitParam(name="vo",value="用户对象")
	@PostMapping("/updateByVO")
	public @ResponseBody ResultVO updateByVO(@RequestBody AccountVO accountVO){
		ResultVO resultVO = ResultVO.build();
		try{
			resultVO.setResult(signInService.doUpdateAccount(accountVO));
		}catch(Exception e){
			logger.error("{}",e.getMessage());
			resultVO.setCode(EConstants.CODE.FAILURE);
		}
		return resultVO;
	}
}
