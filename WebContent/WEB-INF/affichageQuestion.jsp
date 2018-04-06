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
		<%@include file="/WEB-INF/header.html" %>
		<h1 class="text-center">${sessionScope.test.libelle} : ${sessionScope.test.description}</h1>
		<hr>

		<div class="row">
			<div class="col-xs-2">
				<c:forEach var="question" items="${sessionScope.questionnaire}">
					<a href="question?numOrdre=${question.numOrdre }">Question n°${question.numOrdre+1 }</a><br>
				</c:forEach>
			</div>
			
			<div class="col-xs-5">
				<h3>Question n°${sessionScope.questionCourante.numOrdre + 1}</h3>
				<h4>${sessionScope.questionCourante.enonce}</h4>
				
				<hr>
				
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
					
					<hr>
					
					<c:if test="${sessionScope.questionCourante.numOrdre < sessionScope.nbQuestions-1}">
						<input type="submit"  class="btn btn-success" value="Suivant">
					</c:if>
				</form>
				
				<c:if test="${sessionScope.questionCourante.numOrdre == sessionScope.nbQuestions-1}">
					<a href="#" type="button" class="btn btn-success">Récapitulatif</a>
				</c:if>
			</div>
		</div>
		

	</body>
</html>