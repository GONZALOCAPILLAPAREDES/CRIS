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
			<th>URL</th>
			<th>Publications</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${researcherslist}" var="ri">

			<tr>
				
				<td><a href="ResearcherServlet?id=${ri.id}"> ${ri.id} </a></td>
				<td>${ri.name}</td>
				<td>${ri.lastname}</td>
				<td>${ri.scopusURL}</td>
				<td>${fn:length(ri.publications)}</td>
				<td>${ri.email}</td>
			</tr>

		</c:forEach>
	</table>


</body>
</html>