<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Account</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/portfolio-item.css" rel="stylesheet">

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