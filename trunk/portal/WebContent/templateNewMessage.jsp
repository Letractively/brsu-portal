<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tags/security.tld" prefix="sec"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Message</title>
</head>
<body>
	<jsp:include page="/template.jsp">
		<jsp:param value="secondaryMenuForMessage.jsp" name="secondaryMenu"/>
		<jsp:param value="contentNewMessage.jsp" name="content"/>
	</jsp:include>
</body>
</html>