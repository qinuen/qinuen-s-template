package com.mybatis3.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	void insertStudent(Student student);
	
	void updateStudentName(@Param("name") String name,@Param("id") Integer id);
	
	void creatAccount(Student student);
}