<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Styles/css.css">
<meta charset="ISO-8859-1">
<title>Nomber 2</title>
</head>
<body>
	C'est l'heure du combat ! <br>
	Aujourd'hui, <c:out value="${sessionScope.nomPerso}" /> va afronter un être malefique ! <br><br>
	
	
	<c:set var="test1" value="${sessionScope.cara}" />
	SUSPENSSS... <br><br>
	
	<c:choose>

		<c:when test="${test1 == 'force'}">
			<c:set var="scoreF" value="11" />
			<c:set var="scoreR" value="5" />
		</c:when>

		<c:when test="${test1 == 'reflexion'}">
			<c:set var="scoreF" value="5" />
			<c:set var="scoreR" value="8" />
		</c:when>

		<c:otherwise>
			<c:set var="scoreF" value="5" />
			<c:set var="scoreR" value="5" />
		</c:otherwise>
	</c:choose>
	<c:out value="${sessionScope.nomPerso}" /> a ${scoreF + scoreR} points.	<br>
	
	<c:set var="enemiR"><%= java.lang.Math.round(java.lang.Math.random() * 10) %></c:set>
	<c:set var="enemiF"><%= java.lang.Math.round(java.lang.Math.random() * 10) %></c:set>
	<c:choose>

		<c:when test="${scoreF + scoreF <= enemiF + enemiR}">
			<c:out value="${sessionScope.nomPerso}" /> a perdu, l'ennemi était trop fort... <br>
			(il possedait <c:out value="${enemiR + enemiF}" /> points) <br>
		</c:when>

		<c:otherwise>
			C'est gagné ! <br>
			Avec <c:out value="${sessionScope.nomPerso}" />, l'ennemis n'a pas fait long feu !  <br>
		</c:otherwise>
	</c:choose>
	
	<br>(Psit ! Actualise pour affronter un autre enemis, ou revient en arrière pour modifier la dificulté du jeu ;) )
	
</body>
</html>