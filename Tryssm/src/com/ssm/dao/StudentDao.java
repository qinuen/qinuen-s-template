package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.pojo.Student;

@Repository
public interface StudentDao {
	
	public Student selectById(Integer id);
	
	public List<Student> selectAll();
	
	public int insertStudent(Student stu);

}
