<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/registration.css">
    <title>SignIn</title>
</head>
<body>
<#if error??>
    <h1>Неправильный логин или пароль</h1>
</#if>
<div id="wrapper">
    <form method="post" id="signin">
        <fieldset style="border: none">
            <legend style="padding: 10px">Sign In</legend>

            <label for="nickname">
                <span>
                    Nickname
                    <span class="required">
                        *
                    </span>
                </span>
                <input type="text"
                       class="input-field"
                       name="nickname"
                       value=""/>
            </label>
            <br>
            <label for="password">
                <span>
                    Password
                    <span class="required">
                        *
                    </span>
                </span>
                <input type="password"
                       class="input-field"
                       name="password"
                       value=""/>
            </label>
            <br>
        </fieldset>
        <fieldset style="border: none; text-align: center">
            <label>
                <span>
                </span>
                <input type="submit" value="Submit"/>
                <p>don't have an account? <a href="/signUp">create now</a></p>
            </label>
        </fieldset>
    </form>
</div>

</body>
</html>