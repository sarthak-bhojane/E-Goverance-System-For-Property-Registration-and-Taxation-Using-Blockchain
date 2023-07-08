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
 
%><h2>Property Transfer Request</h2>
<hr>
</div><div class="container-fluid"> 


<table class="table table-bordered">
<tr style="background-color:seashell">
 
<th>Title</th>
<th>Requester User Name</th>
<th>Date</th> 
<th>Documents</th> 
 <th></th>
</tr>


<soham:forEach items="${std}" var="rec">
<form method="post" action="ProcessTransferReq">
<tr>
<td>${rec.title}</td>
<td>${rec.username}</td>
<td>${rec.dt}</td>
<td> <a href="Properties/${rec.propId}/${rec.proofPath}" target="_blank">Download Documents</a></td>
 
<td>
<textarea name="remark" required class="form-control"></textarea>
</td>
<td>
<select name="sts" class="form-control">
<option value="partial_approved">Approve</option>
<option value="declined">Decline</option>
</select>
<input type="hidden" name="purId" value="${rec.purId}"/>
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