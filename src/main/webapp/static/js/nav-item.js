var path = window.location.pathname;
if (path == '/alternatives') {
    highlight($('._alternative-li'));
}
else if (path == '/criteria') {
    highlight($('._criteria-li'));
}

function highlight($li)
{
    $li.addClass('active');
}