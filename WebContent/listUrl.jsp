<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Liste des urls :

<c:forEach items="${listUrl}" var="url">
  <div>
      <c:out value="${url['url']}" />
  </div>
  <div>
      <c:out value="${url['urlShort']}" />
  </div>
  <div>
      <c:out value="${url['created']}" />
  </div>
</c:forEach>

