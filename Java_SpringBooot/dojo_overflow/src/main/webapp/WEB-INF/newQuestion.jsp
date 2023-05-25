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
		<h1>What is your Question?</h1>

		<form:form action="/questions/new" modelAttribute="question"
			method="POST" class="w-50">
			<div>
				<form:errors path="text_question" class="d-block" />

			</div>

			<div class="mt-5 d-flex ">
				<form:label path="text_question" class="w-25">Questions:</form:label>
				<form:textarea path="text_question" class="w-75" />
			</div>

			<div class="mt-5 d-flex">
				<label class="w-25">Tags</label>
				 <input  name="listaTag"class="w-50 " placeholder="ej : animales,color,cocina" />
			</div>
			<div>
				 <p class="text-danger d-block">${error}</p>
				 
			</div>
<form:errors path="tags" class="d-block" />
			<div class="d-flex justify-content-end mt-5">
				<button class="mt-3 w-25 btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>