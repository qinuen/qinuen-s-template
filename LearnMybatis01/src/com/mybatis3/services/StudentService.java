package com.mybatis3.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mybatis3.domain.Student;
import com.mybatis3.mappers.StudentMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;

public class StudentService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			// If sqlSession is not closed
			// then database Connection associated this sqlSession will not be
			// returned to pool
			// and application may run out of connections.
			sqlSession.close();
		}
	}

	public Student findStudentById(Integer studId) {
		logger.debug("Select Student By ID :{}", studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}

	public void updateStudentName(String name, Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.updateStudentName(name, id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void creatAccount(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.creatAccount(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}