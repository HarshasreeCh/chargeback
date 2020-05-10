<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration Page</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script type="text/javascript">
function validate(){
	var fname=document.getElementById("firstName").value;
	var lname=document.getElementById("lastName").value;
	var dob=document.getElementById("dob").value;
	var gender=document.getElementById("gender").value;
	var phone=document.getElementById("contactNumber").value;
	var address=document.getElementById("address").value;
	var city=document.getElementById("city");
	var state=document.getElementById("state");
	var zipcode=document.getElementById("zipcode").value;
	var id=document.getElementById("adminId").value;
	var pwd=document.getElementById("password").value;
	var qstn1=document.getElementById("secretquestion1").value;
	var ans1=document.getElementById("answer1").value;
	var qstn2=document.getElementById("secretquestion2").value;
	var ans2=document.getElementById("answer2").value;
	var qstn3=document.getElementById("secretquestion3").value;
	var ans3=document.getElementById("answer3").value;
	
	var pattern=/[A-Za-z0-9 ]{6,32}/;
	var pattern1=/^([+91]{3})-([0-9]{10})$/;
	var pattern2=/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{7,15}$/;
	var pattern3=/^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;
	if(fname==""){
		alert("Please update FirstName field");
		document.getElementById("firstName").style.borderColor="red";
		return false;
		}
	 if(lname==""){
		alert("Please update LastName field");
		document.getElementById("lastName").style.borderColor="red";
		return false;
		}
	 if(dob==""){
		document.getElementById("Age").style.borderColor="red";
		alert("Please update Dob field");
		return false;
		}
	 if(gender==""){
		alert("Please update Gender field");
			document.getElementById("Gender").style.borderColor="red";
			return false;
			}
	 if(phone==""){
		alert("Please update Contact Number field");
		document.getElementById("contactNumber").style.borderColor="red";
		return false;
		}	
	 if(address==""){
			alert("Please update Address field");
			document.getElementById("address").style.borderColor="red";
			return false;
			}			
	 if(city==""){
			alert("Please update City field");
			document.getElementById("city").style.borderColor="red";
			
			return false;
			}
	 if(state==""){
			alert("Please update State field");
			document.getElementById("state").style.borderColor="red";
			
			return false;
			}
	 if(zipcode==""){
			alert("Please update Zipcode field");
			document.getElementById("zipcode").style.borderColor="red";
			return false;
			}	
		
	 if(id==""){
			alert("Please update UserId field");
			document.getElementById("cusId").style.borderColor="red";
			return false;
			}
		
		
	 if(pwd==""){
		alert("Please update Password field");
		document.getElementById("password").style.borderColor="red";		
		return false;
		}
	 if(qstn1==""){
			alert("Please update Secret question 1 field");
			document.getElementById("secretquestion1").style.borderColor="red";		
			return false;
			}

	 if(ans1==""){
			alert("Please update Answer 1 field");
			document.getElementById("answer1").style.borderColor="red";		
			return false;
			}
		
	 if(qstn2==""){
			alert("Please update Secret question 2 field");
			document.getElementById("secretquestion2").style.borderColor="red";		
			return false;
			}

	 if(ans2==""){
			alert("Please update Answer 2 field");
			document.getElementById("answer2").style.borderColor="red";		
			return false;
			}
	 if(qstn3==""){
			alert("Please update Secret question 3 field");
			document.getElementById("secretquestion3").style.borderColor="red";		
			return false;
			}

	 if(ans3==""){
			alert("Please update Answer 3 field");
			document.getElementById("answer3").style.borderColor="red";		
			return false;
			}
			
	  if(!pattern.test(id)){
		alert("UserId can contain only alphabets");
		document.getElementById("adminId").style.borderColor="red";
		return false;		
		}
	 if(!pattern1.test(phone)){
		alert("Please update Mandatory fields");
		document.getElementById("contactNumber").style.borderColor="red";
		return false;
		}
	 if(!pattern2.test(pwd)){
		alert("Please update Mandatory fields");
		document.getElementById("password").style.borderColor="red";
		return false;
		
		}		
	 if(!pattern3.test(dob)){
			alert("Please update DoB as dd-mm-yyyy");
			document.getElementById("dob").style.borderColor="red";
			return false;
			
			}		
		
	
}
</script>
</head>
<body>
<div class="header"/>
<h1>Chargeback Calculator</h1>
</div>
<h2>Admin Registration</h2>
<div class="formdata">
<div align="center">
<form:form onsubmit="return validate()" action="adminreg" modelAttribute="admin" method="post">
<!-- First Name, Last Name, Age, Gender, Contact Number, Admin Id, Password -->
<table>
<tr>
<td>FirstName:</td>
<td><form:input path="firstName" id="firstName" /></td>
</tr>
<tr>
<td>LastName:</td>
<td><form:input path="lastName" id="lastName" /></td>
</tr>
<tr>
<td>DoB:</td>
<td><form:input path="dob" id="dob"/></td>
</tr>
<tr>
<td>Gender:</td>
<td><form:radiobutton path="gender" value="female" id="gender" />Female
<form:radiobutton path="gender" value="male" id="gender" />Male
</td>
</tr>
<tr>
<td>Contact Number:</td>
<td><form:input path="contactNumber" id="contactNumber" />
</td>
</tr>
<tr>
<td>Address:</td>
<td><form:input path="address" id="address" />
</td>
</tr>
<tr>
<td>City:</td>
<td><form:input path="city" id="city" />
</td>
</tr>
<tr>
<td>State:</td>
<td><form:select path="state" id="state" class="select-box" >
  <option value="Telangana">Telangana</option>
  <option value="Andhra Pradesh">Andhra Pradesh</option>
  <option value="Tamilnadu">Tamilnadu</option>
  <option value="Goa">Goa</option>
  <option value="Kerala">Kerala</option>
  <option value="Delhi">Delhi</option>
  <option value="Uttar Pradesh">Uttar Pradesh</option>
  <option value="Maharastra">Maharastra</option>
</form:select></td>
</tr>
<tr>
<td>Zip Code:</td>
<td><form:input path="zipcode" id="zipcode" />
</td>
</tr>
<tr>
<td>UserId:</td>
<td><form:input path="adminId" id="adminId" /></td>
</tr>
<tr>
<td>Password</td>
<td><form:input path="password" id="password" type="password"/>
</tr>
<tr>
<td>Secret Question 1:</td>
<td>
<form:select path="secretquestion1" id="secretquestion1" class="select-box" >
<option  selected="selected" value="What is your Birthdate?">What is your Birthdate?</option>
  <option value="In which school you have studied first?">In which school have you studied first?</option>
  <option value="What is your favourite color?">What is your favourite color?</option>
</form:select>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="answer1" id="answer1" placeholder="Answer" width="170px" />
</td>
</tr>
<tr>
<td>Secret Question 2:</td>
<td>
<form:select path="secretquestion2" id="secretquestion2" class="select-box" >
<option  selected="selected" value="What is your favourite place?">What is your favourite place?</option>
  <option value="What is your parent's anniversary?">What is your parent's anniversary?</option>
  <option value="What is your highest education?">What is your highest education?</option>
</form:select>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="answer2" id="answer2" placeholder="Answer" width="170px" />
</td>
</tr>
<tr>
<td>Secret Question 3:</td>
<td>
<form:select path="secretquestion3" id="secretquestion3" class="select-box" >
<option  selected="selected" value="What is your favourite comic?">What is your favourite comic?</option>
  <option value="What is your hometown?">What is your hometown?</option>
  <option value="In what town or city did you meet your spouse/partner?">In what town or city did you meet your spouse/partner?</option>
</form:select>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="answer3" id="answer3" placeholder="Answer" width="170px" />
</td>
</tr>

</table>
<input type="submit" value ="submit" class="formsubmitbutton"/>
</form:form></div>
Already having account?<a href="adminlogin">Login</a>
<br><br>
<a href="/">Home</a>
<br>
<br>
${message}
</body>
</div>
</html>