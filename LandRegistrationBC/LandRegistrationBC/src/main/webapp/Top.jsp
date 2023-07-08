<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title> Automated property valuation using machine learning techniques
  </title>
   <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--css links-->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" /><!--bootstrap-->
<link href="css/font-awesome.css" rel="stylesheet"><!--font-awesome-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" /><!--stylesheet-->
<!--//css links-->
<!--fonts-->
<link href="//fonts.googleapis.com/css?family=Raleway:300,400,500,600,700,800,900" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<!--//fonts-->
</head>
<body>
<!-- Header -->
<div id="home" class="banner inner-bnr-w3l">
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
									<a class="navbar-brand" href="index.html">E-governance System for Land Registration and Taxation using Blockchain</a>
								</h1>
					</div>
					<!-- navbar-header -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="<%=session.getAttribute("utype").toString() %>">Home</a></li>
							 <%if(session.getAttribute("usertype").toString().trim().equals("admin"))
							{%>
							<li><a href="viewUsers" >View Users</a></li>
							<li><a href="RegTaxCalc.jsp" >Register Tax Details</a></li>
							 
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Offices <b class="caret"></b></a>
								<ul class="dropdown-menu agile_short_dropdown">
									<li><a href="regOffice">Register Office </a></li>
									<li><a href="viewOffice"> View Offices</a></li>
									 
								</ul>
							</li>
							<%} else if(session.getAttribute("utype").toString().trim().equals("user"))
							{%>
							  
							 <li class="nav-item">
            <a class="nav-link " href="regproperty"> Register Property</a></li>
							 <li class="nav-item">
            <a class="nav-link " href="viewProperties">My Properties</a>
           <li class="nav-item">
            <a class="nav-link " href=" viewPendingTransferProp">Pending Transfer Requests</a>
							   			<%}else if(session.getAttribute("utype").toString().trim().equals("officer"))
										{%>
										  
										 <li class="nav-item">
			            <a class="nav-link " href="viewPendingProperties">View Pending Properties</a></li>
			            				 <li class="nav-item">
			            <a class="nav-link " href="viewPropertiesOfficer">View Properties</a></li>
			            <li class="nav-item"> 
			            <a class="nav-link " href="ViewTaxDefaulters">View Defaulters</a></li>
			           <li class="nav-item">  <a class="nav-link " href=" viewPATransferProp">Pending Transfer Requests</a></li>
			           <li class="nav-item">  <a class="nav-link " href=" viewPendingTaxpayment">Pending Tax Payments</a></li>
										   			<%} %>
							<li><a href="logout">Logout</a></li>
							 
						</ul>
					</div>
					<div class="clearfix"> </div>	
				</nav>
							<div class="clearfix"> </div>
		</div>
	</div>	
</div>	
<!-- //Header -->
<!-- about -->
<div class="about">
		<div class="container">
		<h2 class="agileits-title"><%=session.getAttribute("utype").toString() %> Home</h2>
 
           <%
try
{  response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setDateHeader("Expires", -1);
if(session.getAttribute("userid")==null)
{
	response.sendRedirect("home");
}
%>
  
        
	  <p class="para">
            Logged in as <%=session.getAttribute("userid").toString() %>( <%=session.getAttribute("usertype").toString() %>)
            </p>
        
    <!--// end-smoth-scrolling -->
    <%}catch(Exception ex)
{
    	System.out.println("err="+ex.getMessage());
    	 
}%>

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