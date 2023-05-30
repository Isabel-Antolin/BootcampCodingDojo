<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>  --%>
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
		<h1 class="text-center mt-5">Bienvenido</h1>
		<div class="row mt-5">
			<div class="col-4 offset-1 ">
				<h2>Register!</h2>
				<form:form method="POST" action="/registration" modelAttribute="user"> 
					<div><form:errors path="user.*" class="text-danger" /> </div>
					<div> 
					    <div><form:errors path="nombre" class="text-danger" /> </div> 
						<form:label path="nombre">Nombre:</form:label> 
						<form:input class="form-control" type="text" path="nombre" />
					</div> 
					<div> 
						<div><form:errors path="apellido" class="text-danger" /> </div> 
						<form:label path="apellido">Apellido:</form:label> 
						<form:input class="form-control" type="text" path="apellido" /> 
					</div> 
					<div> 
						<div><form:errors path="email" class="text-danger" /> </div> 
						<form:label path="email">Email:</form:label> 
						<form:input class="form-control" type="email" path="email" /> 
					</div> 

					<div class="row"> 
						<div class="col-6"> 
							<div><form:errors path="ciudad" class="text-danger" /> </div> 
							<form:label path="ciudad">Ciudad:</form:label> 
							<form:input class="form-control" type="text" path="ciudad" /> 
						</div> 
						<div class="col-6"> 
							<form:label path="estado">Estado:</form:label> 
							<form:select class="form-control" type="text" path="estado"> 
								<c:forEach items="${estados}" var="estado"> 
									<form:option value="${estado}"> 
									</form:option> 
								</c:forEach> 
							</form:select> 
						</div> 
					</div> 

					<div> 
					    <div><form:errors path="password" class="text-danger" /> </div> 
						<form:label path="password">Password:</form:label> 
						<form:password path="password" class="form-control" /> 
					</div> 
					<div> 
						<div><form:errors path="passwordConfirmation" class="text-danger" /> </div> 
						<form:label path="passwordConfirmation">Password Confirmation:</form:label> 
						<form:password path="passwordConfirmation" class="form-control" /> 
					</div> 
					<button type="submit" class="btn btn-success mt-4">Register!!</button> 
				</form:form> 
				<p class="text-danger mt-2"> 
					<c:out value="${succesRegister}" /> 
				</p> 
			</div> 


			<div class="col-4 offset-2"> 
				<h2>Login</h2> 
				<div> 
					<form:errors path="login.*" class="text-danger" /> 
				</div> 
				<form:form method="POST" action="/login" modelAttribute="login"> 
					<div> 
						<form:label path="email">Email:</form:label> 
						<form:input type="email" path="email" class="form-control" /> 
					</div> 
					<div> 
						<form:label path="password">Password:</form:label> 
						<form:password path="password" class="form-control" /> 
					</div> 
					<button type="submit" class="btn btn-success mt-4">Login!!</button> 
				</form:form> 

			</div>
		</div>
	</div>

</body>
</html>