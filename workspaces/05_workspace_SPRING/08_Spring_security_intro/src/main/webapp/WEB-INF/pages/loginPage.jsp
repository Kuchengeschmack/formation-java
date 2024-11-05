<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<h1>Formulaire de login</h1>

	<form method="post" action="connexion">
		<label>Login: </label> <input type="text" name="j_username" /> <br />
		<label>Password: </label> <input type="text" name="j_password" /> <br />
		<input type="submit" value="Se connecter" />

	</form>

	<h1 style="color: red; text-align: center;">${msg}</h1>

</body>
</html>