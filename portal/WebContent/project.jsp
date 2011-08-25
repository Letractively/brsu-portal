<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<c:forEach var="project" items="${projects}">
			<tr>
				<td><c:out value="${project.idProject}" /></td>
				<td><c:out value="${project.idOwner}" /></td>
				<td><c:out value="${project.name}" /></td>
				<td><c:out value="${project.description}" /></td>
				<td><c:out value="${project.dateOfCreation}" /></td>
				<td><c:out value="${project.dateOfClosing}" /></td>
				<td><c:out value="${project.category}" /></td>
				<td><c:out value="${project.version}" /></td>
				<td><c:out value="${project.license}" /></td>
				<td><c:out value="${project.stageOfDevelopment}" /></td>
				<td><c:out value="${project.technology}" /></td>
				<td><c:out value="${project.languages}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>