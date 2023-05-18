<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
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
		<h1 class="my-5 text-center">Datos de contacto</h1>
		<div class="d-flex justify-content-center">
			<form:form action="/contact/new" modelAttribute="contact" class="w-25 " method="post">
				<div class="">
					<form:label path="student" class="">Estudiantes:</form:label>
					<form:select path="student" class="d-block w-100">
						<c:forEach var="student" items="${listStudent}">
							<form:option value="${student.id}">${student.nombre} ${student.apellido}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class="mt-3">
					<form:label path="direccion" class="">Direccion:</form:label>
					<form:input path="direccion" class="w-100 p-1" placeholder="direccion"/>
				</div>
				
				<div>
					<form:errors path="direccion" class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class=" mt-3">
					<form:label path="ciudad" class="">Ciudad:</form:label>
					<form:input path="ciudad" class="w-100 p-1" placeholder="Ciudad"/>
				</div>
				<div>
					<form:errors path="ciudad" class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class=" mt-3">
					<form:label path="estado" class="">Estado:</form:label>
					<form:input path="estado" class="w-100 p-1" placeholder="Ciudad"/>
				</div>
				<div>
					<form:errors path="estado" class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
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