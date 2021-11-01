<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>
</head>
<body>

	<h2>${method }</h2>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<c:forEach var="member" items="${memberList }">
			<tr align="center">
				<td>${member.id }</td>
				<td>${member.password }</td>
				<td>${member.name }</td>
				<td>${member.email }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>

