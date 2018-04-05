<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.javaee.projetQCM.bo.Roles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Accueil Admin</title>
	<%@include file="/WEB-INF/imports.html" %>
</head>
<body>
	<%@include file="/WEB-INF/header.html" %>
	<c:if test="${!empty sessionScope.utilisateur.nom }">
		<h1>Ouelcom ${ sessionScope.utilisateur.nom } !</h1>
	</c:if>
	
		<h2> Vous êtes connecté en tant qu'Administrateur </h2>
		
		<h2> Gestion des comptes utilisateurs </h2>
		
		<c:if test="${!empty newMdp}">
			<p>Nouvel utilisateur ajouté !</p><br>
			<p>identifiant : ${nom} - mdp : ${newMdp}</p>
			<hr>		
		</c:if>
		
		<label> Nouvel Utilisateur </label>
		
			<p> <label> Veuillez choisir le type de compte à créer :</label> </p>
			
		<form action="admin" method="post">
		
			<select name="codeProfil">
 				 <option value="${ Roles.FORMATEUR }" selected="selected">Formateur</option>
 				 <option value="${ Roles.CELLULE_DE_RECRUTEMENT }">Cellule de recrutement</option>
				 <option value="${ Roles.RESPONSABLE_DE_FORMATION }">responsable de formation</option>
 				 <option value="${ Roles.CANDIDAT }">Candidat</option>
 				 <option value="${Roles.STAGIAIRE }">Stagiaire</option>
			</select>
			
			<p> <label> Nom : </label> <input type="text" id="nom" name="nom"> </p>
			<p> <label> Prenom : </label> <input type="text" id="prenom" name="prenom"> </p>
			<p> <label> Email : </label>  <input type="text" id="email" name="email"> </p>
			<p> <label> Le password du nouvel utilisateur est généré automatiquement</label> </p>
			<p> <label> Code de la promotion (facultatif) : <input type="text" id="codePromo" name="codePromo"> </label> </p>
		
		
			<p> <input type="submit" id="soumettre" value="Soumettre"> </p>
		
		</form>
		<p>
			<input type="button" id="retour" value="Retour">
			<input type="button" id="annuler" value="Annuler">
		</p>
</body>
</html>