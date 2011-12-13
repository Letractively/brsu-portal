<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="text">
	<c:forEach var="new" items="${news}">
		<li><c:out value="${new.text}" /></li>
	</c:forEach>
</div>