<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de JSTL (Java Standard Tag Library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'accueil</title>

<!-- Sp�cifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
<script type="text/javascript" src="./assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="./template/header.html"%>

	<div class="page-header">
		<h1 style="text-align: center">Vos comptes courants</h1>
	</div>


	<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>Solde</th>
			<th>Op�rations</th>
		</tr>

		<c:forEach var="c" items="${comptesCourant}">
			<tr>
				<td>${c.id}</td>
				<td>${c.solde}</td>
				<td><a class="btn btn-danger"
					href="delete?pId=${c.id}&pSolde=${c.solde}&pTypeCompte=compteCourant">Supprimer</a>
					| <a class="btn btn-info"
					href="update?pId=${c.id}&pSolde=${c.solde}&pTypeCompte=compteCourant">Modifier</a></td>
			</tr>
		</c:forEach>

		<tr>
			<form class="form-horizontal" method="post" action="add">
			<td></td>
			<td>
				<div class="form-group">
					<div class="col-sm-10">
						<input type="number" class="form-control" id="idSolde"
							placeholder="Solde" name="pSolde" required>
					</div>
				</div>
			</td>
			<td>
				<button type="submit" class="btn btn-success" name="pTypeCompte"
					value="compteCourant">Ajouter</button>
			</td>
			</form>
		</tr>

	</table>


	<div class="page-header">
		<h1 style="text-align: center">Vos comptes �pargne</h1>
	</div>

	<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>Solde</th>
			<th>Op�rations</th>
		</tr>

		<c:forEach var="c" items="${comptesEpargne}">
			<tr>
				<td>${c.id}</td>
				<td>${c.solde}</td>
				<td><a class="btn btn-danger"
					href="delete?pId=${c.id}&pSolde=${c.solde}&pTypeCompte=compteEpargne">Supprimer</a>
					| <a class="btn btn-info"
					href="update?pId=${c.id}&pSolde=${c.solde}&pTypeCompte=compteEpargne">Modifier</a></td>
			</tr>
		</c:forEach>

		<tr>
			<form class="form-horizontal" method="post" action="add">
			<td></td>
			<td>

				<div class="form-group">
					<div class="col-sm-10">
						<input type="number" class="form-control" id="idSolde"
							placeholder="Solde" name="pSolde" required>
					</div>
				</div>
			</td>
			<td>
				<button type="submit" class="btn btn-success" name="pTypeCompte"
					value="compteEpargne">Ajouter</button>
			</td>
			</form>
		</tr>

	</table>

	<div class="page-header">
		<h1 style="text-align: center">Vos b�n�ficiaires</h1>
	</div>

	<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Pr�nom</th>
			<th>Adresse</th>
			<th>Code postal</th>
			<th>Ville</th>
			<th>Telephone</th>
		</tr>

		<c:forEach var="c" items="${clients}">
			<tr>
				<td>${c.id}</td>
				<td>${c.nom}</td>
				<td>${c.prenom}</td>
				<td>${c.adresse}</td>
				<td>${c.codePostal}</td>
				<td>${c.ville}</td>
				<td>${c.telephone}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>