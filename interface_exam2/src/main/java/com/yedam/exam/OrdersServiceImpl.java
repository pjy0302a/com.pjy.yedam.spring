package com.yedam.exam;



import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired	
	OrdersDAO dao;
	
	@Override
	public ResultVO insertOrders(List<Orders> list) {
		//테이블 입력		
		/*
		 * if(dao.insertOrders(orders) >=1000) { return 0; }
		 */
		
			//return dao.insertOrders(orders);  // 처리 건수 리턴;
		 System.out.println(list);
		 ResultVO result = new ResultVO();
		 List<String> errList = new ArrayList<String>();
		 // list의 수만큼 for 문을 사용
		 for(Orders vo : list) { // 자바에서 향상for문은 of 대신 ":" 사용
			 if(vo.getOrd_price()<1000)
				 dao.insertOrders(vo);
			 else {
				 errList.add(vo.getCustomer());
			 }
		 }
		 result.setTotal(list.size());
		 result.setSuccess(list.size() - errList.size());
		 result.setErrList(errList);
		 
		 return result;	
		
	}

}
