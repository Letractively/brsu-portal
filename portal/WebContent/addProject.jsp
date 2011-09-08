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
			<table>
			<tr><td width=170><label for="name">Project name:</label></td> <td width=120><input type="text" name="name" width=100 /></td></tr>
			<tr><td width=170><label for="owner">Owner name:</label></td> <td width=120><input type="text" name="owner" /></td></tr>
			<tr><td width=170><label for="description">Description:</label></td> <td width=120><input type="text"	name="description" /></td></tr>
			<tr><td width=170><label for="category">Category:</label></td> <td width=120><input type="text" name="category" /></td></tr>
			<tr><td width=170><label for="version">Version:</label></td> <td width=120><input	type="text" name="version" /></td></tr>
			<tr><td width=170><label for="license">License:</label></td> <td width=120><input	type="text" name="license" /></td></tr>
			<tr><td width=170><label for="stageOfDevelopment">Stage of development:</label></td> <td width=120><input	type="text" name="stageOfDevelopment" /></td></tr> 
			<tr><td width=170><label for="technology">Technology:</label></td> <td width=120><input type="text" name="technology" /></td></tr>
			<tr><td width=170><label for="languages">Languages:</label></td> <td width=120><input	type="text" name="languages" /></td></tr>
			</table> 
			<input type="submit" value="Add Project" />
		</form>
	</div>
</body>
</html>