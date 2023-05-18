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
		<div>
			<a href="persons/new">New Person</a> | <a href="licenses/new">New
				License</a>

			<table class="table table-hover mt-5">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Licencia #</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${persona}" var="p">
						<tr>
							<td><a href="/persons/${p.id}">${ p.nombre }${ p.apellido }</a></td>
							<td>${ p.getLicense().numero }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>