  
<%@page import="models.*"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="soham"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">

<title>Car Parts Recognition</title>
</head>
<body><jsp:include page="Top.jsp"></jsp:include>
<%

String userid=String.valueOf(session.getAttribute("userid"));
String usertype=String.valueOf(session.getAttribute("usertype"));
if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60);
JavaFuns jf=new JavaFuns();
Vector v=jf.getValue("select photo from photos where propId="+request.getParameter("propId").trim(), 1);
%>


<div class="row"> 
<h2>Photos</h2>
<hr>

 
   <%for(int i=0;i<v.size();i++){ %>
<div class="col-md-3">
  
<img src="http://localhost:80/OnlinePropertyValuationPython/Photos/<%=v.elementAt(i).toString().trim() %>" class="img-responsive" width="70%"/>
  
 
</div>
  <%} %>
  
 
</div>

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