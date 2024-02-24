function validateMessages(form,A) {
    A=A?A:"ALL";
    var i=0;
    var formName = form.getAttributeNode("id");
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
	
    var formName = form.getAttributeNode("id");
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
    var formName = form.getAttributeNode("id"); 
		
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
//-----------------------------------------------------------------------
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
//-----------------------------------------------------------------------
function personalform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(personal_firstname)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_nativename)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_lastname)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_othernameused)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(personal_middlename)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_othernameList)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_sex)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_maritalstatus)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_dob)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_city)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(personal_state)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(personal_country)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(personal_nationality)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_othnationality)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
  //  eval("this.a" + (j++) + "= new Array('property(personal_passportstatus)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(personal_passportnumber)', 'Select.', new Function ('varName', ' return this[varName];'));");
  //  eval("this.a" + (j++) + "= new Array('property(personal_natidnum)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
 //   eval("this.a" + (j++) + "= new Array('property(personal_usnum)', 'Maximum 25 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(personal_ustaxnum)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
          
    }
function projectform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(project_projectname)', 'Project Name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(project_version)', 'Version Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(project_pdate)', 'Date Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(project_preparedby)', 'Prepared By Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(project_address)', 'Address Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(project_state)', 'Sate Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(project_city)', 'City Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(personal_state)', 'State Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(project_zipcode)', 'Zip Code Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(personal_city)', 'City Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(personal_landmark)', 'LandMark Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(personal_pin)', 'Pin Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(personal_mobile)', 'Mobile Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(personal_othnationality)', 'Other Nationality Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(personal_passportstatus)', 'passportstatus Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(personal_passportnumber)', 'passportnumber Required.', new Function ('varName', ' return this[varName];'));
      //  values[j++]=new Array('property(personal_natidnum)', 'natidnum Required.', new Function ('varName', ' return this[varName];'));
      //  values[j++]=new Array('property(personal_usnum)', 'usnum Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(personal_ustaxnum)', 'US TaxNo Required.', new Function ('varName', ' return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }
function projectform_mask(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
       values[j++]=new Array('property(project_projectname)', 'Project Name Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(project_version)', 'Version Invalid Input', new Function ('varName', 'this.mask=/^[0-9a-zA-Z\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(project_pdate)', 'Date Invalid Input', new Function ('varName', 'this.mask=/^[0-9-\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(project_preparedby)', 'Prepared By Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(project_address)', 'Address Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z0-9.-\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(project_state)', 'Sate Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(project_city)', 'City Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z.\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(project_zipcode)', 'Zip Code Invalid Input', new Function ('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       
       //values[j++]=new Array('property(personal_hmaddr)', 'Door No/Street Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z0-9.-\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_state)', 'State Invalid Input', new Function ('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_district)', 'District Invalid Input', new Function ('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_city)', 'City Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_landmark)', 'LandMark Invalid Input', new Function('varName', 'this.mask=/^[a-zA-Z0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_pin)', 'Pin Invalid Input', new Function('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_mobile)', 'Mobile Invalid Input', new Function('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_email)', 'Email Invalid Input', new Function('varName', 'this.mask=/^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[a-zA-Z]{2,4}$/;return this[varName];'));
       //values[j++]=new Array('property(personal_passport)', 'PassPort Invalid Input', new Function('varName', 'this.mask=/^[A-Za-z0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_aadhar)', 'Aadhar Invalid Input', new Function('varName', 'this.mask=/^[A-Za-z0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_pancard)', 'Pan Card Invalid Input', new Function('varName', 'this.mask=/^[A-Za-z0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_voterid)', 'Voter Id Invalid Input', new Function('varName', 'this.mask=/^[A-Za-z0-9\\s]*$/; return this[varName];'));
       //values[j++]=new Array('property(personal_drivingno)', 'Driving Licence Invalid Input', new Function('varName', 'this.mask=/^[A-Za-z0-9\\s]*$/; return this[varName];'));
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}//alert("   "+"= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', '"+values[i1][2]+"');");
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', "+values[i1][2]+");");
            //alert(this.a0);
        }
    }
/*
 *  Repeat following to all forms
 *      <form id>_required()
 *      <form id>_messages()
 *      <form id>_mask()
 * 
 * 
 */
// Education

function educationform_messages(A)
    {
        var j=0;
    //eval("this.a" + (j++) + "= new Array('property(contact_hm_address)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_pincode)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_city)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_country)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_state)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_mail_address)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_smhm_address)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_smcity)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(contact_smcountry)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(contact_smstate)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_hm_phno)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_cellph)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_wrk_phno)', 'Select.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_email)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    //eval("this.a" + (j++) + "= new Array('property(contact_hm_faxno)', 'Select.', new Function ('varName', ' return this[varName];'));");
         
    }
    
function educationform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(education_qualification)', 'Choose Course Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(education_yrpass)', 'Year of Passing Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(education_xthyrpass)', 'Xth Class Year of Passing Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(education_xthboard)', 'Xth Class Board Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(contact_state)', 'State Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(contact_mail_address)', 'mail Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(contact_smhm_address)', 'same hm address Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(contact_smcity)', 'same city Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(contact_smcountry)', 'same country Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(contact_smstate)', 'same state Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(contact_hm_phno)', 'Phone Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(contact_cellph)', 'Cell no Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(contact_wrk_phno)', 'Work phone no Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(contact_email)', 'email Required.', new Function ('varName', ' return this[varName];'));
        //values[j++]=new Array('property(contact_hm_faxno)', 'Faxno Required.', new Function ('varName', ' return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }
    
    function educationform_mask(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
       values[j++]=new Array('property(education_qualification)', 'Choose Course Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(education_yrpass)', 'Year of Passing Invalid Input', new Function ('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(education_gdstate)', 'Graduation State Invalid Input', new Function ('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(education_university)', 'University Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z.,-\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(education_board)', 'Board Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z.,\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(education_xthyrpass)', 'Xth Year of Passing Invalid Input', new Function ('varName', 'this.mask=/^[0-9\\s]*$/; return this[varName];'));
       values[j++]=new Array('property(education_xthboard)', 'Xth Board Invalid Input', new Function ('varName', 'this.mask=/^[a-zA-Z.,\\s]*$/; return this[varName];'));
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}//alert("   "+"= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', '"+values[i1][2]+"');");
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', "+values[i1][2]+");");
            //alert(this.a0);
        }
    }
    
function passportform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(passport_ptype)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_couissue)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_couhissue)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_passnum)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_city_issue)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_issue_date)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_p_bknum)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_state_issue)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_expdate)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(passport_p_lost)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(passport_lopassnum)', 'Select.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(passport_locouissue)', 'Select.', new Function ('varName', ' return this[varName];'));");
         
    }
function passportform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(passport_ptype)', 'passport type Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_couissue)', ' country issue Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_couhissue)', 'country auth issue Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_passnum)', 'passport num Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_city_issue)', 'city issued Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_issue_date)', 'issued date Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_p_bknum)', 'passport book no Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_state_issue)', 'state issue Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_expdate)', 'Expiration date Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(passport_p_lost)', 'passport lost Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(passport_lopassnum)', 'passport_lopassnum Required.', new Function ('varName', ' return this[varName];'));
       // values[j++]=new Array('property(passport_locouissue)', 'passport_locouissue Required.', new Function ('varName', ' return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }
    
function travelform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(travel_applicant)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_purvisit)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_intend_dob)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_intend_length)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_puryourvisit)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_intenddobarrival)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_intendstay)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_hmaddress)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_pincode)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_city)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_country)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_state)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_pay_trip)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_surname)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_givenname)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_relation)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_telephone)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_organization)', 'Maximum 25 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_orgphone)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_relationtou)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_paytrip)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travel_hmaddressper)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
  //  eval("this.a" + (j++) + "= new Array('property(travel_pincodeper)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(travel_cityper)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(travel_countryper)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
   // eval("this.a" + (j++) + "= new Array('property(travel_stateper)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
          
    }
function travelform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(travel_applicant)', 'Applicant Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_purvisit)', 'purpose visit Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_intend_dob)', 'Intend dob Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_intend_length)', 'Intend length Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_puryourvisit)', 'purpose your visit Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_intenddobarrival)', 'Intend dob arrival Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_intendstay)', 'Intend stay Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_hmaddress)', 'home maddress Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_pincode)', 'Pincode Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_city)', 'City Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_country)', 'Country Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_state)', 'State Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_pay_trip)', 'pay trip Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_surname)', 'Surname Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_givenname)', 'Given name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_relation)', 'Relation Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_telephone)', 'Telephone Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_organization)', 'Organization Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_orgphone)', 'Orgphone Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_relationtou)', 'Relation to u Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_paytrip)', 'paytrip Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travel_hmaddressper)', 'home address person Required.', new Function ('varName', ' return this[varName];'));
      //  values[j++]=new Array('property(travel_pincodeper)', 'travel_pincodeper Required.', new Function ('varName', ' return this[varName];'));
      //  values[j++]=new Array('property(travel_cityper)', 'travel_cityper Required.', new Function ('varName', ' return this[varName];'));
      //  values[j++]=new Array('property(travel_countryper)', 'travel_countryper Required.', new Function ('varName', ' return this[varName];'));
      //  values[j++]=new Array('property(travel_stateper)', 'travel_stateper Required.', new Function ('varName', ' return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }
    
function travelcontform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(travelcont_oth_person)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travelcont_group)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travelcont_inus)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(travelcont_refused)', 'Select.', new Function ('varName', ' return this[varName];'));");
     
    }
function travelcontform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(travelcont_oth_person)', 'other person Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travelcont_group)', 'Group Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travelcont_inus)', 'In US Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(travelcont_refused)', 'Refused Required.', new Function ('varName', ' return this[varName];'));
     
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }    
 
function uscontactform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(uscontact_cont_person)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_orgname)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_relation)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_address)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_pincode)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_email)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_city)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_country)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_state)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(uscontact_phone)', 'Select.', new Function ('varName', ' return this[varName];'));");
      
    }
function uscontactform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(uscontact_cont_person)', 'contact person Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_orgname)', 'Orgname Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_relation)', 'Relation Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_address)', 'Address Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_pincode)', 'Pincode Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_email)', 'Email Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_city)', 'City Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_country)', 'Country Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_state)', 'State Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(uscontact_phone)', 'Phone Required.', new Function ('varName', ' return this[varName];'));
       
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    } 
    
function familyform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(family_fsurname)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_dob)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_inus)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_m_name)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_m_dob)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_finus)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_imrelative)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spouname)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spoudob)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spoucity)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spoucountry)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spounationality)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spouaddress)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spaddress)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_sppincode)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spcity)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spcountry)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(family_spstate)', 'Maximum 25 characters.', new Function ('varName', ' return this[varName];'));");
          
    }
function familyform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(family_fsurname)', 'Father surname Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_dob)', 'Dob Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_inus)', 'In US Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_m_name)', 'Mother name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_m_dob)', 'Dob Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_finus)', 'In US Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_imrelative)', 'relative Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spouname)', 'spouse name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spoudob)', 'spouce dob Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spoucity)', 'spouse city Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spoucountry)', 'spouse country Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spounationality)', 'spouse nationality Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spouaddress)', 'spouse address Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spaddress)', 'spouse address Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_sppincode)', 'pincode Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spcity)', 'city Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spcountry)', 'country Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(family_spstate)', 'state Required.', new Function ('varName', ' return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }  
    
function presentworkform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(presentwork_occupation)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_preschname)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_address)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_pincode)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_city)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_country)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_state)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_monthsal)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(presentwork_duties)', 'Select.', new Function ('varName', ' return this[varName];'));");
         
    }
function presentworkform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(presentwork_occupation)', 'occupation Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_preschname)', 'school name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_address)', 'address Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_pincode)', 'pincode Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_city)', 'city Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_country)', 'country Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_state)', 'state Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_monthsal)', 'monthly salary Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(presentwork_duties)', 'Duties Required.', new Function ('varName', ' return this[varName];'));
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }  
    
function previousworkform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empname)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empaddress)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_emppin)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empcity)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empcountry)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empstate)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_emptelephn)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empjobtitle)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empattfrom)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_empattto)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_supsurname)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_supgivname)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_inus)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_instname)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_attfrom)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_attto)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_instaddress)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(previoustwork_coustudy)', 'Select.', new Function ('varName', ' return this[varName];'));");
         
    }
function previousworkform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(previoustwork_empname)', 'emp name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empaddress)', 'address Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_emppin)', 'pincode Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empcity)', 'city Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empcountry)', 'country Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empstate)', 'state Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_emptelephn)', 'phone Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empjobtitle)', 'Job Title sal Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empattfrom)', 'from date Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empattto)', 'to date Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_supsurname)', 'Surname Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_empduties)', 'Duties Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_supgivname)', 'Given name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_instname)', 'Institutue name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_attfrom)', 'from date Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_attto)', 'To date name Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_instaddress)', 'Institutue address Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(previoustwork_coustudy)', 'course Required.', new Function ('varName', ' return this[varName];'));
        
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }    
    
function additionalorkform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(additionalwork_tribe)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(additionalwork_travel)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(additionalwork_skills)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(additionalwork_military)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(additionalwork_unit)', 'Select.', new Function ('varName', ' return this[varName];'));");
         
    }
function additionalorkform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(additionalwork_tribe)', 'Tribe Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(additionalwork_travel)', 'Travel Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(additionalwork_skills)', 'Skills Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(additionalwork_military)', 'Military Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(additionalwork_unit)', 'Unit Required.', new Function ('varName', ' return this[varName];'));
        
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }        
    
function medicalform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(medical_chancroid)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_gonorrhea)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_granuloma)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_infectious)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_lymphogranuloma)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_venereum)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_stage)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_active)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_mental)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(medical_drugAbuser)', 'Select.', new Function ('varName', ' return this[varName];'));");
        
    }
function medicalform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(medical_chancroid)', 'Chancroid Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_gonorrhea)', 'Gonorrhea Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_granuloma)', 'Granuloma Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_infectious)', 'Infectious Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_lymphogranuloma)', 'lymphogranuloma Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_venereum)', 'venereum Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_stage)', 'Syphilis Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_active)', 'Tuberculosis Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_mental)', 'Mental Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(medical_drugAbuser)', 'DrugAbuser Required.', new Function ('varName', ' return this[varName];'));
        
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }    
    
/* function criminalform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(criminal_arrested)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(criminal_conspiracy)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(criminal_prostitution)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(criminal_laundering)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(criminal_humanTrafficking)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(criminal_aided)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(criminal_spouse)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
         
    }
function criminalform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(criminal_arrested)', 'arrested Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(criminal_conspiracy)', 'conspiracy Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(criminal_prostitution)', 'prostitution Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(criminal_laundering)', 'laundering Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(criminal_humanTrafficking)', 'Human Trafficking Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(criminal_aided)', 'Aided Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(criminal_spouse)', 'spouse Required.', new Function ('varName', ' return this[varName];'));
        
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }  */
    
function securityform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(security_espionage)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_terrorist)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_financial)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_representative)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_genocide)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_torture)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_violence)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_childsoldiers)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_religiousfreedom)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_populationcontrols)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(security_coercive)', 'Select.', new Function ('varName', ' return this[varName];'));");
        
    }
function securityform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(security_espionage)', 'Espionage Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_terrorist)', 'Terrorist Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_financial)', 'Financial Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_representative)', 'Representative Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_genocide)', 'Genocide Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_torture)', 'Torture Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_violence)', 'Violence Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_childsoldiers)', 'Childsoldiers Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_religiousfreedom)', 'Religiousfreedom Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_populationcontrols)', 'Population controls Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(security_coercive)', 'Coercive Required.', new Function ('varName', ' return this[varName];'));
        
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }

/* function immigrationform_messages(A)
    {
        var j=0;
    eval("this.a" + (j++) + "= new Array('property(immigration_sought)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(immigration_custody)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(immigration_violation)', 'Maximum 16 characters.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(immigration_citizenship)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(immigration_application)', 'Select.', new Function ('varName', ' return this[varName];'));");
    eval("this.a" + (j++) + "= new Array('property(immigration_location)', 'Select.', new Function ('varName', ' return this[varName];'));");
        
    }
function immigrationform_required(A)
    {
        var j=0;
        A=A?A:"ALL";
        var values=new Array();
        values[j++]=new Array('property(immigration_sought)', 'Sought Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(immigration_custody)', 'Custody Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(immigration_violation)', 'Violation Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(immigration_citizenship)', 'Citizenship Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(immigration_application)', 'Application Required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(immigration_location)', 'Location Required.', new Function ('varName', ' return this[varName];'));
        
        
        for(var i1=0;i1<values.length;i1++)
        {
            if(A!='ALL')if(A!=values[i1][0]){continue;}
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }  */