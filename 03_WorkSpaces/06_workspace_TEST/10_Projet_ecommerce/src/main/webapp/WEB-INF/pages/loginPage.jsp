<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajouter la lib form de Spring MVC pour le traitement des formulaires -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<!-- Specifier le chemin du bootsrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<%@ include file="/template/header.html"%>
<%@ include file="/template/barreNav.html"%>
<body>

	<div class="container">
	<div style="margin-top: 100px" class="panel panel-default">
			
			<div style="background-color: #f8f8f8" class="panel-body">
	
		<h1 style="color: black; text-align: center;">Veuillez vous
			identifier</h1>
		<br />
		<form class="form-horizontal" method="post" action="connexion">
			<div class="form-group">

				<label class="col-sm-2 control-label">Login: </label>
				<div class="col-sm-10">
					<input type="text" name="j_username" class="form-control" />
				</div>
			</div>

			<div class="form-group">

				<label class="col-sm-2 control-label">Mot de Passe: </label>
				<div class="col-sm-10">
					<input type="text" name="j_password" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<div  class="col-sm-offset-2 col-sm-10">

					<input style="color: black; background-color: #E98311 !important" role="button" class="btn btn-warning" type="submit" value="Se connecter" />
				</div>
			</div>
			
			<br /> 
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
		<a style="color:black;" href="<c:url value='/displayAddClient'/>">Inscrivez vous si vous n'avez pas encore de compte</a>
		<br />
		<br /> 
		
		
		</div>
		</div>
		</form>
		

		<h1 style="color: red; text-align: center;">${msg}</h1>
		
		</div>
		</div>

	</div>



</body>
<%@ include file="/template/footer.html"%>
</html>