<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Help</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="translist" class="a1">Transaction List</a></li>
<li><a href="helpRequests?req=${name}" class="a1">Help Requests</a></li>
<li><a href="trackstatus" class="a1">Track Complaint Status</a></li>
<li><a href="beforehelp" class="a1">Help</a></li>
<li><a href="feedback1" class="a1">Feedback</a></li>
<li><a href="cuslogout" class="a1">Logout</a></li>
</ul>
</div>
<div class="row">
<div class="column">
<div class="formdata2"><br>
<img src="complaint.jpg" alt="lodge a compaint" style="width:60%"><br>
<b style="color:white">Want to know how to Lodge a complaint?</b>
<a href="/lodge" class="a1" >Click Here</a>
</div></div>
<div class="column">
<div class="formdata2"><br>
<img src="status.jpg" alt="status of complaint" style="width:60%"><br>
<b style="color:white">Want to know how to check Status of a complaint?</b>
<a href="/status" class="a1">Click Here</a>
</div>
</div>
</div>
 <div class="formdata1">
<div align="center">
<h2 style="color:white">Report an issue here</h2>
<form action="afterhelp" method="post" modelAtribute="help">
<table>
<tr>
<td style="color:white">UserId:</td>
<td><input type="text" name="userId" value="${name}" class="formcontrol"/>
</td></tr>
<tr>
<td style="color:white">Issue:</td>
<td><input type="text" name="issue" class="formcontrol"/>
</td></tr>
<tr>
<td style="color:white"><label for="description">Description:</label>
<td>
<textarea id="description" rows="3" cols="23" name="description"></textarea></td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/><br><br>
<br><br>
<div align="center" >
<div class="formdata2">

${message}
</div></div>
</form>

</div>
</div> 
<div align="center" >
<div class="formdata2">
You can also Reach Us on <i class="fa fa-phone">: +91-9876543210</i></div></div>
</body>
</html>