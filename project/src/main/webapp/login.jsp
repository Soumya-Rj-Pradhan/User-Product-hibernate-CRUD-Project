<%@page import="org.hbm.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String m = (String)request.getAttribute("msz"); 
if(m!=null){
%>
<%=m %>
<%} %>
<form action="login" method="post">
<input type="tel" name="ph" placeholder="enter phone"><br></br>
<input type="password" name="ps" placeholder="enter password"><br></br>
<input type="submit" value="LOGIN"><br></br>
</form>
<h3><a href="register.jsp">register</a></h3>
</body>
</html>