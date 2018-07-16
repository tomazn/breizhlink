<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Index</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/portfolio-item.css" rel="stylesheet">

</head>

<body>

<%@ include file="header.jsp" %>
<main>

<%@ include file="urlin.jsp" %>

<% if(request.getAttribute("url") != null){ %>
<jsp:useBean id="url" scope="session" class="bean.beanUrl"/>
Votre url raccourcie : <a target="_blank" href="<jsp:getProperty name="url" property="urlShort"/>"><jsp:getProperty name="url" property="urlShort"/></a>
<% } %>

</main>
<%@ include file="footer.jsp" %>
</body>
</html>