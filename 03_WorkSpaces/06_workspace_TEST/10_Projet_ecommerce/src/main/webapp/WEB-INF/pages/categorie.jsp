<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Ajouter la lib form de Spring MVC pour le traitement des formulaires -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Le titre de la page est la désignation (= le nom) du produit -->
<title>${categorie.nom}</title>

<!-- Specifier le chemin du bootsrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">

</head>
<body>

	<%@ include file="/template/header.html"%>
	<%@ include file="/template/barreNav.html"%>

	<div id="formProduit" class="bordure1">
		<form:form modelAttribute="categorie" action="" method="post"
			enctype="multipart/form-data">
			<table>
				
				<tr>
					<td>Nom</td>
					<td></td>
				</tr>

				<tr>
					<td>Description</td>
					<td><p></p></td>
				</tr>
				
                  <tr>
					<td>Photo</td>
					<td>
					<img src="photoProd?idCategorie=${produit.idProduit}" />
					</td>
				</tr>

				</table>
				</form:form>
				</div>		
</body>
<%@ include file="/template/footer.html"%>
</html>