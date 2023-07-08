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
try{
String userid=String.valueOf(session.getAttribute("userid"));
String usertype=String.valueOf(session.getAttribute("usertype"));
if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60);
 
%>
<h2>Tax Details</h2>
<hr>

<table class="table table-bordered">
<tr style="background-color:seashell">
<th>Title</th>
<th>Tax amount</th>
<th>Tax Year</th> 
<th>Payment Dt</th> 
<th>Receipt</th> 
<th>Payment Status</th>
<th>Remark</th>
<th></th>
</tr>


<soham:forEach items="${std}" var="rec">
<form method="post" action="ProcessTaxPayment">
<tr>
<td>${rec.title}</td>
<td>${rec.taxyear}</td>
<td>${rec.taxamt}</td>
<td>${rec.dt}</td>
<td><a href="TaxPayments/${rec.receipt}" target="_blank">View Receipt</a></td>
<td>${rec.sts}</td> 
<td>
<textarea name="remark" class="form-control" required></textarea>
</td>  
 <td>
<select name="sts" class="form-control">
<option value="approved">Approve</option>
<option value="declined">Decline</option>
</select>
<input type="hidden" name="tid" value="${rec.tid}"/>
<input type="hidden" name="propId" value="${rec.propId}"/>
<input type="hidden" name="title" value="${rec.title}"/>
<input type="hidden" name="userid" value="${rec.userid}"/>\
<input type="hidden" name="taxyear" value="${rec.taxyear}"/>
<input type="hidden" name="taxamt" value="${rec.taxamt}"/>
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
}catch(Exception ex){
	System.out.println("err="+ex.getMessage());
}
%>
</body>
</html>