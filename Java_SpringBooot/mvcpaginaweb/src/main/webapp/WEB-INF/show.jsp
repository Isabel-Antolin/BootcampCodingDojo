<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

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
		<h1><c:out value="${libro.title}"/></h1>
		<p>Description: <c:out value="${libro.description}"/></p>
		<p>Language: <c:out value="${libro.language}"/></p>
		<p>Number of pages: <c:out value="${libro.numberOfPages}"/></p>
		
		<div class="d-flex justify-content-between">
			<a href="/books" class="btn btn-primary"> Volver atras</a>
			<a href="/books/edit/${libro.id }"class="btn btn-warning"> Editar Libro </a>
			<a href="/books/delete/${libro.id}" class="btn btn-danger"> Borrar Libro </a>
		</div>

	</div>
	

</body>
</html>