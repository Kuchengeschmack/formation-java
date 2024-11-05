<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href="./assets/css/bootstrap.css" />
</head>
<body>
	<form method="post" action="auth">
		<label>Identifiant : </label> <input type="text" name="pMail" /> <br>
		<label>Mot de passe : </label> <input type="password" name="pPassword" />
		<br> <input type="submit" value="Se connecter" />

	</form>

	<!-- L'expression langage de JSP -->
	<!-- Afficher le message d'erreur s'il existe -->
	<h1 style="color: red; text-align: center;">${msg}</h1>

</body>
</html>