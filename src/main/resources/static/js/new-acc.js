$(document).ready(function(){
    $('#registration__specialist').submit(function(e){
        e.preventDefault();

        var email__specialist = $('input[name="email__specialist"]').val();
        var psw__specialist = $('input[name="psw__specialist"]').val();
        var profession = $('select[name="profession"]').val();

        $.ajax({
            type: 'POST',
            url: 'register.php', //изменить url-адрес скрипта на наш сервер
            data: {
                email__specialist: email__specialist,
                psw__specialist: psw__specialist,
                profession: profession
            },
            success: function(response) {
                alert('Вы успешно зарегистрировались! Теперь войдите в аккаунт.');
            },
            error: function(xhr, status, error) {
                alert('Ошибка регистрации. Пожалуйста, попробуйте ещё раз');
            }
        });
    });


    $('#registration__team').submit(function(event){
        event.preventDefault();

        var email__team = $('input[name="email__team"]').val();
        var psw__team = $('input[name="psw__team"]').val();
        var team__name = $('input[name="team__name"]').val();

        $.ajax({
            type: 'POST',
            url: 'register.php', //изменить url-адрес скрипта на наш сервер
            data: {
                email__team: email__team,
                psw__team: psw__team,
                team__name: team__name
            },
            success: function(response) {
                alert('Команда успешно зарегистрирована! Теперь войдите в аккаунт.');
            },
            error: function(xhr, status, error) {
                alert('Ошибка регистрации. Пожалуйста, попробуйте ещё раз');
            }
        });
    });
});
