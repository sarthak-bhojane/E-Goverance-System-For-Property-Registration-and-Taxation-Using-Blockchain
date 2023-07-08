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
 
%><h2>My Properties Report</h2>
<hr>
</div><div class="container-fluid"> 


<table class="table table-bordered">
<tr style="background-color:seashell">
<th>UserId</th>
<th>Title</th>
<th>Area</th>
<th>Address</th> 
<th>Property type</th> 
 <th colspan="4"></th>
</tr>


<soham:forEach items="${std}" var="rec">
<form method="post" action="updateProp">
<tr>
<td>${rec.userid}</td>
<td>${rec.title}</td>
<td>${rec.area}</td>
<td>${rec.addr} ${rec.city} ${rec.state}</td>
 
 
<td>${rec.proptype}</td> 
<td>
<a href="ViewDetails?propId=${rec.propId}">view details</a>
</td>
<td>
<textarea name="remark" required class="form-control"></textarea>
</td>
<td>
<select name="sts" class="form-control">
<option value="approved">Approved</option>
<option value="declined">Declined</option>
</select>
<input type="hidden" name="propId" value="${rec.propId}"/>
<input type="hidden" name="title" value="${rec.title}"/>
<input type="hidden" name="userid" value="${rec.userid}"/>
</td><td>
<input type="submit" value="Submit" class="btn btn-primary"/>
</td>

 
</tr>
</form>
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