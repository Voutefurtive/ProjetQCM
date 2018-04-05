<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sélection de l'épreuve</title>
		<%@include file="/WEB-INF/imports.html" %>
	</head>
	<body>
		<h2>Tests dispo du candidat ${sessionScope.utilisateur.prenom} ${sessionScope.utilisateur.nom}</h2>
		<c:forEach var="epreuve" items="${epreuves}">
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${epreuve.dateFin >= new Date() && epreuve.dateDebut <= new Date() }"> --%>
<%-- 					<a href="question?id=${epreuve.idTest }">Épreuve n°${epreuve.idEpreuve}</a><br> --%>
<%-- 				</c:when> --%>
<%-- 				<c:when test="${epreuve.dateFin >= new Date() && epreuve.dateDebut > new Date() }"> --%>
<%-- 					<label>Épreuve n°${epreuve.idEpreuve} (Vous n'avez pas accès à cette épreuve avant le ${epreuve.dateDebut})</label><br> --%>
<%-- 				</c:when> --%>
<%-- 			</c:choose> --%>
			<a href="detailTest?id=${epreuve.test.idTest }">Épreuve n°${epreuve.idEpreuve}</a><br>
		</c:forEach>
	</body>
</html>