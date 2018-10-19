package com.library.service;

import com.library.entity.User;

//Service层接口
public interface UserService {
	
	//检验用户登录
	User checkLogin(String username,String password);
	
	//注册
    public boolean addUser(String username,String password);

}
