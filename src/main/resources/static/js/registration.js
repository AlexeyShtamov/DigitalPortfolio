function openRegistration() {
    var x = document.getElementById('specialists__window');
    var y = document.getElementById('teams__window');
    var z = document.getElementById('specialists__button');
    var w = document.getElementById('teams__button');

    if (x.style.display == 'none' && y.style.display == 'block') {
        x.style.display = 'block';
        y.style.display = 'none';
        z.style.background = '#fff';
        z.style.color = '#000';
        z.style.textDecoration = 'underline';
        w.style.background = '#000';
        w.style.color = '#fff';
        w.style.textDecoration = 'none';
    } else {
        x.style.display = 'none';
        y.style.display = 'block';
        z.style.background = '#000';
        z.style.color = '#fff';
        z.style.textDecoration = 'none';
        w.style.background = '#fff';
        w.style.color = '#000';
        w.style.textDecoration = 'underline';
    }
}