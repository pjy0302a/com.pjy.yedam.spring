package com.yedam.myserver.emp.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmpDeptAssociation {

	public EmpDeptAssociation() {}

	private Integer employee_id;
	private Integer manager_id;
	private Integer commission_pct;
	private Integer salary;
	private String job_id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hire_date;
	private String email;
	private String last_name;
	private String first_name;
	
	DepartmentsVO dept;

}
