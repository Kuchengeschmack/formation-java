<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib form de Spring MVC pour le traitement des formulaires -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page formulaire</title>
</head>
<body>

	<h1 style="color: red; text-align: center;">Formulaire</h1>

	<form:form action="soumettre" method="post" modelAttribute="eleve">

		<form:label path="nom">Nom : </form:label>
		<form:input type="text" path="nom" />

		<br />

		<form:label path="prenom">Prénom : </form:label>
		<form:input type="text" path="prenom" />

		<br />

		<form:label path="age">Âge : </form:label>
		<form:input type="number" path="age" />

		<br />

		<!-- Mettre le input à l'intérieur du form -->
		<input type="submit" value="Envoyer">

	</form:form>




</body>
</html>