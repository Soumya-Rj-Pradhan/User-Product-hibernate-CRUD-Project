<%@page import="org.hbm.dto.User"%>
<%@page import="org.hbm.dto.Product"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add" method="post">
	NAME:<input type="text" name="nm">
	DESCRIPTION:<input type="text" name="desc">
	BRAND:<input type="text" name="br">
CATEGORY:<input type="text" name="cat">
IMAGE:<input type="text" name="im">
PRICE:<input type="text" name="price">
<input type="submit" value="ADD">
</form>
</body>
</html>