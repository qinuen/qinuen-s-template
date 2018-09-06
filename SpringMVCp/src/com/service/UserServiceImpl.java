package com.service;

import com.pojo.tb_users;

public interface UserServiceImpl {
	//用户登录
	public boolean userlogin(tb_users userS);
	
	//用户注册
	public boolean userrigister(tb_users userS);
	
	//用户修改
	public boolean userchange(tb_users userS);

}
