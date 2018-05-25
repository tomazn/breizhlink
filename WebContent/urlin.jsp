<jsp:useBean id="urlIn" scope="session" class="beanUrl.beanUrl"/>

<jsp:setProperty name="urlIn" property="url" param="url"/>

<form action="urlin" method="POST"> 
url:
<input type="text" name="url"/>
<br>
<input type=submit value="Raccourcir"> 
</form>