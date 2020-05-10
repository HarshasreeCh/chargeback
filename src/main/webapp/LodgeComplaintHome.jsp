<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lodge Complaint</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
<script type="text/javascript">
function validate(){
	var phno=document.getElementById("contactNumber").value;
	var eid=document.getElementById("emailid").value;
	var accno=document.getElementById("bankaccountnumber").value;
	var bname=document.getElementById("bankname").value;
	var cback=document.getElementById("chargebackamount").value;
	var tid=document.getElementById("transactionid").value;
	var dt=document.getElementById("date").value;
	var rsn=document.getElementById("reason").value;
	 if(phno==""){
			document.getElementById("contactNumber").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}

	  if(eid==""){
			document.getElementById("emailid").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	  if(accno==""){
			document.getElementById("bankaccountnumber").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	  if(bname==""){
			document.getElementById("bankname").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	  if(cback==""){
			document.getElementById("chargebackamount").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	  if(tid==""){
			document.getElementById("transactionid").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	  if(dt==""){
			document.getElementById("date").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	  if(rsn==""){
			document.getElementById("reason").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
		
		
}
</script>
</head>
<body>
<%
long customerid =(long)session.getAttribute("customerid");
String firstname=(String)session.getAttribute("firstname");
String lastname=(String)session.getAttribute("lastname");

%>

<h1>Lodge Complaint</h1>
<div class="formdata">
<div align="center">
<form:form onsubmit="return validate()" action="dblodge" method="post" modelAttribute="lc">
<table>
<tr>
<td>FirstName:</td>
<td><form:input path="firstname" class="formcontrol" value="${firstname}" id="firstname"/></td>
</tr>
<tr>
<td>LastName:</td>
<td><form:input path="lastname" class="formcontrol" value="${lastname}" id="lastname"/></td>
</tr>
<tr>
<td>Contact Number</td>
<td><form:input path="contactnumber" class="formcontrol" id="contactnumber"/></td>
</tr>
<tr>
<td>EmailId</td>
<td><form:input path="emailid" class="formcontrol" id="emailid"/></td>
</tr>
<tr>
<td>Bank Account Number</td>
<td><form:input path="bankaccountnumber" class="formcontrol" id="bankaccountnumber"/></td>
</tr>
<tr>
<td>Bank Branch Name</td>
<td><form:input path="bankname" class="formcontrol" id="branchname"/></td>
</tr>
<tr>
<td>CustomerId</td>
<td><form:input path="customerid" class="formcontrol" value="${customerid}" id="customerid"/></td>
<tr>
<td>Charge Back Amount</td>
<td><form:input path="chargebackamount" class="formcontrol" id="chargebackamount"/></td>
</tr>
<tr>
<td>Transaction Id:</td>
<td><form:input path="transactionid" class="formcontrol" id="transactionid"/>
</td>
</tr>
<tr>
<td>Date(yyyy-mm-dd):</td>
<td><form:input path="date" class="formcontrol" id="date"/>
</td>
</tr>
<tr>
<td>Reason for Dispute</td>
<td><form:input path="reason" class="formcontrol" id="reason"/>
</td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/>
<br><br>
Customer Home<a href="Custhome"> Click here</a>
</form:form>
</div>
</div>

</body>
</html>