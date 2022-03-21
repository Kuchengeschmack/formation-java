<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajouter la lib form de Spring MVC -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
x="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supprimer</title>
<!-- Spécifier le chemin du fichier bootstrap.css -->

<link rel="stylesheet" href='<c:url value="/assets/css/bootstrap.css"/>' />
</head>
<body>

	<h1 style="color: blue; text-align: center;">Formulaire de la
		suppression</h1>

	<form:form class="form-horizontal" method="post" action="submitDelete"
		modelAttribute="eDelete">

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="id">Id: </form:label>
			<div class="col-sm-10">
				<form:input type="number" class="form-control" placeholder="Id: "
					path="id" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-danger">Supprimer</button>
			</div>
		</div>
	</form:form>

</body>
</html>