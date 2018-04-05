<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.javaee.projetQCM.bo.Roles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil CDR </title>
</head>
<body>
	<%@include file="/WEB-INF/header.html" %>
		<c:if test="${!empty sessionScope.utilisateur.nom }">
		<h1>Ouelcom ${ sessionScope.utilisateur.nom } !</h1>
		</c:if>
		
		
		<h2> Vous êtes connecté en tant que Cellule de Recrutement </h2>
		
		<p> <label> Inscrire un candidat à un test </label> 
			<input type="button" id="inscriptionCandidat" value="inscription"> </p>
		<p> <label> Inscrire une promotion à un test </label>
			 <input type="button" id="inscriptionPromo" value="inscription"> </p>
		<p> <label> Désinscrire une promotion à un test </label>
			 <input type="button" id="desinscriptionCandidat" value="desinscription"> </p>
	
</body>
</html>