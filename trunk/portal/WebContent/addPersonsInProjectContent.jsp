<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function focusElement() {
		var elem = document.SaveNewProject.myInput;
		elem.focus();
	}
	function focusElement1() {
		for ( var i = 0; i < document.AddParticipantsInProject.list1.length; i++)
			document.AddParticipantsInProject.list1.options[i].selected = true;
	}
	function addList() {
		valid = true;
		document.AddParticipantsInProject.participant.focus();
		var list1 = document.getElementById('list1');
		var li = document.createElement('option');
		/*Запрещение ввода пустой строки */
		//if (document.forms[0].combo3.value<1)
		//return valid;
		/* Ввод в список из текстового поля */

		for ( var i = 0; i < document.AddParticipantsInProject.participant.length; i++) {
			if (document.AddParticipantsInProject.participant.options[i].selected == true) {
				for ( var j = 0; j < document.AddParticipantsInProject.position.length; j++) {
					if (document.AddParticipantsInProject.position.options[j].selected == true) {
						li.value = document.AddParticipantsInProject.participant.options[i].value+ ","+ document.AddParticipantsInProject.position.options[j].value;
						li.innerHTML = document.AddParticipantsInProject.participant.options[i].label+ " - "+ document.AddParticipantsInProject.position.options[j].label;
					}
				}
				document.AddParticipantsInProject.participant.options[i] = null;
			}
		}
		;
		/* Очистка текстового поля */
		//document.forms[0].combo3.value=""
		list1.appendChild(li);

	}
</script>
<div>
	<form action="Servlet/AddParticipantsInProject" method="post"
		name="AddParticipantsInProject">
		<select name="participant" id="participant">
			<c:forEach var="participant" items="${participants}">
				<option value="${participant.id}" label="${participant.name}">${participant.name}</option>
			</c:forEach>
		</select> <select name="position" id="position">
			<c:forEach var="position" items="${positions}">
				<option value="${position.id}" label="${position.name}">${position.name}</option>
			</c:forEach>
		</select> <br> <input onclick='addList()' type="button"
			value='Add participant' /> <input type=button
			value='Delete participant(s)'
			onClick="var q = form.list1.length; for(var i=0; i!=q; i++){if(form.list1.options[i].selected){	form.list1.options[i] = null;	i--;}}"><br />
		<br /> <select size="5" multiple="multiple" id="list1" name="list1"
			style="width: 200px;"></select>
			<input type="hidden" name="project" value="<c:out value="${project}"/>"/>
		<center>
			<input type="submit" value="Save participant(s)"
				onclick="focusElement1();" />
		</center>
	</form>
</div>