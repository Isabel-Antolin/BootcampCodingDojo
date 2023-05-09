<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div class="container mt-5 d-flex flex-column  flex-column align-items-center">
		<h3 class="text-danger">
		<c:out value="${error}"/>
		</h3>
		<h3>What is the code?</h3>
		<form action="" method="post">
			<input type="text" name="cajaTexto">
			<button type="submit" class="btn btn-primary d-block mt-4 mx-auto">Try code</button>
		</form>
	</div>
</body>
</html>