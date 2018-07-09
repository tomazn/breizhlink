<jsp:useBean id="urlOut" scope="session" class="bean.beanUrl"/>

<p>Vous tentez d'accéder à une URL protégé par un mot de passe</p>
<p>
<a href="<jsp:getProperty name="urlOut" property="urlShort"/>"><jsp:getProperty name="urlOut" property="urlShort"/></a>
</p>
<hr/>
<form action="urlout" method="POST">
<label>Quel est le mot de passe?</label>
<input type="text" placeholder="Mot de passe" name="password">
<input type="submit" value="Envoyer"/>
</form>

<p>
<% 
		String msg = (String)request.getAttribute("messageUrlout"); 
		%>
		<% if(msg != null && msg != ""){ out.println(msg); } %>
</p>