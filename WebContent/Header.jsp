<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${not (empty user)}">
	<p>You are authenticated as ${user.id}</p>
	<p><a href="LogoutServlet">Logout</a></p>
</c:if>
<c:if test="${empty user}">
	<form action="LoginServlet" method="post">
   <input type="text" name="email" placeholder="Email">
   <input type="password" name="password" placeholder="Password">
   <button type="submit">Login</button>
</form>
</c:if>
<p style="color: red;">${message}</p>
<h3>
	<a href="ResearchersListServlet">Researchers list</a>
</h3>
<hr>
</body>
</html>