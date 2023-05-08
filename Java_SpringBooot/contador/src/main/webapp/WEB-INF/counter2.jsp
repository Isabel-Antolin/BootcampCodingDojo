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
<title>Insert title here</title>
</head>
<body>
	<div class="conteinerCounter">
		<h3>
			You have visited <a href="*">http://your_server</a>
			<c:out value="${count}" />
			times
		</h3>
		<a href="/your_server">Test another visit?</a>
		<form method="post" action="/your_server/reset" accept-charset="UTF-8">
			<button type="submit" name="reset">Reset</button>
		</form>

	</div>
</body>
</html>