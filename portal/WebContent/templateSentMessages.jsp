<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sent Messages</title>
</head>
<body>
	<jsp:include page="/template.jsp">
		<jsp:param value="secondaryMenuForMessage.jsp" name="secondaryMenu"/>
		<jsp:param value="contentSentMessages.jsp" name="content" />
	</jsp:include>
</body>
</html>