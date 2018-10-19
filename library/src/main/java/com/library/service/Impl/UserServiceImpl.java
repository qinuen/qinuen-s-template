package com.library.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.UserDao;
import com.library.entity.User;
import com.library.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/*
	 * �����û���¼ҵ��
	 */
	public User checkLogin(String username, String password) {

		User user = userDao.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {

			return user;
		}
		return null;
	}
	
	/**
	 * ����sql���
	 */
	public boolean addUser(String username, String password) {
		userDao.insertUser(username, password);
		System.out.println("service_username"+username);
		System.out.println("service_password"+password);
		return true;
	}
}
