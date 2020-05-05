<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
</head>
<body>
<%
long userid =(long) session.getAttribute("customerid");

%>
<div class="header"/>
<h1>Chargeback Calculator</h1>
</div>
<h2>Customer Feedback</h2>
<div align="center">
<form:form onsubmit="return validate()" action="feedbackques" modelAttribute="feedbk" method="post">
<table border="2">

Enter Your Name:
<form:input path="customerId" id="customerId"></form:input>
<tr>
<td>Questions</td><td>Agree</td><td>Disagree</td><td>StronglyAgree</td><td>StronglyDisagree</td><td>NeitherNorAgree</td></tr><tr>
<td>Information on the website is clear and easy to understand:</td>
<td><form:radiobutton path="ans1" value="agree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="disagree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="Stronglyagree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="Stronglydisagree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="Neithernoragree" id="ans1" /></td>
</tr>
<tr>
<td>I can easily find what iam looking for on the website:</td>
<td><form:radiobutton path="ans2" value="agree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="disagree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="Stronglyagree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="Stronglydisagree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="Neithernoragree" id="ans2" /></td>
</tr>
<tr>
<td>The website includes all of the information i need:</td>
<td><form:radiobutton path="ans3" value="agree" id="ans3" /></td>
<td>
<form:radiobutton path="ans3" value="disagree" id="ans3" /></td>
<td>
<form:radiobutton path="ans3" value="Stronglyagree" id="ans3" /></td>
<td>
<form:radiobutton path="ans3" value="Stronglydisagree" id="ans3" /></td>
<td>
<form:radiobutton path="ans3" value="Neithernoragree" id="ans3" /></td>
</tr>
<tr>
<td>The website works well technically loading quicly and displaying appropriatley:</td>
<td><form:radiobutton path="ans4" value="agree" id="ans4" /></td>
<td>
<form:radiobutton path="ans4" value="disagree" id="ans4" /></td>
<td>
<form:radiobutton path="ans4" value="Stronglyagree" id="ans4" /></td>
<td>
<form:radiobutton path="ans4" value="Stronglydisagree" id="ans4" /></td>
<td>
<form:radiobutton path="ans4" value="Neithernoragree" id="ans4" /></td>
</tr>
<tr>
<td>The website meets my needs:</td>
<td><form:radiobutton path="ans5" value="agree" id="ans5" /></td>
<td>
<form:radiobutton path="ans5" value="disagree" id="ans5" /></td>
<td>
<form:radiobutton path="ans5" value="Stronglyagree" id="ans5" /></td>
<td>
<form:radiobutton path="ans5" value="Stronglydisagree" id="ans5" /></td>
<td>
<form:radiobutton path="ans5" value="Neithernoragree" id="ans5" /></td>
</tr>
</table>
<input type="submit" value ="submit"/>
<a href="CusHome.jsp" >BACK</a>
</form:form>
</div>
<br><br>
${message }
</body>
</html>