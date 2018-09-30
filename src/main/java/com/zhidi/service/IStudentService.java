package com.zhidi.service;

import com.zhidi.entity.Student;

public interface IStudentService {

	Boolean save(Student stu);
	
	Student get(Integer id);
}
