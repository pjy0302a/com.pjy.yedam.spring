package com.yedam.myserver;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.yedam.myserver.emp.vo.Employee;

public class RestTemplateTest {
	
	@Test public void exchangeTest() {
		String url = "http://localhost/myserver/empInsertjson";
//		Employee param = new Employee();
//		param.setEmployee_id(4001);
//		param.setFirst_name("테스트");
//		param.setLast_name("용");
//		param.setEmail("a@a.z");
//		param.setHire_date(new Date());
//		param.setJob_id("IT_PROG");
		//vo -> map 
		Map<String, String> param = new HashMap<String,String>();
		param.put("employee_id", "4004");
		param.put("first_name", "길동2");
		param.put("last_name", "홍");
		param.put("email", "a123@n.com");
		param.put("hire_date", "2000-12-01");
		param.put("job_id", "IT_PROG");
		//header 설정
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, String>> request = new HttpEntity<>(param,headers);
		ResponseEntity<Employee> result = new RestTemplate().exchange(url,HttpMethod.POST,request,Employee.class);
		
		//이름만 출력
		System.out.println(result.getBody().getFirst_name());
		System.out.println(result.getBody());
		//System.out.println(result);
		}
	 
	//@Test
	public void getForObject() {
		RestTemplate rest = new RestTemplate();
		String uri = "http://localhost/myserver/empSelect";
		Employee[] emp = rest.getForObject(uri, Employee[].class);
		System.out.println(emp[0].getFirst_name());
	}

	//@Test
	public void getEntityTest() {
		RestTemplate rest = new RestTemplate();
		String uri = "http://localhost/myserver/empSelect";
		ResponseEntity<Employee[]> emp = rest.getForEntity(uri, Employee[].class);
		System.out.println(emp.getBody()[0].getFirst_name());
		System.out.println(emp.getStatusCodeValue());
	}
}
