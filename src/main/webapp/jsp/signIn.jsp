<%--
  Created by IntelliJ IDEA.
  User: gorde
  Date: 16-10-2021
  Time: 15:32
  To change this templa[te use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <link rel="stylesheet" type="text/css" href="css/registration.css">
</head>
<body>
<form action="/signIn" method="post" class="form">
    <h1>Sign In</h1>
    <div id="wrapper">
        <form id="signin" method="" action="" autocomplete="off">
            <input type="text" id="nickname" name="nickname" placeholder="nickname" autocomplete="off" />
            <input type="password" id="password" name="pass" placeholder="password" autocomplete="off" />
            <button type="submit">&#xf0da;</button>
        </form>
    </div>
</form>

<h3>${signInStatus}</h3>

</body>
</html>
