<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.javaee.projetQCM.bo.Roles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil Admin</title>
</head>
<body>

	<c:if test="${!empty sessionScope.nom }">
		<h1>Ouelcom ${ sessionScope.nom } !</h1>
	</c:if>
		<h2> Gestion des comptes utilisateurs </h2>
		
		<label> Nouvel Utilisateur </label>
		
			
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
			<p> <label> Le password sera généré automatiquement à la validation (random)</label> </p>
			<p> <label>Privilège de type : [valeur récupérée]</label> </p>
			<p> <label> Code de la promo (facultatif) : <input type="text" id="codePromo" name="codePromo"> </label> </p>
		
		
			<p> <input type="submit" id="soumettre" value="Soumettre"> </p>
		
		</form>
		<p>
			<input type="button" id="retour" value="Retour">
			<input type="button" id="annuler" value="Annuler">
		</p>
</body>
</html>