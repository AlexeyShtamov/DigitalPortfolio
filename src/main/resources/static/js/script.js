function openSearch() {
    var x = document.getElementById('search__box');
    var y = document.getElementById('search__js');

    if (x.style.display == 'none'){
        x.style.display = 'block';
        y.style.color = '#000';
        y.style.backgroundColor = '#fff';
        y.style.textDecorationLine = 'underline';
    }
    else{
        x.style.display = 'none';
        y.style.color = '#fff';
        y.style.backgroundColor = '#000';
        y.style.textDecorationLine = 'none';
    }
}

function openProfile() {
    var x = document.getElementById('login__window');

    if (x.style.display == 'none'){
        x.style.display = 'flex';
    }
    else{
        x.style.display = 'none';
    }
}

function goToPagePortfolio() {
    window.location.href = "portfolio-view.html";
}

function goToPageTeam() {
    window.location.href = "add-view.html";
}