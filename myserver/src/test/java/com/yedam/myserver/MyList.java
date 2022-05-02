package com.yedam.myserver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.yedam.myserver.emp.vo.Employee;

/*class MyComp implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getFirst_name().compareTo(o2.getFirst_name());
	}
	
}*/

public class MyList{
	@Test
	public void test1() {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("홍길동"));
		list.add(new Employee("김길동"));
		list.sort((Employee o1, Employee o2) -> 
				o1.getFirst_name().compareTo(o2.getFirst_name())
			);
		System.out.println(list);
	}
}
