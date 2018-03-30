<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Questionnaire</title>
		<%@include file="/WEB-INF/imports.html" %>
	</head>
	<body>
		<h1>Questionnaire Thème : Kaamelott</h1>
		<hr>
		<c:forEach var="question" items="${questionnaire}">
			<h3>Question n°${question.id}</h3>
			<h4>${question.enonce}</h4>
			<ul>
				<c:forEach var="proposition" items="${question.propositions }">
					<li>${proposition.enonce }</li>
				</c:forEach>
			</ul>
			<hr>
		</c:forEach>

	</body>
</html>