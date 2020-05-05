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
<div align="right" style="margin-right: 130px;">
<form action="searchcustomers" method="post">
<table>
<tr>
<td>
<input type="search" name="searchbycustomerId" style="height: 30px;border-radius: 20px;">
</td>
<td>
<button type="submit" style="border-radius: 20px;">
<i class="fa fa-search"></i>
</button>
</td>
</tr>
</table>
</form>
</div> 
</div>
<hr>
<div align="center">
<table border="2" bgcolor="blue">
<c:forEach items="${CustIDs}" var="cid">
<tr>
<td>${cid}</td>
<td><a href="getCustDetails?cust=${cid}">Get Customer Details</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
