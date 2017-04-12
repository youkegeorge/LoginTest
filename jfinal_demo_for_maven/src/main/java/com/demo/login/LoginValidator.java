package com.demo.login;

import com.jfinal.core.Controller;
import com.jfinal.log.Log;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

	@SuppressWarnings("unused")
	private static final Log log = Log.getLog(LoginController.class);
	
	@SuppressWarnings("unused")
	private LoginService loginService;
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();//获取提交表单中的action
		if (actionKey.equals("/login/vali")){
			validateString("userName", 5, 16, "usernameMsg", "请输入用户名!");
			validateString("userPwd", 6, 18, "passwordMsg", "请输入密码!");
		}
	}
	
	protected void handleError(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/login/vali")){
			controller.keepPara("userName", "userPwd");
			controller.render("/test/login.html");
		}
	}
	
}
