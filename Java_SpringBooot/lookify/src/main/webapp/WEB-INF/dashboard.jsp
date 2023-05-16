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
		<div class="row">
			<div class="col">
				<a href="/songs/new" class="me-4">Add New</a>
				<a href="/search/topTen">Top Songs</a>
			</div>
			<div class="col">
				<form:form action="/search" method="post" modelAttribute="song" class="">
					<div class="">
						<div><form:errors path="artista"/></div>
						<div class="d-flex">
							<form:input type="text" class="" path="artista"/>
							<button type="submit" class="btn btn-lg btn-primary ms-3">Search Artists</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>

		<table class="table mt-5">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Rating</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="song" items="${songs}">
					<tr>
						<td><a href="/songs/${song.id}">${song.titulo}</a></td>
						<td>${song.clasificacion}</td>
						<td class="d-flex">
							<form action="/song/${song.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<button type="submit" class="btn btn-link">Delete</button>
							</form>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>