<%--
  Created by IntelliJ IDEA.
  User: gorde
  Date: 09-11-2021
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new advertisement</title>
    <link rel="stylesheet" type="text/css" href="css/registration.css">
</head>
<body>
    <form action="/createNew" method="post" class="form">
        <p><h1>Создать объявление</h1></p>
        <p><textarea name="article" cols="40" rows="1" placeholder="Заголовок"></textarea></p>
        <p><textarea name="desc" cols="40" rows="5" placeholder="Описание"></textarea></p>
        <p><textarea name="phone" cols="40" rows="1" placeholder="Номер телефона"></textarea></p>
        <p><button type="submit">Создать</button></p>
    </form>
</form>
</body>
</html>
