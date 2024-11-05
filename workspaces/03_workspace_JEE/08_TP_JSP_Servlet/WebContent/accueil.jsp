<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de JSTL (Java Standard Tag Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'accueil</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
</head>
<body>
	<%@ include file="./template/header.html"%>
	<h1 style="color: red; text-align: center">Liste des étudiants</h1>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Âge</th>
			<th>Opérations</th>
		</tr>

		<c:forEach var="e" items="${etudiants}">
			<tr>
				<td>${e.id}</td>
				<td>${e.nom}</td>
				<td>${e.prenom}</td>
				<td>${e.age}</td>
				<td><a class="btn btn-danger" href="delete?pId=${e.id}">Supprimer</a> | <a class="btn btn-info" href="update?pId=${e.id}">Modifier</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>