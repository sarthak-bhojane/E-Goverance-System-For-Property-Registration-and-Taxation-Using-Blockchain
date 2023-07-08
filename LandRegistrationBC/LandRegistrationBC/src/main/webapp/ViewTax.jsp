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
<h2>Tax Details</h2>
<hr>

<table class="table table-bordered">
<tr style="background-color:seashell">
<th>Title</th><th>Tax Year</th> 
<th>Tax amount</th>

<th>Payment Status</th>
<th></th>
</tr>


<soham:forEach items="${std}" var="rec">

<tr>
<td>${rec.title}</td>
<td>${rec.taxyear}</td>
<td>${rec.taxamt}</td>
<td>${rec.sts}</td>   
 
<td>
<a href="PayTax.jsp?tid=${rec.tid}&propId=${rec.propId}">Pay Tax</a>
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