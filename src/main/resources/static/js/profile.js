function SignOut(){
    $.ajax({
        url: 'singOut.php', //перенаправить пользователя на эту страницу
            method: 'POST',

            success: function(response) {
                //обработка успешного ответа
                window.location.href = 'login.php' //перенаправление на страницу входа
            },
            error: function(xhr, status, error) {
                //обработка ответ об ошибке
                console.log(error);
            }
    });
}

function show_hide_password(target){
	var input = document.getElementById('password__input');
	if (input.getAttribute('type') == 'password') {
		input.setAttribute('type', 'text');
	} else {
		input.setAttribute('type', 'password');
	}
	return false;
}