package com.yedam.myserver.emp.vo;

import java.util.List;

import lombok.Data;

@Data
public class DeptEmpCollection {
	private String location_id;
	private String manager_id;
	private String department_name;
	private String department_id;
	
	List<Employee> employees;
}
