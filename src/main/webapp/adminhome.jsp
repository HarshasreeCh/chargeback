<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin home</title>
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
<table border="1">
<c:forEach items="${feedlist}" var="c">
<tr>

<td>Customer name : ${c.customerId}</td></tr>
<tr><td>information on the website is clear and easy to understand:</td>
<td>${c.ans1}</td></tr><tr>
<td>I can easily find what iam looking for on the website:</td>
<td>${c.ans2}</td></tr><tr>
<td>The website includes all of the information i need:</td>
<td>${c.ans3}</td></tr><tr>
<td>The website works well technically loading quickly and displaying appropriatley:</td>
<td>${c.ans4}</td></tr><tr>
<td>The website meets my needs:</td>
<td>${c.ans5}</td></tr>

</c:forEach>
</table>
</body>
</html>