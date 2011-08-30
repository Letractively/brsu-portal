<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="text">
	<table border="1">
		<c:forEach var="project" items="${projects}">
			<tr>
				<td><c:out value="${project.idProject}" /></td>
				<td><c:out value="${project.idOwner}" /></td>
				<td><c:out value="${project.name}" /></td>
				<td><c:out value="${project.description}" /></td>
				<td><c:out value="${project.dateOfCreation}" /></td>
				<td><c:out value="${project.dateOfClosing}" /></td>
				<td><c:out value="${project.category}" /></td>
				<td><c:out value="${project.version}" /></td>
				<td><c:out value="${project.license}" /></td>
				<td><c:out value="${project.stageOfDevelopment}" /></td>
				<td><c:out value="${project.technology}" /></td>
				<td><c:out value="${project.languages}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>