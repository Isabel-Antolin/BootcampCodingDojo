<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Books</title>
</head>
<body>
	<div class="container mt-5">
		<h1>All Books</h1>
		<p><c:out value="${error}"></c:out></p>
		<table class="table table-hover">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Title</th>
		            <th>Description</th>
		            <th>Language</th>
		            <th>Number of Pages</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="libro" items="${libros}">
		        <tr onclick="redirectTo('/books/${libro.id}')">
		        	<td><c:out value="${libro.id}"/></td>
		            <td><c:out value="${libro.title}"/></td>
		            <td><c:out value="${libro.description}"/></td>
		            <td><c:out value="${libro.language}"/></td>
		            <td><c:out value="${libro.numberOfPages}"/></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	    <a href="/books/newBook">New Book</a>
	</div>
	
	<script>
	function redirectTo(url) {
        window.location.href = url;
    }
	</script>
</body>
</html>