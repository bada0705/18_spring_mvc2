package com.spring.mvc2.dataTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc2.dataTransfer.dao.OrderDao;

@Controller
@RequestMapping("mTOd")
public class MapperToDao {

	@Autowired
	private OrderDao orderDao;
	
	@RequestMapping(value="/selectAll" , method=RequestMethod.GET)
	public String selectAll() {
		orderDao.selectAllData();
		return "home";
	}
	
	@RequestMapping(value="/selectData1" , method=RequestMethod.GET)
	public String selectData1() {
		orderDao.selectData1();
		return "home";
	}
	
	@RequestMapping(value="/selectData2" , method=RequestMethod.GET)
	public String selectData2() {
		orderDao.selectData2();
		return "home";
	}
	
	@RequestMapping(value="/selectData3" , method=RequestMethod.GET)
	public String selectData3() {
		orderDao.selectData3();
		return "home";
	}
	
	@RequestMapping(value="/selectData4" , method=RequestMethod.GET)
	public String selectData4() {
		orderDao.selectData4();
		return "home";
	}
	
	
}
