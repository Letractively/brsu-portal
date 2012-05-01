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
				<li><a href="/portal/index.jsp" style="color: Red">Main</a>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="/portal/index.jsp">Main</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='${currentPage=="Projects"}'>
				<li><a href="/portal/Servlet/ShowProjects" style="color: Red">Projects</a>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="/portal/Servlet/ShowProjects">Projects</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test='${currentPage=="News"}'>
				<li><a href="/portal/Servlet/ShowNews" style="color: Red">News</a>
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
					<li><a href="/portal/Servlet/ShowUserProf" style="color: Red">Users</a>
					</li>
				</c:when>
				<c:otherwise>
					<li><a href="/portal/Servlet/ShowUserProf">Users</a>
					</li>
				</c:otherwise>
			</c:choose>
		</sec:permission>
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
		<c:choose>
			<c:when test='${currentPage=="CV/Job"}'>
				<li><a href="#" style="color: Red">CV/Job</a>
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