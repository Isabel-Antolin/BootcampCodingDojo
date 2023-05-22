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
	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="product">
			<div class="form-group">
		        <form:label path="name">Name</form:label><br>
				<form:errors class="text-danger" path="name" />
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="description">Description</form:label>
		        <form:input class="form-control" path="description"/>
		    </div>
		    <div class="form-group">
		        <form:label path="price">Price</form:label><br>
		    	<form:errors class="text-danger" path="price" />
		        <form:input type="number" class="form-control" path="price"/>
		    </div>
		    <button class="mt-3 btn btn-primary">New Product</button>
		</form:form>
	</div>
</body>
</html>