<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript">
var tooltip=function(){
	var id = 'tt';
	var top = 3;
	var left = 3;
	var maxw = 300;
	var speed = 10;
	var timer = 20;
	var endalpha = 95;
	var alpha = 0;
	var tt,t,c,b,h;
	var ie = document.all ? true : false;
	return{
		show:function(v,w){
			if(tt == null){
				tt = document.createElement('div');
				tt.setAttribute('id',id);
				t = document.createElement('div');
				t.setAttribute('id',id + 'top');
				c = document.createElement('div');
				c.setAttribute('id',id + 'cont');
				b = document.createElement('div');
				b.setAttribute('id',id + 'bot');
				tt.appendChild(t);
				tt.appendChild(c);
				tt.appendChild(b);
				document.body.appendChild(tt);
				tt.style.opacity = 0;
				tt.style.filter = 'alpha(opacity=0)';
				document.onmousemove = this.pos;
			}
			tt.style.display = 'block';
			c.innerHTML = v;
			tt.style.width = w ? w + 'px' : 'auto';
			if(!w && ie){
				t.style.display = 'none';
				b.style.display = 'none';
				tt.style.width = tt.offsetWidth;
				t.style.display = 'block';
				b.style.display = 'block';
			}
			if(tt.offsetWidth > maxw){tt.style.width = maxw + 'px'}
			h = parseInt(tt.offsetHeight) + top;
			clearInterval(tt.timer);
			tt.timer = setInterval(function(){tooltip.fade(1)},timer);
		},
		pos:function(e){
			var u = ie ? event.clientY + document.documentElement.scrollTop : e.pageY;
			var l = ie ? event.clientX + document.documentElement.scrollLeft : e.pageX;
			tt.style.top = (u - h) + 'px';
			tt.style.left = (l + left) + 'px';
		},
		fade:function(d){
			var a = alpha;
			if((a != endalpha && d == 1) || (a != 0 && d == -1)){
				var i = speed;
				if(endalpha - a < speed && d == 1){
					i = endalpha - a;
				}else if(alpha < speed && d == -1){
					i = a;
				}
				alpha = a + (i * d);
				tt.style.opacity = alpha * .01;
				tt.style.filter = 'alpha(opacity=' + alpha + ')';
			}else{
				clearInterval(tt.timer);
				if(d == -1){tt.style.display = 'none';}
			}
		},
		hide:function(){
			clearInterval(tt.timer);
			tt.timer = setInterval(function(){tooltip.fade(-1)},timer);
		}
	};
};
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new project</title>
</head>
<body>
	<div>	
		<form action="Servlet/AddProject" method="post">
			<table >			
			<tr><td width=170><label for="name" onmouseover='tooltip.show("Write Project name");' onmouseout='tooltip.hide();'>Project name:</label></td> <td width=120><input type="text" name="name" width=100 onmouseover='tooltip.show("Write Project name");' onmouseout='tooltip.hide();'/></td></tr>
			<tr><td width=170><label for="owner" onmouseover='tooltip.show("Select current Users");' onmouseout='tooltip.hide();'>Owner name:</label></td> <td width=120>
			
			<select name="owner">
				<c:forEach var="owner" items="${owner}">
					<option value="${owner.id}" onmouseover='tooltip.show("Select current Users");' onmouseout='tooltip.hide();'><c:out value="${owner.name}" /></option>
				</c:forEach>
			</select>
			</td></tr>
			
			<!--<input type="text" name="owner" onmouseover='tooltip.show("Write Users id");' onmouseout='tooltip.hide();'/></td></tr>-->			
			<!-- <tr><td width=170><label for="datecr">Date Of Creation:</label></td> <td width=120><input type="text"	name="datecr" /></td></tr>
			<tr><td width=170><label for="datecl" onmouseover='tooltip.show("Write Date Of Closing Project");' onmouseout='tooltip.hide();'>Date Of Closing:</label></td> <td width=120><input type="text"	name="datecl" onmouseover='tooltip.show("Write Date Of Closing Project");' onmouseout='tooltip.hide();'/></td></tr>-->
			<tr><td width=170><label for="category" onmouseover='tooltip.show("Write Project category");' onmouseout='tooltip.hide();'>Category:</label></td> <td width=120><input type="text" name="category" onmouseover='tooltip.show("Write Project category");' onmouseout='tooltip.hide();'/></td></tr>
			<tr><td width=170><label for="version" onmouseover='tooltip.show("Write Project version");' onmouseout='tooltip.hide();'>Version:</label></td> <td width=120><input	type="text" name="version" onmouseover='tooltip.show("Write Project version");' onmouseout='tooltip.hide();'/></td></tr>
			<tr><td width=170><label for="license" onmouseover='tooltip.show("Write license for Project");' onmouseout='tooltip.hide();'>License:</label></td> <td width=120><input	type="text" name="license" onmouseover='tooltip.show("Write license for Project");' onmouseout='tooltip.hide();'/></td></tr>
			<tr><td width=170><label for="stageOfDevelopment" onmouseover='tooltip.show("Write stage Of development for Project");' onmouseout='tooltip.hide();'>Stage of development:</label></td> <td width=120><input	type="text" name="stageOfDevelopment" onmouseover='tooltip.show("Write stage Of development for Project");' onmouseout='tooltip.hide();'/></td></tr>
			<tr><td width=170><label for="technology" onmouseover='tooltip.show("Choose Project technology");' onmouseout='tooltip.hide();'>Technology:</label></td> <td width=470>
			<!-- <select name="technology">-->
			<c:forEach var="technology" items="${technology}">
			   <input type="checkbox" value="${technology.id}" onmouseover='tooltip.show("Choose Project technology");' onmouseout='tooltip.hide();'><c:out value="${technology.name}" />
			   </c:forEach>
			   <!--</select>-->
			   </td></tr>
			<tr><td width=170><label for="languages" onmouseover='tooltip.show("Choose Project languages");' onmouseout='tooltip.hide();'>Languages:</label></td> <td width=470>
			<!-- <select name="languages"> -->
			<c:forEach var="language" items="${languages}">
			   <input type="checkbox" value="${language.idLanguage}" onmouseover='tooltip.show("Choose Project languages");' onmouseout='tooltip.hide();'><c:out value="${language.name}" />
			   </c:forEach>
			   <!--</select>-->
			   </td></tr> 
			<tr><td width=170><label for="description" onmouseover='tooltip.show("Write about Project");' onmouseout='tooltip.hide();'>Description:</label></td> <td width=120><input type="text"	name="description" onmouseover='tooltip.show("Write about Project");' onmouseout='tooltip.hide();'/></td></tr>
			</table> 
			<input type="submit" value="Add Project" onmouseover='tooltip.show("Push the button and Project added");' onmouseout='tooltip.hide();' />
		</form>
	</div>
</body>
</html>