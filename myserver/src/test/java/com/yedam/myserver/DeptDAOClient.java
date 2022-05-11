package com.yedam.myserver;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.myserver.dept.mapper.DeptDAO2;
import com.yedam.myserver.emp.vo.Departments;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/*-context.xml")

public class DeptDAOClient {
	@Autowired DeptDAO2 deptDAO;
	@Test
	public void findAll() {
		Departments dept = new Departments();
		dept.setDepartment_id("10");
		dept.setLocation_id("1000");
		List<Departments> list = deptDAO.findAll(dept);
		System.out.println(list);
	}
}
