<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Message</title>
</head>
<body>
<div id="message">
<form action="Servlet/SendMessage" method="post">
<label for="user">To:</label><input type="text" name="user" /><br>
<label for="subject">Subject:</label><input type="text"	name="subject" /><br>
<label for="text">Text: </label><textarea name="text" rows="10" cols="80"></textarea><br>
	<label for="priority">Priority:</label>
		<select name="priority">
			<option selected="selected" value="1">Customary</option>
			<option value="2">Important</option>
			<option value="3">Very Important</option>
			<option value="4">Arhi Important</option>
		</select>
<br>
<input type="submit" value="Send" name="send"/><input type="button" value="Save" name="save" /><input type="reset" value="Clear">
</form>
</div>
</body>
</html>