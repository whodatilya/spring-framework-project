<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: gorde
  Date: 16-10-2021
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Advertisement</title>
    <link rel="stylesheet" type="text/css" href="css/advertisement.css">
</head>
<body>
<div class="topnav">
    <a class="active" href="/main">Home</a>
    <a href="/signUp">Quit</a>
</div>

<figure class="baha1493">
    <div class="image"><img src="https://pbs.twimg.com/media/ESIc-KdWoAMyguJ.jpg:large" alt="ls-sample3"></div>
    <div class="image"><img src="https://pbs.twimg.com/media/EfRfwjgXgAAgHBz.jpg" alt="ls-sample3"></div>
    <figcaption>
        <h3>30000 рублей</h3>
        <hr>
        <p>

            Оаоаоаоа оаоаоаа ээээыэыыэыээыэы......
        </p>
    </figcaption>
</figure>
<footer>
    <a href="/contact" class="floating-button">Message</a>
    <hr>
    <p><h1>Write your comment</h1></p>
    <form action="/advertisement" method="post" class="form">
        <p><textarea name="commentator_name" cols="40" rows="1" placeholder="Name"></textarea></p>
        <p><textarea name="text" cols="40" rows="5" placeholder="Text"></textarea></p>
        <p><button type="submit" class="floating-button">Write</button></p>
    </form>
    <hr>
    <ul>
        <c:forEach items="${comments}" var="comment">
            <a href="${comment.id}">
                    ${comment.text}
            </a>
        </c:forEach>
    </ul>
</footer>

</body>
</html>
