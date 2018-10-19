package com.library.dao;

import org.apache.ibatis.annotations.Param;

import com.library.entity.User;

public interface UserDao {
	
	
	/**
	 * �����û���������
	 * @param username ��¼�û��� 
	 * @param password ����
	 * @return
	 */
	User findByUsername(String username);
	
	/**
	 * ע��
	 * @param username
	 * @param password
	 * @return
	 */
	
	public boolean insertUser(@Param("username")String username,@Param("password")String password);
}