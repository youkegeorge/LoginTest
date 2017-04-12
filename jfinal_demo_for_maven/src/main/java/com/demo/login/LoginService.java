package com.demo.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.commom.service.base.BaseService;
import com.demo.user.User;
import com.jfinal.plugin.activerecord.Page;

public class LoginService extends BaseService {

	public Page<User> paginate(int pageNumber,int pageSize){		
		return User.dao.paginate(pageNumber, pageSize, "select *", "from user order by id asc");		
	}
	
	/**
	 * 验证用户是否存在
	 * @param userIds
	 * @param userName
	 * @return
	 *
	 */ 
	public User valiUserName(String userName){
		User user=User.dao.findFirst("select * from user where user_name=?", userName);
		return user;
	}

	
	/**
	 * 用户登录后台验证
	 * @param request
	 * @param response
	 * @param userName	账号
	 * @param passWord	密码
	 * @return
	 */
	public int login(HttpServletRequest request, HttpServletResponse response, String userName, String passWord) {
		User user = valiUserName(userName);
		if(passWord.equals(user.getUserPwd())){
			request.getSession().setAttribute("currentUser", user);
			return 1;
		}
		return 0;
	}
}
