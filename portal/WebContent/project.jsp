<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Full information about project</title>
</head>
<body>
	<jsp:include page="/template.jsp">
		<jsp:param name="content" value="projectContent.jsp" />
		<jsp:param name="currentPage" value="Projects" />
	</jsp:include>
</body>
</html>