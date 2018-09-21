package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.StudentDao;
import com.ssm.pojo.Student;

@Service
public class StudentServie {
	
	private @Autowired StudentDao dao;

	public Student getById(Integer id) {
		if(id==null || id<=0){
			return null;
		}
		return dao.selectById(id);
	}

	public List<Student> getAll() {
		return dao.selectAll();
	}

    public boolean save(Student stu) {
        //Query OK, 1 row affected
        int rows = dao.insertStudent(stu);
        if(rows == 1){
            return true;
        }
        return false;
    }
	
}
