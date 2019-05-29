package com.cmp.ssm.dao;

import org.springframework.stereotype.Repository;

import com.cmp.ssm.domain.Student;

@Repository
public interface StudentDao {
	
	public Student findById(Integer id);

	public void insert(Student stu);

	public void delete(Integer id);
	
}
