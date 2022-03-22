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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
<script type="text/javascript" src="/assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="/template/header.html"%>
	<h1 style="color: blue; text-align: center;">Liste des étudiants</h1>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date de naissance</th>
			<th>Opérations</th>
		</tr>

		<c:forEach var="e" items="${etudiants}">

			<tr>
				<th>${e.id}</th>
				<th>${e.nom}</th>
				<th>${e.prenom}</th>
				<th>${e.dn}</th>
				<th>
				<a class="btn btn-danger" href="<c:url value='/etudiant/submitDelete?pId=${e.id}'/>">Supprimer</a>
				<a class="btn btn-primary" href="<c:url value='/etudiant/updateLink?pId=${e.id}'/>">Modifier</a>
				</th>
			</tr>

		</c:forEach>

	</table>

</body>
</html>