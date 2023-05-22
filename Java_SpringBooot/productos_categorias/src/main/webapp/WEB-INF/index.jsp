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
		<h2>Products</h2>
		<table class="table table-hover mt-5">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Category Count</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productTable}" var="product">
					<tr>
						<td>${product[0]}</td>
						<td>${product[1]}</td>
						<td>${product[2]}</td>
						<td>${product[3]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<h2>Categories</h2>
		<table class="table table-hover mt-5">
			<thead>
				<tr>
					<th>Category Name</th>
					<th>Product Count</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categoryTable}" var="category">
					<tr>
						<td>${category[0]}</td>
						<td>${category[1]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>