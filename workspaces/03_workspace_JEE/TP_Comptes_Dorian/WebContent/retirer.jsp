<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retirer</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
<script type="text/javascript" src="./assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="./template/header.html"%>
	<hr>
	<br>

	<form class="form-horizontal" method="post" action="withdraw">

		<div class="form-group">
			<label for="idId" class="col-sm-2 control-label">Id: </label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idId" placeholder="Id"
					name="pId" required>
			</div>
		</div>

		<div class="form-group">
			<label for="idMontant" class="col-sm-2 control-label">Montant:
			</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="idMontant"
					placeholder="Montant" name="pMontant" required>
			</div>
		</div>



		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success" name="pTypeCompte"
					value="<%=request.getParameter("pTypeCompte")%>">Retirer</button>
			</div>
		</div>
	</form>

	<!-- Afficher le message d'erreur s'il existe -->
	<div class="page-header">
		<h1 style="color: red; text-align: center;">${msg}</h1>
	</div>


</body>
</html>