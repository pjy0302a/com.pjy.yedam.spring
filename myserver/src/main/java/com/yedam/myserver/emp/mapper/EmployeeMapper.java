package com.yedam.myserver.emp.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.myserver.emp.vo.Departments;
import com.yedam.myserver.emp.vo.DeptEmpCollection;
import com.yedam.myserver.emp.vo.Employee;
import com.yedam.myserver.emp.vo.EmpDeptAssociation;
import com.yedam.myserver.emp.vo.Jobs;

public interface EmployeeMapper {
	List<EmpDeptAssociation> findDeptEmployeesAlias();
	List<DeptEmpCollection> findDeptEmployees();	//사원검색
	List<EmpDeptAssociation> findEmployeesDept();	//사원검색
	List<Employee> findEmployees(Employee emp);	//사원검색
	int persist(Employee emp);			//사원등록
	int merge(Employee emp);			//사원수정
	int remove(Employee emp);			//사원삭제
	
	List<Jobs> findJobs();				//job검색
	List<Departments> findDepartments();//부서검색
	List<Map<String, Object>> findStat(); //부서별 인원수
}
