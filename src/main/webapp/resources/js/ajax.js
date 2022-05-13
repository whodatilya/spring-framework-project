function sendPost() {
    let article = document.getElementById("article").value
    let description = document.getElementById("description").value
    let phoneNumber = document.getElementById('phoneNumber').value

    const postDto = {
        article: article,
        description: description,
        phoneNumber: phoneNumber
    };
    console.log(JSON.stringify(postDto))

    $.ajax({
        url: '/posts',
        method: 'POST',
        // dataType: 'json',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(postDto),
        success: function (data) {
            alert(data);
        }
    })
}