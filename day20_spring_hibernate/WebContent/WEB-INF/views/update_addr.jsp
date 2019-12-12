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
	<form:form method="post" modelAttribute="address">
		<table>
			<tr>
				<td><form:label path="state">State</form:label></td>
				<td><form:input path="state" /></td>
				<td><form:errors path="state" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
	
				<td><form:input path="city" /></td>
				<td><form:errors path="city" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="street">Street</form:label></td>
				<td><form:input path="street" /></td>
				<td><form:errors path="street" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="zipcode">Zip Code</form:label></td>
				<td><form:input path="zipcode" /></td>
				<td><form:errors path="zipcode" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Update Contact Address" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>