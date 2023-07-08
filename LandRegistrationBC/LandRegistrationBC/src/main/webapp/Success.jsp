<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">
<title> </title>
</head>
<body><jsp:include page="DefaultTop.jsp"></jsp:include><div class="container"><center> 
<%

try{
String usertype="NA";
try{String userid="NA";
if(session.getAttribute("userid")!=null){
	userid=String.valueOf(session.getAttribute("userid"));
}
if(session.getAttribute("usertype")!=null){
usertype= String.valueOf(session.getAttribute("usertype"));
}
}
catch(Exception ex)
{
	
}

 
%>
<h2><%
if(request.getAttribute("activity").toString().trim().equals("branchReg"))
{
	%>
	Branch Registered Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("propApproved"))
{
	%>
	Property Approved Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("taxpayment"))
{
	%>
	Tax Payment Details Submitted Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("taxApproved"))
{
	%>
	Tax Payment Approved Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("taxDeclined"))
{
	%>
	Tax Payment Declined Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("propDeclined"))
{
	%>
	Property Declined Successfully...
	
	<%
}else if(request.getAttribute("activity").toString().trim().equals("TaxReg"))
{
	%>
	Tax Calculation details added Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("UserReg"))
{
	%>
	You are Registered Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("PropReg"))
{
	%>
	Property Registered Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("datasetReg"))
{
	%>
	Dataset Uploaded Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("photos"))
{
	%>
	Photos Uploaded Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("propreg"))
{
	%>
	Property Cost Calculated Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("OfficeReg"))
{
	%>
	Office Registration Done Successfully... 
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("DocUpload"))
{
	%>
	Document Uploaded Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("ExamDone"))
{
	%>
	Exam Answers Stored Successfully...
	<br/><a href="Evaluate?examId=<%=request.getAttribute("examId").toString().trim() %>&userid=<%=request.getAttribute("userid").toString().trim() %>">Evaluate Exam Now</a>
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("proptransfered"))
{
	%>
	Property Transfer Request sent to owner Successfully...
	
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("proptransApproved"))
{
	%>
	Property Transferred Request Approved Successfully...
	<%
}else if(request.getAttribute("activity").toString().trim().equals("proptransDeclined"))
{
	%>
	Property Transferred Request Declined Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("ExamReg"))
{
	%>
	Exam Registered Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("ExamQuesReg"))
{
	%>
	Exam Question Registered Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("SubReg"))
{
	%>
	New Subject Registered Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("SubAllocation"))
{
	%>
	Subject Allotted to Selected Staff Member Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("changePass"))
{
	%>
	Password Changed Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("QuesReg"))
{
	%>
	Question Registered Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("RegUnit"))
{
	%>
	New Unit Registered Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("studActivation"))
{
	%>
	Dealer Activation Done Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("SubmitExam"))
{
	%>
	Exam Scheduled Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("StaffProfile"))
{
	%>
	Your Profile Updated Successfully...
	<%
}
else if(request.getAttribute("activity").toString().trim().equals("StudProfile"))
{
	%>
	Your Profile Updated Successfully...
	<%
}
%></h2>
<hr><br>
<%
if(request.getAttribute("activity").toString().trim().equals("StudReg"))
{%>
	<a href="index.jsp">Home</a>
<%}
else
{  
	if(usertype.equals("admin")){	%>
		<a href="admin.jsp">Home</a>
		<%
	}
	else if(usertype.equals("user")){
		%>
		<a href="user.jsp">Home</a>
		<%
	}else if(usertype.equals("officer")){
		%>
		<a href="officer.jsp">Home</a>
		<%
	}
	else if(usertype.equals("staff")){
	 if(request.getAttribute("activity").toString().trim().equals("ExamQuesReg"))
		{%>
		<a href="viewPendingExams">Continue...</a>
		<%
		}else{
		%>
		<a href="Staff.jsp">Home</a>
		<%}
	}
	else if(usertype.equals("user")){
		%>
	<a href="User.jsp">Home</a>
<%
	}
	else {%>
		<a href="index.jsp">Home</a>
		<%
	}

}}
catch(Exception ex)
{
	System.out.println("errr="+ex.getMessage());
}%>
 
 
</body>
</html>