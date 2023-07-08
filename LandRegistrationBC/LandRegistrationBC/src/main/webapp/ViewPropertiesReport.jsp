<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soham"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">

<title></title>
</head>
<body><jsp:include page="Top.jsp"></jsp:include>
<%

String userid=String.valueOf(session.getAttribute("userid"));
String usertype=String.valueOf(session.getAttribute("usertype"));
if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60);
 
%>
<h2>My Properties Report</h2>
<hr>

<table class="table table-bordered">
<tr style="background-color:seashell">
<th>UserId</th>
<th>Title</th>
<th>Area</th>
<th>Address</th>
<th>City</th> 
<th>State</th>
 
<th>Property type</th>
 <th>Bus Stand Distance</th>
 <th>Evaluated Cost(in Rs.)
 <th colspan="2"></th>
</tr>


<soham:forEach items="${std}" var="rec">

<tr>
<td>${rec.userid}</td>
<td>${rec.title}</td>
<td>${rec.area}</td>
<td>${rec.addr}</td>
<td>${rec.city}</td> 
<td>${rec.state}</td>
 
<td>${rec.proptype}</td>
<td>${rec.busStandDist} km</td>  
<td>
${rec.cprice}
</td>
<td>
<a href="showMap.jsp?lat=${rec.lat}&lng=${rec.lng}">Show Map</a>
</td>
 
<td>
<a href="ViewTaxHistory?propId=${rec.propId}">View Tax History</a>
</td>  
 <td>
<a href="ViewTax?propId=${rec.propId}">Tax</a>
</td>
</tr>

</soham:forEach>
</table>

<%
if(usertype.equals("admin")){
%> 
<%
}
else{	%>
	 
<%
	}
	
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