<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/imports.html" %>
<title>Authentification</title>
</head>
<body>
	<h1>Veuillez vous connecter</h1>
	<!--  -->
	<form action="login" method="post">

		<p>
			<label>Login : </label><input type="text" id="log" name="log">
			<label>Password : </label><input type="password" id="mdp" name="mdp">
		</p>
		<input type="submit" id="valider" value="valider">
		
	</form>
</body>
</html>