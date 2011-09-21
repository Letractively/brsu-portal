<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Message</title>
</head>
<body>
	<div>
		<form action="Servlet/creatMessage" method="post">
			<label for="user">User:</label><input type="text" name="user" /><br>
			<label for="title">Title:</label><input type="text"	name="title" /><br> 
			<label for="text">Text:</label><input type="text" name="text" /><br> 
			<br> <input type="submit" value="Send" /><br>
		</form>
	</div>
</body>
</html>