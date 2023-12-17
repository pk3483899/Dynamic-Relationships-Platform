<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ include file="menu.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create lead</title>
</head>
<body>
	<h1>Create lead</h1>
	<h3>Insert data</h3>
	
	<pre>
	<form action="saveReg" method="post">
	First Name: <input type="text" name="firstName"/>
	Last Name : <input type="text" name="lastName"/>
	Email	  : <input type="email" name="email"/>
	Mobile	  : <input type="tel" name="mobile"/>
	<input type="Submit" value="Save"/>
	</form>
</pre>
	${msg}
	
</body>
</html>