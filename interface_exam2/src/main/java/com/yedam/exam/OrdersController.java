package com.yedam.exam;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OrdersController {
	
	@Autowired OrdersService service;
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//주문처리 핸들러 작성

	 @ResponseBody // @Restful 이 선언 안되어있다면 무조건 ResponseBody 서언
	 @PostMapping("/insertOrders")
	 public ResultVO insertOrders(@RequestBody List<Orders> list){ // 단건으로 받는거면 VO타입으로 변수기입
		 return service.insertOrders(list);
		 
			/*
			 * Orders newOrder = new Orders(); newOrder.setCustomer(orders.getCustomer());
			 * newOrder.setOrd_no(orders.getOrd_no());
			 * newOrder.setOrd_goods(orders.getOrd_goods());
			 * newOrder.setOrd_cnt(orders.getOrd_cnt());
			 * newOrder.setOrd_price(orders.getOrd_price()); List<Orders> ord = new
			 * ArrayList<Orders>(); ord.add(newOrder);
			 */ 
	 }
	 
	
}
