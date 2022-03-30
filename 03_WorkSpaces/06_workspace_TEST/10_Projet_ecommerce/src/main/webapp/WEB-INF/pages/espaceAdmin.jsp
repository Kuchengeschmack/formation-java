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
<title>Espace Admin</title>

<!-- Specifier le chemin du bootsrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">

</head>
<%@ include file="/template/header.html"%>
<%@ include file="/template/barreNav.html"%>
<body>

	<div class="container">
		<br>

		<h1 style="color: black; text-align: center;">A quel espace
			voulez-vous accéder ?</h1>
			
			<br>

		<div style="text-align: center; font-family: sans-serif;" class="admin">
			<p>
				<a style="font-size: 20px; font-family: sans-serif;"
					href="adminCategorie.jsp"><i>Espace Admin Catégorie</i> </a>
			</p>
			<p>
				<a class="admin" style="font-size: 20px;"
					href="<c:url value='/adminProd/DisplayAdminProd'/>"><i>Espace
						Admin Produit</i> </a>
			</p>
		</div>






	</div>




</body>
<%@ include file="/template/footer.html"%>
</html>