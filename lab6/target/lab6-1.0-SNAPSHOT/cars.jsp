<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Car List</h1>
<jsp:useBean id="carList" scope="request" type="java.util.List"/>
<c:forEach items="${carList}" var="car">
    ${car.model}: ${car.price}
    <br>
</c:forEach>
<br>
<br>
<ul>
    <li><a href="main.htm">to main page</a></li>
</ul>
</body>
</html>