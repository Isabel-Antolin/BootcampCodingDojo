<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>

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
		<h1>${evento.nombreEvento}</h1>
		<h2 class="mt-5">Editar Evento</h2>
		<form:form method="POST" action="/${evento.id}" modelAttribute="evento" class="mt-5">
				<input type="hidden" name="_method" value="PUT">
				<form:hidden value="${ usuario.id }" path="user" />
				<div class="row">
					<div class="col-2">
						<form:label path="nombreEvento" class="mb-4 d-block">Nombre</form:label>
						<form:label path="fechaEvento" class="mb-4 d-block">Fecha del Evento</form:label>
						<form:label path="ciudad">Ciudad</form:label>
					</div>
					<div class="col-4">
						<form:input path="nombreEvento" class="mb-4 w-100" />
						<form:input path="fechaEvento" type="date" class="mb-4 w-100" />
						<form:input path="ciudad" class="mb-4 w-50" />
						<form:select class="ms-2" path="estado">
							<c:forEach items="${ estados }" var="estado">
								<option value="${ estado }">${ estado }</option>
							</c:forEach>
						</form:select>
						<form:hidden path="user" value="${usuario.id}" />
						<form:button class="btn btn-success d-block">Editar Evento</form:button>
					</div>
					<div class="col">
						<form:errors class="text-danger mb-4 d-block" path="nombreEvento"></form:errors>
						<form:errors class="text-danger mb-4 d-block" path="fechaEvento"></form:errors>
						<form:errors class="text-danger mb-4 d-block" path="ciudad"></form:errors>
					</div>
				</div>
			</form:form>
	</div>
</body>
</html>