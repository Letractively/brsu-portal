<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
#container {
	width: 760px;
	border: 1px solid #999;
	margin: 0 auto;
}
</style>
</head>
<body BGCOLOR=#FFFFFF>
	<div id="container">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="mainMenu.jsp"></jsp:include>
		<jsp:include page='<%= request.getParameter("content") %>'></jsp:include>
		<!--<jsp:include page="secondaryMenu.jsp"></jsp:include>-->
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>