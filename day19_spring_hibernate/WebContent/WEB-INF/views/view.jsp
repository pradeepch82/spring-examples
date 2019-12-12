<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach var="cp" items="${requestScope.contact_list}">
			<tr>
				<td>${cp.id}</td>
				<td>${cp.email}</td>
				<td>${cp.regAmount}</td>
				<td>${cp.regDate}</td>
			</tr>
		</c:forEach>
	</table>
	<spring:url var="url" value="admin_ok"/>
	<a href="${url}">Back To Admin Main Page</a>
</body>
</html>