<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome 2 Spring web MVC</h3>
<h3>${requestScope.server_date}</h3>
<h3>${requestScope.name_list}</h3>
<h3>${requestScope.name_list.get(0)}</h3>
<h3>${requestScope.name_list.size()}</h3>
<h3>${requestScope.date}</h3>
</body>
</html>