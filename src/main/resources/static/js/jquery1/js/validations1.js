function validateMessages(form,A) {
    A=A?A:"ALL";
    var i=0;
    var formName = form.getAttributeNode("name");
    var oRequired = eval('new ' + formName.value + '_messages()');  
    for (var x in oRequired) {
        var field = form[oRequired[x][0]];
        if(A==field.name){
            return oRequired[x][1];
        }
    }
} 
function validateRequired(form,A) {
    var isValid = true;
    var focusField = null;
    var i = 0;
    var fields = new Array();
	
    var formName = form.getAttributeNode("name");
    var oRequired = eval('new ' + formName.value + '_required("'+A+'")');  

    for (var x in oRequired) {
	
        if (!jcv_verifyArrayElement(x, oRequired[x])) {
            continue;
        }
        var field = form[oRequired[x][0]];
        if (!jcv_isFieldPresent(field)) {
            fields[i++] = oRequired[x][0];
            isValid=false;
        } else if ((field.type == 'hidden' ||
            field.type == 'text' ||
            field.type == 'textarea' ||
            field.type == 'file' ||
            field.type == 'radio' ||
            field.type == 'checkbox' ||
            field.type == 'select-one' ||
            field.type == 'password')) {

            var value = '';
            // get field's value
            if (field.type == "select-one") {
                var si = field.selectedIndex;
                if (si >= 0) {
                    value = field.options[si].value;
                }
            } else if (field.type == 'radio' || field.type == 'checkbox') {
                if (field.checked) {
                    value = field.value;
                }
            } else {
                value = field.value;
            }

            if (trim(value).length == 0) {

                if ((i == 0) && (field.type != 'hidden')) {
                    focusField = field;
                }
                fields[i++] = oRequired[x][0];
                isValid = false;
            }
        } else if (field.type == "select-multiple") { 
            var numOptions = field.options.length;
            lastSelected=-1;
            for(loop=numOptions-1;loop>=0;loop--) {
                if(field.options[loop].selected) {
                    lastSelected = loop;
                    value = field.options[loop].value;
                    break;
                }
            }
            if(lastSelected < 0 || trim(value).length == 0) {
                if(i == 0) {
                    focusField = field;
                }
                fields[i++] = oRequired[x][0];
                isValid=false;
            }
        } else if ((field.length > 0) && (field[0].type == 'radio' || field[0].type == 'checkbox')) {
            isChecked=-1;
            for (loop=0;loop < field.length;loop++) {
                if (field[loop].checked) {
                    isChecked=loop;
                    break; // only one needs to be checked
                }
            }
            if (isChecked < 0) {
                if (i == 0) {
                    focusField = field[0];
                }
                fields[i++] = oRequired[x][0];
                isValid=false;
            }
        }   
    }
    if (fields.length > 0) {
		
        //jcv_handleErrors(fields, focusField);
        displayError(form,fields,A,oRequired,true);
		
    }
    else
    {
        displayError(form,fields,A,oRequired,false);
    }
	
    return isValid;
}
function validateMask(form,A) {
    var isValid = true;
    var focusField = null;
    var i = 0;
    var fields = new Array();
    var formName = form.getAttributeNode("name"); 
		
    oMasked = eval('new ' + formName.value + '_mask("'+A+'")');      
    for (x in oMasked) {
        var field = form[oMasked[x][0]];
 
        if ((field.type == 'hidden' ||
            field.type == 'text' ||
            field.type == 'textarea' ||
            field.type == 'file') &&
        (field.value.length > 0) &&
            field.disabled == false) {
//alert(field.value+"   "+ oMasked[x][2]("mask"));
            if (!matchPattern(field.value, oMasked[x][2]("mask"))) {
                if (i == 0) {
                    focusField = field;
                }
                fields[i++] = oMasked[x][0];
                isValid = false;
            }
        }
    }

    if (fields.length > 0) {
        // focusField.focus();
        // alert(fields.join('\n'));
        displayError(form,fields,A,oMasked,true);
    }else
    {
        displayError(form,fields,A,oMasked,false);
    }
    return isValid;
}

function matchPattern(value, mask) {
    return mask.exec(value);
}

function displayError(form,messages,field,allfields,s)
{
    var str=new Array();
    var i=0;
    for (var x in allfields) 
    {
        form[allfields[x][0]].className="border_grey";
        if(document.getElementById(allfields[x][0]+"_error")!=null)
        {
            document.getElementById(allfields[x][0]+"_error").innerHTML="";
            document.getElementById(allfields[x][0]+"_error").style.display="none"
            for(y in messages)
            {
                if(allfields[x][0]==messages[y])
                {
                    if(s)
                    {
                        form[messages[y]].className="border_red";
                        document.getElementById(messages[y]+"_error").innerHTML=allfields[x][1];
                        document.getElementById(messages[y]+"_error").className="txt_red";
                        document.getElementById(messages[y]+"_error").style.display=""
                    }else
                    {
                        form[messages[y]].className="border_grey";
                    }
                }
            }
        }
        else
        {
            for(y in messages)
            {
                if(allfields[x][0]==messages[y])
                {
                    str[i++]=allfields[x][1];
                }
            }
        }
    }
    if(str.length>0)
        alert(str.join('\n'));
}
// Trim whitespace from left and right sides of s.
function trim(s) {
    return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
}
	
function jcv_verifyArrayElement(name, element) {
    if (element && element.length && element.length == 3) {
        return true;
    } else {
        return false;
    }
}
function jcv_isFieldPresent(field) {
    var fieldPresent = true;
    if (field == null || (typeof field == 'undefined')) {
        fieldPresent = false;
    } else {
        if (field.disabled) {
            fieldPresent = false;
        }
    }
    return fieldPresent;
}
function jcv_handleErrors(messages, focusField) {
    if (focusField && focusField != null) {
        var doFocus = true;
        if (focusField.disabled || focusField.type == 'hidden') {
            doFocus = false;
        }
        if (doFocus && 
            focusField.style && 
            focusField.style.visibility &&
            focusField.style.visibility == 'hidden') {
            doFocus = false;
        }
        if (doFocus) {
            focusField.focus();
        }
    }
    alert(messages.join('\n'));
}