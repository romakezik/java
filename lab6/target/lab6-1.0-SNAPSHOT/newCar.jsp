<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 26.03.2021
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creating new car page</title>
</head>
<body>
<h2>Insert required information:</h2>
<form action="main.htm?command=add" method="post">
    <input name="model" type="text" placeholder="model">
    <input name="price" type="number" placeholder="price" min="1">
    <input type="submit" value="create">
</form>
<br>
<br>
<ul>
    <li><a href="main.htm">to main page</a></li>
</ul>
</body>
</html>
