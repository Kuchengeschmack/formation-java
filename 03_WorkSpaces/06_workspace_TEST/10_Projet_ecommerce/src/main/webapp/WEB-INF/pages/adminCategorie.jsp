<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Espace Categorie</title>

<!-- Specifier le chemin du bootsrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">

</head>
<body>
	<%@ include file="/template/header.html"%>
	<%@ include file="/template/barreNav.html"%>
	<div>
		<!--afficher les exceptions -->
		${exception}
	</div>
	<div id="formCat">
		<form:form modelAttribute="categorie" action="" method="post"
			enctype="multipart/form-data">

			<table>
				<tr>
					<td>ID Categorie</td>
					<td><form:input path="idCategorie" /></td>
				</tr>

				<tr>
					<td>Nom Categorie</td>
					<td><form:input path="nomCatagorie" /></td>
				</tr>

				<tr>
					<td>Description</td>
					<td><form:textarea path="Description" /></td>
				</tr>

				<tr>
					<td>Photo</td>
					<td><input type="file" name="file" /></td>
				</tr>

				<tr>
					<td>Boutton</td>
					<td><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div id="">
		<table>
			<tr>
				<th>ID</th>
				<th>Nom Categorie</th>
				<th>Description</th>
				<th>Photo</th>
			</tr>
			<c:forEach items="${categorie}" var="categorie">
				<tr>
					<td>${categorie.idCategorie }</td>
					<td>${categorie.nomCategorie }</td>
					<td>${categorie.Description }</td>
					<td><img src="photoCategorie?idCategorie=${categorie.image}"
						alt="No image" /></td>
				</tr>
			</c:forEach>
		</table>


		<h2 style="color: black; text-align: center">${msg}</h2>
	</div>

	<div style="font-size: 24px; color: black;" class="panel-heading">Formulaire
		d'ajout</div>
	<div style="background-color: #f8f8f8" class="panel-body">

		<br>

		<form:form class="form-horizontal" method="post" action="submitAddCat"
			modelAttribute="cAdd" enctype="multipart/form-data">

			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="description">Description: </form:label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control"
						placeholder="Description " path="description" />
				</div>
			</div>

			<div class="form-group">
				<label for="Photo" class="col-sm-2 control-label">Image</label>
				<div class="col-sm-4">
					<input type="file" class="form-control" id="Photo" name="picture" />
				</div>
			</div>

		</form:form>

		<h2 style="color: black; text-align: center">${msg}</h2>
	</div>

	<br>
	<div style="font-size: 24px; color: black;" class="panel-heading">Rechercher
		Categorie</div>
	<div style="background-color: #f8f8f8" class="panel-body">

		<form:form class="form-horizontal" method="post"
			action="submitRechercheCat" modelAttribute="cSearch"
			enctype="multipart/form-data">

			<div class="form-group">
				<form:label class="col-sm-2 control-label" path="id">Idcat </form:label>
				<div class="col-sm-10">
					<form:input type="number" class="form-control" placeholder="Id "
						path="id" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>
			</div>

		</form:form>

	</div>

</body>