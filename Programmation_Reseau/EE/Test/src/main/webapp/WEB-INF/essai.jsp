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
	<h1>Mon personnage</h1>
	
	  
    <form action = "Test" method="post">
      <label>Nom du personnage : <input name="nomPersonnage" type="text"></label>
      <fieldset>
        <legend>Caracteristique principale</legend>
          <label><input type="radio" name="caracteristique" value = "force">Force</label></br>
          <label><input type="radio" name="caracteristique" value = "reflexion">Reflexion</label></br>
          <button>Sauvegarder</button>
      </fieldset>
    </form>
  	
    <p> Salut ! Moi c'est <c:out value="${sessionScope.nomPerso}" /><br>
        Mon point fort ? C'est ma <c:out value="${sessionScope.cara}" /> ! <br>
        Attention, <c:out value="${sessionScope.myEJB.message()}"/> </p>

	<p><a href="page2Servlet">Lancer le combat !</a></p>
    
</body>
</html>