<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chargebacks</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
</head>
<body>

<%
String userid =(String) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/emp");
}
%>
<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="report" class="a1">Generate Report</a>
<li><a href="listcust" class="a1">List of Customers</a></li>
<li><a href="complaints" class="a1">Chargeback Details</a></li>
<li><a href="emplogout" class="a1">Logout</a></li>
</ul>
</div>
<div align="center" >
<c:forEach items="${lodge}" var="l">
<table class="content-table"><thead>

<th>Account Number</th>
<th>Date</th>
<th>Chargeback Amount</th>
<th>Reason</th>
<th>Status</th></thead><tbody>
<tr>
<td>${l.bankaccountnumber}</td>
<td>${l.date}</td>
<td>${l.chargebackamount}</td>
<td>${l.reason}</td>
<td><button><a href="eaccept?acc=${l.bankaccountnumber}">Accept</a></button> <button><a href="ereject?acc=${l.bankaccountnumber}">Reject</a></button></td></tr></tbody>
</table><br>
</c:forEach>
</div>
</body>
</html>
