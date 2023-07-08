<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soham"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">

<title> </title>
</head>
<body><jsp:include page="Top.jsp"></jsp:include>
<%

String userid=String.valueOf(session.getAttribute("userid"));

if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60);

%>


<h2>Registered Offices</h2>
<hr>
<table class="table table-bordered">
<tr style="background-color:seashell">
<th>UserId</th>
<th>UserName</th>
<th>Usertype</th>
<th>Userstatus</th>
<th>Address</th>
<th>Pincode
<th>Mobile 
<th>City 
<th>State 
</tr>


<soham:forEach items="${std}" var="rec">

<tr>
<td>${rec.userid}</td>
<td>${rec.usernm}</td>
<td>${rec.usertype}</td>
<td>${rec.userstatus}</td>
<td>${rec.addr}</td>
<td>${rec.pincode}</td>
<td>${rec.mobile}</td> 
<td>${rec.city}</td> 
<td>${rec.state}</td> 
</tr>

</soham:forEach>
</table>
 
<%
}
else{
	%>
	<h2>Invalid Session...Login again</h2>
	<br>
	<a href="index.jsp">Login</a>
	
	<%
}

%>
</body>
</html>