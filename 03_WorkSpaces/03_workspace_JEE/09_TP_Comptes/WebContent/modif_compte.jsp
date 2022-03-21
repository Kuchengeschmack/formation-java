<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification</title>
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
		<h1 style="text-align: center;">Formulaire de la modification</h1>
	</div>

	<form class="form-horizontal" method="post" action="update">
		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idId" placeholder="Id"
					name="pId" value="${compteModif.id}" required>
			</div>
		</div>

		<div class="form-group">
			<label for="idSolde" class="col-sm-2 control-label">Solde: </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idSolde"
					placeholder="Solde" name="pSolde" value="${compteModif.solde}"
					required>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary" name="pTypeCompte"
					value="<%= request.getParameter("pTypeCompte") %>">Modifier</button>
			</div>
		</div>
	</form>

	<!-- Afficher le message d'erreur s'il existe -->
	<div class="page-header">
		<h1 style="color: red; text-align: center;">${msg}</h1>
	</div>

</body>
</html>