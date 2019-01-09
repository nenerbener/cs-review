<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>The rain in spain</h1>
<br>

<!-- 
<form action="MyServlet" method="get" id="form1"><input type="submit" value="send" />
</form>

<fieldset form="form1">
  Name: <input type="text" name="username"><br>
  Email: <input type="text" name="usermail"><br>
</fieldset>
<br>
-->

<form action="MyServlet">
  First name:<br>
  <input type="text" name="firstname"><br>
  Last name:<br>
  <input type="text" name="lastname">
  <input type="submit" value="Submit">
</form>

</body>
</html>