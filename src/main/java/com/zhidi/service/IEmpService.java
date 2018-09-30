package com.zhidi.service;

import java.util.List;
import java.util.Map;

import com.zhidi.commons.PagerHandler;
import com.zhidi.entity.Emp;

public interface IEmpService {

	Boolean save(Emp emp);
	
	Boolean delete(Integer empno);
	
	Boolean update(Emp emp);
	
	Emp get(Integer empno);
	
	List<Emp> getAll();
	
	PagerHandler<Emp> getByPager(PagerHandler pager, Map<String, Object> params);
}
