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
		<table class="table mt-5">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Creator</th>
					<th scope="col">Version</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="language" items="${languages}">
					<tr>
						<td><a href="/languages/${language.id}">${language.name}</a></td>
						<td>${language.creator}</td>
						<td>${language.currentVersion}</td>
						<td class="d-flex">
							<form action="/languages/${language.id}" method="post">
					            <input type="hidden" name="_method" value="delete">
					            <button type="submit" class="btn btn-link">Delete</button>
					            <a href="languages/${language.id}/edit" class="btn btn-link">Edit</a>
				            </form>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form:form action="/languages" method="post" modelAttribute="language"
			class="mt-5 p-3">
			<div class="mb-3">
				<div>
					<form:errors path="name"/>
				</div>
				<div class="d-flex justify-content-between">
					<form:label for="name" class="" path="name">Name</form:label>
					<form:input type="text" class="w-50" path="name" />
				</div>
			</div>
			<div class="mb-3">
				<div>
					<form:errors path="creator"/>
				</div>
				<div class="d-flex justify-content-between">
					<form:label for="creator" class="" path="creator">Creator</form:label>
					<form:input type="text" class="w-50" path="creator" />
				</div>
			</div>
			<div class="mb-3">
				<div>
					<form:errors path="currentVersion"/>
				</div>
				<div class="d-flex justify-content-between">
					<form:label for="currentVersion" class="" path="currentVersion">Version</form:label>
					<form:input type="text" class="w-50" path="currentVersion" />
				</div>
			</div>

			<div class="mb'3 d-flex justify-content-end">
				<button type="submit" class="btn btn-lg btn-primary w-25">Submit</button>
			</div>
		</form:form>

	</div>
</body>
</html>