package com.zhidi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhidi.commons.PagerHandler;
import com.zhidi.dao.EmpMapper;
import com.zhidi.entity.Emp;
import com.zhidi.service.IEmpService;

@Service
public class EmpServiceImpl implements IEmpService{
	
	@Autowired
	private EmpMapper empMapper;

	@Override
	public Boolean save(Emp emp) {
		return empMapper.insert(emp) > 0;
	}

	@Override
	public Boolean delete(Integer empno) {
		return empMapper.deleteByPrimaryKey(empno) > 0;
	}

	@Override
	public Boolean update(Emp emp) {
		return empMapper.updateByPrimaryKey(emp) > 0;
	}

	@Override
	public Emp get(Integer empno) {
		return empMapper.selectByPrimaryKey(empno);
	}

	@Override
	public List<Emp> getAll() {
		return empMapper.getAll();
	}

	@Override
	public PagerHandler<Emp> getByPager(PagerHandler pager, Map<String, Object> params) {
		//��ѯ����������
		Integer totalRows = empMapper.count(params);
		//���������������ͻ������ҳ��
		pager.setTotalRows(totalRows);
		//��ѯ����
		List<Emp> data = empMapper.getByPager((pager.getPageNumber() - 1) * pager.getPageSize(), pager.getPageSize(), params);
		//���������õ�PagerHandler��
		pager.setData(data);
		return pager;
	}

}
