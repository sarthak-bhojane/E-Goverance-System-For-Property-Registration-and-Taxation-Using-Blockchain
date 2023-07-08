 
<%@page import="java.util.List"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 

</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<%  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);%>
<div class="container">
<div class="row">

<div class="col-md-6">
<img src="assets/img/upload.png" width="70%"/>
</div>
<div class="col-md-6">
<div ><center><h2>Register Tax Details</h2></center><br/>
 <form   action="RegTaxCalc" method="post" >
									 
									  <table class="tblform">
									   
									  
                 
               <tr><td>Upload CSV Dataset</td>
                <td><input type="file"  class="form-control"  name="file" required></td></tr>
                 <tr>
									     <tr>
		 <td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/>
		  </td></tr>
		  </table>
		  </form>
</div>
</div>

</div>

</div>
</body>
</html>