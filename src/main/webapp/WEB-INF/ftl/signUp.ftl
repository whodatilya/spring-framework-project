<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/registration.css">
    <title>SignUp</title>
</head>
<body>
<#if registrationStatus??>
    <h1>${registrationStatus}</h1>
</#if>
<div id="wrapper">
    <form method="post" id="signin">
        <fieldset style="border: none">

            <legend style="padding: 10px">Sign Up</legend>
            <label for="nickname"><span>Nickname<span class="required">*</span></span><input type="text"
                                                                                                class="input-field"
                                                                                                name="nickname"
                                                                                                value=""/></label>
            <br>
            <label for="firstName"><span>First Name<span class="required">*</span></span><input type="text"
                                                                                                class="input-field"
                                                                                                name="firstName"
                                                                                                value=""/></label>
            <br>
            <label for="lastName"><span>Last Name <span class="required">*</span></span><input type="text"
                                                                                               class="input-field"
                                                                                               name="lastName"
                                                                                               value=""/></label>
            <br>
            <label for="password"><span>Password<span class="required">*</span></span><input type="password"
                                                                                             class="input-field"
                                                                                             name="password"
                                                                                             value=""/></label>
            <br>
            <label for="confirmPassword"><span>Confirm Password<span class="required">*</span></span><input type="password"
                                                                                                            class="input-field"
                                                                                                            name="confirmPassword"
                                                                                                            value=""/></label>
            <br>
        </fieldset>
        <fieldset style="border: none; text-align: center">
            <label><span> </span><input type="submit" value="Submit"/></label>
            <p>already have an account? <a href="/signIn">log in</a></p>
        </fieldset>
    </form>

</div>

</body>
</html>