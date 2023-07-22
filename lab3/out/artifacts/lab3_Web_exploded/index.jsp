<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
        <body bgcolor="#aaccff">
        <Font color="green" size="10">
            Форма для работы со словарем
        </Font>
        <br>
        <br>
        <form name="frm" method="Get" action="MyServlet">
            <Font color="blue" size="6"> Введите слово: </Font><input type="Text" name="txt"/>
            <br>
            <br>
            <Font color="blue" size="6">Перевод: ${word} ${trans}</Font><br>
            <h4>Кликни здесь для получения перевода :<Input type="submit" value="Перевести"/>
            </h4>
        </form>
    </body>
</html>