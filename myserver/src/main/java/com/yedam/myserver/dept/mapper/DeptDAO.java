package com.yedam.myserver.dept.mapper;

import java.util.List;

import com.yedam.myserver.emp.vo.Departments;

//@Repository
public interface DeptDAO {
	
	//@Autowired SqlSessionTemplate sqlSession;
	public List<Departments> findAll();
	//{
		//return sqlSession.selectList("DeptDAO.findAll");
	//}
}
