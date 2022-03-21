<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajouter la lib form de Spring MVC -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->
<link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.css"/>' />
<script type="text/javascript" src="/assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>

</head>
<body>
<%@ include file="/template/header.html"%>
	<h1 style="color: blue; text-align: center;">Formulaire d'ajout</h1>

	<form:form class="form-horizontal" method="post" action="submitAdd"
		modelAttribute="eAdd">

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="nom">Nom: </form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" placeholder="Nom: "
					path="nom" />
			</div>
		</div>

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="prenom">Prenom: </form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" placeholder="Prenom: "
					path="prenom" />
			</div>
		</div>

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="dn">Birthday</form:label>
			<div class="col-sm-10">
				<form:input type="date" class="form-control" placeholder="Date: "
					path="dn" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>
	</form:form>

</body>
</html>