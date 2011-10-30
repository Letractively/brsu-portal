<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Message</title>
<style>
#message .label{float:left; color:blue; width:50px}
</style>
</head>
<body>
	<div id="message">
		<form action="Servlet/creatMessage" method="post" id="message">
			<label class="label" for="user">User:</label><input type="text" name="user" /><br>
			<label class="label" for="title">Title:</label><input type="text"	name="title" /><br> <br>
			<label class="label" for="text">Text:</label><textarea cols="47" rows="10"  wrap="off" />Theme1</textarea><br> 
			<br> <input type="submit" value="Send" /><br>
		</form>
	</div>
</body>
</html>