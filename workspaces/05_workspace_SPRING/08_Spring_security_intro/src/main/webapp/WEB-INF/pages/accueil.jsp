<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!-- Ajouter la lib core de jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>

	<h1 style="color: red; text-align: center;">${msg}</h1>

	<a href="<c:url value='/public/client'/>"> Espace Client </a>

	<br />

	<a href="<c:url value='/admin/magasin'/>"> Espace Admin </a>

</body>
</html>