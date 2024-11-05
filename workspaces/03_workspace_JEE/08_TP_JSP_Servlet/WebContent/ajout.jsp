<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout page</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
</head>
<body>
	<%@ include file="./template/header.html"%>
	<hr>
	<br>

	<form class="form-horizontal" method="post" action="add">
		<div class="form-group">
			<label for="idNom" class="col-sm-2 control-label">Nom: </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idNom" placeholder="Nom"
					name="pNom">
			</div>
		</div>

		<div class="form-group">
			<label for="idPrenom" class="col-sm-2 control-label">Prénom:
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="idPrenom"
					placeholder="Prenom" name="pPrenom">
			</div>
		</div>

		<div class="form-group">
			<label for="idAge" class="col-sm-2 control-label">Âge: </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idAge" placeholder="Age"
					name="pAge">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Ajouter</button>
			</div>
		</div>
	</form>

	<!-- Afficher le message d'erreur s'il existe -->
	<h1 style="color: red; text-align: center;">${msg}</h1>


</body>
</html>