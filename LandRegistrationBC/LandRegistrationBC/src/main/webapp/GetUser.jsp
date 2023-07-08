
<%@page import="java.util.List"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> </title>
 

</head>
<body> 
<% try{ response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("home");
}
%> 
 <div class="row"> 
 <c:forEach var="userdsc" items="${lst}">
		<div class="col-md-3"><table class="table table-bordered" > 
			 <tr><td rowspan="3">  <h4>${userdsc.getName() }</h4>
			 <img src="Uploads/${userdsc.getProfPhoto()}"  class="img-thumbnail img-responsive"/>
			<br/> <a href="SendFriendReq?fuserid=${userdsc.getUserid()}&fusername=${userdsc.getName()}">Send Friend Request</a> | 
			<a href="viewFDetails?userid=${userdsc.getUserid() }"  >View Profile</a>
			</td></tr></table> </div>
		</c:forEach>
		 </div>
<%}
catch(Exception ex)
{
	System.out.println("err="+ex.getMessage());
} %>
 
</body>
</html>