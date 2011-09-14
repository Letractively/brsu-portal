<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
<form>
	<table class="tabl">
		<tr>
		<td>ID</td>
		<td> Surname 
		<td> Name </td>
		<%--		<td> Options </td>		--%>
		<td> Date of birth</td>
		<td> Sex </td>
		<td> Email</td>
		<td> Skype</td>
		<td> Telephone</td>
		<td> DateOfLastVisit</td>
		
		
		</tr>
	
		
		
		<c:forEach var="user" items="${users}">
			<tr>		
				<td><c:out value="${user.id}" /></td> 
				<td><c:out value="${user.surname}" /></td>
			 	<td><c:out value="${user.name}" /></td>	
		<%--	 	<td> <a href="/portal/onlyProfileUser.jsp">Full</a> </td> 	--%>
				<td><c:out value="${user.dateOfBirth}" /></td>					
				<td><c:out value="${user.sex}"/></td>			 
				<td><c:out value="${user.email}" /></td>				
				<td><c:out value="${user.skype}"></c:out>
				<td><c:out value="${user.telephone}"></c:out>
				<td><c:out value="${user.dateOfLastVisit}"></c:out>
			
			</tr>
		</c:forEach>
</table>
</form>
<form action="/portal/edit.jsp">
<button type="submit">Edit Profile</button>
</form>
</div>