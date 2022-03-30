<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Espace Admin Prod</title>

<!-- Specifier le chemin du bootsrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">

</head>
<body>

	<%@ include file="/template/header.html"%>
	<%@ include file="/template/barreNav.html"%>

	<div class="container">

		<div class="panel panel-default">
			<div style="font-size: 24px; color: black;" class="panel-heading">Liste
				des produits</div>
			<div style="background-color: #f8f8f8" class="panel-body">

				<br>
				<table class="table table-hover">
					<tr>
						<th>ID Produit</th>
						<th>Designation</th>
						<th>Description</th>
						<th>Prix</th>
						<th>Photo</th>
						<th>Opérations</th>



					</tr>

					<c:forEach var="prod" items="${produits}">

						<tr>
							<td>${prod.idProduit}</td>
							<td>${prod.designation}</td>
							<td>${prod.description}</td>
							<td>${prod.prix}</td>
							<td> <img src="photoProduit?idProduit=${prod.photo}"
						alt="No image" /> </td>
							<td><a class="btn btn-info"
								href="<c:url value='/adminProd/submitSuppProd?pId=${prod.idProduit }'/>">Supprimer</a>
								<a class="btn btn-info"
								href="<c:url value='/adminProd/updateLink?pId=${prod.idProduit }'/>">Modifier</a>
							</td>

						</tr>

					</c:forEach>

				</table>

				<h2 style="color: black; text-align: center">${msg}</h2>
			</div>

		</div>

		<div style="font-size: 24px; color: black;" class="panel-heading">Formulaire
			d'ajout</div>
		<div style="background-color: #f8f8f8" class="panel-body">

			<br>
			
			<form:form class="form-horizontal" method="post" action="submitAddProd" modelAttribute="pAdd" enctype="multipart/form-data">
	
		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="designation">Designation: </form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" placeholder="Designation " path="designation"/>
			</div>
		</div>
		
		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="description">Description: </form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" placeholder="Description " path="description"/>
			</div>
		</div>
		
		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="prix">Prix </form:label>
			<div class="col-sm-10">
				<form:input type="number" class="form-control" placeholder="Prix " path="prix"/>
			</div>
		</div>
		
		<div class="form-group">
			<label for="Photo" class="col-sm-2 control-label">Image</label>
			<div class="col-sm-4">
				<input type="file" class="form-control" id="Photo"
					name="picture" />
			</div>
		</div>
		
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>
		
	</form:form>
			
			
			
			<h2 style="color: black; text-align: center">${msg}</h2>
		</div>

	</div>

<br>	<div style="font-size: 24px; color: black;" class="panel-heading">Rechercher produit</div>
		<div style="background-color: #f8f8f8" class="panel-body">
			
			<form:form class="form-horizontal" method="post" action="submitRechercheProd" modelAttribute="pSearch" enctype="multipart/form-data">
	
		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="id">Id </form:label>
			<div class="col-sm-10">
				<form:input type="number" class="form-control" placeholder="Id " path="id"/>
			</div>
		</div>
		

		
		
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>
		
	</form:form>
			
			
			
			<h2 style="color: black; text-align: center">${msg}</h2>
		</div>






	


</body>
<%@ include file="/template/footer.html"%>
</html>