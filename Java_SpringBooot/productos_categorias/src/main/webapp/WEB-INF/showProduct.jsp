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
	<hr>
	<div class="container mt-5">
		<h1>${producto.name }</h1>

		<div class="row mt-4">
			<div class="col-6">
				<h2>Categorias</h2>
				<c:forEach items="${producto.categories}" var="categoria">
					<li>${categoria.name }</li>
				</c:forEach>
			</div>

			<div class="col-6">
				<h2>Add Category:</h2>
				<form:form action="/aso/${producto.id }" method="post"
					modelAttribute="productcategory">
					<form:input type="hidden" path="product" value="${producto.id }" />
					<form:select class="form-control" path="category">
						<c:forEach items="${categorias}" var="categoria">
							<form:option value="${categoria.id} "> ${categoria.name}</form:option>
						</c:forEach>
					</form:select>
					<button class="mt-4 btn btn-primary">Agregar</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>