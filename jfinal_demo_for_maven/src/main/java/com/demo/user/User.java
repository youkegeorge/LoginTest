package com.demo.user;

import com.demo.common.model.base.BaseModel;

@SuppressWarnings("unused")
public class User extends BaseModel<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final User dao=new User().dao();
	
	public static final String column_id="id";	
	public static final String column_userName="userName";
	public static final String column_userPwd="userPwd";
	
	
	private String id;
	private String userName;
	private String userPwd;
	
	
	public void setId(String id){
		set(column_id, id);
	}
	public String getId() {
		return get(column_id);
	}
	
	public void setUserName(String userName){
		set(column_userName, userName);
	}
	public String getUserName() {
		return get(column_userName);
	}
	
	public void setUserPwd(String userPwd){
		set(column_userPwd, userPwd);
	}
	public String getUserPwd() {
		return get(column_userPwd);
	}
	
}
