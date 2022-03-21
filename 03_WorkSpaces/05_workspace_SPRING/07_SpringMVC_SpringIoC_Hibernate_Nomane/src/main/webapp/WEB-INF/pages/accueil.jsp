<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la libs core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

	<h1 style="color: red; text-align: center;">Liste des etudiants</h1>

	<table>
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date</th>
		</tr>

		<c:forEach var="e" items="${etudiants}">
			<tr>
				<td>${e.id}</td>
				<td>${e.nom}</td>
				<td>${e.prenom}</td>
				<td>${e.dn}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>