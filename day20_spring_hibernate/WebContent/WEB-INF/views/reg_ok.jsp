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
	<center>
		<h3>${requestScope.sts_mesg}</h3>
	</center>
	<h3>${sessionScope.valid_contact}</h3>
	<spring:url var="url" value="update_addr" />
	<a href="${url}">Update Address</a><br/>
	<spring:url var="url" value="logout" />
	<a href="${url}">Log Out </a>
</body>
</html>