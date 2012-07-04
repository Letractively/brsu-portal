<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function focusElement() {
		var elem = document.SaveNewProject.myInput;
		elem.focus();
	}
	function focusElement1() {
		for ( var i = 0; i < document.SaveNewProject.list1.length; i++)
			document.SaveNewProject.list1.options[i].selected = true;
	}
	function addList() {
		valid = true;
		document.SaveNewProject.myInput.focus();
		var list1 = document.getElementById('list1');
		var li = document.createElement('option');

		if (document.SaveNewProject.myInput.value != "") {
			li.value = document.SaveNewProject.myInput.value;
			li.innerHTML = document.SaveNewProject.myInput.value;
			document.SaveNewProject.myInput.value = "";
			list1.appendChild(li);
		}
	}
</script>
<div>
	<form action="SaveProject" method="post" name="SaveProject">
	<input type="hidden" value="${project.idProject}" name="id"/>
		<table>
			<tr>
				<td width=170><label for="name"
					onmouseover='tooltip.show("Write Project name");'
					onmouseout='tooltip.hide();'>Project name:</label></td>
				<td width=120><input type="text" name="name" width=100
					onmouseover='tooltip.show("Write Project name");'
					onmouseout='tooltip.hide();' value="${project.name}" /></td>
			</tr>
			<tr>
				<td width=170><label for="owner"
					onmouseover='tooltip.show("Select current Users");'
					onmouseout='tooltip.hide();'>Owner name:</label></td>
				<td width=120>${owner.name}</td>
			</tr>
			<tr>
				<td width=170><label for="category"
					onmouseover='tooltip.show("Write Project category");'
					onmouseout='tooltip.hide();'>Category:</label></td>
				<td width=120><select name="projectCategory">
						<c:forEach var="category" items="${projectCategory}">
							<c:choose>
								<c:when test="${category == project.category}">
									<option value="${category.id }" selected="selected">
								</c:when>
								<c:otherwise>
									<option value="${category.id }">
								</c:otherwise>
							</c:choose>
							<c:out value="${category.name}"></c:out>
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td width=170><label for="version"
					onmouseover='tooltip.show("Write Project version");'
					onmouseout='tooltip.hide();'>Version:</label></td>
				<td width=120><input type="text" name="version"
					value="${project.version}"
					onmouseover='tooltip.show("Write Project version");'
					onmouseout='tooltip.hide();' /></td>
			</tr>
			<tr>
				<td width=170><label for="license"
					onmouseover='tooltip.show("Write license for Project");'
					onmouseout='tooltip.hide();'>License:</label></td>
				<td width=120><input type="text" name="license"
					value="${project.license}"
					onmouseover='tooltip.show("Write license for Project");'
					onmouseout='tooltip.hide();' /></td>
			</tr>
			<tr>
				<td width=170><label for="stageOfDevelopment"
					onmouseover='tooltip.show("Write stage Of development for Project");'
					onmouseout='tooltip.hide();'>Stage of development:</label></td>
				<td width=120><input type="text" name="stageOfDevelopment"
					value="${project.stageOfDevelopment}"
					onmouseover='tooltip.show("Write stage Of development for Project");'
					onmouseout='tooltip.hide();' /></td>
			</tr>
			<tr>
				<td width=170><label for="technology"
					onmouseover='tooltip.show("Choose Project technology");'
					onmouseout='tooltip.hide();'>Technology:</label></td>
				<td width=470>
					<c:forEach var="technology"
						items="${technologies}">
						<input type="checkbox" value="${technology.id}"
							onmouseover='tooltip.show("Choose Project technology");'
							onmouseout='tooltip.hide();' name="technology" />
						<c:out value="${technology.name}" />
					</c:forEach> <!-- </select>-->
				</td>
			</tr>
			<tr>
				<td width=170><label for="languages"
					onmouseover='tooltip.show("Choose Project languages");'
					onmouseout='tooltip.hide();'>Languages:</label></td>
				<td width=470>
					<!-- <select name="languages"> --> <c:forEach var="language"
						items="${languages}">
						<input type="checkbox" value="${language.idLanguage}"
							onmouseover='tooltip.show("Choose Project languages");'
							onmouseout='tooltip.hide();' name="language" />
						<c:out value="${language.name}" />
					</c:forEach> <!--</select>-->
				</td>
			</tr>
			<tr>
				<td width=170><label for="description"
					onmouseover='tooltip.show("Write about Project");'
					onmouseout='tooltip.hide();'>Description:</label></td>
				<td width=120><input type="text" name="description"
					onmouseover='tooltip.show("Write about Project");'
					onmouseout='tooltip.hide();' value="${project.description}" /></td>
			</tr>
			<tr>
				<td><label>Links:</label></td>
				<td><input name="myInput" value="" size="42" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input onclick='addList()' type="button" value='Add link' />
					<input type=button value='Delete link(s)'
					onClick="var q = form.list1.length; for(var i=0; i!=q; i++){if(form.list1.options[i].selected){	form.list1.options[i] = null;	i--;}}"><br />
					<br /> <select size="5" multiple="multiple" id="list1"
					name="list1" style="width: 200px;"></select>
				</td>
			</tr>
		</table>
		<center>
			<input type="submit" value="Save" onclick="focusElement1();" />
		</center>
	</form>
</div>