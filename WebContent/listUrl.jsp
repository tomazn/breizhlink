<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Liste des urls :</h1>
<hr/>

<c:forEach items="${listUrl}" var="url">
  Lien : <a href="<c:out value="${url['url']}" />"><c:out value="${url['url']}" /></a>
  <br>
  Lien raccourcie : <a href="<c:out value="${url['urlShort']}" />"><c:out value="${url['urlShort']}" /></a>
  <div>
      Créé le : <c:out value="${url['created']}" />
  </div>
  <hr/>
</c:forEach>

