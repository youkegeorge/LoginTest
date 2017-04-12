package com.demo.user;

import java.util.List;

import com.demo.commom.service.base.BaseService;
import com.jfinal.plugin.activerecord.Page;

public class UserService extends BaseService {
	
	public Page<User> paginate(int pageNumber,int pageSize){		
		return User.dao.paginate(pageNumber, pageSize, "select *", "from user order by id asc");		
	}
	
	public List<User> findUserList(){
		return null;
	}
	
	public User findUser(int id){
		return User.dao.findById(id);
	}
}
