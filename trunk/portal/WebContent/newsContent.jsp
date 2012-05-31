<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
	<c:forEach var="new" items="${news}">
		<div class="news"> <c:out value="${new.text}" /></div> 
	</c:forEach>
</div>