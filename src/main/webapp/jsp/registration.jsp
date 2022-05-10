<%--
  Created by IntelliJ IDEA.
  User: gorde
  Date: 16-10-2021
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="css/registration.css">
</head>
<body>
    <form action="/signUp" method="post" class="form">
        <h1>Sign Up</h1>
        <div id="wrapper">
            <form id="signin" method="post" action="" class="form">
                <input type="text" id="nickname" name="nickname" placeholder="username" autocomplete="off" />
                <input type="password" id="password" name="password" placeholder="password" autocomplete="off" />
                <button type="submit">&#xf0da;</button>
                <p>already have an account? <a href="/signIn">log in</a></p>
                <br>
                <p>Для дебага <a href="/main">main</a></p>
            </form>
        </div>
    </form>
</body>
</html>
