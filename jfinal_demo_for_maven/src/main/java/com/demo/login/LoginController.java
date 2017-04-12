package com.demo.login;

import com.demo.user.User;
import com.demo.user.UserService;
import com.demo.user.UserValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;


public class LoginController extends Controller {

	@SuppressWarnings("unused")
	private static final Log log = Log.getLog(LoginController.class);
	
	private LoginService loginService;
	
	/**
	 * 准备登陆
	 */
	public void index() {
		render("/test/land.html");
	}
	
	/**
	 * 验证用户名是否存在
	 * @param userName
	 */
	public void find(String userName){
		User user = loginService.valiUserName(userName);
		boolean flag1=false;
		if(user != null){
			flag1=true;			
		}
		renderJson(flag1);//传到ajax中的data:flag1
	}
	
	/**
	 * 验证密码是否可用及其登录
	 */
	public void valiLogin(){
		String userName = getPara("userName");
		String userPwd = getPara("userPwd");
		int flag2 = loginService.login(getRequest(), getResponse(), userName, userPwd);
		renderJson(flag2);//flag2=1(姓名和密码正确),flag2=0(密码错误)
	}
	
	/**
	 * 注册保存新用户
	 */
	@Before(UserValidator.class)
	public void save() {
		getModel(User.class).save();
		redirect("/test/land.html");//转发到用户登录页面
	}
	/**
	 * 注销
	 */
	public void logout() {
		/*String cxtPath = getRequest().getContextPath();
		if(StrKit.isBlank(cxtPath)){
			cxtPath = "/";
		}*/
		
		getRequest().getSession().removeAttribute("currentUser");
		redirect("/test/land.html");
	}

}
