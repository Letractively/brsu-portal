<link rel="stylesheet" type="text/css" href="/portal/style.css">
<div id="container">
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="mainMenu.jsp"></jsp:include>
	<jsp:include page='<%= request.getParameter("content") %>'></jsp:include>
	<!--<jsp:include page="secondaryMenu.jsp"></jsp:include>-->
	<jsp:include page="footer.jsp"></jsp:include>
</div>
