<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer home</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
</head>
<body>

<%
String userid =(String) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/cus");
}
%>
<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="translist" class="a1">Transaction List</a></li>
<li><a href="helpRequests?req=${name}" class="a1">Help Requests</a></li>
<li><a href="trackstatus" class="a1">Track Complaint Status</a></li>
<li><a href="beforehelp" class="a1">Help</a></li>
<li><a href="cuslogout" class="a1">Logout</a></li>
</ul>
</div>
<div align="center">
<table border="2">
<th>Status</th>
<tr>
<td>${status}</td>
</tr>
</table>
</div>
</body>
</html>