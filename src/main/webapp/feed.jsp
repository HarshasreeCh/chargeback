<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<link rel="stylesheet" type="text/css" href="/style1.css">
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">

window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer", {
		title:{
			text: "Feedbacks"              
		},
		data: [              
		{
			type: "column",
			name:"Agree",
			showInLegend: true,
			dataPoints: [
				{ label: "Question1",  y: ${last.get(0)} },
				{ label: "Question2", y: ${last.get(5)}  },
				{ label: "Question3", y: ${last.get(10)} },
				{ label: "Question4",  y: ${last.get(15)}},
				{ label: "Question5",  y: ${last.get(20)} }
			]
			
		},
		{
		type: "column",
		name:"Disagree",
		showInLegend: true,
		dataPoints: [
			{ label: "Question1",  y: ${last.get(1)} },
			{ label: "Question2", y: ${last.get(6)}  },
			{ label: "Question3", y: ${last.get(11)} },
			{ label: "Question4",  y: ${last.get(16)}},
			{ label: "Question5",  y: ${last.get(21)} }
		]
		},
		{
			type: "column",
			name:"Strongly Agree",
			showInLegend: true,
			dataPoints: [
				{ label: "Question1",  y: ${last.get(2)} },
				{ label: "Question2", y: ${last.get(7)}  },
				{ label: "Question3", y: ${last.get(12)} },
				{ label: "Question4",  y: ${last.get(17)}},
				{ label: "Question5",  y: ${last.get(22)} }
			]
	   },
     	{
		   type: "column",
		   name:"Strongly Disagree",
		   showInLegend: true,
			dataPoints: [
			{ label: "Question1",  y: ${last.get(3)} },
			{ label: "Question2", y: ${last.get(8)}  },
			{ label: "Question3", y: ${last.get(13)} },
		    { label: "Question4",  y: ${last.get(18)}},
			{ label: "Question5",  y: ${last.get(23)} }
				]
		},
		{
		type: "column",
		name:"Neither agree nor disagree",
		showInLegend: true,
		dataPoints: [
		{ label: "Question1",  y: ${last.get(4)} },
		{ label: "Question2", y: ${last.get(9)}  },
		{ label: "Question3", y: ${last.get(14)} },
		{ label: "Question4",  y: ${last.get(19)}},
		{ label: "Question5",  y: ${last.get(24)} }
	   ]
		}
		]
	});
	chart.render();
}
</script>


</head>
<body>
<%
String userid =(String) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="header">
<h1>Welcome <span><%=session.getAttribute("name")%></span></h1>
<ul class="a">
<li><a href="employees" class="a1">New Employees</a></li>
<li><a href="feedbkcustomers" class="a1">Feedback Questionaire</a></li>
<li><a href="acceptuserregisteration" class="a1">Accept Users</a></li>
<li><a href="helpreq" class="a1">Help Requests</a></li>
<li><a href="adminlogout" class="a1">Logout</a></li>
</ul>
</div>

<div align="center">
<table class="content-table">
<thead><th>Serial No.</th>
<th>Details</th></thead><tbody>
<c:forEach items="${feedlist}" var="c">

<tr>
<td>${c.fid}</td>
<td><a href="getfeedDetails?cust=${c.fid}">Get Feedback Details</a></td></tr></c:forEach></tbody></table></div>
<br><br><a href="pie" class="a1">Graph</a>
<div align="center"><br><br>
<div id="chartContainer" style="height: 300px; width: 40%;"></div></div>


</body>
</html>