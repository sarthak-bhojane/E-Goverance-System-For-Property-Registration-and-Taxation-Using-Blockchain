<%@page import="models.States"%>
<%@page import="java.util.List"%>
<%@page import="models.GetStateNCities"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
<title>e-governance system for land registration and taxation using blockchain</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Land Investors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--css links-->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /><!--bootstrap-->
<link href="css/font-awesome.css" rel="stylesheet"><!--font-awesome-->
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" /> <!-- Flexslider-CSS -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" /><!--stylesheet-->
<!--//css links-->
<!--fonts-->
<link href="//fonts.googleapis.com/css?family=Raleway:300,400,500,600,700,800,900" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<!--//fonts-->
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
</head>
<body>
<!-- Header -->
<div id="home" class="banner w3l">
	<div class="container">
		<div class="header-nav">
			<nav class="navbar navbar-default">
					<div class="navbar-header logo">
								<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<h1>
									<a class="navbar-brand" href="/home">E-governance System for Land Registration and Taxation using Blockchain</a>
								</h1>
					</div>
					<!-- navbar-header -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="home" class="active">Home</a></li>
							<li><a href="about.html">Registration</a></li>
							<li><a href="about.html">Login</a></li>
						<!-- 	<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="icons.html">Web Icons</a></li>
									<li><a href="typography.html">Typography</a></li>
								</ul>
							</li>
							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="contact.html">Contact</a></li> -->
						</ul>
					</div>
					<div class="clearfix"> </div>	
				</nav>
							<div class="clearfix"> </div>
		</div>
		<div class="banner-info wow bounceInDown" data-wow-duration="1s" data-wow-delay="0s">
			<div  class="callbacks_container">
				<ul class="rslides" id="slider3">
					<li>
						<div class="banner-text">
						 
							<h3>Blockchain based secure and transparent Land Registration and Taxation System</h3>
							<p>Tax transactions will be maintained on blockchain servers in encrypted format in the form of blocks</p>
								 
						</div>
					</li>
					<li>
						<div class="banner-text">
							 
							<h3>AES Encryption </h3>
							<p>Transactions and Properties ownership will be maintained on blockchain servers in encrypted format using AES algorithm </p>
							 
						</div>
					</li>
					 
				</ul>
			</div>	
		</div>
		
	</div>	
</div>	
<!-- //Header -->
 
<!-- serach --><!--
<div class="serach-w3agile">
		<div class="container"> 
			<div class="place-grids">
				<form action="#" method="post">
					<div class="col-md-3 col-xs-3 place-grid">
						
						<select class="sel" required="">
							<option value="">Select by price</option>
							<option value="">price2</option>
							<option value="">price3</option>
							<option value="">price4</option> 
							<option value="">price5</option>
							<option value="">price6</option> 
						</select>
					</div>
					<div class="col-md-3 col-xs-3 place-grid">
						
						<select class="sel" required="">
							<option value="">Select by location</option>
							<option value="">location2</option>
							<option value="">location3</option>
							<option value="">location4</option>
							<option value="">location5</option>
						</select>
					</div>
					<div class="col-md-3 col-xs-3 place-grid">
						
						<select class="sel" required="">
							<option value="">Select by area</option>
							<option value="">area2</option>
							<option value="">area3</option>
							<option value="">area4</option>
							<option value="">area5</option>
							<option value="">area6</option>
						</select>
					</div>
					<div class="col-md-3 col-xs-3 place-grid"> 
						<input type="submit" value="Search"> 
					</div>
					<div class="clearfix"></div>
				</form>
			</div>
		</div>
	</div>-->
<!-- //serach --> 
<!-- about -->
	<div class="about w3layouts-agileinfo">
		<div class="container">
			<h3 class="agile-titlew3">Login</span></h3>
			<div class="about-top w3ls-agile">
				<div class="col-sm-6 red">
					 	  <form action="check" method="post">
                  <table class="tblform">
                      <tr>
                          <td>Userid</td>
                          <td>
                              <input type="text" name="userid" required class="form-control" />
                          </td>
                      </tr>
                      <tr>
                          <td>Password</td>
                          <td>
                              <input type="password" name="pswd" required class="form-control" />
                          </td>
                      </tr>
                      <tr>
                          <td colspan="2">
                          <input type="submit" value="Submit" class="btn btn-primary"/>
                          </td>
                      </tr>
                  </table>
              </form>
				</div>
				<div class="col-sm-6 about-wel">
				
					 <img src="images/login.png" width="200px"/>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //about -->
	<!-- Stats -->
<div class="stats-agileits" id="stats">
	<div class="container">
		<div class="stats-info agileits w3layouts">
			<div class="col-md-6 agileits w3layouts col-sm-6 stats-grid stats-grid-1">
				<div class="stat-info-w3ls jumbotron">
				<h2>User Registration</h2>
				   <form name="frm" method="post" action="registeruser" enctype="multipart/form-data"><table class="tblform">
	<tr><td>Userid</td>
	<td><input type="text" name="userid" class="form-control" required></td>
	</tr>
	<tr><td>User Name</td>
	<td><input type="text" name="usernm" class="form-control" required></td>
	</tr>
	<tr><td>Password</td>
	<td><input type="password" name="pswd" class="form-control" required>
	 <input type="hidden" name="usertype" value="user"/>
	</td>
	</tr>
 
       <tr><td>Mobile Number</td>
       	<td><input type="text" name="mobileno"  pattern="^\d{10}$" class="form-control" required></td></tr>
       <tr>
		<td>Email Address</td>       
       <td><input type="text" name="emailid" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"  class="form-control" required></td>
       </tr>
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
<td>Gender</td>
<td>
  <input type="hidden" name="userstatus" value="active"/>
<input type="radio" name="gender" value="Male"   checked="checked" required >Male 
<input type="radio" name="gender" value="Female"  required>Female 
</td>
</tr>
        
         <tr><td> Address</td>
	<td><textarea  name="addr" class="form-control" required></textarea></td>
	</tr>
	<tr><td>Pincode</td>
	<td><input type="text" name="pincode" class="form-control" required></td>
	</tr>
      
       <tr>
       	<td>Date Of Birth</td>
       	<td><input type="date" name="dob" class="form-control"></td>
       </tr>
       <tr><td>Photo</td>
       <td>
       <input type="file" name="file" class="form-control"/>
       </td>
	<tr>
	<td><input type="submit" value="Submit" class="btn btn-primary" ></td>
	</tr>
	</table>
</form> 		</div>
			</div>
			 
			<div class="clearfix"></div>
		</div>
	</div>
</div>
	<!-- //Stats -->
 
<!-- footer -->
<div class="footer">
		<div class="container">
			<div class="w3_agile_footer_grids">
				 
				 
			 
			<div class="w3ls_address_mail_footer_grids">
				 
			<div class="agileinfo_copyright">
				<p>&copy 2022 e-governance system for land registration and taxation using blockchain. All Rights Reserved  </p>
			</div>
		</div>
	</div>
<!-- Modal1 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" >
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>Land Investors</h4>
					<img src="images/5.jpg" alt="blog-image" />
					<p class="para-agileits-w3layouts">Lorem ipsum dolor sit amet, Sed ut perspiciatis unde omnis iste natus error sit voluptatem , eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.accusantium doloremque laudantium, totam rem aperiamconsectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
			</div>
		</div>
	</div>
</div>
<!-- //Modal1 -->
<!--//footer -->
<!-- js -->
<script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
<!--//js -->
<!-- responsiveslides -->
<script src="js/responsiveslides.min.js"></script>
			<script>
									// You can also use "$(window).load(function() {"
									$(function () {
									 // Slideshow 4
									$("#slider3").responsiveSlides({
										auto: true,
										pager: false,
										nav: true,
										speed: 500,
										namespace: "callbacks",
										before: function () {
									$('.events').append("<li>before event fired.</li>");
									},
									after: function () {
										$('.events').append("<li>after event fired.</li>");
										}
										});
										});
			</script>
<!-- //responsiveslides -->
<!-- OnScroll-Number-Increase-JavaScript -->
	<script type="text/javascript" src="js/numscroller-1.0.js"></script>
<!-- //OnScroll-Number-Increase-JavaScript -->
<!--Scrolling-top -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!--//Scrolling-top -->
 	<!-- FlexSlider -->
				  <script defer src="js/jquery.flexslider.js"></script>
				  <script type="text/javascript">
					$(function(){
					 
					});
					$(window).load(function(){
					  $('.flexslider').flexslider({
						animation: "slide",
						start: function(slider){
						  $('body').removeClass('loading');
						}
					  });
					});
				  </script>
		<!-- FlexSlider -->
<!-- script for responsive tabs -->						
<script src="js/easy-responsive-tabs.js"></script>
<script>
$(document).ready(function () {
$('#horizontalTab').easyResponsiveTabs({
type: 'default', //Types: default, vertical, accordion           
width: 'auto', //auto or any width like 600px
fit: true,   // 100% fit in a container
closed: 'accordion', // Start closed if in accordion view
activate: function(event) { // Callback function if tab is switched
var $tab = $(this);
var $info = $('#tabInfo');
var $name = $('span', $info);
$name.text($tab.text());
$info.show();
}
});
$('#verticalTab').easyResponsiveTabs({
type: 'vertical',
width: 'auto',
fit: true
});
});
</script>
<!-- script for responsive tabs -->	
<!-- smooth scrolling -->
	<script type="text/javascript">
		$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/								
		$().UItoTop({ easingType: 'easeOutQuart' });
		});
	</script>
	<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
</body>
</html>