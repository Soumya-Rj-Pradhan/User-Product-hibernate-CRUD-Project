<%@page import="org.hbm.dto.User"%>
<%@page import="org.hbm.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	User u = (User)session.getAttribute("User");
	if(u!=null){
		Product p = (Product)request.getAttribute("product");
	%>
	<form action="editProduct" method="post">
		<input type="hidden" value="<%=p.getId() %>" name="id" ><br></br>
		<input type="text" value="<%=p.getName() %>" name="nm" ><br></br>
		<input type="text" value="<%=p.getDescription()%>" name="desc" ><br></br>
		<input type="text" value="<%=p.getBrand() %>" name="br" ><br></br>
		<input type="text" value="<%=p.getCategory() %>" name="cat" ><br></br>
		<input type="text" value="<%=p.getImage() %>" name="im" ><br></br>
		<input type="text" value="<%=p.getCost() %>" name="price" ><br></br>
		<input type="submit" value="UPDATE" ><br></br>
	</form>
	<%
	}else
		response.sendRedirect("login.jsp");
	%>
</body>
</html>