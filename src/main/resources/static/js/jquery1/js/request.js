

function trim(str){
            return str.replace(/^\s*|\s*$/g,"");
     }


function getAjaxRequest()
	{
var openRequest;
try {
openRequest = new XMLHttpRequest();
return openRequest;
}
catch (error) {
try {
openRequest = new ActiveXObject("Microsoft.XMLHTTP");
return openRequest;
}
catch (error)
	{
if(isDebugOn)
displayDebugError("Error crea");
	}

}
	}


//======================================================= request Object ==========================================



var http=getXMLHTTPRequest();
function getXMLHTTPRequest()
{
    var req = false;
    try
    {
        req = new XMLHttpRequest(); // e.g. Firefox
    //alert("hi"+req)
    }
    catch(err1)
    {

        try
        {
            req = new ActiveXObject("Msxml2.XMLHTTP");
        // some versions IE
        }
        catch(err2)
        {
            try
            {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            // some versions IE
            }
            catch(err3)
            {
                req = false;
            }
        }
    }
    return req;
}

//======================================= Eduational Year ==========================================
function getSelYear()
   {
     var url = "./ajaxyear.jsp?param="; 
 //    alert("hello");
    var sscyear= document.forms[0].sscyear.value;
       http.open("GET", url + escape(sscyear), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setSelYear;
    http.send(null);
   }
   function setSelYear()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
	if(results == "")
	{
	}else{
	//alert("calling---------");

            document.forms[0].interyear.length = 0;
            var oOption1 = document.createElement("OPTION");
            oOption1.text=trim("-  -Year-  -");
            oOption1.value=trim("");
            document.forms[0].interyear.options.add(oOption1);

            var j=0;
            var course=document.forms[0].interyear;
            for(var i=0;i<results.length-1;i++)
            {
            results1=results[i].split(";");
            for(var j=0;j<results1.length-1;j++)
            {
            var oOption = document.createElement("OPTION");
            oOption.text=trim(results1[1]);
            oOption.value=trim(results1[0]);
            document.forms[0].interyear.options.add(oOption);

            }
            }
       }
	}

   }
            function getSelYear1()
           
           {
                 var url = "./ajaxyear.jsp?param="; 
                //   alert("hello");
                var interyear= document.forms[0].interyear.value;
                http.open("GET", url + escape(interyear), true);
                http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                http.onreadystatechange = setSelYear1;
                http.send(null);
                }
                function setSelYear1()
                {

                //alert(">>set>>");
                if (http.readyState == 4) {

                results = http.responseText.split("$");

                if(results == "")
                {
                }else{
                document.forms[0].gnmyear.length = 0;
                var oOption1 = document.createElement("OPTION");
                oOption1.text=trim("-  -Year-  -");
                oOption1.value=trim("");
                document.forms[0].gnmyear.options.add(oOption1);

                var j=0;
                var course=document.forms[0].gnmyear;
                for(var i=0;i<results.length-1;i++)
                {
                results1=results[i].split(";");
                for(var j=0;j<results1.length-1;j++)
                {
                var oOption = document.createElement("OPTION");
                oOption.text=trim(results1[1]);
                oOption.value=trim(results1[0]);
                document.forms[0].gnmyear.options.add(oOption);

                }
      }
}
}
}





//======================================= distic Details ==========================================




function getStateDetails()
{
   //alert("hiiiii");
    var url = "ajaxState.jsp?param="; // The server-side script
    var statecode= Contact.statecode.value;
   // alert(statecode);
    http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setStateDetails;
    http.send(null);
}
function setStateDetails()
{


    if (http.readyState == 4) {

        results = http.responseText.split("$");

        if(results == "")
        {
        //alert("No course exists with this training type");
        }else{

            // if(document.getElementById("distcode").options.length!=1)
            //{
            document.forms[0].distcode.options.length = 0;
            //}
            var oOption1 = document.createElement("OPTION");
            oOption1.text=("- - - - - - select - - - - - - -");
            oOption1.value=("");
            document.forms[0].distcode.options.add(oOption1);

            var j=0;
            var course=document.forms[0].distcode;
            for(var i=0;i<results.length-1;i++)
            {
                results1=results[i].split(";");
                for(var j=0;j<results1.length-1;j++)
                {
                    var oOption = document.createElement("OPTION");
                    oOption.text=(results1[1]);
                    oOption.value=(results1[0]);
                    document.forms[0].distcode.options.add(oOption);

                }
            }


        }
    }

}





function getDistDetails(v,statecode)
{

    var distcode= v.value;
    //alert("in Ajax"+distcode);
    var state=statecode.value;
    //alert(param);
    var url = "ajaxDist.jsp?param="; // The server-side script
   // var statecode= SMSForm.distcode.value;
    var param=state;
    http.open("GET", url + escape(param), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetails;
    http.send(null);
}
function setDistDetails()
{


    if (http.readyState == 4) {

        results = http.responseText.split("$");

        if(results == "")
        {
        //alert("No course exists with this training type");
        }else{

            // if(document.getElementById("mandalcode").options.length!=1)
            //{
            document.forms[0].nativedistrict.options.length = 0;
            //}
            var oOption1 = document.createElement("OPTION");
            oOption1.text=("- - - - - - select - - - - - - -");
            oOption1.value=("");
            document.forms[0].nativedistrict.options.add(oOption1);

            var j=0;
            var course=document.forms[0].nativedistrict;
            for(var i=0;i<results.length-1;i++)
            {
                results1=results[i].split(";");
                for(var j=0;j<results1.length-1;j++)
                {
                    var oOption = document.createElement("OPTION");
                    oOption.text=(results1[1]);
                    oOption.value=(results1[0]);
                    document.forms[0].nativedistrict.options.add(oOption);

                }
            }


        }
    }

}




function getDistDetails1(v,statecode)
{

    var distcode= v.value;
    //alert("in Ajax"+distcode);
    var state=statecode.value;
    //alert(param);
    var url = "ajaxDist.jsp?param="; // The server-side script
   // var statecode= SMSForm.distcode.value;
    var param=state;
    http.open("GET", url + escape(param), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetails1;
    http.send(null);
}
function setDistDetails1()
{


    if (http.readyState == 4) {

        results = http.responseText.split("$");

        if(results == "")
        {
        //alert("No course exists with this training type");
        }else{

            // if(document.getElementById("mandalcode").options.length!=1)
            //{
            document.forms[0].district.options.length = 0;
            //}
            var oOption1 = document.createElement("OPTION");
            oOption1.text=("- - - - - - select - - - - - - -");
            oOption1.value=("");
            document.forms[0].district.options.add(oOption1);

            var j=0;
            var course=document.forms[0].district;
            for(var i=0;i<results.length-1;i++)
            {
                results1=results[i].split(";");
                for(var j=0;j<results1.length-1;j++)
                {
                    var oOption = document.createElement("OPTION");
                    oOption.text=(results1[1]);
                    oOption.value=(results1[0]);
                    document.forms[0].district.options.add(oOption);

                }
            }


        }
    }

}




function getDistDetails2(v,statecode)
{

    var distcode= v.value;
    //alert("in Ajax"+distcode);
    var state=statecode.value;
    //alert(param);
    var url = "ajaxDist.jsp?param="; // The server-side script
   // var statecode= SMSForm.distcode.value;
    var param=state;
    http.open("GET", url + escape(param), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetails2;
    http.send(null);
}
function getDistDetails3(v,statecode)
{
    
    var distcode= v.value;
    //alert("in Ajax"+distcode);
    var state=statecode.value;
    //alert(param);
    var url = "ajaxDist.jsp?param="; // The server-side script
   // var statecode= SMSForm.distcode.value;
    var param=state;
    http.open("GET", url + escape(param), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetails3;
    http.send(null);
}

function setDistDetails3()
{


    if (http.readyState == 4) {

        results = http.responseText.split("$");
 // alert("results"+results);
        if(results == "")
        {
        //alert("No course exists with this training type");
        }else{

            // if(document.getElementById("mandalcode").options.length!=1)
            //{
            document.forms[0].districtpre.options.length = 0;
            //}
            var oOption1 = document.createElement("OPTION");
            oOption1.text=("- - - - - - select - - - - - - -");
            oOption1.value=("");
            document.forms[0].districtpre.options.add(oOption1);

            var j=0;
            var course=document.forms[0].districtpre;
            for(var i=0;i<results.length-1;i++)
            {
                results1=results[i].split(";");
                for(var j=0;j<results1.length-1;j++)
                {
                    var oOption = document.createElement("OPTION");
                    oOption.text=(results1[1]);
                    oOption.value=(results1[0]);
                    document.forms[0].districtpre.options.add(oOption);

                }
            }


        }
    }

}

function setDistDetails2()
{


    if (http.readyState == 4) {

        results = http.responseText.split("$");

        if(results == "")
        {
        //alert("No course exists with this training type");
        }else{

            // if(document.getElementById("mandalcode").options.length!=1)
            //{
            document.forms[0].districtp.options.length = 0;
            //}
            var oOption1 = document.createElement("OPTION");
            oOption1.text=("- - - - - - select - - - - - - -");
            oOption1.value=("");
            document.forms[0].districtp.options.add(oOption1);

            var j=0;
            var course=document.forms[0].districtp;
            for(var i=0;i<results.length-1;i++)
            {
                results1=results[i].split(";");
                for(var j=0;j<results1.length-1;j++)
                {
                    var oOption = document.createElement("OPTION");
                    oOption.text=(results1[1]);
                    oOption.value=(results1[0]);
                    document.forms[0].districtp.options.add(oOption);

                }
            }


        }
    }

}




















