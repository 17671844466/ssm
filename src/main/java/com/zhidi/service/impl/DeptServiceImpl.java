package com.zhidi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.dao.DeptMapper;
import com.zhidi.entity.Dept;
import com.zhidi.service.IDeptService;

@Service
public class DeptServiceImpl implements IDeptService{

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> getAll() {
		return deptMapper.getAll();
	}

}
