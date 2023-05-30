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
		<h1 class="text-capitalize">${question.text_question}</h1>
		<!-- 		_______________________________________________________________________________ -->
		<div class="d-flex mt-5 text-capitalize">
			<p class="fs-2 text">Tags :</p>
			<c:forEach var="tag" items="${question.tags }">
				<p class="ms-5 p-2 text-center border border-dark border-3">${tag.subject}</p>
			</c:forEach>
		</div>
		<!-- 		_______________________________________________________________________________ -->
		
		<div class="row">
			<div class="col-5">
				<table class="table table-borderless">
				<thead>
					<tr class="table-dark">
						<th>Answers</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="answer" items="${question.answers}">
					<tr class="table-secondary">
						<td>${answer.text_answer}</td>
					</tr>
					</c:forEach>

				</tbody>
			</table>
			</div>
			
			<div class="col ms-5">
				<h2 class="mb-4">Add your answer:</h2>
				<div class="d-flex">
					<p class="fs-2 me-4">Answer:</p>
					<form action="/newAnswer" method="post">
						<textarea class="form-control custom-textarea" cols="40" name="text_answer"></textarea>
						<div class="d-flex justify-content-end mt-3">
							<input type="hidden" value="${question.id}" name="idQuestion">
							<button class="btn btn-primary d-block">Answer it!</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>