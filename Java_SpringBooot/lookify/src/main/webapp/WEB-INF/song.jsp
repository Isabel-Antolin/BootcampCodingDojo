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
		<a class="text-end d-block" href="/dashboard">Dashboard</a>

		<div class="container mt-5">
			<div class="d-flex justify-content-between w-50">
				<p>Titulo</p>
				<p>
					<c:out value="${song.titulo}"></c:out>
				</p>
			</div>

			<div class="d-flex justify-content-between w-50">
				<p>Artista</p>
				<p>
					<c:out value="${song.artista}"></c:out>
				</p>
			</div>

			<div class="d-flex justify-content-between w-50">
				<p>Rating</p>
				<p>
					<c:out value="${song.clasificacion}"></c:out>
				</p>
			</div>

			<div>
				<form action="/song/${song.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<button type="submit" class="btn btn-link">Delete</button>
				</form>

			</div>
		</div>

	</div>
</body>
</html>