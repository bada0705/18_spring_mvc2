package com.spring.mvc2.dataTransfer.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc2.dataTransfer.domain.MemberDto;

@Controller
@RequestMapping("vTOc")
public class ViewToController {

	/* 
	 * 	
	 * 	예시 1) HttpServletRequest
	 * 
	 *  HttpServletRequest를 직접 이용하여 getParameter메서드를 이용하여 파라메타의 값에 접근 할 수 있다.
	 *  jsp에서의 사용법과 같다.
	 * 
	 */	
	@RequestMapping(value="/form" , method=RequestMethod.GET)
	public String form() {
		return "dataTransfer/joinForm";
	}
	
	@RequestMapping(value="/transfer1" , method=RequestMethod.POST)
	public String transfer1(HttpServletRequest request) {
		
		System.out.println("\n transfer1 \n");
		System.out.println("id : "       + request.getParameter("id"));
		System.out.println("password : " + request.getParameter("password"));
		System.out.println("name : "     + request.getParameter("name"));
		System.out.println("email : "    + request.getParameter("email"));
		System.out.println();
		
		return "home";
	}
	
	/*
	 * 
	 *  예시 2) 커멘드 객체
	 *  
	 *  예시 1번과 같은 방법은 요청 파라미터 개수가 증가할때마다 코드의 길이도 길어지는 단점이 있다. 
	 *  만약 파라메타의 개수가 20개면 파라미터의 값을 읽어와 설정하는 코드만 최소 40줄 이상 작성해야 한다.
	 *  
	 *  name인 요청 파라미터의 값을 커맨드 객체(pojo)의 setter 메서드를 사용해서 커맨드 객체에 전달한다.
	 *  
	 *  커맨드 객체라고 해서 특별한 코드를 작성하는 것이 아니라 pojo를 사용해주면 된다.
	 *  
	 */
	
	@RequestMapping(value="/transfer2" , method=RequestMethod.POST)
	public String transfer2(MemberDto mdto) {
		
		System.out.println("\n transfer2 \n");
		System.out.println("id : "       + mdto.getId());
		System.out.println("password : " + mdto.getPassword());
		System.out.println("name : "     + mdto.getName());
		System.out.println("email : "    + mdto.getEmail());
		System.out.println();
		
		return "home";
		
	}
	
	/* 
	 * 예시 3) Map
	 * 
	 * Map 컬렉션 프레임워크를 이용하여 요청파라미터에 접근이 가능하다.
	 * 
	 */
	@RequestMapping(value="/transfer3" , method=RequestMethod.POST)
	public String transfer3(@RequestParam Map<String,String> memberMap) {
		
		System.out.println("\n transfer3 \n");
		System.out.println("id : "       + memberMap.get("id"));
		System.out.println("password : " + memberMap.get("password"));
		System.out.println("name : "     + memberMap.get("name"));
		System.out.println("email : "    + memberMap.get("email"));
		System.out.println();
		
		return "home";
		
	}
	
	/* 
	  
	 	예시 4) [ 특정 값만 입력받기 ] requestParam 이용
	
		- 요청 파라미터의 개수가 얼마 되지 않는다면 @RequestParam어노테이션을 사용하여 파라메타의 값에 접근 할 수 있다. 
		- @RequestParam 어노테이션의 속성
		
			name 		 : 파라메타의 이름을 지정한다. 
			required	 : 필수 여부를 지정한다. 기본값은 true이며 요청값이 없으면 익셉션이 발생한다.
			defaultValue : 요청 파라미타의 값이 없을때 사용할 값을 지정한다.
		
	 */
	@RequestMapping(value="/transfer4" , method=RequestMethod.POST)
	public String transfer4(@RequestParam(name="id" , defaultValue = "anonymous")  String id ,
							@RequestParam(name="password" , defaultValue = "1111") String password) {
		
		System.out.println("\n transfer4 \n");
		System.out.println("id : "       + id);
		System.out.println("password : " + password);
		System.out.println();
		
		return "home";
		
	}
	
	/* 
	 * 예시 5) [ 특정 값만 입력받기 ] parameter에 직접 name값만 입력
	 * 
	 * 메서드의 파라미터에 name값을 직접 입력하여 파라메타에 접근이 가능하지만 , 
	 * 가독성 향상 및 코드의 통일성을 위해 @RequestParam 어노테이션 사용을 권장한다.
	 * 
	 */
	@RequestMapping(value="/transfer5" , method=RequestMethod.POST)
	public String transfer5(String id , String password , String name) {
		
		System.out.println("\n transfer5 \n");
		System.out.println("id : " + id    );
		System.out.println("password : " + password);
		System.out.println("name : " + name);
		System.out.println();
		
		return "home";
		
	}
	
}



