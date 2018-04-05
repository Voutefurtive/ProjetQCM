<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="fr.eni.javaee.projetQCM.bo.Roles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Inscriptions </title>
</head>
<body>

		<h1> Inscription des candidats </h1> 
		
		<form action="inscription" method="post">
		
			<p> <label> Selection par :  </label>
			<select name="choixTypeInscription">
 				 <option value="candidat" selected="selected"> Candidat </option>
 				 <option value="promo" > Promo </option>
			</select> </p>
			<input type="text" id="chanptext" name="champtext">
			<p> <input type="submit" id="soumettre" value="Soumettre"> </p>
		
		</form>
		
		<p> <label> </label>
</body>
</html>
