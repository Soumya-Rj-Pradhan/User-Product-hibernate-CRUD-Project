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
<% User u = (User)session.getAttribute("User"); %>
	<h2>welcome <%=u.getName() %></h2><br></br>
	<%if(u!=null){ %>
	<form action="edit" method = "post">
	ID(hidden):<input type="hidden" name = "id" value="<%=u.getId()%>"><br></br>
	NAME:<input type="text" name = "nm" value="<%=u.getName()%>"><br></br>
	EMAIL:<input type="email" name = "em" value="<%=u.getEmail()%>"><br></br>
	GENDER:<input type="radio" name = "gender" value="male">MALE<br></br>
	<input type="radio" name = "gender" value="female">FEMALE<br></br>
	AGE:<input type="number" name = "age" value="<%=u.getAge()%>"><br></br>
	PHONE:<input type="tel" name = "ph" value="<%=u.getPhone()%>"><br></br>
	PASSWORD:<input type="password" name = "ps" value="<%=u.getPassword()%>"><br></br>
	<input type="submit" value="SAVE">
	</form>
	<%}else{
		response.sendRedirect("login.jsp");
		}%>
	
</body>
</html>