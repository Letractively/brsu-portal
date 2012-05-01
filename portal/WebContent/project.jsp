<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="table">
<table cellspacing="0">
	<thead>
		<tr>
			<td>Name of project</td>
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
	</thead>
	<c:forEach var="project" items="${projects}">
		<tr>
			<td class="lc"><c:out value="${project.name}" /></td>
			<td><c:out value="${project.description}" /></td>
			<td><c:out value="${project.dateOfCreation}" /></td>
			<td><c:choose>
				<c:when test="${not empty project.dateOfClosing}">${project.dateOfClosing}</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose></td>
			<td><c:choose>
				<c:when test="${not empty project.category}">${project.category}</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose></td>
			<td><c:choose>
				<c:when test="${not empty project.version}">${project.version}</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose></td>
			<td><c:choose>
				<c:when test="${not empty project.license}">${project.license}</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose></td>
			<td><c:choose>
				<c:when test="${not empty project.stageOfDevelopment}">${project.stageOfDevelopment}</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose></td>
			<td><c:choose>
				<c:when test="${not empty project.technology}">${project.technology}</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose></td>
			<td><c:choose>
				<c:when test="${not empty project.languages}">${project.languages}</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose></td>
		</tr>
	</c:forEach>
</table>
</div>