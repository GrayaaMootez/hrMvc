<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>

<spring:url value="/resources/css/login.css" var="log" />
<link href="${log}" rel="stylesheet" />
<link
	href='//fonts.googleapis.com/css?family=Yanone+Kaffeesatz:400,700,300,200'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>

<!-- For-Mobile-Apps-and-Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Dark Sign In Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- //For-Mobile-Apps-and-Meta-Tags -->
</head>
<body onload='document.loginForm.username.focus();'>

	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<p>Invalid username and password.</p>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<p>You have been logged out successfully.</p>
		</div>
	</c:if>

	<h1>DARK SIGN IN FORM</h1>
	<div class="container">
		<h2>Sign In</h2>
		 <c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method='POST'>

			<input type='text' name='username' class="name"
				placeholder="Username" required> <input type='password'
				name='password' class="password" placeholder="Password" required />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="clear"></div>
			<input type="submit" value="SIGN IN">
		</form>
	</div>


</body>
</html>