package com.cmp.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmp.ssm.dao.StudentDao;
import com.cmp.ssm.domain.Student;

@Service
public class StudentServie {
	
	private @Autowired StudentDao dao;
	
	public Student findById(Integer id){
		//数据校验
		return dao.findById(id);
	}

	public void save(Student stu) {
		dao.insert(stu);
	}

	public void delete(Integer id) {
		dao.delete(id);
	}
}
