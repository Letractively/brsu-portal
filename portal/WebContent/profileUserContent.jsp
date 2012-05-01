<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
<div id="table">
<form>
<table>
	<tr>
		<td>ID</td>
		<td>Surname and Name</td>
		<td>Date of birth</td>
		<td>Sex</td>
		<td>DateOfLastVisit</td>
	</tr>
	<c:forEach var="user" items="${users}">
		<tr>
			<td><c:out value="${user.id}" /></td>

			<c:url var="stUrl" value="ShowFullUser">
				<c:param name="id" value="${user.id}"></c:param>
			</c:url>
			<td><a href="${stUrl}"> <c:out value="${user.surname}" /> <c:out
				value="${user.name}" /></a></td>
			<td><c:out value="${user.dateOfBirth}" /></td>
			<td><c:if test="${user.sex>0}">
				<c:out value="men" />
			</c:if> <c:if test="${user.sex<1}">
				<c:out value="women" />
			</c:if></td>

			<td><c:out value="${user.dateOfLastVisit}"></c:out></td>
			<td><a	href="Servlet/DelUser?id=<c:out value="${user.id}"></c:out>"> X</a></td>
		</tr>
	</c:forEach>
</table>
</form>
</div>
</div>