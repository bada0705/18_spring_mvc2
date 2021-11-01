<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
</head>
<body>
	<form action="transfer5" method="post"> 
		<fieldset>
			<legend>회원가입</legend>
			<p> 아이디 :   <input type="text"     name="id" /></p>	
			<p> 비밀번호 : <input type="password" name="password" /></p>	
			<p> 이름 :     <input type="text"     name="name" /></p>		
			<p> 이메일 :   <input type="email"    name="email"></p>	
		    <p> <input type="submit" value="회원가입" ></p>
		</fieldset>	
     </form>
</body>
</html>