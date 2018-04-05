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
		<h1>${sessionScope.test.libelle} : ${sessionScope.test.description}</h1>
		<hr>
		
<%-- 		<c:forEach var="question" items="${sessionScope.questionnaire}"> --%>
<%-- 			<h3>Question n°${question.id}</h3> --%>
<%-- 			<h4>${question.enonce}</h4> --%>
<!-- 			<ul> -->
<%-- 				<c:forEach var="proposition" items="${question.propositions }"> --%>
<%-- 					<li>${proposition.enonce }</li> --%>
<%-- 				</c:forEach> --%>
<!-- 			</ul> -->
<!-- 			<hr> -->
<%-- 		</c:forEach> --%>
		<h3>Question n°${sessionScope.questionCourante.numOrdre + 1}</h3>
		<h4>${sessionScope.questionCourante.enonce}</h4>
		<form action="question" method="post">
			<c:forEach var="proposition" items="${sessionScope.questionCourante.propositions }">
				<c:choose>
					<c:when test="${proposition.cochee==true}">
						<label><input type="radio" name="proposition" value="${proposition.id}" checked="checked" >${proposition.enonce }</label><br> 
					</c:when>
					<c:when test="${proposition.cochee==false}">
						<label><input type="radio" name="proposition" value="${proposition.id}">${proposition.enonce }</label><br>
					</c:when>
				</c:choose>
			</c:forEach>
<%-- 		<p><%session.setAttribute("questionCourante", session.getAttribute("questionnaire").get(1)) %> --%>
			<c:if test="${sessionScope.questionCourante.numOrdre < sessionScope.nbQuestions-1}">
				<input type="submit"  class="btn btn-success" value="Suivant">
			</c:if>
		</form>
		<c:if test="${sessionScope.questionCourante.numOrdre == sessionScope.nbQuestions-1}">
			<a href="#" type="button" class="btn btn-success">Récapitulatif</a>
		</c:if>
		
		<c:forEach var="question" items="${sessionScope.questionnaire}">
			<a href="question?idQuestion=${question.numOrdre }">Question n°${question.id }</a>
		</c:forEach>
	</body>
</html>