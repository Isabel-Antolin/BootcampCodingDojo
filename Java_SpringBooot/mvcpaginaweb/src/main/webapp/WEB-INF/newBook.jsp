<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>New Book</h1>
			<form:form action="/books/newBook" method="post" modelAttribute="book" class="border rounded border-dark m-5 p-2">
			<div class="row mb-3">
				<form:errors class="text-danger" path="title"></form:errors>
				<form:errors class="text-danger" path="language"></form:errors>
				<form:errors class="text-danger" path="description"></form:errors>
				<form:errors class="text-danger" path="numberOfPages"></form:errors>
			</div>
			<div class="row mb-3">
				<form:label path="title" for="text" class="col-sm-3 col-form-label">Titulo:</form:label>
				<div class="col-sm-8">
					<form:input path="title" type="text" class="form-control" name="nombre" id="text" aria-describedby="text" />
				</div>
			</div>
			<div class="row mb-3">
				<form:label path="language" for="text" class="col-sm-3 col-form-label">Language:</form:label>

				<div class="col-sm-8">
					<form:input path="language" type="text" class="form-control" name="nombre" id="text" aria-describedby="text" />

				</div>
			</div>
			<div class="row mb-3">
				<form:label path="description" for="text"
					class="col-sm-3 col-form-label">Description:</form:label>

				<div class="col-sm-8">
					<form:input path="description" type="text" class="form-control"
						name="nombre" id="text" aria-describedby="text" />
				</div>
			</div>
			<div class="row mb-3">
				<form:label path="numberOfPages" for="text"
					class="col-sm-3 col-form-label">Num of Pages:</form:label>
				<div class="col-sm-8">
					<form:input path="numberOfPages" type="text" class="form-control"
						name="nombre" id="text" aria-describedby="text" />
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-sm-11 d-flex justify-content-end">
					<button type="submit" class="btn btn-lg btn-primary w-25">Submit</button>
				</div>
			</div>

		</form:form>

</body>
</html>