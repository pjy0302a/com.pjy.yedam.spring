package com.yedam.myserver.emp.vo;

import java.util.List;

import lombok.Data;

@Data
public class ModifyData<T> {
	List<T> createRows;
	List<T> updateRows;
	List<T> deleteRows;
	
	//위젯 사용시 위젯에서 요구하는
	//요청,응답 구조대로 서버 프로그램 작성
}
