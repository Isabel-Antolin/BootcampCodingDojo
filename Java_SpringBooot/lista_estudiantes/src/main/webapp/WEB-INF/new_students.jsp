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
	<div class="container">
		<h1 class="my-5 text-center">New Student</h1>
		<div class="d-flex justify-content-center">
			<form:form action="" modelAttribute="student" class="w-25 ">
				<div class="">
					<form:label path="nombre" class="">Nombre:</form:label>
					<form:input path="nombre" class="w-100 p-1" placeholder="Nombre" />
				</div>
				<div>
					<form:errors path="nombre" class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class="mt-3">
					<form:label path="apellido" class="">Apellido:</form:label>
					<form:input path="apellido" class="w-100 p-1" placeholder="Apellido"/>
				</div>
				<div>
					<form:errors path="apellido" class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class=" mt-3">
					<form:label path="edad" class="">Edad:</form:label>
					<form:input path="edad" class="w-100 p-1" placeholder="Edad" type="number" />
				</div>
				<div>
					<form:errors path="edad" class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class="d-flex justify-content-center mb-3">
					<button class="btn btn-primary">Crear</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>