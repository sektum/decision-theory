function sendLoginData() {
    $.post('/login', $('#loginForm').serialize());
}