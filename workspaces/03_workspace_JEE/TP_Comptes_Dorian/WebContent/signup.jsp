<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Sp�cifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
<script type="text/javascript" src="./assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
<title>Sign Up</title>
</head>
<body>
	<div class="page-header">
		<h1 style="text-align: center">Cr�ation de compte</h1>
	</div>

	<div class="container mt-5">
		<h2>Cr�er un compte</h2>
		<form method="post" action="signUp">
			<div class="form-group">
				<label>Identifiant : </label> <input type="text"
					class="form-control" placeholder="Renseignez votre courriel"
					name="pMail" required />
			</div>
			<div class="form-group">
				<label>Mot de passe : </label> <input type="password"
					class="form-control" placeholder="Renseignez votre mode de passe"
					name="pPassword" required />
			</div>
			<div class="form-group">
				<label>Nom : </label> <input type="text" class="form-control"
					placeholder="Votre nom" name="pNom" required />
			</div>
			<div class="form-group">
				<label>Pr�nom : </label> <input type="text" class="form-control"
					placeholder="Votre pr�nom" name="pPrenom" required />
			</div>
			<div class="form-group">
				<label>Adresse : </label> <input type="text" class="form-control"
					placeholder="Votre Adresse" name="pAdresse" required />
			</div>
			<div class="form-group">
				<label>Code postal : </label> <input type="number"
					class="form-control" placeholder="Code postal" name="pCodePostal"
					required />
			</div>
			<div class="form-group">
				<label>Ville : </label> <input type="text" class="form-control"
					placeholder="Ville" name="pVille" required />
			</div>
			<div class="form-group">
				<label>T�l. : </label> <input type="number" class="form-control"
					placeholder="T�l�phone" name="pTelephone" required />
			</div>
			<input class="btn btn-success" type="submit" value="Cr�er un compte" />
		</form>
	</div>

</body>
</html>