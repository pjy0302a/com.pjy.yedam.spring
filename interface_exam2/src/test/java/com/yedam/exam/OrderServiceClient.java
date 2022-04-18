package com.yedam.exam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/*-context.xml")
public class OrderServiceClient {
	
	@Autowired
	OrdersDAO dao;
	@Test
	public void insert() {
		Orders vo = new Orders();
		vo.setOrd_no(1);
		vo.setCustomer("101");
		vo.setOrd_goods("g1");
		vo.setOrd_cnt(10);
		vo.setOrd_price(100);
		dao.insertOrders(vo);
	}
	
	

}
