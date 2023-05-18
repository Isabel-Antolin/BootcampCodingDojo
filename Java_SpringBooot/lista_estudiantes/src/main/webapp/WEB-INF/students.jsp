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
	<div>
		<h1>Estudiantes</h1>
	    	<table class="table table-hover mt-5">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Edad</th>
						<th>Direccion</th>
						<th>Ciudad</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="s">
						<tr>
							<td><a href="/student/${s.id}">${ s.nombre } ${ s.apellido }</a></td>
							<td>${ s.edad }</td>
							<td>${ s.getContacto().direccion }</td>
							<td>${ s.getContacto().ciudad }</td>
							<td>${ s.getContacto().estado}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>