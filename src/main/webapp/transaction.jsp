<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lodge Complaint</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>

<%
String userid =(String) session.getAttribute("name");
long id=(long) session.getAttribute("customerid");

if(userid==null)
{
	response.sendRedirect("/cus");
}
%>
<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="notification?msg=${customerid}" class="a1"><i class='far fa-bell' style='font-size:36px'></i></a>
<li><a href="translist" class="a1">Transaction List</a></li>
<li><a href="helpRequests?req=${name}" class="a1">Help Requests</a></li>
<li><a href="trackstatus" class="a1">Track Complaint Status</a></li>
<li><a href="beforehelp" class="a1">Help</a></li>
<li><a href="feedback1" class="a1">Feedback</a></li>
<li><a href="cuslogout" class="a1">Logout</a></li>
</ul>
</div>
<br><br>
<div align="center">
<table class="content-table"><thead>
<th>TransactionId</th>
<th>Transaction Data</th>
<th>Transaction Amount</th>
<th>Lodge Complaint</thead>
<c:forEach items="${custtransactionlist}" var="transactions">
<tbody><tr>
<td>${transactions.transactionid}</td>
<td>${transactions.transactiondate}</td>
<td>${transactions.transationamount}</td>

<td> <a href="/LodgeComplaint?transactionid=${transactions.transactionid}" style="color: yellow;">Lodge A Complaint</a> </td>
</tr></tbody>

</c:forEach>

</table>
</div>
<br><br>${message}
</body>
</html>