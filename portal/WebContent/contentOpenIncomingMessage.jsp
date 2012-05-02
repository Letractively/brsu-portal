<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
<div id="content_message">

<form action="/portal/Servlet/SendMessage" method="post">
<fieldset title="Opened Message">
<legend title="Opened  Message">New Message</legend>
	<label>To:</label><input type="text" readonly="readonly" value="${message.userTo.email}"/><br/>
	<label>From:</label><input type="text" readonly="readonly" value="${message.userFrom.email}"/><br/>
	<label>Title:</label><input type="text" readonly="readonly" value="${message.title}"/><br/>
	<label>Date:</label><input type="text" readonly="readonly" value="${message.date}"/><br/>
	<label>Priority:</label><input type="text" readonly="readonly" value="${message.priority}"/><br/>
	<label>Text:</label><textarea name="message">${message.text}</textarea><br/>
<div id="button">
<input type="button" name="reply" value="Reply"/>
<input type="button" name="save" value="Save"/>
<input type="button" name="delete" value="Delete"/>
</div>
</fieldset>
</form>
</div>
</div>