<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="table">
<form action="Servlet/DelMessage" method="post">

<div id="buttomSearch">
<input type="text" name="someText" value="Input Text">
<input type="checkbox" name="withResults">
<label>With Results</label>
<input type="button" name="search" value="Search">
</div>
<table>
	<thead>
		<tr>
			<th><input type="checkbox" name="id" value=""></th>
			<th>Priority</th>
			<th>Email </th>
			<th>Subject</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="message" items="${messages}">
		<tr><td><input name="messageId" type="checkbox" name="idMessage" value="${message.id}"></td>
			<td><a href="#"><c:out value="${message.priority}"/></a></td>
			<td><a href="#"><c:out value="${message.idUserFrom}"/></a></td>
			<td><a href="#"><c:out value="${message.title}"/></a></td>
			<td><a href="#"><c:out value="${message.date}"/></a></td>
		</tr>
	</c:forEach> 
	</tbody>
</table>
<div id="button">
<input type="submit" value="Delete Checked"><input type="reset" value="Clear"> 
</div>

</form>
</div>