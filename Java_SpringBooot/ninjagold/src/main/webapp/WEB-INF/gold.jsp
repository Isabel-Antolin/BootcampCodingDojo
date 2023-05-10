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
	<div class="container mt-5 text-white">
		<div class="d-flex justify-content-between mb-5">
			<h2 class="">
				Your Gold: <span class="py-1 px-4 border border-dark bg-secondary"><c:out
						value="${gold}"></c:out></span>
			</h2>
			<a class="btn btn-primary" href="/reset">Reset</a>
		</div>



		<div class="row mb-5">
			<div
				class="col border border-dark rounded  mx-2 pt-3 pb-3 text-center">
				<h3 class="text-center">Farm</h3>
				<p>(earns 10-20 gold)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="location" value="farm">
					<div class="d-flex justify-content-center">
						<button  class="btn btn-success" type="submit">Find Gold!</button>
					</div>
				</form>
			</div>

			<div class="col border border-dark rounded mx-2 pt-3 text-center">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="location" value="cave">
					<div class="d-flex justify-content-center">
						<button class="btn btn-success" type="submit">Find Gold!</button>
					</div>
				</form>
			</div>

			<div class="col border border-dark rounded mx-2 pt-3 text-center">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="location" value="house">
					<div class="d-flex justify-content-center">
						<button class="btn btn-success" type="submit">Find Gold!</button>
					</div>
				</form>
			</div>

			<div class="col border border-dark rounded mx-2 pt-3 text-center">
				<h3>Casino!</h3>
				<p>(earns/takes 0-50 gold)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="location" value="casino">
					<div class="d-flex justify-content-center">
						<button class="btn btn-success" type="submit">Find Gold!</button>
					</div>
				</form>
			</div>

			<div class="col border border-dark rounded mx-2 pt-3 text-center">
				<h3>Spa</h3>
				<p>(takes 5-20 gold)</p>
				<form action="/process_money" method="post">
					<input type="hidden" name="location" value="spa">
					<div class="d-flex justify-content-center">
						<button class="btn btn-success" type="submit">Find Gold!</button>
					</div>
				</form>
			</div>
		</div>
		<!-- 		fin del row -->
		<h3>Activities:</h3>
		<div class="containerActivities  border border-dark rounded px-4 mt-4 h-25 overflow-auto">
			<c:forEach var="actividad" items="${actividades}">
				<c:choose>
					<c:when test="${actividad.contains('lost')}">
						<p class="text-danger m-0">${actividad}</p>
					</c:when>
					<c:otherwise>
						<p class="m-0">${actividad}</p>
					</c:otherwise>
				</c:choose>

			</c:forEach>

		</div>
	</div>
</body>
</html>