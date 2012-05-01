<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="message">
<form action="/portal/Servlet/SendMessage" method="post">
<label>To:</label><input type="text" readonly="readonly" value="${message.idUserTo}"/>
<label>From:</label><input type="text" readonly="readonly" value="${message.idUserFrom}"/>
<label>Title:</label><input type="text" readonly="readonly" value="${message.title}"/>
<label>Date:</label><input type="text" readonly="readonly" value="${message.date}"/>
<label>Priority:</label><input type="text" readonly="readonly" value="${message.priority}"/>
<textarea name="message">${message.text}</textarea>
<div id="button">
<input type="button" name="reply" value="Reply"/>
<input type="button" name="save" value="Save"/>
<input type="button" name="delete" value="Delete"/>
</div>
</form>
</div>