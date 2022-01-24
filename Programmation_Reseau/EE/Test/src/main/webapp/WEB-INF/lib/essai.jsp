<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Styles/css.css">
<meta charset="ISO-8859-1">
<title>TEST</title>
</head>
<body>
    <c:out value = "${'<tag> , &'}"/>
	<h1>Je regarde quoi ce soir ?</h1>
	
	  
    <form action = "Test" method="post">
      <label>Nom du film : <input name="nomFilm" type="text"></label>
      <label>Durée : <input name="duree"type="text"></label>
      <fieldset>
        <legend>Proposition Titre</legend>
          <label><input type="radio" name="radio">Sélectionnez-moi</label></br>
          <label><input type="radio" name="radio">Sélectionnez-moi</label></br>
          <label><input type="radio" name="radio">Sélectionnez-moi</label></br>
          <button>Sauvegarder</button>
      </fieldset>
    </form>
  
    <p> Le film choisi est : <c:out value="${sessionScope.nomf}" /><br>
        Vous lui avez donné une durée de : <c:out value="${param.duree}" /><br>
        Mon message est : <c:out value="${sessionScope.myEJB.message()}"/> </p>

    
</body>
</html>