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
<title>Accueil</title>

<!-- Specifier le chemin du bootsrap -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">
</head>
<%@ include file="/template/header.html"%>
<%@ include file="/template/barreNav.html"%>
<body>

	<div id="accueil">

		<div id="pres">


			<div id="pres2">
				<div id="pres3">
					<h1 style="margin-bottom: 0px; font-size: 42px;">CHOUQUETTE
						BOULANGERIE</h1>
					<p>
						<span id="sousTitre"> <i>à Rennes</i>
						</span>
					</p>
				</div>


				<div id="photoB">
					<img style="width: 440px; height: 400px;"
						src="./assets/images/9.jpg" class="img-responsive"
						alt="Responsive image">
				</div>
				<div id="text">

					<p>
						<b>Installé à Rennes depuis 50 ans la Chouquette Boulangerie a
							révolutionné le monde de la boulangerie. </br> Avec ses pains
							délicieux et ses chouquettes élues meilleure chouquettes de
							France en 2021, </br> la Chouqette Boulangerie ravie petit et grand.
						</b>
					</p>

					<p>N'hésitez pas à venir nous faire un coucou rue de la
						gourmandise à Rennes pour satisfaire votre faim.</p>

				</div>



			</div>


		</div>

		<div id="presBoula">




			<div id="photoC">
				<img style="width: 500px; height: 400px;"
					src="./assets/images/images.jpg" class="img-responsive"
					alt="Responsive image">
			</div>

			<div id="pres4">

				<div id="pres5">
					<h1 style="margin-bottom: 0px; font-size: 42px;">NOS PAINS</h1>
					<p>
						<span id="sousTitre"> <i>Pains 100% Maison</i>
						</span>
					</p>
				</div>


				<div id="text1">

					<p>
						<b>Tous les pains de Chouquette Boulangerie sont 100% fait
							maison, </br> travaillés quotidiennement par nos boulangers.


						</b>
					</p>

					<p>Notre boulangerie est certifiée Bio agréments n°FRAB02</p>

					<div id="bouton">
						<p>

							<a style ="font-size: 17px;color: black; background-color:#E98311 !important"class="btn btn-warning" role="button" href="#" title="Pains">Notre
								Selection De Pains</a>
						</p>
					</div>


				</div>


			</div>

		</div>

		<div id="presPat">

			<div id="pres6">
				<div id="pres7">
					<h1 style="margin-bottom: 0px; font-size: 42px;">NOS PATISSERIE</h1>
					<p>
						<span id="sousTitre"> <i>Les Meilleures Du Monde</i>
						</span>
					</p>
				</div>

				


			</div>
			

		</div>

		




	</div>











</body>
<%@ include file="/template/footer.html"%>
</html>