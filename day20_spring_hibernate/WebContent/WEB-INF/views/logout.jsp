<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>Hello , ${requestScope.contactPOJO.email} , logged in under ${requestScope.contactPOJO.role}</h3>
	U r being logged out 
	<h3>Via session scope : ${sessionScope.valid_contact}</h3>
	<!-- <a href="/day19_spring_hibernate">Back To Index Page </a> -->
	<a href="${pageContext.request.contextPath}">Back To Index Page</a>
</body>
</html>