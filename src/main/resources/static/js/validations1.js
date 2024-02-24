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
function validateMinLength(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name");


        oMinLength = eval('new ' + formName.value + '_minlength()');

        for (x in oMinLength) {
            var field = form[oMinLength[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'password' ||
                field.type == 'textarea') &&
                field.disabled == false) {

                var iMin = parseInt(oMinLength[x][2]("minlength"));
                if ((trim(field.value).length > 0) && (field.value.length < iMin)) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oMinLength[x][1];
                    isValid = false;
                }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return isValid;
    }
function validateMinLength(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name");


        oMinLength = eval('new ' + formName.value + '_minlength()');

        for (x in oMinLength) {
            var field = form[oMinLength[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'password' ||
                field.type == 'textarea') &&
                field.disabled == false) {

                var iMin = parseInt(oMinLength[x][2]("minlength"));
                if ((trim(field.value).length > 0) && (field.value.length < iMin)) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oMinLength[x][1];
                    isValid = false;
                }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return isValid;
    }
function validateDate(form) {
       var bValid = true;
       var focusField = null;
       var i = 0;
       var fields = new Array();
       var formName = form.getAttributeNode("name"); 

       oDate = eval('new ' + formName.value + '_DateValidations()');

       for (x in oDate) {
           var field = form[oDate[x][0]];
           var value = field.value;
           var datePattern = oDate[x][2]("datePatternStrict");
           // try loose pattern
           if (datePattern == null)
               datePattern = oDate[x][2]("datePattern");
           if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'textarea') &&
               (value.length > 0) && (datePattern.length > 0) &&
                field.disabled == false) {
                 var MONTH = "MM";
                 var DAY = "dd";
                 var YEAR = "yyyy";
                 var orderMonth = datePattern.indexOf(MONTH);
                 var orderDay = datePattern.indexOf(DAY);
                 var orderYear = datePattern.indexOf(YEAR);
                 if ((orderDay < orderYear && orderDay > orderMonth)) {
                     var iDelim1 = orderMonth + MONTH.length;
                     var iDelim2 = orderDay + DAY.length;
                     var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                     var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                     if (iDelim1 == orderDay && iDelim2 == orderYear) {
                        dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
                     } else if (iDelim1 == orderDay) {
                        dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
                     } else if (iDelim2 == orderYear) {
                        dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
                     } else {
                        dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
                     }
                     var matched = dateRegexp.exec(value);
                     if(matched != null) {
                        if (!isValidDate(matched[2], matched[1], matched[3])) {
                           if (i == 0) {
                               focusField = field;
                           }
                           fields[i++] = oDate[x][1];
                           bValid =  false;
                        }
                     } else {
                        if (i == 0) {
                            focusField = field;
                        }
                        fields[i++] = oDate[x][1];
                        bValid =  false;
                     }
                 } else if ((orderMonth < orderYear && orderMonth > orderDay)) {
                     var iDelim1 = orderDay + DAY.length;
                     var iDelim2 = orderMonth + MONTH.length;
                     var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                     var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                     if (iDelim1 == orderMonth && iDelim2 == orderYear) {
                         dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
                     } else if (iDelim1 == orderMonth) {
                         dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
                     } else if (iDelim2 == orderYear) {
                         dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
                     } else {
                         dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
                     }
                     var matched = dateRegexp.exec(value);
                     if(matched != null) {
                         if (!isValidDate(matched[1], matched[2], matched[3])) {
                             if (i == 0) {
                         focusField = field;
                             }
                             fields[i++] = oDate[x][1];
                             bValid =  false;
                          }
                     } else {
                         if (i == 0) {
                             focusField = field;
                         }
                         fields[i++] = oDate[x][1];
                         bValid =  false;
                     }
                 } else if ((orderMonth > orderYear && orderMonth < orderDay)) {
                     var iDelim1 = orderYear + YEAR.length;
                     var iDelim2 = orderMonth + MONTH.length;
                     var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                     var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                     if (iDelim1 == orderMonth && iDelim2 == orderDay) {
                         dateRegexp = new RegExp("^(\\d{4})(\\d{2})(\\d{2})$");
                     } else if (iDelim1 == orderMonth) {
                         dateRegexp = new RegExp("^(\\d{4})(\\d{2})[" + delim2 + "](\\d{2})$");
                     } else if (iDelim2 == orderDay) {
                         dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})(\\d{2})$");
                     } else {
                         dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{2})$");
                     }
                     var matched = dateRegexp.exec(value);
                     if(matched != null) {
                         if (!isValidDate(matched[3], matched[2], matched[1])) {
                             if (i == 0) {
                                 focusField = field;
                             }
                             fields[i++] = oDate[x][1];
                             bValid =  false;
                         }
                     } else {
                          if (i == 0) {
                              focusField = field;
                          }
                          fields[i++] = oDate[x][1];
                          bValid =  false;
                     }
                 } else {
                     if (i == 0) {
                         focusField = field;
                     }
                     fields[i++] = oDate[x][1];
                     bValid =  false;
                 }
          }
       }
       if (fields.length > 0) {
          focusField.focus();
          alert(fields.join('\n'));
       }
       return bValid;
    }
    
    function isValidDate(day, month, year) {
	    if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) &&
            (day == 31)) {
            return false;
        }
        if (month == 2) {
            var leap = (year % 4 == 0 &&
               (year % 100 != 0 || year % 400 == 0));
            if (day>29 || (day == 29 && !leap)) {
                return false;
            }
        }
        return true;
    }    
function matchPattern(value, mask) {
    return mask.exec(value);
}

function displayError(form, messages, field, allfields, s)
{
    var str = new Array();
    var str1 = new Array();
    var i = 0, j = 0;
    for (var x in allfields)
    {
        form[allfields[x][0]].className = form[allfields[x][0]].className + " border_grey";
        if (document.getElementById(allfields[x][0] + "_error") != null)
        {
            document.getElementById(allfields[x][0] + "_error").innerHTML = "";
            document.getElementById(allfields[x][0] + "_error").style.display = "none"
            for (y in messages)
            {
                if (allfields[x][0] == messages[y])
                {
                    if (s)
                    {
                        form[messages[y]].className = "border_red";
                        document.getElementById(messages[y] + "_error").innerHTML = allfields[x][1];
                        document.getElementById(messages[y] + "_error").className = "txt_red";
                        document.getElementById(messages[y] + "_error").style.display = ""
                    } else
                    {
                        form[messages[y]].className = form[messages[y]].className + " border_grey";
                    }
                }
            }
        }
        else
        {
            for (y in messages)
            {

                if (allfields[x][0] == messages[y])
                {
                    str[i++] = allfields[x][1];
                    str1[j++] = allfields[x][0];
                    form[allfields[x][0]].style.border = "thin solid rgb(208, 84, 47)";
                    //form[allfields[x][0]].focus();
                    // break;
                }
                else
                {
                    form[allfields[x][0]].style.border = "none solid rgb(208, 84, 47)";
                }
            }
        }
    }
    if (str.length > 0)
        alert(str.join('\n'));



    /* BootstrapDialog.show({
     title: 'Message',
     message: str.join('\n'),
     buttons: [{
     id: 'btn-ok',
     // icon: 'glyphicon glyphicon-check',       
     label: 'OK',
     cssClass: 'btn-primary',
     // autospin: true,
     action: function (dialogRef) {
     dialogRef.close();
     }
     }]
     });*/


    if (str1.length > 0)
        form[str1[0]].focus();
    $("select").select2();

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
    
    
    
    
    
    //alert(messages.join('\n'));
}


function ictcFormBean_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
         values[j++]=new Array('property(MOTHER_TYPE_CASE)', 'Type of Case Required.', new Function ('varName', ' return this[varName];'));
          //values[j++]=new Array('property(MOTHER_DATE_OF_POST_TEST_COUNSELLING)', 'Type of Case.', new Function ('varName', ' return this[varName];'));
          values[j++]=new Array('property(MOTHER_DATE_OF_ANC_REGISTRATION_AT_ANC_CLINIC)', 'Date of ANC registration at ANC Clinic Required.', new Function ('varName', ' return this[varName];'));
          values[j++]=new Array('property(MOTHER_DATE_OF_FIRST_VISIT_TO_ICTC_DURING_THE_CURRENT_PREGNANCY)', 'Date of first visit to ICTC during the current pregnancy Required.', new Function ('varName', ' return this[varName];'));
        //  values[j++]=new Array('property(MOTHER_MCTC_ID)', 'Mother Child Tracking System (MCTS) ID Required.', new Function ('varName', ' return this[varName];'));
          values[j++]=new Array('property(MOTHER_MARITAL_STATUS)', 'Marital status Required.', new Function ('varName', ' return this[varName];'));
          values[j++]=new Array('property(MOTHER_MOBILE)', 'Mobile Number Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_GEST_AGE)', 'Gestational Age Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_AGE)', 'Mother Age Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_ADHAR_NO)', 'Adhar No Required.', new Function ('varName', ' return this[varName];'));
         values[j++]=new Array('property(MOTHER_MOTHER_NAME)', 'Mother Name  Required.', new Function ('varName', ' return this[varName];'));
       
        values[j++]=new Array('property(MOTHER_LMP_DATE)', 'Last Menstrual Period(LMP) Date Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(DELIVERY_EXPECTED_DATE)', 'Expected Date of  Delivery (EDD) Required.', new Function ('varName', ' return this[varName];'));
      //  values[j++]=new Array('property(MOTHER_AGE)', 'Age of the AN/DIL/PN Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_ORDER_PREGNANCY)', 'Order of Pregnancy Required.', new Function ('varName', ' return this[varName];'));
       values[j++]=new Array('property(MOTHER_EDUCATION)', 'Education of AN/DIL/PN Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_OCCUPATION)', 'Occupation Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_FATHER_NAME)', 'Name of the Father of the AN/PN Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_FATHER_STATECODE)', 'Father State Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_FATHER_DISTCODE)', 'Father District Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_FATHER_BLOCK)', 'Father Block Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_FATHER_STREET)', 'Father Street Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(MOTHER_FATHER_VILLAGE)', 'Father Village Required.', new Function ('varName', ' return this[varName];'));
       values[j++]=new Array('property(MOTHER_FATHER_PINCODE)', 'Father Pincode Required.', new Function ('varName', ' return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }
function ictcFormBean_mask(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
       values[j++]=new Array('property(MOTHER_MOTHER_NAME)', 'Mother Name is Invalid ', new Function ('varName', 'this.mask=/^[a-zA-Z\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(MOTHER_ADHAR_NO)', 'Aadhar No. is Invalid ', new Function ('varName', 'this.mask=/^[0-9]{12}$/; return this[varName];'));
       values[j++]=new Array('property(MOTHER_MOBILE)', 'Mobile No. is Invalid ', new Function ('varName', 'this.mask=/^[0-9]{10}$/; return this[varName];'));
       values[j++]=new Array('property(MOTHER_AGE)', 'Invalid Age! Sholud be between 15 to 49', new Function ('varName', 'this.mask=/^(1[5-9]|[2-4][0-9])$/; return this[varName];'));
       values[j++]=new Array('property(MOTHER_GEST_AGE)', 'Invalid Gestrinal Age in Weeks! Sholud be between 6 to 40', new Function ('varName', 'this.mask=/^([6-9]|1[0-9]|[2-3][0-9]|40)$/; return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}//alert("   "+"= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', '"+values[i1][2]+"');");
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', "+values[i1][2]+");");
            //alert(this.a0);
        }
    }
    
    
    function validateForm(form)
    {
        if(validateRequired(form,'ALL')&&validateMask(form,'ALL'))
        { 
            //alert("name="+form.name)

            var val=confirm("Are you Sure you want to Submit the application ");
            if(val==true)
                {
                 var val1= confirm("Confirm the Data Entered is Correct , Click on Ok button ");
                 if(val1==true)
                  return true;
                  else return false;
                }
            else return false;
        }
        else return false;
    }