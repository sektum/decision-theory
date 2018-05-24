var path = window.location.pathname;
if (path == '/alternatives') {
    highlight($('._alternative-li'));
}
else if (path == '/criteria') {
    highlight($('._criteria-li'));
}

else if (path == '/persons') {
    highlight($('._persons-li'));
}

else if (path == '/marks') {
    highlight($('._marks-li'));
}

else if (path == '/vectors') {
    highlight($('._vectors-li'));
}

else if (path == 'smart') {
    highlight($('._smart-li'));
}

else if (path == '/results') {
    highlight($('._results-li'));
}

function highlight($li)
{
    $li.addClass('active');
}