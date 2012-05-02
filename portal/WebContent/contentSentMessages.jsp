<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
<input type="text"/>
<input type="checkbox" name="withResults"/>
<label>With Results</label>
<input type="button" name="search" value="Search"/>

<div id="table">
<form action="Servlet/DelMessage" method="get">
<table>
	<thead>
		<tr>
			<th><input type="checkbox"></th>
			<th>Priority</th>
			<th>Email </th>
			<th>Subject</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="message" items="${messages}">
	<c:set var="url" value="/portal/Servlet/OpenSentMessage?idMessage=${message.id}&idUserTo=${message.userTo.id}"></c:set>
		<tr><td><input type="checkbox" name="idMessage" value="${message.id}"></td>
			<td><a href="${url}"><c:out value="${message.priority}"/></a></td>
			<td><a href="${url}"><c:out value="${message.userTo.email}"/></a></td>
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