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
		<form action="Servlet/AddUser" method="post">
			<table>
			<tr><td><label for="name" >Name:</label></td><td><input type="text" name="name"/></td></tr>
			<tr><td><label for="surname">Surname:</label></td><td><input type="text" name="surname"/></td></tr>
			<tr><td><label for="email">E-mail(login):</label></td><td><input type="text" name="email"/></td></tr> 
			<tr><td><label for="password">Password:</label></td><td><input type="password" name="password"/></td></tr>
			<tr><td><label for="sex">Sex:</label></td><td><select name="sex"><option selected="selected">select sex</option><option value="1">men</option><option value="0">women</option></select></td></tr>
		<tr><td><label for="dateofbirth">Date of birth:</label></td><td><input type="text" name="dateofbirth"/></td></tr>
			<tr><td><label for="telephone">Telephone:</label></td><td><input type="text" name="telephone"/></td></tr>
			<tr><td><label for="skype">Skype:</label></td><td><input type="text" name="skype"/></td></tr>
			<tr><td><label for="icq">ICQ:</label></td><td><input type="text" name="icq"/></td></tr>
		<%--<tr><td><label for="picture">Picture:</label></td><td><input type="file" name="picture"/></td></tr>--%>
			<tr><td><label for="about">About:</label></td><td><input type="text" name="about"/></td></tr>
			</table>		
			
			<center><input type="submit" value="Add User"/></center>
		</form>
	</div>
</body>
</html>