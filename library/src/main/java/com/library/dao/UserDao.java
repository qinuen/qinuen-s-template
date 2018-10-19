package com.library.dao;

import org.apache.ibatis.annotations.Param;

import com.library.entity.User;

public interface UserDao {
	
	
	/**
	 * 查找用户名和密码
	 * @param username 登录用户名 
	 * @param password 密码
	 * @return
	 */
	User findByUsername(String username);
	
	/**
	 * 注册
	 * @param username
	 * @param password
	 * @return
	 */
	
	public boolean insertUser(@Param("username")String username,@Param("password")String password);
}