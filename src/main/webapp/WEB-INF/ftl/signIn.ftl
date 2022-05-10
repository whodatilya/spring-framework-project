<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/registration.css">
    <title>SigIn</title>
</head>
<body>
<div class="form-style-3">
    <form method="post">
        <fieldset>
            <legend>Sign In</legend>
            <#if error??>
                <h1>Неправильный логин или пароль</h1>
            </#if>
            <label for="nickname">
                <span>
                    Email
                    <span class="required">
                        *
                    </span>
                </span>
                <input type="text"
                       class="input-field"
                       name="nickname"
                       value=""/>
            </label>
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
        </fieldset>
        <fieldset>
            <label>
                <span>
                </span>
                <input type="submit" value="Submit"/>
            </label>
        </fieldset>
    </form>
</div>

</body>
</html>