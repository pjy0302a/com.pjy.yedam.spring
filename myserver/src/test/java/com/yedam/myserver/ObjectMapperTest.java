package com.yedam.myserver;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.Test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.myserver.emp.vo.Departments;

public class ObjectMapperTest {
	//@Test
	public void toJson() throws Exception {
		Departments dept = new Departments();
		dept.setDepartment_id("500");
		dept.setDepartment_name("인사");
		//new ObjectMapper().writeValue(new File("dept.json"), dept);
		String str = new ObjectMapper().writeValueAsString(dept);
		System.out.println(str);
	}
	//@Test
	public void toObject() throws Exception{
		String str = "{\"location_id\":null,\"city\":null,\"manager_id\":null,\"manager_name\":null,\"department_name\":\"인사\",\"department_id\":\"500\"}";
//		Departments dept = new ObjectMapper().readValue(str, Departments.class);
		Departments dept = new ObjectMapper().readValue(new File("dept.json"), Departments.class);
		System.out.println(dept.getDepartment_name());
	}
	@Test
	public void URLtoObject() throws Exception {
		String url = "http://localhost/myserver/empSelect";
//	Employee[] employees= new ObjectMapper().readValue(new URL(url), Employee[].class);
	//List<Employee> list = Arrays.asList(employees);
	//System.out.println(list.get(0).getFirst_name());

//	List<Employee> empList = new ObjectMapper().readValue(new URL(url), new MyList());
//	System.out.println(empList.get(0).getFirst_name());
	}
}
