package com.service;

import com.pojo.tb_users;

public interface UserServiceImpl {
	//�û���¼
	public boolean userlogin(tb_users userS);
	
	//�û�ע��
	public boolean userrigister(tb_users userS);
	
	//�û��޸�
	public boolean userchange(tb_users userS);

}
