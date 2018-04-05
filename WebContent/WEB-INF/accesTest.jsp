<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${sessionScope.test.libelle} : ${sessionScope.test.description}</title>
		<%@include file="/WEB-INF/imports.html" %>
	</head>
	<body>
		<h2>Intitulé de l'épreuve : ${sessionScope.test.libelle}</h2>
		<hr>
		<h4>Description</h4>
		<p>${sessionScope.test.description}</p>
		<hr>
		<p>Durée : ${sessionScope.test.duree} min</p><br>
		
		<a href="question" type="button" class="btn btn-success">Accès au test</a>
		
<!-- 		<a href="question" type="button" class="btn btn-warning">Poursuivre le test</a> -->
		
	</body>
</html>