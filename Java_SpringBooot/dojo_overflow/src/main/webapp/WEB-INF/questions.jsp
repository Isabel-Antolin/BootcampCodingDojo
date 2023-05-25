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
		<h1>Questions Dashboard</h1>
		<!-- 		_______________________________________________________________________ -->
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Question</th>
					<th scope="col" class="text-center">Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pregunta" items="${listaPreguntas}">
					<tr>
						<td><a href="/questions/${pregunta.id}">${pregunta.text_question}</a></td>
						<td>
							<c:forEach var="tag" items="${pregunta.tags}">
								<span class="btn btn-warning">${tag.subject}</span>
							</c:forEach>
						
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 		_______________________________________________________________________ -->
		<div class="mt-3 text-end">
			<a href="/questions/new" class="btn btn-success">New Question</a>
		</div>
	</div>
</body>
</html>