package com.spring.mvc2.dataTransfer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc2.dataTransfer.domain.MemberDto;

@Controller
@RequestMapping("cTOv") // 중복되는 경로는 Controller위에 설정하여 코드의 중복을 줄일 수 있다.
public class ControllerToView {

	
	/*
	 *	전송방식을 지정해 GET과 POST 방식을 다른 메서드로 처리할 수 있다.
	 *	명시하지 않을 경우 GET과 POST방식을 모두 처리한다.
	 *	@GetMapping("/modelEx") 과 같이 어노테이션을 이용한 설정도 가능하다.
	 *	@RequestMapping("/modelEx")
	 */
	
	
	/*
	 * 
	 *  예시 1) Model
	 *  
	 *  메서드의 파라미터로 Model을 추가하여 addAddtribute("속성명","값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 
	 * */
	
	@RequestMapping(value="/modelEx" , method=RequestMethod.GET)
	public String modelEx(Model model) {
		
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		MemberDto mdto;
		
		for (int i = 1; i < 11; i++) {
			mdto = new MemberDto();
			mdto.setId("아이디"+i);
			mdto.setPassword("1111");
			mdto.setName("이름"+i);
			mdto.setEmail("anon@anon.com");
			memberList.add(mdto);
		}
		
		model.addAttribute("method" , "Model");
		model.addAttribute("memberList", memberList);
		
		return "dataTransfer/memberList";
		
	}
	
	
	/*
	 * 예시 2) ModelAndView
	 * 
	 * ModelAndView객체를 생성하여  addObject("속성명", "값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 관용적으로 객체명으로 mv 혹은 mav로 작성한다.
	 * 
	 * */
	@RequestMapping(value="/modelAndViewEx" , method=RequestMethod.GET)
	public ModelAndView modelAndViewEx() { // return 타입은 String이 아닌 ModelAndView 클래스타입을 작성한다.
		
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		MemberDto mdto;
		
		for (int i = 11; i < 21; i++) {
			mdto = new MemberDto();
			mdto.setId("아이디"+i);
			mdto.setPassword("1111");
			mdto.setName("이름"+i);
			mdto.setEmail("anon@anon.com");
			memberList.add(mdto);
		}
		
		
		//ModelAndView mv = new ModelAndView(); // ModelAndView 객체 생성
		//mv.setViewName("dataTransfer/memberList"); // view 파일명 작성
		
		//setViewName 메서드 대신 생성자의 인수로 view파일명을 지정할 수 있다.
		ModelAndView mv = new ModelAndView("dataTransfer/memberList");
		
		mv.addObject("method" , "ModelAndView");
		mv.addObject("memberList" , memberList);
		
		return mv;							  // ModelAndView 객체를 반환
		
	}
	
	/*
	 * 예시 3) httpServeletRequest
	 * 
	 * HttpServletRequest객체를 생성하여  setAttribute("속성명", "값") 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 
	 * */
	
	@RequestMapping(value="/requestEx" , method=RequestMethod.GET) 
	public String requestEx(HttpServletRequest request) {
		
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		MemberDto mdto;
		
		for (int i = 21; i < 31; i++) {
			mdto = new MemberDto();
			mdto.setId("아이디"+i);
			mdto.setPassword("1111");
			mdto.setName("이름"+i);
			mdto.setEmail("anon@anon.com");
			memberList.add(mdto);
		}
		
		request.setAttribute("method", "Request");
		request.setAttribute("memberList", memberList);
		
		return "dataTransfer/memberList";
		
	}
	
	/*
	  
	 	# 예시 4) ResponseBody  
	 	
	 	- ResponseEntity와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
	 	- 한글 데이터가 전송이 되지 않으며 한글 전송시 ResponseEntity의 객체의 
	 	  객체명.add("Content-Type", "text/html; charset=utf-8") 메서드를 이용하여 헤더 정보를 추가하여 사용한다.
	
	 */
	
	@RequestMapping(value="/responseBodyEx" , method=RequestMethod.GET)
	public @ResponseBody String responseBodyEx() {
		
		//return "html page";
		//return "<h1>html page</h1>";
		
		String message  = "<script>";
			   message +=    "alert('html page');";
			   message +=    "location.href = 'modelEx';";
			   message += "</script>";
	    
		return message;			  
	
	}
	
	
	/*
	  
		 # 예시 5) ResponseEntity
		 
			 - HTTP에서 Request와 Response 동작시 전송되는 정보는 크게 body(몸체) , headers(헤더), status code(상태 코드)가 있다.
			 - @ResponseBody 에는 없는 헤더와 상태코드가 함께 들어간다.
			
			1. body
			- HTTP의 request 또는 response가 전송하는 데이터(본문)
			
			2. headers
			- HTTP의 request 또는 response에 대한 부가적인 정보
			
			3. status code
			- 클라이언트의 요청이 성공적으로 처리되었는지 상태를 알려주는 것
			- 상태 코드는 필수적으로 리턴해주어야 한다.
	
	*/
	
	@RequestMapping(value="/responseEntityEx" , method=RequestMethod.GET)
	public ResponseEntity<Object> responseEntityEx(){
		
		//1) return new ResponseEntity<Object>(HttpStatus.OK);
		
		//2) return new ResponseEntity<Object>(data , HttpStatus.OK);
		
		//3)
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
		
		String data = "<h1>html페이지를 반환합니다.</h1>";
		return new ResponseEntity<Object>(data , responseHeaders ,HttpStatus.OK);		
		
	}
	
}

/*

	# 예시 6) RestController 이용 
	
	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 html 본문만 전송한다.
	- 클래스에 @RestController어노테이션을 작성하여 구현한다. 

*/

@RestController
class RestControllerEx {
		
	@RequestMapping(value="/restControllerEx" , method=RequestMethod.GET)
	public String restControllerEx() {
		
		String message  = "<script>";
		   message +=    "alert('html page');";
		   message +=    "location.href = 'modelEx';";
		   message += "</script>";
		
		return message;
		
	}
	
}









