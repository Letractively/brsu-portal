<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language = javascript type="text/javascript">
var CONSTS = new Array();
CONSTS['name'] = 'Enter name';
CONSTS['surname'] = 'Enter surname';
CONSTS['skype'] = 'Enter skype';
CONSTS['dateofbirth'] = 'format(1989-06-28)';
CONSTS['telephone'] = 'Enter telephone';
CONSTS['password'] = 'password';
CONSTS['password2'] = CONSTS['password']; 
CONSTS['about'] = '';
CONSTS['icq'] = 'Enter ICQ';
CONSTS['email'] = 'Enter email';

function help(id, who){
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
	adduserForm.password2.value = CONSTS['password'];
	disablkey();
}

function checkPass() { 
with (document) 
getElementById ('info').innerHTML = (getElementById ('password').value != getElementById ('password2').value) ? 
   'Error' : 'OK';  
} 

function disablkey(){
adduserForm.but.disabled = (adduserForm.dateofbirth.value == CONSTS['dateofbirth'] || adduserForm.dateofbirth.value ==''||
		adduserForm.name.value == CONSTS['name']||adduserForm.name.value == '' || 
		adduserForm.surname.value == CONSTS['surname']||adduserForm.surname.value == '' ||
		adduserForm.email.value ==CONSTS['email'] || adduserForm.email.value == '' ||
		adduserForm.password.value !=adduserForm.password2.value||adduserForm.password.value ==''||adduserForm.password2.value == '' ||adduserForm.password.value == CONSTS['password']) ? true : false;	
}

function valid(id){
	var	cont = document.getElementById(id);
	
	if(adduserForm.name.value != CONSTS['name']||adduserForm.surname.value != CONSTS['surname']||adduserForm.email.value != CONSTS['email']||adduserForm.dateofbirth.value != CONSTS['dateofbirth']||adduserForm.password.value != CONSTS['password']||adduserForm.password2.value != CONSTS['password']){
				cont.className = 'greenfont';}
	if(adduserForm.name.value == ''||adduserForm.surname.value == ''||adduserForm.email.value == ''||adduserForm.dateofbirth.value == '' ||adduserForm.password.value == ''|| adduserForm.password2.value == ''){
		cont.className = 'redfont';}
}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="initialize()">
	<div>	
		<form action="Servlet/AddUser" method="post" name="adduserForm" >
			<table>
			<tr><td><label for="name">Name:</label></td><td><input  type="text" name="name" id="name" class="help" onchange="disablkey(),valid('inf')" onkeyup="disablkey(),valid('inf')"  onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td><td><b id="inf" class="redfont">*</b></td></tr>
			<tr><td><label for="surname">Surname:</label></td><td><input type="text" name="surname" id="surname" class="help" onchange="disablkey(),valid('inf1')" onkeyup="disablkey(),valid('inf1')"  onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td><td><b id="inf1" class="redfont">*</b></td></tr>
			<tr><td><label for="email">E-mail(login):</label></td><td><input type="text" name="email" id="email" class="help" onchange="disablkey(),valid('inf2')" onkeyup="disablkey(),valid('inf2')"  onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td><td><b id="inf2" class="redfont">*</b></td></tr> 
			<tr><td><label for="password">Password:</label></td><td><input type="password" name="password" id="password" class="help" onchange="disablkey(),valid('infp')" onkeyup="disablkey(),valid('infp')"  onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td><td><b id="infp" class="redfont">*</b></td></tr>
			<tr><td><label for="password2">Password repeat:</label></td><td><input type="password" name="password2"  id="password2"  onchange="disablkey(),valid('inf4')" onkeyup="disablkey(),valid('inf4'),checkPass()" class="help"  onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td><td><b id="inf4" class="redfont">*</b></td><td><b class="redfont" id="info"></b><br></td></tr>
			<tr><td><label for="sex">Sex:</label></td><td><select name="sex"><option selected="selected" value="1">male</option><option value="0">female</option></select></td></tr>
			<tr><td><label for="dateofbirth">Date of birth:</label></td><td><input type="text"  onchange="disablkey(),valid('inf3')" onkeyup="disablkey(),valid('inf3')"   name="dateofbirth" id="dateofbirth" class="help" onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td><td><b id="inf3" class="redfont">*</b></td></tr>
			<tr><td><label for="telephone">Telephone:</label></td><td><input type="text" name="telephone" id="telephone" class="help" onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td></tr>
			<tr><td><label for="skype">Skype:</label></td><td><input type="text" name="skype" id="skype" class="help"  onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td></tr>
			<tr><td><label for="icq">ICQ:</label></td><td><input type="text" name="icq" id="icq" class="help" onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td></tr>
<%--	 	<tr><td><label for="picture">Picture:</label></td><td><input type="file" name="picture"/></td></tr>--%>
 			<tr><td><label for="about">About:</label></td><td><input type="text" name="about" id="about" class="help" onfocus="help(this.id,false)" onblur="help(this.id,true)"/></td></tr>
			<tr><td> <b class="redfont">*</b> - REQUIRED FIELDS</td></tr>
			</table>			
			<center><input type="submit" id="but" name="but"  value="Add User" /></center>
		</form>
	</div>
</body>
</html>