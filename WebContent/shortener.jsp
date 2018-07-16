<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shortener</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/portfolio-item.css" rel="stylesheet">

</head>

<body>

<%@ include file="header.jsp" %>
<main>

<div class="col-md-12">
<form action="shortener" method="POST"> 
<label>url:</label>
<input class="form-control" type="text" name="url"/>
<br>
<label>captcha</label>
<input class="form-control" type="checkbox" name="captcha">
<br>
<label>password:</label>
<input class="form-control" type="text" name="password"/>
<br>
<label>Valable du</label>
<input class="form-control" type="date" name="minDate">
<span>au</span>
<input class="form-control" type="date" name="maxDate">
<br>
<label>max click</label>
<input class="form-control" type="chebkbox" name="maxClick">
<br>
<input class="btn btn-primary" type=submit value="Raccourcir"> 
</form>
</div>

</main>
<%@ include file="footer.jsp" %>
</body>
</html>
