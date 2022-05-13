<!doctype html>
<html lang="en">
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="/resources/js/ajax.js"></script>
    <link rel="stylesheet" href="/resources/css/main.css">

    <title>Add product</title>

</head>
<body>
<div class="topnav">
    <a class="active" href="/main">Home</a>
    <a href="/signUp">Quit</a>
    <a href="/postAdd">Create</a>
</div>
<div class="form-style-3">
    <fieldset style="border: none">
        <legend style="padding: 10px">Add product</legend>
        <label for="article"><span>Название товара<span class="required">*</span></span><input type="text"
                                                                                             class="input-field"
                                                                                             name="article"
                                                                                             id="article"
                                                                                             value=""/></label>
        <br>
        <label for="description"><span>Описание товара<span class="required">*</span></span><input type="text"
                                                                                                   class="input-field"
                                                                                                   name="description"
                                                                                                   id="description"
                                                                                                   value=""/></label>
        <br>
        <label for="phoneNumber"><span>Стоимость<span class="required">*</span></span><input type="number"
                                                                                      step="0.01"
                                                                                      class="input-field"
                                                                                      name="phoneNumber"
                                                                                      id="phoneNumber"
                                                                                      value=""/></label>
        <br>
    </fieldset>
    <fieldset style="border: none; text-align: center">
        <label><span> </span>
            <button type="submit" value="Submit" onclick="sendPost()">Добавить</button>
        </label>
    </fieldset>

</div>

</body>
</html>