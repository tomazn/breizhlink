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
		<a href="">Création de compte</a>
		</li>
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
				<a href="./account">Mon compte</a>
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