<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<%@ include file="header.jsp" %>
<main>

<form action="shortener" method="POST"> 
<label>url:</label>
<input type="text" name="url"/>
<br>
<label>captcha</label>
<input type="checkbox" name="captcha">
<br>
<label>password:</label>
<input type="text" name="password"/>
<br>
<label>Valable du</label>
<input type="date" name="minDate">
<span>au</span>
<input type="date" name="maxDate">
<br>
<label>max click</label>
<input type="chebkbox" name="maxClick">
<br>
<input type=submit value="Raccourcir"> 
</form>

</main>
<%@ include file="footer.jsp" %>
</body>
</html>