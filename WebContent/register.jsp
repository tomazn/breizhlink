<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<%@ include file="header.jsp" %>
<main>
	<div class="col-1 panel p-15">
<form method="POST" action="register">
<div class="form-group">
<label class="form-label" for="email">Email</label>
	<input class="input" type="text" id="email" name="email">
</div>
	<div class="form-group">
	<label class="form-label" for="password">Mot de passe</label>
	<input class="input" type="password" id="password" name="password">
</div>
	<input class="input btn red" type="submit" value="S'inscrire">
</form>
</div>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>