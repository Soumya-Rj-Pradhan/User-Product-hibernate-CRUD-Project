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
<%User u = (User) session.getAttribute("User");
if(u!=null){
	List<Product> products = (List<Product>)request.getAttribute("products");
%>
<table border="1" cellpadding="10" align="center">
  <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>DESCRIPTION</th>
    <th>BRAND</th>
    <th>CATEGGORY</th>
    <th>IMAGE</th>
    <th>PRICE</th>
    <th>EDIT</th>
    <th>DELET</th>
  </tr>
  <%for(Product p:products){ %>
  <tr>
    <td><%=p.getId() %></td>
    <td><%=p.getName() %></td>
    <td><%=p.getDescription() %></td>
    <td><%=p.getBrand() %></td>
    <td><%=p.getCategory() %></td>
    <td><%=p.getImage() %></td>
    <td><%=p.getCost() %></td>
    <td><a href="find?pid=<%=p.getId()%>">Edit</a></td>
    <td><a href="deletProduct?pid=<%=p.getId()%>">Delete</a></td>
  </tr>
  <%} %>
</table>
<%
	}else
		response.sendRedirect("login.jsp");
	%>
</body>
</html>