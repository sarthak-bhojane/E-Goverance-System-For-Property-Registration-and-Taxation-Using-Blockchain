 
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
<div ><center><h2>Property Purchase Details </h2></center><br/>
 <form   action="transferProp" method="post"  enctype="multipart/form-data">
									 
									  <table class="tblform">
									  <tr><td>Title</td>
									  <td><input type="text" name="title" value="<%=request.getAttribute("title").toString().trim() %>"/></td>
									  </tr> 
								 <tr><td>New Owner Name</td>
									  <td><input type="text" name="username" value="<%=session.getAttribute("username").toString().trim() %>"/>
									  <input type="hidden" name="userid" value="<%=session.getAttribute("userid").toString().trim() %>"/>
									  <input type="hidden" name="propId" value="<%=request.getAttribute("propId").toString().trim() %>"/>
									  </td>
									  </tr>
									   <tr><td>Owner Name</td>
									  <td><input type="text" name="pusername" value="<%=request.getAttribute("pusername").toString().trim() %>"/>
									  <input type="hidden" name="puserid" value="<%=request.getAttribute("puserid").toString().trim() %>"/>
									  </td>
									  </tr>
                 
               <tr><td>Proof and Payment Receipts</td>
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