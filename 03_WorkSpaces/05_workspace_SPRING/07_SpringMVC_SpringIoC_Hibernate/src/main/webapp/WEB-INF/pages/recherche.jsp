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
<title>Rechercher</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->

<link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.css"/>' />
<script type="text/javascript" src="/assets/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/template/header.html"%>

	<h1 style="color: blue; text-align: center;">Formulaire de la
		recherche</h1>

	<form:form class="form-horizontal" method="post" action="submitSearch"
		modelAttribute="eSearch">

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="id">Id: </form:label>
			<div class="col-sm-10">
				<form:input type="number" class="form-control" placeholder="Id: "
					path="id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-info">Rechercher</button>
			</div>
		</div>
	</form:form>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Date de naissance</th>
		</tr>


		<tr>
			<th>${etudiant.id}</th>
			<th>${etudiant.nom}</th>
			<th>${etudiant.prenom}</th>
			<th>${etudiant.dn}</th>
		</tr>


	</table>

</body>
</html>