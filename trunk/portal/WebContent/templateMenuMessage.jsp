<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Message</title>
</head>
<body>
	<jsp:include page="/template.jsp">
		<jsp:param value="secondaryMenuForMessage.jsp" name="secondaryMenu" />
		<jsp:param value="contentIncomingMessages.jsp" name="content"/>

	</jsp:include>
</body>
</html>