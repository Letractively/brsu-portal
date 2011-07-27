<%@page import="by.brsu.portal.news.NewsDAO"%>
<%@page import="by.brsu.portal.news.News"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%
	NewsDAO nDAO = new NewsDAO();
%>
<%
	List<News> news = nDAO.readNews();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<TITLE>BRSU Portal</TITLE>
<META HTTP-EQUIV="Content-Type"
	CONTENT="text/html; charset=windows-1251">
<link rel="stylesheet" href="main.css" type="text/css">
</HEAD>
<BODY BGCOLOR=#FFFFFF background="images/bgb.jpg">
	<table width="778" height="30" border="0" cellspacing="0"
		cellpadding="0" background="images/Untitled-6.png">
		<tr>
			<td width="549"><img src="images/Untitled-7.png">
			</td>
			<td width="227">
				<form>
					<input type="text" id="Login" value="Login" size="10"> <input
						type="password" id="Password" value="Password" size="10">
					<input type="button" value="Log In" style="height: 18">
				</form></td>

		</tr>
	</table>
	<table width="778" border="0" cellspacing="0" cellpadding="0"
		background="images/Untitled-12.png">
		<tr>
			<td height="90">&nbsp;</td>
		</tr>
	</table>
	<table width="778" border="0" cellspacing="0" cellpadding="0"
		background="images/Untitled-6.png">
		<tr>
			<td width="550"><a href="index.html"><img
					src="images/Untitled-1.png" width="103" height="30"> </a><a
				href="projects.jsp"><img src="images/Untitled-2.png" width="103"
					height="30"> </a><a href="news.jsp"><img
					src="images/Untitled-3.png" width="103" height="30"> </a><a
				href="members.jsp"><img src="images/Untitled-4.png" width="103"
					height="30"> </a><a href="cv.jsp"><img
					src="images/Untitled-5.png" width="103" height="30"> </a>
			<td width="228">
				<form>
					<input type="text" value="search"> <input type="button">
				</form>
			</td>
			</td>
		</tr>
	</table>



	<table width="778" border="0" cellspacing="0" cellpadding="0">
		<tr valign="top">
			<td width="210" background="images/index_20.gif" rowspan="2">
				<table width="210" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="210" height="30"><img src="images/Untitled-8.png"
							width=210 height="30" alt=""></td>
					</tr>
				</table>
				<table width="210" border="0" cellspacing="0" cellpadding="10">
					<tr>
						<td width="210" class="main"></td>
					</tr>
				</table>
				<table width="210" border="0" cellspacing="0" cellpadding="10">
					<tr>
						<td width="210" class="main"></td>
					</tr>
				</table>
				<table width="210" border="0" cellspacing="0" cellpadding="0"
					height="20">
					<tr>

					</tr>
				</table>
			</td>
			<td width="356" background="images/index_32.jpg">

				<table width="356" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="356"><img src="images/Untitled-9.png" width=356
							height=30 alt=""></td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="1" cellpadding="5"
					background="images/index_32.jpg">
					<td valign="top" class="main">
					<tr>
						<h1>News</h1>
					</tr>
					<%
						for (int i = 0; i < news.size(); i++) {
					%>
					<tr border="1">
							<%
								News temp = news.get(i);
							%>
							<td>
							<%=temp.getTitle()%>
							</td>
							<td>
							<%=temp.getText()%>
							</td>
							<%
								}
							%>
					</tr>
					</td>
				</table>
			</td>
			<td width="212" rowspan="2" background="images/index_32(2).gif">
				<table width="212" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="212"><img src="images/Untitled-10.png" width=212
							height=30 alt=""></td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<p>&nbsp;</p></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr valign="top">
			<td width="356" valign="bottom" background="images/index_32.jpg">&nbsp;</td>
		</tr>
	</table>
	<table width="778" border="0" cellspacing="0" cellpadding="0"
		background="images/Untitled-11.png" height="56">
		<tr>
			<td align="center" class="main"><font color="#FFFFFF">Copyright
					© 2003 CompanyName. All Rights Reserved.</font>
			</td>
		</tr>
	</table>

	<map name="Map">
		<area shape="rect" coords="-1,12,266,19" href="#">
	</map>
</BODY>
</HTML>