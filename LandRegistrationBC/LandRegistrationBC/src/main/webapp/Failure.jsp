<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">
<title></title>
</head>
<body><jsp:include page="DefaultTop.jsp"></jsp:include>
<div class="container"><center> 
<%

String userid=String.valueOf(session.getAttribute("userid"));
String usertype=String.valueOf(session.getAttribute("usertype"));

if(!userid.equalsIgnoreCase("null")){	
	
session.setMaxInactiveInterval(10*60);

%>
<h2><%
if(request.getAttribute("activity").toString().trim().equals("branchReg"))
{
	%>
	Branch Registration Failed!!
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("taxpayment"))
{
	%>
	Something went wrong!!
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("StudReg"))
{
	%>
	Registration Failed!!
	<%
}else if(request.getAttribute("activity").toString().trim().equals("SubmitExam"))
{
	%>
	Total marks of the Questions added in selected question paper are greater than registered marks!!<br/>Please Adjust Questions as per exam total marks!!
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("ExamQuesReg"))
{
	%>
	This Question Already Added in selected Exam!!
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("UnitReg"))
{
	%>
	Unit Already Exist!!
	<%
}else if(request.getAttribute("activity").toString().trim().equals("SubAllocation"))
{
	%>
	Subject Allocation Failed!!
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("QuesReg"))
{
	%>
	Question Already Exist!!
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("RegUnit"))
{
	%>
	Unit Already Exist!! Please try another
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("StaffReg"))
{
	%>
	New Staff Registration Failed!!
	<%
}else if(request.getAttribute("activity").toString().trim().equals("changePass"))
{
	%>
	Updating Password Failed!!
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("studActivation"))
{
	%>
	Student Activation Failed!!
	<%
}else if(request.getAttribute("activity").toString().trim().equals("StaffProfile"))
{
	%>
	Updating Profile Failed!!
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("StudProfile"))
{
	%>
	Updating Profile Failed!!
	<%
}
%></h2>

<%
	if(usertype.equals("admin")){	%>
		<a href="Admin.jsp">Home</a>
		<%
	}
	else if(usertype.equals("student")){
		%>
		<a href="Student.jsp">Home</a>
		<%
	}
	else if(usertype.equals("staff")){
		
		 if(request.getAttribute("activity").toString().trim().equals("ExamQuesReg"))
			{%>
				<a href="viewPendingExams">try another</a>
			<% }
		 else if(request.getAttribute("activity").toString().trim().equals("SubmitExam"))
			{%>
				<a href="viewPendingExams">try again</a>
			<% } 
		 else{
		%>
		<a href="Staff.jsp">Home</a>
		<%}
	}
	else if(usertype.equals("exstudent")){
		%>
	<a href="ExStudent.jsp">Home</a>
<%
	} 
	else{
		%>
		<a href="index.jsp">Home</a>
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
	
</div>

</body>
</html>