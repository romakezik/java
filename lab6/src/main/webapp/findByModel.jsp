<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Searching page</title>
</head>
<body>
<h2>Insert car price:</h2>
<form action="main.htm?command=priceByModel" method="post">
    <input name="model" placeholder="model" type="text">
    <input type="submit" value="find">
</form>
<c:if test="${car!=null}">
    Price of ${car.model} is ${car.price}
</c:if>
${requestScope.errorMsg}
<br>
<br>
<ul>
    <li><a href="main.htm">to main page</a></li>
</ul>
</body>
</html>
