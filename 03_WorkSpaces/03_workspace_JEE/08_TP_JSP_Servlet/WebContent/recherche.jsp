<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de JSTL (Java Standard Tag Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recherche page</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
</head>
<body>
	<%@ include file="./template/header.html"%>
	<hr>
	<br>

	<h1 style="color: red; text-align: center;">Formulaire de la
		recherche</h1>

	<form class="form-horizontal" method="get" action="search">
		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idId" placeholder="Id"
					name="pId">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-info">Rechercher</button>
			</div>
		</div>
	</form>

	<h1 style="color: red; text-align: center">L'étudiant trouvé :</h1>

	<c:if test="${not empty etudiant}">

		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Âge</th>
			</tr>

			<tr>
				<td>${etudiant.id}</td>
				<td>${etudiant.nom}</td>
				<td>${etudiant.prenom}</td>
				<td>${etudiant.age}</td>
			</tr>
		</table>
		
		</c:if>

		<!-- Afficher le message d'erreur s'il existe -->
		<h1 style="color: red; text-align: center;">${msg}</h1>
</body>
</html>