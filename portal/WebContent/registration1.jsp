<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language = javascript type="text/javascript">
var CONSTS = new Array();
CONSTS['name'] = 'Pasha';
CONSTS['surname'] = 'Ghraznykh';
CONSTS['skype'] = 'pasha_pm07';
CONSTS['dateofbirth'] = '1989-06-28';
CONSTS['telephone'] = '+375336716757';
CONSTS['password'] = 'password';
CONSTS['about'] = 'I am students';
CONSTS['icq'] = '123321999';
CONSTS['email'] = 'pasha-9@tut.by';

function a(id, who){
	var control = document.getElementById(id);
	
	if (!who){
		if (control.value == CONSTS[id]){
		control.value = '';
		control.className = 'help1';
		}
		}
	else if(control.value == ''){
		control.value = CONSTS[id];
		control.className = 'help';
	}	
}

function initialize()
{
	adduserForm.name.value = CONSTS['name'];
	adduserForm.surname.value = CONSTS['surname'];
	adduserForm.skype.value = CONSTS['skype'];
	adduserForm.email.value = CONSTS['email'];
	adduserForm.telephone.value = CONSTS['telephone'];
	adduserForm.dateofbirth.value = CONSTS['dateofbirth'];
	adduserForm.about.value = CONSTS['about'];
	adduserForm.icq.value = CONSTS['icq'];
	adduserForm.password.value = CONSTS['password'];
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="initialize()">
	<div>
		
		<form action="Servlet/AddUser" method="post" name="adduserForm">
			<table>
			<tr><td><label for="name">Name:</label></td><td><input  type="text" name="name" id="name" class="help"  onfocus="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
			<tr><td><label for="surname">Surname:</label></td><td><input type="text" name="surname" id="surname" class="help" onclick="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
			<tr><td><label for="email">E-mail(login):</label></td><td><input type="text" name="email" id="email" class="help" onfocus="a(this.id,false)" onblur="a(this.id,true)"/></td></tr> 
			<tr><td><label for="password">Password:</label></td><td><input type="password" name="password" id="password" class="help" onfocus="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
			<tr><td><label for="sex">Sex:</label></td><td><select name="sex"><option selected="selected" value="1">male</option><option value="0">female</option></select></td></tr>
			<tr><td><label for="dateofbirth">Date of birth:</label></td><td><input type="text" name="dateofbirth" id="dateofbirth" class="help" onfocus="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
			<tr><td><label for="telephone">Telephone:</label></td><td><input type="text" name="telephone" id="telephone" class="help" onfocus="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
			<tr><td><label for="skype">Skype:</label></td><td><input type="text" name="skype" id="skype" class="help"  onclick="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
			<tr><td><label for="icq">ICQ:</label></td><td><input type="text" name="icq" id="icq" class="help" onfocus="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
<%--	 	<tr><td><label for="picture">Picture:</label></td><td><input type="file" name="picture"/></td></tr>--%>
 			<tr><td><label for="about">About:</label></td><td><input type="text" name="about" id="about" class="help" onfocus="a(this.id,false)" onblur="a(this.id,true)"/></td></tr>
			</table>			
			<center><input type="submit" value="Add User"/></center>
		</form>
	</div>
</body>
</html>