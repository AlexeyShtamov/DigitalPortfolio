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

function sendProjectData(){
    const projectData = {
        name: document.getElementById('portfolio__input__name'),
        file: document.getElementById('document.getElementById'),
        description: document.getElementById('portfolio__link'),
        avatar: document.getElementById('portfolio__logo')
    }

    const jsonData = JSON.stringify(projectData);

    $.ajax({
        url: "", //сюда вписать путь, куда эти данные отправить
        type: "POST",
        data: jsonData,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(response) {
            console.log("отправлено на бэк");
        },
        error: function(error) {
            console.error("ошибка при отправке на бэк", error);
        }
    });
}