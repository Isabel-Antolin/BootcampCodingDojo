<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title></title>
</head>
<body>
	<div class="container mt-5 d-flex justify-content-around">
		<div>
			<h2>Register!</h2>
			<div><form:errors path="user.*" class="text-danger" /></div>

			<form:form method="POST" action="/registration" modelAttribute="user" class="d-flex flex-column">
				<div class="mb-3"><form:input type="text" path="userName" placeholder="User Name" class="w-100"/></div>
				<div class="mb-3"><form:input type="email" path="email" placeholder="Email" class="w-100" /></div>
				<div class="mb-3"><form:password path="password" placeholder="Password" class="w-100" /></div>
				<div class="mb-3"><form:password path="passwordConfirmation" placeholder="Password Confirmation" class="w-100" /></div>
				<input type="submit" value="Register!" class="mb-3" />
			</form:form>
		</div>

		<div>
			<h2>Login</h2>
			<div><form:errors path="loginUser.*" class="text-danger" /></div>
			<form:form method="POST" action="/login" modelAttribute="loginUser" class=" d-flex flex-column">
				<div class="mb-3"><form:input type="email" path="email" placeholder="Email" class="w-100" /></div>
				<div class="mb-3"><form:password path="password" placeholder="Password" class="w-100" /></div>
				<input type="submit" value="Login!"/>
			</form:form>
		</div>
	</div>
</body>
</html>