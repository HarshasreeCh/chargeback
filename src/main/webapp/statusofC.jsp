<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/style1.css">

<title>GenerateReport</title>
</head>
<body>
<div align="center">
<h1>${message}</h1>
</div>
 <br>
<br>
<div class="header">
<ul class="a">
<li><a href="complaintscount"><button>NumberOfComplaints</button></a></li>
<li><a href="statusofcomplaints"><button>StatusOfComplaints</button></a></li>
</ul>
 </div>
 <div align="center">
<c:forEach items="${status}" var="status">

<table class="content-table"><thead>
<tr>
<th>TransactionId</th>
<th>CustomerId</th>
<th>Status</th></tr></thead><tbody>
<tr>
<td>${status.transactionid}</td>
<td>${status.customerid}</td>
<td>${status.status}</td></tr></tbody>

</table>
</c:forEach>

</div>
<br>
<a href="Emphome">Employee Home</a>
</body>
</html>