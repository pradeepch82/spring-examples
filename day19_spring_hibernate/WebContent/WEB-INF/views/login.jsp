<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
<style type="text/css">
.error {
	color: red
}
</style>
</head>
<body>
<center><h3>${requestScope.sts_mesg}</h3></center>
	<form:form method="post" modelAttribute="contactPOJO">
		<table>
			<tr>
				<td><form:label path="email">Contact Email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Contact Password</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Contact Login" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>