<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to BRSU Portal</title>
</head>
<body>
<form>
		<table>						
			<tr><td><label>Surname:</label></td>  <td><input type="text" name="surname"/></td></tr>			
			<tr><td><label>Name:</label></td><td><input  type="text" name="name"/></td></tr>	
			<tr><td><label>Date of birth:</label></td><td><input type="text" name="dateofbirth"/><td></tr>	
			<tr><td><label>Telephone:</label></td><td><input type="text" name="telephone"/></td></tr>
			<tr><td><label>About:</label></td><td><input type="text" name="about"/></td></tr>			
		</table>	
</form>

<form action="/portal/Servlet/ShowUserProf">
<center><input  type="submit" value="Save Changes" /></center>
</form>
</body>
</html>