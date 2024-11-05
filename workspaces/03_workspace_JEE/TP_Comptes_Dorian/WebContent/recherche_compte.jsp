<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de JSTL (Java Standard Tag Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recherche</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
<script type="text/javascript" src="./assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="./template/header.html"%>
	<hr>
	<br>

	<div class="page-header">
		<h1 style="text-align: center;">Formulaire de la recherche</h1>
	</div>

	<form class="form-horizontal" method="get" action="search">
		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idId" placeholder="Id"
					name="pId" required>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-info" name="pTypeCompte"
					value="<%= request.getParameter("pTypeCompte") %>">Rechercher</button>
			</div>
		</div>
	</form>

	<div class="page-header">
		<h1 style="text-align: center">Le compte trouvé :</h1>
	</div>

	<c:if test="${not empty compte}">

		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Solde</th>
			</tr>

			<tr>
				<td>${compte.id}</td>
				<td>${compte.solde}</td>
			</tr>
		</table>

	</c:if>

	<!-- Afficher le message d'erreur s'il existe -->
	<div class="page-header">
		<h1 style="color: red; text-align: center;">${msg}</h1>
	</div>
</body>
</html>