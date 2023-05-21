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
		<h1 class="text-center">New Dojo</h1>

		<div class="d-flex justify-content-center">
			<form:form action="/dojos/new" modelAttribute="dojo" method="POST"
				class="w-25">
				<div>
					<form:errors path="name" class="d-block" />
				</div>

				<div class="mt-5">
					<form:label path="name">Name</form:label>
					<form:input path="name" />
				</div>
				
				<div class="d-flex justify-content-center">
				<button class="mt-3 w-50 btn btn-primary">Create</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>