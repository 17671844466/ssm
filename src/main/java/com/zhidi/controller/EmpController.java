package com.zhidi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhidi.commons.PagerHandler;
import com.zhidi.entity.Dept;
import com.zhidi.entity.Emp;
import com.zhidi.service.IDeptService;
import com.zhidi.service.IEmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private IEmpService empService;
	@Autowired
	private IDeptService deptService;
	
	@GetMapping("/list")//@RequestMapping( method=MethodType.GET)
	public String list() {
		return "emp/list";
	}
	
	@ResponseBody
	@PostMapping("/list")
	public PagerHandler<Emp> list(PagerHandler pager, String ename, @DateTimeFormat(pattern = "yyyy-MM-dd") Date hiredate) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ename", ename);
		params.put("hiredate", hiredate);
		pager = empService.getByPager(pager, params);
		return pager;
	}
	
	//新增或修改
	@GetMapping("/edit")
	public ModelAndView edit(ModelAndView mv, Integer empno) {
		//查询需要修改的员工
		Emp emp = empService.get(empno);
		//查询所有部门
		List<Dept> depts = deptService.getAll();
		
		mv.addObject("emp", emp);
		mv.addObject("depts", depts);
		mv.setViewName("emp/edit");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("/getMgr")
	public List<Emp> getMgr() {
		return empService.getAll();
	}
	
	//保存
	@PostMapping("/save")
	public String save(Emp emp) {
		if (emp.getEmpno() == null) {
			empService.save(emp);
			//如果没有主键代表新增
		} else {
			//否则代表修改
			empService.update(emp);
		}
		return "redirect:list.do";
	}

}
