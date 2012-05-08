<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/tags/security.tld" prefix="sec"%>


<div id="navigation">

		<div id="menu">
	<ul>
		<%
			request.setAttribute("currentPage", request.getParameter("currentPage"));
		%>
		<c:choose>
			<c:when test='${currentPage=="Main"}'>
				<li class="link_active"><a href="/portal/index.jsp" style="background-color: #9FB6CD">Main</a>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="/portal/index.jsp" >Main</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='${currentPage=="Projects"}'>
				<li><a href="/portal/Servlet/ShowProjects" style="background-color: #9FB6CD" >Projects</a>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="/portal/Servlet/ShowProjects" >Projects</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='${currentPage=="News"}'>
				<li><a href="/portal/Servlet/ShowNews" style="background-color: #9FB6CD ">News</a>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="/portal/Servlet/ShowNews">News</a>
				</li>
			</c:otherwise>
		</c:choose>
		<sec:permission role="Administrator">
			<c:choose>
				<c:when test='${currentPage=="Users"}'>
					<li><a href="/portal/Servlet/ShowUserProf" style="background-color: #9FB6CD">Users</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="/portal/Servlet/ShowUserProf">Users</a>
					</li>
				</c:otherwise>
			</c:choose>
		</sec:permission>
		<sec:permission role="Administrator,Moderator,Redactor">
		<c:choose>
			<c:when test='${currentPage=="IncomingMessages"}'>
				<li><a href="/portal/Servlet/IncomingMessages"
					style="color: Red">Messages</a>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="/portal/Servlet/IncomingMessages">Messages</a>
				</li>
			</c:otherwise>
		</c:choose>
		</sec:permission>
		<c:choose>
			<c:when test='${currentPage=="CV/Job"}'>
				<li><a href="#" style="background-color: #9FB6CD">CV/Job</a>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="#">CV/Job</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</div>