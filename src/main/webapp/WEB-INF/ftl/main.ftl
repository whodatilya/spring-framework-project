<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <title>Main</title>
</head>
<body onload="connect(${user.id})">
<div class="topnav">
    <a class="active" href="/main">Home</a>
    <a href="/logout">Quit</a>
    <a href="/postAdd">Create</a>
    <p style="margin-left:20px; margin-top:18px; color: white"> ${user.firstName} ${user.lastName} </p>
</div>
<div class="posts-wrapper" style="height: 800px">
    <figure class="baha1493">
        <div class="image"><img src="https://vip-1gl.ru/vipberrrt/2701Duplex-at-Beacon-Court-14.jpg" alt="ls-sample1" /></div>
        <figcaption>
            <div class="date"><span class="day">28</span><span class="month">Oct</span></div>
            <h3>10000 рублей</h3>
            <p>

                Сдадим ИМОшникам помойку для жизни.
            </p>
            <footer>
                <div class="views"><i class="ion-eye"></i>2,907</div>
            </footer>
        </figcaption>
        <a href="/advertisement"></a>
    </figure>
    <figure class="baha1493">
        <div class="image"><img src="https://mykaleidoscope.ru/uploads/posts/2021-04/1617568322_7-p-kvartira-vnutri-7.jpg" alt="ls-sample2" />
        </div>
        <figcaption>
            <div class="date"><span class="day">17</span><span class="month">Nov</span></div>
            <h3>20000 рублей</h3>
            <p>

                100 м^2, 1 спальное место. Рассмотрим только дураков полнейших.
            </p>
            <footer>
                <div class="views"><i class="ion-eye"></i>1,870</div>
                <br>
            </footer>
        </figcaption>
        <a href="/advertisement"></a>
    </figure>
</div>

<div >
    <h2 style="color:white">
        Чат:
    </h2>
</div>
<div style="padding-right: 5%; padding-left: 5%">
    <div id="chatScrollView" style="overflow-x:hidden; overflow-y:hidden; height:300px;">
        <div id="messagesList"></div>
    </div>
    <div style="text-align: center">
        <button class="btn btn-primary btn-sm" id="enterChatButton" onclick="enterChat(' ${user.firstName}')">
            Войти
        </button>
    </div>
    <label for="message">
    </label>
    <input name="message" id="message" disabled placeholder="Сообщение" hidden>
    <button class="btn btn-success btn-sm" onclick="sendMessage('${user.firstName}', $('#message').val())" id="sendMessageButton" hidden>
        Отправить
    </button>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="/resources/js/chat.js"></script>
</body>

</html>