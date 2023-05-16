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
	
	<div class="container mt-5">
	    <a class="text-end d-block" href="/dashboard">Dashboard</a>
	    
		<form:form class="mt-5 w-50" action="/songs/new" method="POST" modelAttribute="song">
		    <div> <form:errors class="text-danger" path="titulo"/></div>
		    <div class="mb-3 d-flex justify-content-between">
		        <form:label class="" path="titulo">Titulo</form:label>
		        <form:input class="" path="titulo"/>
		    </div>
		    
		    <div> <form:errors class="text-danger" path="artista"/></div>
		    <div class="mb-3 d-flex justify-content-between">
		        <form:label class="" path="Artista">Artista</form:label>
		        <form:input class="" path="Artista"/>
		        <form:errors class="text-danger" path="Artista"/>
		    </div>
		    
		    <div> <form:errors class="text-danger" path="clasificacion"/></div>
		    <div class="mb-3 d-flex justify-content-between">
		        <form:label class="" path="clasificacion">Rating(1-10)</form:label>
		        <form:input type="number" class="" path="clasificacion" min="1" max="10" />
		    </div>
		    <input class="btn btn-primary float-end" type="submit" value="Add Song"/>
		</form:form>
	
	</div>
</body>
</html>