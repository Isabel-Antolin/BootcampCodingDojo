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
		<h1 class="my-5 text-center">New Ninja</h1>
		<c:if test="${existe}">
			<div class="my-5 text-center">El ninja ya se encuentra registrado.</div>
		</c:if>
		<div class="d-flex justify-content-center">
			<form:form action="/ninjas/new" modelAttribute="ninja" class="w-25"
				method="post">
				<div class="">
					<form:label path="dojo" class="">Dojo:</form:label>
					<form:select path="dojo" class="d-block w-100">
						<c:forEach var="dojo" items="${listaDojos}">
							<form:option value="${dojo.id}">${dojo.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class="mt-3">
					<form:label path="firstName" class="">First Name:</form:label>
					<form:input path="firstName" class="w-100 p-1"
						placeholder="First Name" />
				</div>

				<div>
					<form:errors path="firstName"
						class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class=" mt-3">
					<form:label path="lastName" class="">Last Name:</form:label>
					<form:input path="lastName" class="w-100 p-1"
						placeholder="Last Name" />
				</div>
				<div>
					<form:errors path="lastName"
						class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
				</div>
				<!-- 	___________________________________________________________________________________			 -->
				<div class=" mt-3">
					<form:label path="age" class="">Age:</form:label>
					<form:input path="age" class="w-100 p-1" placeholder="Age" type="number"/>
				</div>
				<div>
					<form:errors path="age"
						class="d-block text-white bg-danger p-1 mt-1 text-center border rounded fs-6 text" />
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