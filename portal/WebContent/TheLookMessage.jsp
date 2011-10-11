<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
input{padding:3em 2em;
}
 </style>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>The Look Message</title>
</head>

<body bgcolor="#B5EDFB">
<fieldset title="The Look of Message">
<legend title="The Look of Message">The Look of Message</legend>
	  
	  To: 
	  <input type="text"  readonly="readonly"  name="Reg_to"/><br /><br />
 Who :   
 <input type="text" readonly="readonly" name="Reg_who"/><br /><br />
 Subject: 
 <input type="text"  readonly="readonly" name="Reg_subject"/><br /><br />
       <textarea cols="30" rows="10" name="Reg_mes" readonly="readonly" wrap="off">Theme 1</textarea><br /><br />
<input type="button" name="Reg_answer" value="Answer"/>
<input type="button" name="Reg_send" value="Send on"/> 
<input type="reset" name="Reg_reset" value="Reset"/>       
</fieldset>
</body>
</html>
