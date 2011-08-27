<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new project</title>
</head>
<body>
	<div>
		<form action="Servlet/AddProject" method="post">
			<label for="name">Project name:</label><input type="text" name="name" /><br>
			<label for="owner">Owner name:</label><input type="text" name="owner" /><br>
			<label for="description">Description:</label><input type="text"
				name="description" /><br> <label for="category">Category:</label><input
				type="text" name="category" /><br> <label for="version">Version:</label><input
				type="text" name="version" /><br> <label for="license">License:</label><input
				type="text" name="license" /><br> <label
				for="stageOfDevelopment">Stage of development:</label><input
				type="text" name="stageOfDevelopment" /><br> <label
				for="technology">Technology:</label><input type="text"
				name="technology" /><br> <label for="languages">Languages:</label><input
				type="text" name="languages" /><br> <input type="submit"
				value="Add" />
		</form>
	</div>
</body>
</html>