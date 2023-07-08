<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@page import="models.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/cust.css">
 
<title> </title>

<script language="Javascript" type="text/javascript">
 

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return tmpXmlHttpObject;
}


var http = createRequestObject();

function makeGetRequest(st) {
   // st=document.frm.state.value;
   
    http.open('get', 'Cities?state=' + st);
    http.onreadystatechange = processResponse;
    http.send(null);
}

function processResponse() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('cities').innerHTML = response;
    }
}
 
</script>

<script language="Javascript" type="text/javascript">
 

function createRequestObject() {
    var tmpXmlHttpObject;
    if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return tmpXmlHttpObject;
}


var http = createRequestObject();

function makeGetRequest1(st) {
   // st=document.frm.state.value;
   
    http.open('get', 'Areas?city=' + st);
    http.onreadystatechange = processResponse1;
    http.send(null);
}

function processResponse1() {
    if(http.readyState == 4){
        var response = http.responseText;
        document.getElementById('areas').innerHTML = response;
    }
}
 
</script>
</head>
<body><jsp:include page="Top.jsp"></jsp:include>
<div class="container"><div class="row"> <div class="col-md-6"> 
 

<h2>Tax Calculation Details</h2>
 
<hr>

<div class="form-group">
 <form name="frm" method="post" action="regTaxDetails" ><table class="tblform">
	
	 
     <%
									 GetStateNCities obj=new GetStateNCities();
									 obj.getStates();
									 List<States> lst=obj.getLststate();
									 %>
									  <tr>
									 <td>State
									 </td>
									 <td> 
									 <select required name="state" class="form-control" onchange="makeGetRequest(this.value)">
									 <option value=""><--select--></option>
										<%for(int i=0;i<lst.size();i++)
											{%>
									 <option value="<%=lst.get(i).getState() %>"><%=lst.get(i).getState() %></option>											
											<%}%>															  
									 </select>
									 </td>
									 </tr>
									   <tr>
									 <td>City
									 </td>
									 <td> 
									<div id="cities"></div>
									 </td>
									 </tr>
									 
       <tr>
<td>Type</td>
<td> 
<input type="radio" name="ctype" value="urban"   checked="checked" required >Urban 
<input type="radio" name="ctype" value="rural"  required>Rural
<input type="radio" name="ctype" value="metro"  required>Metro
</td>
</tr>
        
          
	<tr><td>Rate</td>
	<td><input type="text" name="price" class="form-control" required></td>
	</tr>
       <tr>
									 <td>Property Type
									 </td>
									 <td> 
									 <select required name="proptype" class="form-control" >
									 <option value=""><--select--></option>
										 
									 <option value="Plot">Plot</option>
									 <option value="Bungalow">Bungalow</option>
									 <option value="House">House</option>
									 <option value="Duplex">Duplex</option>											
									<option value="Flat">Flat</option>	
									<option value="Shop">Shop</option>
									<option value="Farm">Farm</option>	 															  
									 </select>
									 </td>
									 </tr> 
									 <tr>
 			<td>Unit</td>
 			<td>
 			<select name="propunit" class="form-control">
 			<option value="<--select-->"><--select--></option>
 			<option value="Square foot">Square foot </option>
 			<option value="Square yard">Square yard</option>
 			<option value="Acre">Acre</option>
 			<option value="Hectare">Hectare</option>
 			</select> 
 			 </td>
 			</tr>
      <tr>  
	<td><input type="submit" value="Submit" class="btn btn-primary" ></td>
	</tr>
	</table>
</form>
</div></div><div class="col-md-6"><br/><br/>
<img src="images/officereg.jpg" width="100%"/>
</div>
</div></div>
</body>
</html>