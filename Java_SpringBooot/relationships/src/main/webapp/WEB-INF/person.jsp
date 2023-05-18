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
	<div class="container">

		<h1>${persona.nombre }</h1>
		<div class="d-flex">
			<div>
				<p class="">License Number</p>
				<p class="">State</p>
				<p class="">Expiration Date</p>
			</div>
			<div class="ms-5">
				<p class="">${persona.getLicense().numero}</p>
				<p class="">${persona.getLicense().estado}</p>
				<p class="">${persona.getLicense().fechaExpiracion }</p>
			</div>
		</div>


	</div>
</body>
</html>