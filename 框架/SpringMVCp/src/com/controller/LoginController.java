package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.tb_users;
import com.service.UserService;

@Controller
public class LoginController {

	private UserService userService;

	public LoginController() {
		userService = new UserService();
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	
	@RequestMapping("/userLogin")
	public String canlogin(String username, String password) {
		tb_users userS = new tb_users();
		userS.setUser_name(username);
		userS.setUser_pass(password);

		UserService us = new UserService();
		if (us.userlogin(userS)) {
			System.out.println("success");
			String page = "success";
			return page;
		} else {
			System.out.println("bad");
			String page = "bad";
			return page;
		}
	}
	
	@RequestMapping("/userRigister")
	public String canrigister(String username,String password) {
		tb_users userS = new tb_users();
		userS.setUser_name(username);
		userS.setUser_pass(password);
		
		UserService us = new UserService();
		if(us.userrigister(userS)) {
			String page = "login";
			return page;
		}else {
			String page = "bad";
			return page;
		}
	}
	
	@RequestMapping("/userChange")
	public String canrchange(String username,String password) {
		tb_users userS = new tb_users();
		userS.setUser_name(username);
		userS.setUser_pass(password);
		
		UserService us = new UserService();
		if(us.userchange(userS)) {
			String page = "login";
			return page;
		}else {
			String page = "bad";
			return page;
		}
	}

}
