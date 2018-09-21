package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssm.pojo.Student;
import com.ssm.result.ResponseCode;
import com.ssm.result.ResponseResult;
import com.ssm.service.StudentServie;

@RestController
public class StudentController {

	private @Autowired StudentServie service;

	@GetMapping("student/{id}")
	public ResponseResult getById(@PathVariable Integer id) {
		ResponseResult responseResult;
		Student stu = service.getById(id);
		if(stu==null) {
			responseResult=new ResponseResult();
			responseResult.setCode(ResponseCode.FAIL);
			responseResult.setMessage("查询失败，无对应ID"+id+"的数据");
		} else {
			responseResult = new ResponseResult(ResponseCode.SUCCESS,"成功",stu);
		}
		return responseResult;
	}
	
	@GetMapping("students")
	public ResponseResult getAll() {
		ResponseResult responseResult;
		List<Student> stus=service.getAll();
		responseResult = new ResponseResult(ResponseCode.SUCCESS,"成功",stus);
		return responseResult;
	}
	
	@GetMapping("students")
	public ResponseResult save(Student stu) {
		ResponseResult responseResult;
		boolean successed = service.save(stu);
		if(successed) {
			responseResult=new ResponseResult(ResponseCode.SUCCESS,"成功");
		}else {
			responseResult = new ResponseResult();
			responseResult.setCode(ResponseCode.FAIL);
			responseResult.setMessage("添加失败");
		}
		return responseResult;
	}
}
