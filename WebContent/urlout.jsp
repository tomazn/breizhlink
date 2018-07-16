
<jsp:useBean id="urlOut" scope="session" class="bean.beanUrl"/>

<% 
		boolean outday = (boolean) request.getAttribute("outday"); 
		%>
		<% if(outday == true){ %>
		<p>url:
		<p><jsp:getProperty name="urlOut" property="urlShort"/></p>
		</p>
			<p>Cette url n'est pas valide pour aujourd'hui</p>
		<%  }else{ %>
		
<p>Vous tentez d'accéder à une URL protégé par un mot de passe</p>
<p>
<a href="<jsp:getProperty name="urlOut" property="urlShort"/>"><jsp:getProperty name="urlOut" property="urlShort"/></a>
</p>
<hr/>
<form action="urlout" method="POST">
<label>Quel est le mot de passe?</label>
<input type="text" placeholder="Mot de passe" name="password">

<% 
		boolean captcha = (boolean) request.getAttribute("captcha"); 
		%>
		<% if(captcha){ %>
			<input type="text" placeholder="captcha" name="captcha">
		<%  } %>

<input type="submit" value="Envoyer"/>
</form>

<p>
<% 
		String msg = (String)request.getAttribute("messageUrlout"); 
		%>
		<% if(msg != null && msg != ""){ out.println(msg); } %>
</p>

<% } %>