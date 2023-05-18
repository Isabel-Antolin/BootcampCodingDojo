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
	<div class="container mt-5">
		<h1>New Person</h1>

		<form:form action="/person/newPerson" modelAttribute="person" method="POST" class="w-50">
			<div>
				<form:errors path="nombre" class="d-block" />
				<form:errors path="apellido" class="d-block" />
			</div>
			
			<div class="mt-5">
				<form:label path="nombre">First Name</form:label>
				<form:input path="nombre"  />
			</div>
			<div class="mt-5 mb-4">
				<form:label path="apellido">Last Name</form:label>
				<form:input path="apellido"/>
			</div>

			<button>Create</button>
		</form:form>
	</div>
</body>
</html>