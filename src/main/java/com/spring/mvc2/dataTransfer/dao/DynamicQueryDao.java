package com.spring.mvc2.dataTransfer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.dataTransfer.domain.OrderDto;

@Repository
public class DynamicQueryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void ifEx(OrderDto orderDto) {
		sqlSession.insert("dynamicQuery.ifEx" , orderDto);
	}
	
	public void chooseEx(OrderDto orderDto) {
		sqlSession.insert("dynamicQuery.chooseEx" , orderDto);
	}
	
	public void foreachEx(List<OrderDto> orderList) {
		sqlSession.insert("dynamicQuery.foreachEx" , orderList);
	}
	
	public void whereEx(OrderDto orderDto) {
		
		OrderDto result = sqlSession.selectOne("dynamicQuery.whereEx" , orderDto);
		System.out.println("memberId : "     + result.getMemberId());
		System.out.println("orderId : "      + result.getOrderId());
		System.out.println("productCode : "  + result.getProductCode());
		System.out.println("productName : "  + result.getProductName());
		System.out.println("productPrice : " + result.getProductPrice());
		System.out.println("orderCount : "   + result.getOrderCount());
		System.out.println("totalPrice : "   + result.getTotalPrice());
		System.out.println("orderDate : "    + result.getOrderDate());
		System.out.println();
		
	}
	
	
	
	
	
}


