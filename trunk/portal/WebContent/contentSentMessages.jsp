<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="buttomSearch">
<input type="text"/>
<input type="checkbox" name="withResults"/>
<label>With Results</label>
<input type="button" name="search" value="Search"/>
</div>
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
		<tr><td><input type="checkbox" name="idMessage" value="${message.id}"></td>
			<td><a href="/portal/Servlet/OpenSentMessage?idMessage=${message.id}&idUserTo=${message.idUserTo}"><c:out value="${message.priority}"/></a></td>
			<td><a href="/portal/Servlet/OpenSentMessage?idMessage=${message.id}&idUserTo=${message.idUserTo}"><c:out value="${message.idUserTo}"/></a></td>
			<td><a href="/portal/Servlet/OpenSentMessage?idMessage=${message.id}&idUserTo=${message.idUserTo}"><c:out value="${message.title}"/></a></td>
			<td><a href="/portal/Servlet/OpenSentMessage?idMessage=${message.id}&idUserTo=${message.idUserTo}"><c:out value="${message.date}"/></a></td>
			<td><a href="/portal/Servlet/DelMessage?idMessage=${message.id}&idUserTo=${message.idUserTo}">X</a></td>
		</tr>
	</c:forEach> 
	</tbody>
</table>
</form>
</div>