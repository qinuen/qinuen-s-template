package com.cmp.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cmp.ssm.domain.Student;
import com.cmp.ssm.service.StudentServie;

@Controller
public class StudentController {
	
	private @Autowired StudentServie service;
	
	@GetMapping("student/query/{id}")
	public String find(@PathVariable Integer id,Model model){
		//service->dao(mybatis)->db
		Student stu = service.findById(id);
		model.addAttribute("stu", stu);
		return "list";
	}
	
	@PostMapping("student/add")
	public String add(Student stu){
		service.save(stu);
		return "success";
	}
	
	@GetMapping("student/del/{id}")
	public String del(@PathVariable Integer id){
		service.delete(id);
		return "success";
	}
}
