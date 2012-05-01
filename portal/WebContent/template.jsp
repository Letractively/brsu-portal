<link rel="stylesheet" type="text/css" href="/portal/style.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="layout_wrapper">
	<h1 class="logotip"><a href="index.jsp">BRSU Portal<br></a></h1> 
	
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainMenu.jsp"></jsp:include>
	<div id="main_content">
	<jsp:include page="sidebar_right.jsp"></jsp:include>
	<jsp:include page="sidebar_left.jsp"></jsp:include>
	<% request.setAttribute("secondaryMenu", request.getParameter("secondaryMenu")); %>
	<c:if test="${not empty secondaryMenu}">
		<jsp:include page='<%= request.getParameter("secondaryMenu") %>'></jsp:include>
	</c:if>	
	<% request.setAttribute("content", request.getParameter("content")); %>
	<c:if test="${not empty content}">
		<jsp:include page='<%= request.getParameter("content") %>'></jsp:include>	
	</c:if>
	
	
</div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
