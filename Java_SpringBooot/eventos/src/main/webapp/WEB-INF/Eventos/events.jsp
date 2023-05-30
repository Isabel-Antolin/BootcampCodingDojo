<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<div class=container>
		<div class="d-flex justify-content-between mt-5">
			<h1 class="text-capitalize">
				Bienvenido, <span><c:out value="${usuario.nombre}"></c:out></span>
			</h1>
			<a href="/logout">Logout</a>
		</div>
		<div class="mb-5">
			<h3>Estos son algunos de los eventos en su estado:</h3>
			<table class="table border">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Fecha</th>
						<th scope="col">Ciudad</th>
						<th scope="col">Host</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="evento" items="${listaEventosPorEstado}">
						<tr>
							<td class="text-capitalize"><a href="/events/${evento.id}">${evento.nombreEvento}</a></td>
							<td class="text-capitalize"><fmt:formatDate value="${evento.fechaEvento}" pattern="MMMM dd, yyyy" /></td>
							<td>${evento.ciudad}</td>
							<td class="text-capitalize">${evento.user.nombre}</td>
							<td class="d-flex"><c:choose>
								<c:when test="${ evento.user.id == usuario.id }">
									<a href="/events/${ evento.id }/edit" class="btn btn-primary me-3">Edit</a> 
									<form class="delete-form" action="/events/${ evento.id }"
										method="post">
										<input type="hidden" name="_method" value="delete" />
										<button class="btn btn-danger">Borrar</button>
									</form>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ evento.asistentes.contains(usuario)}"> 
											<a> Unido</a>
											<a href="/event/${ evento.id }/cancelar" class="ms-4"> Cancelar</a>
										</c:when>
										<c:otherwise>
											 <a href="/event/${ evento.id }/unirse" >Unirse</a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<hr>
		<div class="mt-5 mb-5">
			<h3>Estos son algunos de los eventos en otros estados:</h3>
			<table class="table border">
				<thead>
					<tr>
						<th scope="col">Nombre</th>
						<th scope="col">Fecha</th>
						<th scope="col">Ciudad</th>
						<th scope="col">Estado</th>
						<th scope="col">Host</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="otroEvento" items="${listaOtrosEventos}">
						<tr>
							<td class="text-capitalize"><a
								href="/events/${otroEvento.id}">${otroEvento.nombreEvento}</a></td>
							<td class="text-capitalize"><fmt:formatDate
									value="${otroEvento.fechaEvento}" pattern="MMMM dd, yyyy" /></td>
							<td class="text-capitalize">${otroEvento.ciudad}</td>
							<td>${otroEvento.estado}</td>
							<td class="text-capitalize">${otroEvento.user.nombre}</td>
							<td class="d-flex"><c:choose>
								<c:when test="${ otroEvento.user.id == usuario.id }">
									<a href="/events/${ otroEvento.id }/edit" class="btn btn-primary me-3">Edit</a> 
									<form class="delete-form" action="/events/${ otroEvento.id }"
										method="post">
										<input type="hidden" name="_method" value="delete" />
										<button class="btn btn-danger">Borrar</button>
									</form>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ otroEvento.asistentes.contains(usuario)}"> 
											<a> Unido</a>
											<a href="/event/${ otroEvento.id }/cancelar" class="ms-4"> Cancelar</a>
										</c:when>
										<c:otherwise>
											 <a href="/event/${ otroEvento.id }/unirse" >Unirse</a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose></td>
						</tr>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<div>
			<h2>Crear un Evento</h2>
			<form:form method="Post" action="/newEvento" modelAttribute="evento"
				class="mt-5">
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
						<form:button class="btn btn-success d-block">Agregar Evento</form:button>
					</div>
					<div class="col">
						<form:errors class="text-danger mb-4 d-block" path="nombreEvento"></form:errors>
						<form:errors class="text-danger mb-4 d-block" path="fechaEvento"></form:errors>
						<form:errors class="text-danger mb-4 d-block" path="ciudad"></form:errors>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>