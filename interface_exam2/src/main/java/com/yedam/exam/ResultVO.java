package com.yedam.exam;

import java.util.List;


public class ResultVO {
	private Integer total;
	private Integer success;
	List<String> errList;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSuccess() {
		return success;
	}
	public void setSuccess(Integer success) {
		this.success = success;
	}
	public List<String> getErrList() {
		return errList;
	}
	public void setErrList(List<String> errList) {
		this.errList = errList;
	}
	
	
	
}
