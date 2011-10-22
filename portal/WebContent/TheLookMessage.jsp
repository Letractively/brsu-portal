<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#mainForm {font-size:10pt;}
#mainForm .label{float:left;color:blue;width:150px;}
#mainForm .labelb{color:blue}
#mainForm .legend{color:blue;font-weight:bold;font-size:1.25em;}


 </style>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>The Look Message</title>
</head>

<body bgcolor="#B5EDFB">
<form method="get" id="mainForm">
<fieldset title="The Look of Message">
<legend class="legend" title="The Look of Message">The Look of Message</legend>
<label class="label" for="txt1">To:</label><input type="text" readonly="readonly" value="" size="25" maxlength="20" id="txt1"/><br>
<label class="label" for="txt2">Who:</label><input type="text" value="" size="25" readonly="readonly" maxlength="20" id="txt2"/><br>
<label class="label" for="txt3">Subject:</label><input type="text" value="" size="25" maxlength="20" readonly="readonly" id="txt3"/><br><br>

   <!--<label class="label" for="txt4"></label>-->
    <textarea cols="47" rows="10" name="Reg_mes" readonly="readonly" wrap="off" id="txt4">Theme 1</textarea><br /><br />
<input type="button" name="Reg_answer" value="Answer" class="labelb"/>
<input type="button" name="Reg_send" value="Send on" class="labelb"/> 
<input type="reset" name="Reg_reset" value="Reset" class="labelb"/>       
</fieldset>
</form>
</body>
</html>
