<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="registration">
			<c:choose>
			<c:when test="${empty user}">
				<form action="Login" method="post">
					<input type="text" name="userName" size="10"> <input
						type="password" name="password" size="10"> <input
						type="submit" value="Log In" style="height: 18"><br>
					<a href="/portal/registration.jsp">Registration</a>
				</form>
			</c:when>
			<c:otherwise>
				<form action="/portal/LogOut" method="post">
					<p align="right">
						<input type="submit" value="LogOut" />
					</p>
				</form>
			</c:otherwise>
		</c:choose>
		<form>
			<input type="text" value="search"> <input type="button"
				value="search" style="height: 18">
		</form>
	</div>
