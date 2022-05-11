package com.yedam.myserver.dept.mapper;

import java.util.List;

import com.yedam.myserver.emp.vo.Departments;

//@Repository
public interface DeptDAO2 {
	
	public List<Departments> findAll(Departments dept);

}
