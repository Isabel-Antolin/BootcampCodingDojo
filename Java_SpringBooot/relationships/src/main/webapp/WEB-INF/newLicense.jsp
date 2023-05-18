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
		<h1>New License</h1>

		<form:form action="/license/newLicense" modelAttribute="license"
			method="POST" class="w-50">
			<form:errors path="estado" />
			<div class="d-flex justify-content-between mb-3 mt-3">
				<form:label path="person">Persons: </form:label>
				<form:select class="" path="person">
					<c:forEach items="${persons}" var="p">
						<form:option value="${p.id} "> ${p.nombre } ${p.apellido}
						</form:option>
					</c:forEach>
				</form:select>
			</div>

			<div class="d-flex justify-content-between  mb-3">
				<form:label path="estado">State:</form:label>
				<form:input path="estado" />
			</div>
			<div class="d-flex justify-content-between  mb-3">
				 <form:label path="fechaExpiracion">Expiration Date</form:label>
				 <form:input path="fechaExpiracion" type="Date" />
			</div>

			<div class="mt-5">
				<button>Create</button>
			</div>

		</form:form>
	</div>
</body>
</html>