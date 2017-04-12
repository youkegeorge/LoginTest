package com.demo.user;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(UserInterceptor.class)
public class UserController extends Controller {
	private UserService userService;
	public void index() {
		setAttr("userPage", userService.paginate(getParaToInt(0, 1), 10));
		render("user.html");
	}
	
	public void add(){
	}
	public void find(int id){
		User user=userService.findUser(id);
		if(user != null){
			getSession().setAttribute("currentUser", user);
			redirect("/user");
		}
	}
	
	@Before(UserValidator.class)
	public void save() {
		getModel(User.class).save();
		redirect("/user");
	}
	
	public void edit() {
		setAttr("user", User.dao.findById(getParaToInt()));
	}
	
	@Before(UserValidator.class)
	public void update() {
		getModel(User.class).update();
		redirect("/user");
	}
	
	public void delete() {
		User.dao.deleteById(getParaToInt());
		redirect("/user");
	}
}


