<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="EditProject" method="post" name="EditProject">
<b>Name of project:</b>
<input type="hidden" value="${project.idProject}" name="id"/>
<c:out value="${project.name}" />
<br />
<b>Description:</b>
<c:out value="${project.description}" />
<br />

<b>Date of creation:</b>
<c:out value="${project.dateOfCreation}" />
<br />

<b>Date of closing:</b>
<c:choose>
	<c:when test="${not empty project.dateOfClosing}">${project.dateOfClosing}</c:when>
	<c:otherwise>&nbsp;</c:otherwise>
</c:choose>
<br />
<b>Category:</b>
<c:choose>
	<c:when test="${not empty project.category}">${project.category.name}</c:when>
	<c:otherwise>&nbsp;</c:otherwise>
</c:choose>
<br />
<b>Version:</b>
<c:choose>
	<c:when test="${not empty project.version}">${project.version}</c:when>
	<c:otherwise>&nbsp;</c:otherwise>
</c:choose>
<br />
<b>License:</b>
<c:choose>
	<c:when test="${not empty project.license}">${project.license}</c:when>
	<c:otherwise>&nbsp;</c:otherwise>
</c:choose>
<br />
<b>Stage of development:</b>
<c:choose>
	<c:when test="${not empty project.stageOfDevelopment}">${project.stageOfDevelopment}</c:when>
	<c:otherwise>&nbsp;</c:otherwise>
</c:choose>
<br />
<b>Technologies:</b>
<c:choose>
	<c:when test="${not empty project.technology}">
		<c:forEach var="technology" items="${project.technology}">
	${technology.name};
		</c:forEach>
	</c:when>
	<c:otherwise>&nbsp;Not specified
	</c:otherwise>
</c:choose>
<br />
<b>Languages:</b>
<c:choose>
	<c:when test="${not empty project.languages}">
		<c:forEach var="language" items="${project.languages}">
	${language.name};
	</c:forEach>
	</c:when>
	<c:otherwise>&nbsp;</c:otherwise>
</c:choose><br/>
<c:if test="${project.user==user.id}">
<center><input type="submit" value="Edit"/></center>
</c:if>
</form>