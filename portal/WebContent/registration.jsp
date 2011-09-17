<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div>
		<form action="Servlet/AddUser" method="post">
			<label for="name">Name:</label><input type="text" name="name" /><br>
			<label for="surname">Surname:</label><input type="text"
				name="surname" /><br> <label for="email">E-mail(login):</label><input
				type="text" name="email" /><br> <label for="password">Password:</label><input
				type="password" name="password" /><br> <input type="submit"
				value="Add" />
		</form>
	</div>
</body>
</html>