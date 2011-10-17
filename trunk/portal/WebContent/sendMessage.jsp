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
		<form action="Servlet/SendMessage" method="post">
			<label for="user">To:</label>
				<input type="text" name="user" />
			<br>
			<label for="subject">Subject:</label>
				<input type="text"	name="subject" />
			<br> 
			<label for="text">Text: </label>
				<textarea name="text" rows="10" cols="80"></textarea>
			<br>
			<label for="priority">Priority:</label>
				<select name="priority">
					<option selected="selected" value="0">Normal</option>
					<option value="1">Important</option>
				</select>
			<br>
			<input type="submit" value="Send" />
			<br>
		</form>
	</div>
</body>
</html>