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
		<a href="/breizhlink">Accueil</a>
		</li>
		<li>
		<a href="">Présentation</a>
		</li>
		<%if(session.getAttribute("login") != null){ %>
		<% String login = session.getAttribute("login").toString(); %>
		<% if(login == "false"){ %>
				<li>
		<a href="./register">Création de compte</a>
		</li>
		<li>
			<div>
				<%@ include file="login.jsp" %>
			</div>
		</li>
		<% }else{ %>
			<li>
				<a href="./shortener">Racourcir</a>
			</li>
			<% 
		String loginName = (String)session.getAttribute("loginName"); 
		%>
			<li>
				<a href="./account">Mon compte (<% if(loginName != null && loginName != ""){ out.println(loginName); } %>)</a>
			</li>
				<li>
				<a href="./logout">Déconnexion</a>
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