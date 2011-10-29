<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Message</title>
</head>
<body background="/portal/images/bgb.jpg">
	<jsp:include page="/template.jsp">
		<jsp:param name="content" value="allMessage.jsp" />
		<jsp:param name="secondaryMenu" value="secondaryMenuMessage.jsp"/>
		<jsp:param name="currentPage" value="Message"/>
	</jsp:include>
</body>
</html>