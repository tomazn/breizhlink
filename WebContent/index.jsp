<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>

<header>
<div>
<img src="" alt="logo"/>
	<div class="ads">
		<!-- ADS -->
	</div>
</div>
<nav>
	<ul>
		<li>
		<a href="">Accueil</a>
		</li>
		<li>
		<a href="">Présentation</a>
		</li>
		<li>
		<a href="">Création de compte</a>
		</li>
		<%if(session.getAttribute("login") != null){ %>
		<% String login = session.getAttribute("login").toString(); %>
		<% if(login == "false"){ %>
		<li>
			<div>
				<%@ include file="login.jsp" %>
			</div>
		</li>
		<% }else{ %>
			<li>
				<a href="">Racourcir</a>
			</li>
			<li>
				<a href="">Mon compte</a>
			</li>
		<% } %>
		<% }else{ %>
		<li>
			<div>
				<%@ include file="login.jsp" %>
			</div>
		</li>
		<% } %>
		<% 
		String msg = (String)request.getAttribute("message"); 
		%>
		<% if(msg != null && msg != ""){ out.println(msg); } %>
	</ul>
</nav>
</header>
<main>

<%@ include file="urlin.jsp" %>

<% if(request.getAttribute("url") != null){ %>
<jsp:useBean id="url" scope="session" class="bean.beanUrl"/>
Votre url raccourcie : <a href="<jsp:getProperty name="url" property="urlShort"/>"><jsp:getProperty name="url" property="urlShort"/></a>
<% } %>

</main>
<footer>
<ul>
<li>
	<a href="">Devenir partenaire</a>
</li>
<li>
	<a href="">CGV</a>
</li>
<li>
	<a href="">Mentions légales</a>
</li>
</ul>
</footer>
</body>
</html>