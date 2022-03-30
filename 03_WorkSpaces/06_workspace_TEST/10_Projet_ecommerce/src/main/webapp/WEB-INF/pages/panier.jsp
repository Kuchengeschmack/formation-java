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
<title>Votre Panier</title>

<!-- Specifier le chemin du bootsrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">

</head>
<body>

	<%@ include file="/template/header.html"%>
	<%@ include file="/template/barreNav.html"%>

	<h1 style="color: blue; text-align: center;">Votre panier</h1>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th></th>
				<th>Produit</th>
				<th>Prix unitaire</th>
				<th>Qté</th>
				<th>Prix total</th>
				<th></th>
			</tr>
		</thead>

		<tbody>

			<!-- On parcourt les lignes de commande du panier -->
			<c:forEach var="lc" items="${panier.a}">
				<tr>
					<td><img src="${lc.image}" /></td>
					<td>${lc.produit.designation}</td>
					<td>${lc.prix}</td>
					<td>${lc.quantite}</td>
					<td>${lc.prix * lc.quantite}</td>
					<td class="text-right"><button class="btn btn-sm btn-danger">
							<i class="fa fa-trash"></i>
						</button></td>
				</tr>

			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><strong>Total</strong></td>
				<td><strong></strong></td>
			</tr>
		</tbody>
	</table>

	<button>Revenir aux produits</button>

	<button>Valider la commande</button>

</body>
<%@ include file="/template/footer.html"%>
</html>