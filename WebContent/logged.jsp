<% String loginName = (String)session.getAttribute("loginName"); %>
<img style="max-width:150px;" src="img/img.jpg"/>
<p>Salut <%= loginName %></p>
<a style="float:right;" href="/Pouet/logout">Logout</a>