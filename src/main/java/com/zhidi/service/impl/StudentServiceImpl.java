package com.zhidi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.dao.StudentMapper;
import com.zhidi.entity.Student;
import com.zhidi.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentMapper stuMapper;
	
	@Override
	public Boolean save(Student stu) {
		return stuMapper.insert(stu) > 0;
	}

	@Override
	public Student get(Integer id) {
		return stuMapper.selectByPrimaryKey(id);
	}

}
