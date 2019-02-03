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

<spring:url value="/resources/css/login2.css" var="log" />
<link href="${log}" rel="stylesheet" />
</head>

<body onload='document.loginForm.username.focus();'>

	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<p>Invalid username or password.</p>
		</div>
	</c:if>


	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<p>You have been logged out successfully.</p>
		</div>
	</c:if>

	<c:url var="loginUrl" value="/login" />

	<div class="login-page">
		<div class="form">
			<form class="login-form" action="${loginUrl}" method='POST'>
				<input type="text" placeholder="username" name='username' required/>
				<input type="password" placeholder="password" required
					name='password' /> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button>login</button>
			</form>
		</div>
	</div>

</body>
</html>