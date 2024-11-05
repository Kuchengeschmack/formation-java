<!-- Une directive de type page qui nous permet d'injecter du java à l'intérieur d'une page HTML -->
<%@page import="java.util.Date"%>

<!-- La directive page ave l'attribut sert à importer des classes java -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ma page</title>
</head>
<body>
<%@ include file="./template/header.html" %>

	<!-- I. Les balises de scripting -->
	<!-- 1. Injecter du code java dans la JSP -->
	<h3 style="color: blue">Les scriplets &lt% %&gt</h3>
	<%
		for (int i = 0; i < 10; i++) {
			out.println(i + " ");
		}
	%>
	<hr>
	<h3 style="color: blue">Les expressions &lt% %&gt</h3>
	<!-- 2. Les expressions -->

	<h1>
		<%
			out.println(9 * 5);
		%>
	</h1>
	<br>
	<h1><%=9 * 5%></h1>

	<hr>
	<h3 style="color: blue">Les déclarations &lt%! %&gt</h3>
	<%!String nom = "TOTO";%>
	<%!String prenom = "Titi";%>

	<%!String nomComplet(String pNom, String pPrenom) {
		return pNom + " " + pPrenom;
	}%>

	<%-- Ceci est un commentaire en jsp --%>
	<%-- Utilisation des attributs et des méthodes déjà déclarées --%>
	<h4><%="le nom : " + nom%></h4>
	<h4><%="le nom complet est : " + nomComplet(nom, prenom)%></h4>
	
	<!-- II. Les directives -->
	<%-- 1. Les directives de type page --%>
	<h3 style="color:blue">Les directives &lt%@ page %&gt</h3>
	<%= new Date() %>
	
	<%-- 2. Les directives includes --%>
	<hr>
	<h3 style="color:blue">Les directives &lt%@ include %&gt</h3>
	<%@ include file="./template/footer.html" %>
	
	

</body>
</html>