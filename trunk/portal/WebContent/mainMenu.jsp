<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
#nav {
	width: 760px;
	height: 36px;
	color: #f00;
	font-size: 100%;
	font-weight: bold;
	line-height: 1.8em;
	text-align: center;
}

#nav ul {
	list-style-type: none;
}

#nav li {
	display: inline;
	margin: 0 8px;
}

#nav li a {
	color: #0c0;
}

#nav li a:hover {
	color: #f00;
}
</style>
</head>
<body>
	<div id="nav">
		<ul>
			<li><a href="/portal/index.jsp">Main</a></li>			
			<li><a href="Servlet/ShowProjects">Projects</a></li>
			<li><a href="Servlet/ShowNews">News</a></li>
			<li><a href="#">Member/People</a></li>
			<li><a href="#">CV/Job</a></li>
		</ul>
	</div>
</body>
</html>