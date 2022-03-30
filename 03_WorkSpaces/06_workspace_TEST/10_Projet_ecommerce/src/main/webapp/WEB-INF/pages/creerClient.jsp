<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>

<h1 style="color: red; text-align: center">Formulaire de creation de client</h1>

	<form:form class="form-horizontal" method="post" action="submitAddClient"
		modelAttribute="client/submitAddClient">

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="nom">Nom : </form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" placeholder="Nom : "
					path="nom" />
			</div>
		</div>

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="adresse">Adresse : </form:label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" placeholder="Prenom : "
					path="prenom" />
			</div>
		</div>

		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="dn">Email : </form:label>
			<div class="col-sm-10">
				<form:input type="date" class="form-control" placeholder="Date : "
					path="dn" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="Telephone">Telephone : </form:label>
			<div class="col-sm-10">
				<form:input type="date" class="form-control" placeholder="Telephone : "
					path="dn" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</div>
	</form:form>

	<h1 style="color: red; text-align: center">${msg}</h1>

</body>
</html>