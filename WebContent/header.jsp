<header>
<div class="row">
    <div class="col-md-6 text-center">
      <h3 class="my-3">LOGO</h3>
    </div>
    <div class="col-md-6">
      <img class="img-fluid" src="http://placehold.it/750x100" alt="">
    </div>
  </div>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/breizhlink">Breizhlink</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/breizhlink">Accueil
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Présentation</a>
          </li>
          <%if(session.getAttribute("login") != null){ %>
		<% String login = session.getAttribute("login").toString(); %>
		<% if(login == "false"){ %>
          <li class="nav-item">
            <a class="nav-link" href="./register">Création d'un compte</a>
          </li>
          <li>
			<div>
				<%@ include file="login.jsp" %>
			</div>
		</li>
          <% }else{ %>
          	<li class="nav-item">
				<a class="nav-link" href="./shortener">Racourcir</a>
			</li>
			<% 
		String loginName = (String)session.getAttribute("loginName"); 
		%>
			<li class="nav-item">
				<a class="nav-link" href="./account">Mon compte (<% if(loginName != null && loginName != ""){ out.println(loginName); } %>)</a>
			</li>
				<li class="nav-item">
				<a class="nav-link" href="./logout">Déconnexion</a>
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
		<% if(msg != null && msg != ""){ %>
		<div class="alert alert-danger">
		<% out.println(msg); %>
		</div>
			<% } %>
		
        </ul>
      </div>
    </div>
  </div>
</nav>
</header>


