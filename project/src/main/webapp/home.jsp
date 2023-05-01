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
	<h3>
		<a href ="viewUser.jsp">VIEW PROFILE</a>
	</h3>
	<h3>
		<a href ="editUser.jsp">EDIT PROFILE</a>
	</h3>
	<h3>
		<a href ="delet">DELET PROFILE</a>
	</h3>
	<h3>
		<a href ="addProduct.jsp">ADD PRODUCTS</a>
	</h3>
	<h3>
		<a href ="viewProducts">VIEW PRODUCTS</a>
	</h3>
	<h3>
		<a href ="logout">LOGOUT</a>
	</h3>
	<%
	}else
		response.sendRedirect("login.jsp");
	%>
</body>
</html>