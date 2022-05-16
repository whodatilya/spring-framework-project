let webSocket;

function enterChat(from)
{
    let message =
        {
        "messageType": "enterChat",
        "firstName": from,
        "body": ""
    };

    webSocket.send(JSON.stringify(message));
    document.getElementById('message').disabled = false
    document.getElementById('message').hidden = false
    document.getElementById('sendMessageButton').hidden = false
    document.getElementById('enterChatButton').hidden = true
}

function connect(id)
{
    document.cookie = 'X-Authorization=' + '123456' + ';path=/';
    webSocket = new WebSocket('ws://localhost:8080/chat');
    webSocket.onmessage = function receiveMessage(response)
    {
        let data = response['data'];
        let json = JSON.parse(data);
        $('#messagesList').last().before("<p style='font-size: larger; color: white;'>" + json['firstName'] + ": " + json['body'] + "</p>")
        let scrollView = document.getElementById('chatScrollView')
        scrollView.scrollTop = scrollView.scrollHeight;
    };
    webSocket.onerror = function errorShow()
    {
        alert('Ошибка при входе в чат (авторизация)')
    }
}

function sendMessage(from, text)
{
    if (from == null || text === '') return

    let message =
        {
        "messageType": "chat",
        "firstName": from,
        "body": text
    };

    webSocket.send(JSON.stringify(message));
    document.getElementById('message').value = ''
}