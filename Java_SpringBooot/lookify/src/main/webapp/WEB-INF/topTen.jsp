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
		<div class="d-flex justify-content-between">
			<p>Top Ten Songs</p>
			<a class="text-end d-block" href="/dashboard">Dashboard</a>
		</div>
		
		<div class="border border-dark p-5 mt-3 w-50">
			<c:forEach var="song" items="${topTen}">
				<div class="d-flex">
					<p><c:out value="${song.clasificacion} -"></c:out></p>
				 	<a href="/songs/${song.id}">${song.titulo}</a>
				 	<p> <c:out value="- ${song.artista}"></c:out></p>
				</div>
				
			</c:forEach>
			
		</div>
	</div>
</body>
</html>