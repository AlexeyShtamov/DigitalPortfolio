function show_hide_password(){
    var input = document.getElementById('password__input');
    if (input.getAttribute('type') == 'password') {
        input.setAttribute('type', 'text');
    } else {
        input.setAttribute('type', 'password');
    }
    return false;
}

function changeAvatar(){
    var x = document.getElementById('window__avatar__input');

    if (x.style.display == 'none'){
        x.style.display = 'flex';
    }
    else{
        x.style.display = 'none';
    }
}

function changeCover(){
    var x = document.getElementById('window__cover__input');

    if (x.style.display == 'none'){
        x.style.display = 'flex';
    }
    else{
        x.style.display = 'none';
    }
}