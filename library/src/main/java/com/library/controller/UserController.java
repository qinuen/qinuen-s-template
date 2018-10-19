package com.library.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.library.entity.User;
import com.library.service.UserService;

@Controller
@RequestMapping("/user")

// ��������@SessionAttributes������ֱ�Ӱ�model�е�user(Ҳ��key)��������
// ������֤��session�д���user�������
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userServivce;

	// ��������loginҳ��
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// ���ύ������·��
	@RequestMapping("/checkLogin")
	public String checkLogin(User user, Model model) {
		// ����service����
		user = userServivce.checkLogin(user.getUsername(), user.getPassword());
		// ����user����ӵ�model�ﲢ����ת���ɹ�ҳ��
		if (user != null) {
			model.addAttribute("user", user);
			return "success";
		}
		return "fail";
	}

	// ���Գ�������ת����һ��ҳ���Ƿ����ȡ��sessionֵ
	@RequestMapping("/anotherpage")
	public String hrefpage() {
		return "anotherpage";
	}

	// ע������
	@RequestMapping("/outLogin")
	public String outLogin(HttpSession session) {
		// ͨ��session.invalidata()������ע����ǰ��session
		session.invalidate();
		return "login";
	}

	// ע��
	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/checkRegister")
	public String addUser(User user) {
		userServivce.addUser(user.getUsername(), user.getPassword());
		
		System.out.println("controller_username"+user.getUsername());
		System.out.println("controller_password"+user.getPassword());
		return "login";
	}
}
