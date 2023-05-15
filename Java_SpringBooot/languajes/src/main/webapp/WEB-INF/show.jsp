<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<a href="/languages" class="d-block text-end">Dashboard</a>
		<h2 class="mb-5">${lenguage.name }</h2>
		<h2 class="mb-5">${lenguage.creator }</h2>
		<h2 class="mb-5">${lenguage.currentVersion }</h2>

		<form action="/languages/${language.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<button type="submit" class="btn btn-link d-block">Delete</button>
			<a href="languages/${language.id}/edit" class="btn btn-link">Edit</a>
		</form>
	</div>
</body>
</html>