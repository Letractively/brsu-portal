<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="text" name="textSearch"/>
<input type="checkbox" name="withResults"/>
<label>With Results</label>
<input type="button" name="search" value="Search"/>
<div id="content">
<div id="table">

<form action="/portal/Servlet/DelMessage" method="get">
<table>
	<thead>
		<tr>
			<th><input type="checkbox" name="id" value=""/></th>
			<th>Priority</th>
			<th>Email </th>
			<th>Subject</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="message" items="${messages}">
	<c:set var="url" value="/portal/Servlet/OpenIncomingMessage?idMessage=${message.id}&idUserFrom=${message.userFrom.id}"></c:set>
		<tr class="${message.readed==0?'notRead':'Read'}">
			<td><input type="checkbox" name="idMessage" value="${message.id}" /></td>
			<td><a href="${url}"><c:out value="${message.priority}"/></a></td>
			<td><a href="${url}"><c:out value="${message.userFrom.email}"/></a></td>
			<td><a href="${url}"><c:out value="${message.title}"/></a></td>
			<td><a href="${url}"><c:out value="${message.date}"/></a></td>
			<td><a href="/portal/Servlet/DelMessage?idMessage=${message.id}&idUserTo=${message.userTo.id}">X</a></td>
		</tr>
	</c:forEach> 
	</tbody>
</table>
</form>
</div>
</div>