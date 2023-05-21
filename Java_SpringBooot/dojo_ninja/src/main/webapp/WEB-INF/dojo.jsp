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
		<h1><c:out value="${dojo.name}"></c:out> <span>Location Ninjas</span> </h1>
	    	<table class="table table-hover mt-5">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dojosyninjas}" var="ninja">
						<tr>
							<td>${ ninja.firstName}</td>
							<td>${ ninja.lastName}</td>
							<td>${ ninja.age}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>