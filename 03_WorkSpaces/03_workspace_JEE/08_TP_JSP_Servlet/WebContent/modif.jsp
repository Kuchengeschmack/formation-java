<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification page</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
</head>
<body>
	<%@ include file="./template/header.html"%>

	<hr>
	<br>

	<h1 style="color: red; text-align: center;">Formulaire de la
		modification</h1>

	<form class="form-horizontal" method="post" action="update">
		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idId" placeholder="Id"
					name="pId" value="${eModif.id}">
			</div>
		</div>

		<div class="form-group">
			<label for="idNom" class="col-sm-2 control-label">Nom: </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idNom" placeholder="Nom" name="pNom" value="${eModif.nom}">
			</div>
		</div>

		<div class="form-group">
			<label for="idPrenom" class="col-sm-2 control-label">Prénom:
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idPrenom" placeholder="Prenom" name="pPrenom" value="${eModif.prenom}">
			</div>
		</div>

		<div class="form-group">
			<label for="idAge" class="col-sm-2 control-label">Âge: </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idAge" placeholder="Age"	name="pAge" value="${eModif.age}">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Modifier</button>
			</div>
		</div>
	</form>

	<!-- Afficher le message d'erreur s'il existe -->
	<h1 style="color: red; text-align: center;">${msg}</h1>

</body>
</html>