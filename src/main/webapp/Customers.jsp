<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Customers</title>
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
<tr>
<th>Customer UserID</th>
<th>First name</th>
<th>Last name</th>
<th> Dob</th>
<th> Gender</th>
 <td>City</td>
<th> Status</th>
</tr></thead><tbody>
<c:forEach items="${cusList}" var="cus">
   <tr>
   <td>${cus.cusId}</td>
   <td>${cus.firstName}</td>
   <td>${cus.lastName}</td>
   <td>${cus.dob}</td>
   <td>${cus.gender}</td>
   <td>${cus.city}</td>
    <td>${cus.status}
   <a href="activate?id=${cus.cusId}"><button>Accept</button></a>
   <a href="deactivate?id=${cus.cusId}"><button>Reject</button></a></td> 
   
</c:forEach></tbody>
</table> 
</div></body></html>