<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
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