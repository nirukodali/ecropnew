function charCheck(e, ch)
{
    var key;
    var keychar;
    if (window.event)
        key = window.event.keyCode;
    else if (e)
        key = e.which;
    else
        return true;
    keychar = String.fromCharCode(key);
    keychar = keychar.toLowerCase();
    if ((key == 0) || (key == 8) || (key == 9) || (key == 13) || (key == 27) || (key == 127))
        return true;
    else if (((ch).indexOf(keychar) > -1))
    {
        return true;
    }
    else
        return false;
}