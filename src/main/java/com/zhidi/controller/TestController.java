package com.zhidi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhidi.entity.Student;
import com.zhidi.service.IStudentService;

@Controller
public class TestController {

	@Autowired
	private IStudentService studentService;
	
	@ResponseBody
	@RequestMapping("/get")
	public Student get() {
		return studentService.get(2);
	}
}
