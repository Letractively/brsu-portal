<HTML>
<HEAD>
<TITLE>Добавление и удаление элементов из списков</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">

<script type="text/javascript">

function focusElement1() {
	 for(var i=0;i<document.forms[0].list1.length;i++) document.forms[0].list1.options[i].selected=true;
}
function focusElement() {
	var elem = document.forms[0].myInput;
	elem.focus();
	}
function addList(){
valid = true;
document.forms[0].combo3.focus()
var list1 = document.getElementsByTagName('select')[1]; 
var li   = document.createElement('option');
/*Запрещение ввода пустой строки */
//if (document.forms[0].combo3.value<1)
//return valid;
/* Ввод в список из текстового поля */
 
 
 for(var i=0;i<document.forms[0].combo3.length;i++) if(document.forms[0].combo3.options[i].selected==true) {li.value =document.forms[0].combo3.options[i].value; li.innerHTML =document.forms[0].combo3.options[i].label};
/* Очистка текстового поля */
//document.forms[0].combo3.value=""
list1.appendChild(li); 
}  
</script>
</HEAD>
<BODY onload='focusElement()'>
<form name="form1" method="post" action="Servlet/SaveNewProject">
<br /><b>Ввод элементов технической системы</b><br />
<input name="myInput" value= "" size="42" onclick='addList()'> <br /><br />
<select name="combo3" id="combo_3"  
style="width:200px;">
<option value="1" label="1">1</option>
<option value="4" label="2">3</option>
</select>
<input onclick='focusElement1();addList()' type="submit" 
value='Добавить элемент ТС в список'><br />
<input type=button value='Удалить элемент ТС из списка' 
onClick="var q = form.elements[4].length; for(i=0; i!=q; i++){if(form.elements[4].options[i].selected){	form.elements[4].options[i] = null;	i--;}}"><br /><br />
<b>Элементы ТС</b><br /><br />
<select size="5"  multiple="multiple" id="list1" name="list1"></select> 
</form>
</BODY>
</HTML>
