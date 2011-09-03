<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="tabl">
	<table border="1">
		<tr bordercolor="12">
			<td >Name of project</td>
			<td>Description</td>
			<td>Date of creation</td>
			<td>Date of closing</td>
			<td>Category</td>
			<td>Version</td>
			<td>License</td>
			<td>Stage of development</td>
			<td>Technology</td>
			<td>Languages</td>
		</tr>
		<c:forEach var="project" items="${projects}">
			<tr>
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