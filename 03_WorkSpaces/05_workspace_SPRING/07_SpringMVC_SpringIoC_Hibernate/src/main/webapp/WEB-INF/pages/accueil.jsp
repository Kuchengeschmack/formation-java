<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>

<!-- Spécifier le chemin du fichier bootstrap.css -->
<!-- ${pageContext.request.contextPath} sera remplacé par /8080/nom du projet... -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
</head>
<body>

	<h1 style="color: blue; text-align: center;">Liste des étudiants</h1>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date de naissance</th>
		</tr>

		<c:forEach var="e" items="${etudiants}">

			<tr>
				<th>${e.id}</th>
				<th>${e.nom}</th>
				<th>${e.prenom}</th>
				<th>${e.dn}</th>
			</tr>

		</c:forEach>

	</table>

</body>
</html>