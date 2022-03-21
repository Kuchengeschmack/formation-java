<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
<script type="text/javascript" src="./assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="page-header">
		<h1 style="text-align: center">Écran de connexion</h1>
	</div>


	<div class="container mt-5">
		<h2>Se connecter</h2>
		<form method="post" action="auth">
			<div class="form-group">
				<label for="pMail"> Courriel : </label> <input type="email"
					class="form-control" placeholder="Renseignez votre courriel"
					name="pMail" required />
			</div>
			<div class="form-group">

				<label for="pPassword"> Mot de passe : </label> <input
					type="password" class="form-control"
					placeholder="Renseignez votre mode de passe" name="pPassword"
					required />
			</div>
			<input class="btn btn-success" type="submit" value="Se connecter" />
		</form>
	</div>

	<div class="container mt-5">
		<h2>Je n'ai pas de compte</h2>
		<form method="post" action="signup.jsp">
			<input class="btn btn-success" type="submit"
				value="Je créé un compte" />
		</form>
	</div>

	<!-- L'expression langage de JSP -->
	<!-- Afficher le message d'erreur s'il existe -->
	<div class="page-header">
		<h1 style="color: red; text-align: center;">${msg}</h1>
	</div>

</body>
</html>