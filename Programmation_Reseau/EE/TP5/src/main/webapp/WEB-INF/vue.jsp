<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Styles/style.css">
<meta charset="ISO-8859-1">
<title>TP TEST</title>
</head>
<body>
	<h1>Ceci est un titre H1</h1>
	
	<!-- Formulaire qui enverra une requête POST à l'URL actuelle -->
	<form method="post">
	  	<label for="name">Enter your name: </label>
		<input type="text" name="name" id="name" required>
		 <fieldset>
		   	<legend>Titre</legend>
		  	<label><input type="radio" name="moi1">Sélectionnez-moi1</label></br>
		  	<label><input type="radio" name="moi2">Sélectionnez-moi2</label></br>
		  	<label><input type="radio" name="moi3">Sélectionnez-moi33</label></br>
		  	<button>Sauvegarder</button>
		 </fieldset>
	</form>
	<c:set var = "name" scope = "session" value = "${param.name}"/>

	<p> You are : <c:out value = "${name}" /> </p>
	
</body>
</html>