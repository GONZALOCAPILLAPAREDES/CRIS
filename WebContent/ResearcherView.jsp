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

	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Last name</th>
			<th>Password</th>
			<th>Email</th>
			<th>URL</th>
		</tr>


		<tr>
			<td>${ri.id}</td>
			<td>${ri.name}</td>
			<td>${ri.lastname}</td>
			<td>${ri.password}</td>
			<td>${ri.email}</td>
			<td>${ri.scopusURL}</td>
		</tr>
		
	</table>	
	<table>
		<tr>
			<th>Publications</th>
		</tr>
		
		<c:forEach items="${publications}" var="pi">
		<tr>
			<td><a href="PublicationServlet?pi=${pi.id}"> ${pi.id} </a></td>	
		</tr>
		</c:forEach>
	

	</table>

</body>
</html>