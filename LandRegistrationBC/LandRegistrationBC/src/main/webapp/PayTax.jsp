 
<%@page import="java.util.Vector"%>
<%@page import="models.JavaFuns"%>
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
<img src="images/qr.jpeg" width="70%"/>
</div>
<div class="col-md-6">
<%
JavaFuns jf=new JavaFuns();
Vector v=jf.getValue("select taxyear,tax from taxdetails where tid="+request.getParameter("tid").trim() , 2);
%>
<div ><center><h2>Tax Payment Details </h2></center><br/>
 <form   action="SubmitTaxPayment" method="post"  enctype="multipart/form-data">
									 
									  <table class="tblform">
									  <tr><td>Tax Year</td>
									  <td><input type="text" name="taxyear" class="form-control" value="<%=v.elementAt(0).toString().trim() %>"/></td>
									  </tr> 
									   <tr><td>Tax Amount</td>
									  <td><input  class="form-control" type="text" readonly="readonly" name="taxamt" value="<%=v.elementAt(1).toString().trim() %>"/>
									  <input type="hidden" name="userid" value="<%=session.getAttribute("userid").toString().trim() %>"/>
									  <input type="hidden" name="propId" value="<%=request.getParameter("propId").toString().trim() %>"/>
									  <input type="hidden" name="tid" value="<%=request.getParameter("tid").toString().trim() %>"/>
									 
									  </td>
									  </tr> 
								  
                 
               <tr><td>  Payment Receipts</td>
                <td><input  type="file"  class="form-control"  name="file" required></td></tr>
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