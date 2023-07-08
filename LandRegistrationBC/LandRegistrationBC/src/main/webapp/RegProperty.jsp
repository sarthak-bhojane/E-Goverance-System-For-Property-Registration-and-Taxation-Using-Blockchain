 
<%@page import="models.*"%>
<%@page import="models.GetStateNCities"%>
<%@page import="java.util.List"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch input { 
  opacity: 0;
  width: 0;
  height: 0;
}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>

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
<body>
<jsp:include page="Top.jsp"></jsp:include>
<%  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);%>
<div class="container">
<div class="row">
<div class="col-md-12">

<center><h2>Register Property</h2></center><br/>
 		
<form   action="propReg" method="post"  enctype="multipart/form-data">
<div class="row">
<div class="col-md-6">
<table class="tblform">
 <tr><td>Title/Description</td>
                <td><textarea  class="form-control"  name="title" required></textarea></td></tr>
                 <tr>						   
				  						   
				 <tr><td>Address</td>
                <td><textarea  class="form-control"  name="addr" required></textarea></td></tr>
                <tr><td>pincode</td>
                <td><input type="text"  class="form-control"  name="pincode" required/></td></tr>
                						   
				<tr>						   
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
									 <td>Area
									 </td>
									 <td> 
									<div id="areas"></div>
									 </td>
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
									 <td>Property Current Status
									 </td>
									 <td> 
									 <select required name="propCurrentSts" class="form-control" >
									 <option value=""><--select--></option>
										 
									 <option value="ForSale">For Sale</option>
									 <option value="NotForSale">Not For Sale</option>
									 															  
									 </select>
									 </td>
									 </tr> 
               <tr><td>Upload Property Photo</td>
                <td><input type="file"  class="form-control"  name="file" required></td></tr>
                 <tr><td>Upload Property Documents in Zip</td>
                <td><input type="file"  class="form-control"  name="file1" required></td></tr>
                <tr><td>Village</td>
                <td><textarea  class="form-control"  name="village" required></textarea></td></tr>
            <tr><td>Property Condition</td>
                <td>New <input type="radio" name="propcondition" value="New" checked="checked"/>
             Old <input type="radio" name="propcondition" value="Old" />
                </td></tr>
            
                 
									     <tr>
		 <td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/>
		  </td></tr>
		  </table>
</div>
<div class="col-md-6">
 			<table>
 			<tr>
 			<td>Bus Stand Distance from Property in meters</td>
 			<td>
 			<input type="Number" name="busStandDist" required class="form-control"/>
 			<input type="hidden" name="userid"   value="<%=session.getAttribute("userid").toString().trim() %>"/>
 			</td>
 			</tr>
 			<tr>
 			<td>Auto Stand Distance from Property in meters</td>
 			<td>
 			<input type="Number" name="autoStandDist" required class="form-control"/>
 			</td>
 			</tr>
 			<tr>
 			<td>Shops Near Property</td>
 			<td>
 			 <label class="switch"><input type="checkbox" name="nearbyShops"  /> <span class="slider round"></span> </label>
 			</td>
 			</tr>
 			<tr>
 			<td>Hospitals Near Property</td>
 			<td>
 			<label class="switch"><input type="checkbox" name="nearbyHosp"  /> <span class="slider round"></span> </label>
 			</td>
 			</tr>
 			<tr>
 			<td>Distance from Main Road in meters</td>
 			<td>
 			<input type="Number" name="mainRoadDist" required class="form-control"/>
 			</td>
 			</tr>
 			<tr>
 			<td>Schools Near Property</td>
 			<td>
 			<label class="switch"><input type="checkbox" name="nearbySchools"  /> <span class="slider round"></span> </label>
 			</td>
 			</tr>
 			<tr>
 			<td>Colleges Near Property</td>
 			<td>
 			<label class="switch"><input type="checkbox" name="nearByColg"  /> <span class="slider round"></span> </label>
 			</td>
 			</tr>
 			<tr>
 			<td>Shopping Mall Near Property</td>
 			<td>
 			<label class="switch"><input type="checkbox" name="nearbyMall"  /> <span class="slider round"></span> </label>
 			</td>
 			</tr>
 			<tr>
 			<td>Purchase Date</td>
 			<td>
 			<input type="date" name="purchaseDt" required class="form-control"/>
 			</td>
 			</tr>
 			<tr>
 			<td>Property Size</td>
 			<td>
 			<input type="text" name="propsize" required class="form-control"/>
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
 			<td>Cost Price in Rs.</td>
 			<td>
 			<input type="Number" name="cprice" required class="form-control"/> 
 			</td>
 			</tr>
 			<tr>
 			<td>Selling Price in Rs.</td>
 			<td>
 			<input type="Number" name="sprice" required class="form-control"/> 
 			</td>
 			</tr>
 			</table>			 
	</div>	</div> 
		  </form>
</div>
</div>

</div>

</div>
</body>
</html>