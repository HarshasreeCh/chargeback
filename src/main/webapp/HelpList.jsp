<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
</head>
<body>
<%
String userid =(String) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="employees" class="a1">New Employees</a></li>
<li><a href="feedbkcustomers" class="a1">Feedback Questionaire</a></li>
<li><a href="acceptuserregisteration" class="a1">Accept Users</a></li>
<li><a href="helpreq" class="a1">Help Requests</a></li>
<li><a href="adminlogout" class="a1">Logout</a></li>
</ul>
</div>
<div align="center">
<table class="content-table"><thead>
<th>HelpId</th>
<th>User Id</th>
<th>Issue</th>
<th>Description</th>
<th>Reply</th></thead><tbody>
<c:forEach items="${helpList}" var="u">
<tr>
<td>${u.helpId}</td>
<td>${u.userId}</td>
<td>${u.issue}</td>
<td>${u.description}</td>
<td>${u.status} <button><a href="reply?msg=${u.helpId}" class="a2">Reply</a></button></td>
</tr>
</c:forEach></tbody>
</table>
</div>


</body>
</html>