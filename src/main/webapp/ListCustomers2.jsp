<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee home</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/style1.css">
<!-- <link rel="stylesheet" type="text/css" href="/empstyle.css"> -->
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
<li><a href="Transactions" class="a1">List of Customers</a></li>
<li><a href="complaints" class="a1">Chargeback Details</a></li>
<li><a href="emplogout" class="a1">Logout</a></li>
</ul>
 <!-- ...................................... -->
<div align="center">
<table class="content-table"><thead>
<th>Firstname</th>
<th>Lastname</th>
<th>dob</th>
<th>AccountNumber</th>
<th>Bank Name</th>
<th>Bank Address</th>
<th>Available Bal</th></thead><tbody>
<tr>
<td>${searchCustomer.firstName}</td>
<td>${searchCustomer.lastName}</td>
<td>${searchCustomer.dob}</td>
<c:forEach items="${searchCustomer.bankinfoo}" var="b"> 
<td>${b.bankacno}</td>
<td>${b.branchname}</td>
<td>${b.branchaddress}</td>
<td>${b.avlbal}</td></tr></tbody>
</c:forEach>
</table><br>
Transactions of ${searchCustomer.firstName} ${searchCustomer.lastName}
<table class="content-table"><thead>
<th>Transaction Id   </th>
<th>Transaction Amount  </th>
<th>Transaction Date</th></thead><tbody>

<c:forEach items="${searchCustomer.transacList}" var="tlist"> 
<tr>
<td>${tlist.transactionid}</td>
<td>${tlist.transationamount}</td>
<td>${tlist.transactiondate}</td></tr>
</c:forEach> </tbody>
</tr>
</table>
</div>
</div>
</body>
</html>
