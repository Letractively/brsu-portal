<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
<div id="table">
<form>
	<table>
		<tr>
		<td>ID</td>
		<td> Surname</td>
		<td> Name </td>
		<td> Date of birth</td>
		<td> Sex </td>
		<td> Email</td>
		<td> Skype</td>
		<td> Telephone</td>
		<td> DateOfLastVisit</td>
		</tr>
	
		
			<tr>		
				<td><c:out value="${users_id.id}" /></td>
 				<td><c:out value="${users_id.name}" /></td>
 				<td><c:out value="${users_id.surname}" /></td>
 				<td><c:out value="${users_id.dateOfBirth}" /></td>
 				<td><c:out value="${users_id.sex}" /></td>								 
				<td><c:out value="${users_id.email}" /></td>				
				<td><c:out value="${users_id.skype}"></c:out></td>
				<td><c:out value="${users_id.telephone}"></c:out></td>
				<td><c:out value="${users_id.dateOfLastVisit}"></c:out></td>
			
			</tr>

</table>
</form>
<br>
<center>
<a href="/portal/Servlet/EditUser?id=<c:out value="${users_id.id}"></c:out>">Edit Profile</a>
</center>
</div>
</div>