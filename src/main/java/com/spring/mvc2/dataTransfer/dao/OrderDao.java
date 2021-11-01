package com.spring.mvc2.dataTransfer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.dataTransfer.domain.OrderDto;

@Repository
public class OrderDao {

	@Autowired
	private SqlSession sqlSession;
	
	/*
	 * 
	 * # Mapper To Dao
	 * 
	 *  - mybatis 연결 설정을 한후
	 *     1) [ pom.xml ] 의존성 추가
	 *     2) [ root-context.xml ] db 연결 정보 설정
	 *     3) [ mybatis-config.xml ] mybatis설정 정보 
 	 *     4) [ *.xml ] mapper 파일 생성
 	 *     
 	 *     SqlSession 객체를 생성하여 쿼리문을 실행한다.
 	 *     
	 *  - 한개의 데이터를 조회할 경우 .selectOne() 메서드를 사용한다.
	 *  - 한개 이상의 데이터를 조회할 경우 .selectList() 메서드를 사용하며 반환데이터는 List로 받을 수 있다.
	 *      주의) mapper파일에서의 resultType을 List로 사용하지 않고 selectList() 메서드로 List를 처리한다.
	 *  
	 * */
	
	public void selectAllData() {
		
		System.out.println("\n selectAll \n");
		
		List<OrderDto> orderList = sqlSession.selectList("order.selectAll");
		
		for (OrderDto orderDto : orderList) {
			System.out.println("memberId : "    + orderDto.getMemberId());
			System.out.println("orderId : "     + orderDto.getOrderId());
			System.out.println("productCode : " + orderDto.getProductCode());
			System.out.println("productName : " + orderDto.getProductName());
			System.out.println("productPrice: " + orderDto.getProductPrice());
			System.out.println("orderCount: "   + orderDto.getOrderCount());
			System.out.println("totalPrice: "   + orderDto.getTotalPrice());
			System.out.println("orderDate: "    + orderDto.getOrderDate());
			System.out.println();
		}
		
	}
	
	public void selectData1() {
		
		System.out.println("\n selectData1 \n");
		
		int result = sqlSession.selectOne("order.select1");
		System.out.println("selectData1 : " + result);
		
	}
	
	public void selectData2() {
		
		System.out.println("\n selectData2 \n");
		
		List<OrderDto> orderList = sqlSession.selectList("order.select2");
		
		for (OrderDto orderDto : orderList) {
			System.out.println("memberId : "    + orderDto.getMemberId());
			System.out.println("orderId : "     + orderDto.getOrderId());
			System.out.println("productCode : " + orderDto.getProductCode());
			System.out.println("productName : " + orderDto.getProductName());
			System.out.println("productPrice: " + orderDto.getProductPrice());
			System.out.println("orderCount: "   + orderDto.getOrderCount());
			System.out.println("totalPrice: "   + orderDto.getTotalPrice());
			System.out.println("orderDate: "    + orderDto.getOrderDate());
			System.out.println();
		}
		
	}
	
	
	public void selectData3() {
		
		System.out.println("\n selectData3 \n");
		
		List<Map<String,Object>> orderList = sqlSession.selectList("order.select3");
		for (Map<String, Object> orderMap : orderList) {
			System.out.println("memberId : "     + orderMap.get("memberId"));
			System.out.println("orderId : "      + orderMap.get("orderId"));
			System.out.println("productCode : "  + orderMap.get("productCode"));
			System.out.println("productName : "  + orderMap.get("productName"));
			System.out.println("productPrice : " + orderMap.get("productPrice"));
			System.out.println("tax : "          + orderMap.get("tax"));
			System.out.println("afterTax : "     + orderMap.get("afterTax"));
			System.out.println("orderCount : "   + orderMap.get("orderCount"));
			System.out.println("orderDate : "    + orderMap.get("orderDate"));
			System.out.println("imageName : "    + orderMap.get("imageName"));
			System.out.println("imageType : "    + orderMap.get("imageType"));
			System.out.println("fileSize : "     + orderMap.get("fileSize"));
			System.out.println();
			
		}
		
	}
	
	public void selectData4() {
		
		System.out.println("\n selectData4 \n");
		
		List<Map<String,Object>> orderList = sqlSession.selectList("order.select4");
		for (Map<String, Object> orderMap : orderList) {
			System.out.println("memberId : "     + orderMap.get("memberId"));
			System.out.println("orderId : "      + orderMap.get("orderId"));
			System.out.println("productCode : "  + orderMap.get("productCode"));
			System.out.println("productName : "  + orderMap.get("productName"));
			System.out.println("productPrice : " + orderMap.get("productPrice"));
			System.out.println("tax : "          + orderMap.get("tax"));
			System.out.println("afterTax : "     + orderMap.get("afterTax"));
			System.out.println("orderCount : "   + orderMap.get("orderCount"));
			System.out.println("orderDate : "    + orderMap.get("orderDate"));
			System.out.println("imageName : "    + orderMap.get("imageName"));
			System.out.println("imageType : "    + orderMap.get("imageType"));
			System.out.println("fileSize : "     + orderMap.get("fileSize"));
			System.out.println();
			
		}
		
	}
	
	/*
	 * 
	 * # Dao To Mapper
	 * 
	 *  - 2개 이상의 파라미터를 mapper로 전달할 수 없고 오직 1개의 파라미터만 전송이 가능하다.
	 *  - 2개 이상의 데이터는 Dto , Map형식으로 전송한다.
	 *  - 전송되는 복수의 데이터가 Dto의 멤버로 포함되어 있으면 일반적으로 Dto 전송 방식을 사용하고
	 *    전송되는 복수의 데이터가 Dto의 멤버에 포함되어 있지 않은 경우 Map 전송 방식을 사용한다.
	 * 
	 *  - insert쿼리를 사용할 경우 .insert() 메서드를 사용한다.
	 *  - update쿼리를 사용할 경우 .update() 메서드를 사용한다.
	 *  - delete쿼리를 사용할 경우 .delete() 메서드를 사용한다.
	 * 
	 * */
	
	// 예시1) 단일 데이터 전송
	public void insertSingleData(String memberId) {
		sqlSession.insert("order.insertSingleData" , memberId);
	}
	
	// 예시2) dto 전송
	public void insertDto(OrderDto orderDto) {
		sqlSession.insert("order.insertDto" , orderDto);
	}
	
	// 예시3) map 전송
	public void insertMap(Map<String,String> orderMap) {
		sqlSession.insert("order.insertMap" , orderMap);
	}
	
	
}
