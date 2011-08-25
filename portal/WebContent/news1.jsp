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
	<div>
		<div><%@include file='header.jsp'%></div>
		<div><%@include file='mainMenu.jsp'%></div>
		<div>
			<c:forEach var="new" items="${news}">
				<li><c:out value="${new.text}" /></li>
			</c:forEach>
		</div>
		<div><%@include file='secondaryMenu.jsp'%></div>
		<div><%@include file='footer.jsp'%></div>
	</div>
</body>
</html>