<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<spring:url value="/resources/css/bootstrap.min.css" var="css1" />
<spring:url value="/resources/css/style.css" var="css2" />

<spring:url value="/resources/css/owl.carousel.css" var="css3" />
<spring:url value="/resources/css/owl.theme.default.css" var="css4" />
<spring:url value="/resources/css/fontello.css" var="css5" />
<spring:url value="/resources/css/font-awesome.min.css" var="css6" />
<link href="${css1}" rel="stylesheet" />
<link href="${css2}" rel="stylesheet" />
<link href="${css3}" rel="stylesheet" />
<link href="${css4}" rel="stylesheet" />
<link href="${css5}" rel="stylesheet" />
<link href="${css6}" rel="stylesheet" />
</head>
<!-- top-header-section-->
<div class="top-header">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-7 col-sm-6 col-xs-12">
				<ul>
					<li>+216 23567143</li>
					<li>|</li>
					<li>grayaamootez@gmail.com</li>
				</ul>
			</div>
			<div class="col-lg-4 col-md-5 col-sm-6 col-xs-12">
				<ul>
					<li><a href="#">Help Center</a></li>
					<li>|</li>
					<li><a href="#">Job Listing</a></li>
					<li>|</li>
					<li><a href="#">Clients</a></li>
					<li>|</li>
					<li><a href="#">Client Reviews</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<div class="menu-toggel">
	<a href="#" id="dots" class="dots-icon"><i
		class="fa fa-ellipsis-v visible-xs"></i></a>
</div>
<!-- /.top-header-section-->
<!-- header-section-->
<div class="header-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-lg-2 col-md-4 col-sm-6 col-xs-12">
				<div class="logo">
					<spring:url value="/resources/images/logo.png" var="img2" />
					<a href="/hrMvc/home"><img src="${img2}" alt=""> </a>
				</div>
			</div>
			<div class="col-lg-7 col-md-8 col-sm-12 col-xs-12">
				<!-- navigations-->
				<div class="navigation">
					<div id="navigation">
						<ul>
							<li class="active"><a href="/hrMvc">Home</a></li>
							<li class="has-sub"><a href="#">Paramétrage</a>
								<ul>
									<li><a href="/hrMvc/countries">Countries</a></li>
									<li><a href="/hrMvc/departments">Departments</a></li>
									<li><a href="/hrMvc/employees">Employees</a></li>
									<li><a href="/hrMvc/jobs">Jobs</a></li>
									<li><a href="/hrMvc/locations">Locations</a></li>
									<li><a href="/hrMvc/regions">Regions</a></li>
								</ul></li>
							<li class="has-sub"><a href="#">Blog</a>
								<ul>
									<li><a href="blog-default.html">Blog Default</a></li>
									<li><a href="blog-single.html">Blog Single</a></li>
								</ul></li>
							<li class="has-sub"><a href="#">Pages</a>
								<ul>
									<li><a href="about.html">About</a></li>
									<li><a href="client-list.html">Client List</a></li>
									<li><a href="job-list.html">Job List</a></li>
									<li><a href="job-single.html">Job Single</a></li>
									<li><a href="client-review.html">Client Reviews</a></li>
									<li><a href="consultation-form.html">Consultation Form</a>
									</li>
									<li><a href="404-page.html">404-page</a></li>
									<li><a href="styleguide.html">styleguide</a></li>
								</ul></li>
							<li><a href="contact-us.html">Contact Us</a></li>
							<li><a href="template-feature.html">Template Feature</a></li>
						</ul>
					</div>
				</div>
				<!-- /.navigations-->
			</div>
		</div>
	</div>
	    Dear <strong>${pageContext.request.remoteUser}</strong>, Welcome to Admin Page.
    <a href="<c:url value="/logout" />">Logout</a>
    <sec:authentication property="principal.authorities"/>
</div>
<!-- /. header-section-->