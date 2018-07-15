<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account</title>
</head>
<body>
<%@ include file="header.jsp" %>
<main>
	<h1>My account</h1>
	<% 
		String loginName = (String)session.getAttribute("loginName"); 
		%>
	<p>Bonjour <% if(loginName != null && loginName != ""){ out.println(loginName); } %>, vous pouvez désormais accéder à toutes nos options de création d'URL
	raccourcies</p>
	<a href="./account/personnal">Informations personnelles</a>
	<a href="./account/urls">Mes urls</a>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>