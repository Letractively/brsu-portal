<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to BRSU Portal</title>
</head>
<body>
<form
	action="Servlet/SaveEditUser?id=<c:out value="${edit.id}"></c:out>"
	method="post">
<table>

	<tr>
		<td><label for="surname">Surname:</label></td>
		<td><input value="<c:out value="${edit.name}"></c:out>"
			type="text" name="surname"></td>
	</tr>
	<tr>
		<td><label for="name">Name:</label></td>
		<td><input value="<c:out value="${edit.surname}"></c:out>"
			type="text" name="name"></td>
	</tr>
	<%-- 	<tr><td><label for="dateOfBirth">Date of birth:</label></td> <td><input value="<c:out value="${edit.dateOfBirth}"></c:out>" type="text" name="dateOfBirth"></td></tr>--%>

	<tr>
		<td><label for="sex">Sex:</label></td>
		<td><input value="<c:out value="${edit.sex}"></c:out>"
			type="text" name="sex">
		</td>
	</tr>

	<tr>
		<td><label for="email">Email:</label></td>
		<td><input value="<c:out value="${edit.email}"></c:out>"
			type="text" name="email">
		</td>
	</tr>
	<tr>
		<td><label for="skype">Skype:</label></td>
		<td><input value="<c:out value="${edit.skype}"></c:out>"
			type="text" name="skype">
		</td>
	</tr>
	<%-- 	<tr><td><label for="dateOfLastVisit">Date of last visit:</label></td> <td><input value="<c:out value="${edit.dateOfLastVisit}"></c:out>" type="text" name="dateOfLastVisit"><td></tr>--%>
	<tr>
		<td><label for="telephone">Telephone:</label></td>
		<td><input value="<c:out value="${edit.telephone}"></c:out>"
			type="text" name="telephone">
		</td>
	</tr>
	<tr>
		<td>
		<center><input type="submit" value="Save Changes" /></center>
		</td>
	</tr>



</table>
</form>

</body>
</html>