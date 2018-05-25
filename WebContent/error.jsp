<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 PAGE NOT FOUND</title>
</head>
<body>
<h1>404 PAGE NOT FOUND</h1>
<% boolean login = (boolean)session.getAttribute("login"); %>
<% if(login){ %>
<a href="/Pouet/dashboard">return dashboard</a>
<% }else{ %>
<a href="/Pouet/login">return to login</a>
<% } %>
</body>
</html>