<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/portal/style.css">
<div id="container">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainMenu.jsp"></jsp:include>
	<% request.setAttribute("secondaryMenu", request.getParameter("secondaryMenu")); %>
	<c:if test="${not empty secondaryMenu}">
	<jsp:include page='<%= request.getParameter("secondaryMenu") %>'></jsp:include>
	</c:if>	
	<jsp:include page='<%= request.getParameter("content") %>'></jsp:include>	
	<jsp:include page="footer.jsp"></jsp:include>
</div>
