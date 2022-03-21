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
			<th>Opérations</th>
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
		<form class="form-horizontal" method="post" action="add">
		<tr>

			<td></td>
			<td>

				<div class="form-group">
					<label for="idSolde" class="col-sm-2 control-label">Solde:
					</label>
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

		</tr>
		</form>
	</table>


	<div class="page-header">
		<h1 style="text-align: center">Vos comptes épargne</h1>
	</div>

	<table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>Solde</th>
			<th>Opérations</th>
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
		<form class="form-horizontal" method="post" action="add">
			<tr>

				<td></td>
				<td>

					<div class="form-group">
						<label for="idSolde" class="col-sm-2 control-label">Solde:
						</label>
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
			</tr>
		</form>
	</table>

</body>
</html>