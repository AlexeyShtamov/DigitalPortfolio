$(document).ready(function(){
    $('#login__specialist').submit(function(e){
        e.preventDefault();

        var account = {
            email__specialist: $('input[name="email__specialist"]').val(),
            psw__specialist: $('input[name="psw__specialist"]').val()
        };

        $.ajax({
            url: 'login.php', //Путь к обработчику авторизации
            method: 'POST',
            data: account,

            success: function(response) {
                //если авторизция прошла успешно
                if(response == 'success') {
                    //Перенаправить пользователя на страницу профиля
                    window.location.href = 'profile.php';
                } else {
                    //вывести сообщение об ошибке
                }
            }
        });
    });
});