<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.javaee.projetQCM.bo.Roles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil Formateur </title>
<%@include file="/WEB-INF/imports.html" %>
</head>
<body>

		
		<c:if test="${!empty sessionScope.utilisateur.nom }">
		<h1>Ouelcom ${ sessionScope.utilisateur.nom } !</h1>
		</c:if>
	
		<h2> Vous êtes connecté en tant que Formateur </h2>
		
		<p> <label> Inscrire un candidat à un test </label> 
			<input type="button" id="inscriptionCandidat" value="inscription"> </p>
		<p> <label> Inscrire une promotion à un test </label>
			 <a href="ServletInscriptionTest" type="button" class="btn btn-success" > Inscription </a> </p>
		<p> <label> Désinscrire une promotion à un test </label>
			 <input type="button" id="desinscriptionCandidat" value="desinscription"> </p>
			
</body>
</html>