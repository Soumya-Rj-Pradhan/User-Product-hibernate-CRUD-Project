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
	<% User u = (User)session.getAttribute("User"); 
	if(u!=null){
	%>
	<h2>welcome <%=u.getName() %></h2>
	<h2>ID: <%=u.getId() %></h2>
	<h2>AGE: <%=u.getAge() %></h2>
	<h2>EMAIL: <%=u.getEmail()%></h2>
	<h2>GENDER: <%=u.getGender()%></h2>
	<h2>PHONE: <%=u.getPhone()%></h2>
	<%
	}else
		response.sendRedirect("login.jsp");
	%>
</body>
</html>