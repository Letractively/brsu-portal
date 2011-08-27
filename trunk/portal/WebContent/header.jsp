<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
#header {
	color: Black;
	background: #665;
	width: 760px;
	height: 76px;
}
#header h3{
	margin:10px;
}
#headerLeft {
	float: left;
}
#headerRight {
	float: right;
}
#headerRight form{
	margin: 10px;
}
</style>
</head>
<body>
	<div id="header">
		<div id="headerLeft">
			<h3>BRSU Portal</h3>			
		</div>
		<div id="headerRight">
		<form>
				<input type="text" id="Login" value="Login" size="10"> <input
					type="password" id="Password" value="Password" size="10"> <input
					type="button" value="Log In" style="height: 18">
			</form>
			<form>
				<input type="text" value="search"> <input type="button"
					value="search" style="height: 18">
			</form>
		</div>
	</div>
</body>
</html>