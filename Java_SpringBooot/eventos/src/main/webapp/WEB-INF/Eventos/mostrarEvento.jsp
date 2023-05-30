<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		<div class="row mt-4">
			<div class="col-4 me-5">
				<p>Host: <span>${evento.user.nombre}</span> </p>
				<p class="text-capitalize">Fecha Evento: <span><fmt:formatDate value="${evento.fechaEvento}" pattern="MMMM dd, yyyy" /></span> </p>
				<p>Ciudad: <span>${evento.ciudad}</span> </p>
				<p>Personas que asisten a este evento: <span>${evento.asistentes.size()}</span> </p>
				
				 <table class="table">
				      <thead>
				        <tr>
				          <th scope="col">Nombre</th>
				          <th scope="col">Ciudad</th>
				        </tr>
				      </thead>
				      <tbody>
				      <c:forEach var="asistentes" items="${evento.asistentes}">
				      	 <tr>
					          <th>${asistentes.nombre}</th>
					          <td>${asistentes.ciudad}</td>
				        </tr>
				      </c:forEach>
				       
				      </tbody>
				    </table>
			</div>
			<div class="col-6">
				<h2>Muro de Mensajes</h2>
				<div class="border border-dark mt-3 p-4 mb-5 overflow-auto h-50">
					<c:forEach  var="mensajes" items="${evento.mensajes}">
						<p>${mensajes.user.nombre} : <span>${mensajes.comentario}</span> </p>
					<hr>
					</c:forEach>
				</div>
				
				<form:form  action="/events/agregarMensaje" method="POST" modelAttribute="mensaje">
					<form:hidden path="evento.id" value="${evento.id}" />
					<form:label path="comentario" class="d-block mb-3 ">Agregar Comentario</form:label>
					<form:textarea path="comentario" cols="50"/>
					<div class="">
						<form:errors class="text-danger mb-4 d-block" path="comentario"></form:errors>
					</div>
					<form:button class="btn btn-success d-block mt-5">Agregar comentario</form:button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>