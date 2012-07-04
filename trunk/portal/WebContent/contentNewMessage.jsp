<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="/portal/NewMessage.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Message</title>
</head>
<body onload="initialize()">
<form action="/portal/Servlet/SendMessage" method="post">
<div id="content">
<div id="content_message">
<c:out value="${error}"></c:out>
<fieldset title="New Message">
<legend title="New  Message">New Message</legend>
<label for="user">To:</label><input type="text" name="userTo" value="${userTo}"/> <br>
<label for="subject">Subject:</label><input type="text"	name="subject" value="${subject}"/><br>
<label for="text">Text: </label> <textarea name="text" >${text}</textarea><br>
	<label for="priority">Priority:</label>
		<select name="priority">
		<c:forEach var="priority" items="${prioritys}">
			<option value="${priority}">${priority}</option>
		</c:forEach>
		</select><br>
<div id="button">
<input type="submit" value="Send" name="send"/><input type="button" value="Save" name="save" /><input type="reset" value="Clear"/>
</div>
</fieldset>
</div>
</div>
</form>

</body>
</html>
