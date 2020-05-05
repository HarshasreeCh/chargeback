<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script type="text/javascript">
function validate(){
	var id=document.getElementById("hid").value;
	var rep=document.getElementById("reply").value;
	 if(id==""){
			document.getElementById("hid").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}

	 else if(rep==""){
			document.getElementById("reply").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
}

</script>
</head>
<body>
<div class="header">
<h1>Chargeback Calculator</h1>
</div>
<h2>Reply</h2>
<div class="formdata">
<div align="center">
<form:form onsubmit="return validate()" action="replyaction" method="post" modelAttribute="rep">
<table>
<tr>
<tr>
<td>
HelpId:</td>
<td>
<form:input path="hid" id="hid"/>
</td>
</tr>
<tr>
<td>Reply:</td>
<td><form:input path="reply" class="formcontrol" id="reply"/></td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/>
</form:form>
Admin home <a href="adminlogin">Click here</a>
<br>
<br>
${message}
</div>
</div>
</body>
</html>