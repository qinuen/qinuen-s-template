package com.library.service;

import com.library.entity.User;

//Service��ӿ�
public interface UserService {
	
	//�����û���¼
	User checkLogin(String username,String password);
	
	//ע��
    public boolean addUser(String username,String password);

}
