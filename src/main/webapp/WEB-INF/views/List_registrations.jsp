<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Registrations</title>
</head>
<body bgcolor="#F4F6F7">
<center>
<table bgcolor="#BDC3C7">

<h1>All Registraitons</h1><br>

	<tr>
	<th>ID</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Mobile No. </th>
	<th>Delete </th>
	</tr>
	
	
	<c:forEach var="registration" items="${registrations}">
	 <tr>
	 <td>${registration.id}</td>
	<td>${registration.firstName}</td>	
	<td>${registration.lastName}</td>
	<td>${registration.email}</td>
	<td>${registration.mobile}</td>
	<td><a href="delete?id=${registration.id }">delete</a>
	</tr>
	</c:forEach>
	 
</table>
</center>
</body>
</html>