package com.mybatis3.test;

import java.util.*;
import org.junit.*;
import com.mybatis3.domain.Student;
import com.mybatis3.services.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;

	@BeforeClass
	public static void setup() {
		studentService = new StudentService();
	}

	@AfterClass
	public static void teardown() {
		studentService = null;
	}

	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student);
	}

	@Test
	public void updateStudentName() {
		studentService.updateStudentName("zhaosi",3);
		
	}
	
	@Test
	public void creatAccount() {
		Student student = new Student();
		int id = 5;
		student.setStudId(id);
		student.setName("student_" + id);
		student.setEmail("student_" + id + "gmail.com");
		student.setDob(new Date());
		studentService.creatAccount(student);
		Student newStudent = studentService.findStudentById(id);
		Assert.assertNotNull(newStudent);
		
	}
}