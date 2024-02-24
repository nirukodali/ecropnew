
//======================================================= request Object ==========================================
var http=getXMLHTTPRequest();
/*
function getXMLHTTPRequest()
{
    var request_o;
    var browser = navigator.appName;
    
    if(browser == "Microsoft Internet Explorer")
    {
	//	alert("in ie"+XMLHttpRequest)
        // Create the object using MSIE's method 
        request_o = new ActiveXObject("Microsoft.XMLHTTP");
    }
    else
    {
		alert("in mozilla"+XMLHttpRequest);
        // Create the object using other browser's method 
        request_o = new XMLHttpRequest();
    }
	//alert(request_o)
    return request_o; //return the object
}

*/
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


//======================================= district Details ==========================================
function getDistDetails()
   {
      
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.AddressDetailsForm.state.value;
       http.open("GET", url + escape(statecode), true);
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
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{
               
			 document.AddressDetailsForm.district.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.AddressDetailsForm.district.options.add(oOption1);

	         var j=0;
			 var course=document.AddressDetailsForm.district;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.AddressDetailsForm.district.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }

	      
       }
	}

   }

   function getDistDetailsForP()
   {
       
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.AddressDetailsForm.pstate.value;
       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetailsForP;
    http.send(null);
   }
   function setDistDetailsForP()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.AddressDetailsForm.pdistrict.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.AddressDetailsForm.pdistrict.options.add(oOption1);

	         var j=0;
			 var course=document.AddressDetailsForm.pdistrict;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.AddressDetailsForm.pdistrict.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   
function getMandDetails()
   {
     var url = "./ajaxMand.jsp?param="; // The server-side script
    var statecode= document.AddressDetailsForm.state.value;
    var district= document.AddressDetailsForm.district.value;
       http.open("GET", url + escape(statecode+"-"+district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetails;
    http.send(null);
   }
   function setMandDetails()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.AddressDetailsForm.mandcode.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.AddressDetailsForm.mandcode.options.add(oOption1);

	         var j=0;
			 var course=document.AddressDetailsForm.mandcode;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.AddressDetailsForm.mandcode.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   function getMandDetails1()
   {
     var url = "./ajaxMand.jsp?param="; // The server-side script
    var statecode= document.AddressDetailsForm.pstate.value;
    var district= document.AddressDetailsForm.pdistrict.value;
       http.open("GET", url + escape(statecode+"-"+district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetails1;
    http.send(null);
   }
   function setMandDetails1()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.AddressDetailsForm.pmandcode.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.AddressDetailsForm.pmandcode.options.add(oOption1);

	         var j=0;
			 var course=document.AddressDetailsForm.pmandcode;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.AddressDetailsForm.pmandcode.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
   function getMandDetailsSchool1()
   {
       
     var url = "./ajaxMandSchool.jsp?param="; // The server-side script
    var district= document.SchoolEntryForm.dist1.value;
       http.open("GET", url + escape(district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetailsSchool1;
    http.send(null);
   }
   function setMandDetailsSchool1()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SchoolEntryForm.mand1.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SchoolEntryForm.mand1.options.add(oOption1);

	         var j=0;
			 var course=document.SchoolEntryForm.mand1;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SchoolEntryForm.mand1.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

function getMandDetailsSchool2()
   {
       
     var url = "./ajaxMandSchool.jsp?param="; // The server-side script
    var district= document.SchoolEntryForm.dist2.value;
       http.open("GET", url + escape(district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetailsSchool2;
    http.send(null);
   }
   function setMandDetailsSchool2()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SchoolEntryForm.mand2.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SchoolEntryForm.mand2.options.add(oOption1);

	         var j=0;
			 var course=document.SchoolEntryForm.mand2;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SchoolEntryForm.mand2.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   function getMandDetailsSchool3()
   {
      
     var url = "./ajaxMandSchool.jsp?param="; // The server-side script
    var district= document.SchoolEntryForm.dist3.value;
       http.open("GET", url + escape(district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetailsSchool3;
    http.send(null);
   }
   function setMandDetailsSchool3()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SchoolEntryForm.mand3.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SchoolEntryForm.mand3.options.add(oOption1);

	         var j=0;
			 var course=document.SchoolEntryForm.mand3;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SchoolEntryForm.mand3.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

function getMandDetailsSchool4()
   {
       
     var url = "./ajaxMandSchool.jsp?param="; // The server-side script
    var district= document.SchoolEntryForm.dist4.value;
       http.open("GET", url + escape(district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetailsSchool4;
    http.send(null);
   }
   function setMandDetailsSchool4()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SchoolEntryForm.mand4.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SchoolEntryForm.mand4.options.add(oOption1);

	         var j=0;
			 var course=document.SchoolEntryForm.mand4;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SchoolEntryForm.mand4.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   function getMandDetailsSchool5()
   {
      
     var url = "./ajaxMandSchool.jsp?param="; // The server-side script
    var district= document.SchoolEntryForm.dist5.value;
       http.open("GET", url + escape(district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetailsSchool5;
    http.send(null);
   }
   function setMandDetailsSchool5()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SchoolEntryForm.mand5.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SchoolEntryForm.mand5.options.add(oOption1);

	         var j=0;
			 var course=document.SchoolEntryForm.mand5;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SchoolEntryForm.mand5.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

function getMandDetailsSchool6()
   {
      
     var url = "./ajaxMandSchool.jsp?param="; // The server-side script
    var district= document.SchoolEntryForm.dist6.value;
       http.open("GET", url + escape(district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetailsSchool6;
    http.send(null);
   }
   function setMandDetailsSchool6()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SchoolEntryForm.mand6.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SchoolEntryForm.mand6.options.add(oOption1);

	         var j=0;
			 var course=document.SchoolEntryForm.mand6;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SchoolEntryForm.mand6.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

function getMandDetailsSchool7()
   {
      
     var url = "./ajaxMandSchool.jsp?param="; // The server-side script
    var district= document.SchoolEntryForm.dist7.value;
       http.open("GET", url + escape(district), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetailsSchool7;
    http.send(null);
   }
   function setMandDetailsSchool7()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SchoolEntryForm.mand7.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SchoolEntryForm.mand7.options.add(oOption1);

	         var j=0;
			 var course=document.SchoolEntryForm.mand7;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SchoolEntryForm.mand7.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }






function getVillDetails()
   {
     var url = "./ajaxVill.jsp?param="; // The server-side script
    var statecode= document.AddressDetailsForm.state.value;
    var district= document.AddressDetailsForm.district.value;
    var mandal= document.AddressDetailsForm.mandcode.value;
       http.open("GET", url + escape(statecode+"-"+district+"-"+mandal), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setVillDetails;
    http.send(null);
   }
   function setVillDetails()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.AddressDetailsForm.villcode.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.AddressDetailsForm.villcode.options.add(oOption1);

	         var j=0;
			 var course=document.AddressDetailsForm.villcode;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.AddressDetailsForm.villcode.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   function getVillDetails1()
   {
     var url = "./ajaxVill.jsp?param="; // The server-side script
    var statecode= document.AddressDetailsForm.pstate.value;
    var district= document.AddressDetailsForm.pdistrict.value;
    var mandal= document.AddressDetailsForm.pmandcode.value;
       http.open("GET", url + escape(statecode+"-"+district+"-"+mandal), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setVillDetails1;
    http.send(null);
   }
   function setVillDetails1()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.AddressDetailsForm.pvillcode.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.AddressDetailsForm.pvillcode.options.add(oOption1);

	         var j=0;
			 var course=document.AddressDetailsForm.pvillcode;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.AddressDetailsForm.pvillcode.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
function getGrade()
   {
     var url = "./ajaxGrade.jsp?param="; // The server-side script
    var statecode= document.forms[0].catgname.value;

       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setGrade;
    http.send(null);
   }
   function setGrade()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].gradename.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].gradename.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].gradename;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].gradename.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
function getCategory()
   {
     var url = "./ajaxCourse.jsp?param="; // The server-side script
    var statecode= document.GraduationForm.catgname.value;

       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setCategory;
    http.send(null);
   }
   function setCategory()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.GraduationForm.coursename.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.GraduationForm.coursename.options.add(oOption1);

	         var j=0;
			 var course=document.GraduationForm.coursename;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.GraduationForm.coursename.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
   
   function getPostCategory()
   {
     var url = "./ajaxPostCourse.jsp?param="; // The server-side script
    var statecode= document.PostGraduationForm.catgname.value;

       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setPostCategory;
    http.send(null);
   }
   function setPostCategory()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.PostGraduationForm.coursename.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.PostGraduationForm.coursename.options.add(oOption1);

	         var j=0;
			 var course=document.PostGraduationForm.coursename;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.PostGraduationForm.coursename.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   function getPGDCategory()
   {
     var url = "./ajaxDiplomaCourse.jsp?param="; // The server-side script
    var statecode= document.PGDiplomaForm.catgname.value;

       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setPGDCategory;
    http.send(null);
   }
   function setPGDCategory()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.PGDiplomaForm.coursename.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.PGDiplomaForm.coursename.options.add(oOption1);

	         var j=0;
			 var course=document.PGDiplomaForm.coursename;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.PGDiplomaForm.coursename.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }


function getInsttype()
   {
     var url = "./ajaxInsttype.jsp?param="; // The server-side script
    var statecode= document.forms[0].depthead.value;
       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setInsttype;
    http.send(null);
   }
   function setInsttype()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].institutetype.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].institutetype.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].institutetype;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[0]);
                   oOption.value=trim(results1[1]);
                   document.forms[0].institutetype.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
function getInstname()
   {
     var url = "./ajaxInstname.jsp?param="; // The server-side script
    var dist= document.forms[0].district.value;
     var dept= document.forms[0].depthead.value;
      var inst= document.forms[0].institutetype.value;
       http.open("GET", url + escape(dist+"-"+dept+"-"+inst), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setInstname;
    http.send(null);
   }
   function setInstname()
   {

     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].institutename.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].institutename.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].institutename;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].institutename.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
function getCatgname()
   {
     var url = "./ajaxCatgname.jsp?param="; // The server-side script
    var service= document.forms[0].service.value;

       http.open("GET", url + escape(service), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setCatgname;
    http.send(null);
   }
   function setCatgname()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].category.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].category.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].category;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].category.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
function getDistDetails1()
   {
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.forms[0].stateperm.value;
       http.open("GET", url + escape(statecode), true);
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
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].districtperm.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].districtperm.options.add(oOption1);
                   var dist=document.forms[0].districtaddr.value;

	         var j=0;
			 var course=document.forms[0].districtperm;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].districtperm.options.add(oOption);

				}
                                 document.forms[0].districtperm.value=dist;
			   }


       }
	}

   }
function getDistDetails2()
   {
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.forms[0].stateexch.value;
       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetails2;
    http.send(null);
   }
   function setDistDetails2()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].districtexch.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].districtexch.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].districtexch;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].districtexch.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
function getDistDetails3()
   {
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.forms[0].centerstate.value;
       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetails3;
    http.send(null);
   }
   function setDistDetails3()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].centerdist.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].centerdist.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].centerdist;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].centerdist.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
   function getPostDetails()
   {
     var url = "./ajaxPost.jsp?param="; // The server-side script
    var coursecode= document.forms[0].advt.value;
    http.open("GET", url + escape(coursecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setPostDetails;
    http.send(null);
   }
   function setPostDetails()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	 
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.forms[0].posts.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");

                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].posts.options.add(oOption1);

	         var j=0;

		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
                
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   
                   oOption.value=trim(results1[0]);
                   document.forms[0].posts.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
   function getServiceDetails(v)
   {

   // alert(""+v.value);
    var url = "./ajaxItem.jsp?param="; // The server-side script
    //alert(v);
    var statecode= v.value;
    //alert("hi"+statecode);
    //alert(document.forms[0].it[item1].value);
    //alert(document.getElementById("item"));
    http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   
    http.onreadystatechange = setCategoryDetails;
    http.send(null);
   }


   function setCategoryDetails()
   {
//alert("results"+results);

     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
    // alert("No course exists with this training type");
	}else{

		 // if(document.getElementById("districtcode").options.length!=1)
		//{
			document.getElementById("item").options.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=("- - - - - - select - - - - - - -");
                   oOption1.value=("0");
                   document.getElementById("item").options.add(oOption1);

	         var j=0;
			 var course=document.getElementById("item");
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{


			       var oOption = document.createElement("OPTION");
                               oOption.text=trim(results1[1]);
                               oOption.value=trim(results1[0]);
                               document.getElementById("item").options.add(oOption);


				}
			   }


       }
	}

   }



/** Update Service Details **/
function getServiceDetailsUpdate(v,setvar)
   {

   // alert(""+v.value);
    var url = "./ajaxItem.jsp?param="; // The server-side script
    //alert(v);
    var statecode= v.value;
    //alert("hi"+statecode);
    //alert(document.forms[0].it[item1].value);
    //alert(document.getElementById("item"));
    http.open("GET", url + escape(statecode+"-"+setvar), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    http.onreadystatechange = setCategoryDetailsUpdate;
    http.send(null);
   }


   function setCategoryDetailsUpdate()
   {

    
       //alert(http.responseText);

        
        
     if (http.readyState == 4) {
         
         
      results=http.responseText.split("+");

      if(results.length==2)
          {
           setvar=trim(results[0]);
           dbvalue=results[1];
           results = dbvalue.split("$");


	if(results == "")
	{
    // alert("No course exists with this training type");
	}else{

         		 // if(document.getElementById("districtcode").options.length!=1)
		//{
			document.getElementById(setvar).options.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=("- - - - - - select - - - - - - -");
                   oOption1.value=("0");
                   document.getElementById(setvar).options.add(oOption1);

	                  var j=0;
			 var course=document.getElementById(setvar);
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{


			       var oOption = document.createElement("OPTION");
                               oOption.text=trim(results1[1]);
                               oOption.value=trim(results1[0]);
                               document.getElementById(setvar).options.add(oOption);


				}
			   }


       }
	}
          }
          
   }




/*

   function getServiceDetails1(v)
   {

    alert(""+v.value);
    var url = "./ajaxItem.jsp?param="; // The server-side script
    //alert(v);
    var statecode= v.value;
    //alert("hi"+statecode);
    //alert(document.forms[0].it[item1].value);
    //alert(document.getElementById("item"));
    http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    http.onreadystatechange = setCategoryDetails1;
    http.send(null);
   }
   function setCategoryDetails1()
   {
//alert("results");

     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
    // alert("No course exists with this training type");
	}else{

		 // if(document.getElementById("districtcode").options.length!=1)
		//{
		alert("hello1");
                document.ServiceEntryForm.catName.options.length = 0;
		//}
                alert("hello");
                
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=("- - - - - - select - - - - - - -");
                   oOption1.value=("0");
                   document.ServiceEntryForm.catName.options.add(oOption1);

	         var j=0;
			 var course=document.ServiceEntryForm.catName;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
alert("helloooooooo");

			       var oOption = document.createElement("OPTION");
                               oOption.text=trim(results1[1]);
                               oOption.value=trim(results1[0]);
                               document.ServiceEntryForm.catName.options.add(oOption);


				}
			   }


       }
	}

   }

*/

 function getCat(obj,val)
   {
       var dest=document.getElementById("item"+val);
       //var url = "./ajaxDist.jsp?param="; // The server-side script
       var url = "./ajaxItem.jsp?param=";
    var statecode= obj.value;
     var postData="param="+ escape(statecode);
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxItem.jsp",false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   dest.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   dest.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                  var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  dest.options.add(oOption);
			   }
 // obj.value=val;

   }
   function getItems(obj,val)
   {
       var dest=document.getElementById("item"+val);
       //var url = "./ajaxDist.jsp?param="; // The server-side script
       var url = "./ajaxItem.jsp?param=";
    var statecode= obj.value;
     var postData="param="+ escape(statecode);
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxItem.jsp",false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   dest.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   dest.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                  var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  dest.options.add(oOption);
			   }
 // obj.value=val;

   }
function getSchoolDetails(v)
   {

    //alert(""+v.value);
    var url = "./ajaxSchool.jsp?param="; // The server-side script
    //alert(v);
    var statecode= v.value;
    //alert("hi"+statecode);
    //alert(document.forms[0].it[item1].value);
    //alert(document.getElementById("item"));
    http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setSchoolDetails;
    http.send(null);
   }
   function setSchoolDetails()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     alert("No course exists with this training type");
	}else{

		 // if(document.getElementById("districtcode").options.length!=1)
		//{
			document.getElementById("item").options.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=("- - - - - - select - - - - - - -");
                   oOption1.value=("0");
                   document.getElementById("item").options.add(oOption1);

	         var j=0;
			 var course=document.getElementById("item");
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{


			       var oOption = document.createElement("OPTION");
                               oOption.text=trim(results1[1]);
                               oOption.value=trim(results1[0]);
                               document.getElementById("item").options.add(oOption);


				}
			   }


       }
	}

   }
function getSchlCat(obj,val)
   {
       var dest=document.getElementById("item"+val);
       //var url = "./ajaxDist.jsp?param="; // The server-side script
       var url = "./ajaxSchool.jsp?param=";
    var statecode= obj.value;
     var postData="param="+ escape(statecode);
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxSchool.jsp",false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   dest.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   dest.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                  var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  dest.options.add(oOption);
			   }
 // obj.value=val;

   }
   function getSchlItems(obj,val)
   {
       var dest=document.getElementById("item"+val);
       //var url = "./ajaxDist.jsp?param="; // The server-side script
       var url = "./ajaxSchool.jsp?param=";
    var statecode= obj.value;
     var postData="param="+ escape(statecode);
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxSchool.jsp",false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   dest.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   dest.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                  var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  dest.options.add(oOption);
			   }
 // obj.value=val;

   }
function getSpecl()
   {
     var url = "./ajaxSpeclname.jsp?param="; // The server-side script
    var catg= document.GraduationForm.catgname.value;
var grade= document.GraduationForm.gradename.value;
    var course= document.GraduationForm.coursename.value;

       http.open("GET", url + escape(catg+"-"+grade+"-"+course), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setSpecl;
    http.send(null);
   }
   function setSpecl()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.GraduationForm.specialization.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.GraduationForm.specialization.options.add(oOption1);

	         var j=0;
			 var course=document.GraduationForm.specialization;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.GraduationForm.specialization.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   function getPostSpecl()
   {
     var url = "./ajaxPostSpeclname.jsp?param="; // The server-side script
    var catg= document.PostGraduationForm.catgname.value;
var grade= document.PostGraduationForm.gradename.value;
    var course= document.PostGraduationForm.coursename.value;

       http.open("GET", url + escape(catg+"-"+grade+"-"+course), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setPostSpecl;
    http.send(null);
   }
   function setPostSpecl()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.PostGraduationForm.specialization.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.PostGraduationForm.specialization.options.add(oOption1);

	         var j=0;
			 var course=document.PostGraduationForm.specialization;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.PostGraduationForm.specialization.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

 function keepDist(obj,val,parameter)
   {
       //var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.getElementById(parameter).value;
    //alert(statecode);
     var postData="param="+ escape(statecode);
     
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxDist.jsp",false);
     openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   obj.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   obj.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                                   var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  obj.options.add(oOption);
                  			   }
  obj.value=val;

   }   
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
//-------------POSTS--------------

function getInstTypeDetails(v)
   {

    //alert(""+v.value);
    var url = "./ajaxInstype.jsp?param="; // The server-side script
    //alert(v);
    var statecode= v.value;
    //alert("hi"+statecode);
    //alert(document.forms[0].it[item1].value);
    //alert(document.getElementById("item"));
    http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setInsDetails;
    http.send(null);
   }   
   function setInsDetails()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{

		 // if(document.getElementById("districtcode").options.length!=1)
		//{
			document.getElementById("ins").options.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=("- - - - - - select - - - - - - -");
                   oOption1.value=("0");
                   document.getElementById("ins").options.add(oOption1);

	         var j=0;
			 var course=document.getElementById("ins");
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{


			       var oOption = document.createElement("OPTION");
                               oOption.text=trim(results1[1]);
                               oOption.value=trim(results1[0]);
                               document.getElementById("ins").options.add(oOption);


				}
			   }


       }
	}
   }   
   function getInstNameDetails()
   {
     var url = "./ajaxInsname.jsp?param="; // The server-side script
    var dist= document.getElementById("dist").value;
     var dept= document.getElementById("hod").value;
      var inst= document.getElementById("ins").value;
      //alert("dist"+dist+"----dept"+dept+"----inst"+inst);
       http.open("GET", url + escape(dist+"-"+dept+"-"+inst), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setInsname;
    http.send(null);
   }
   function setInsname()
   {
     if (http.readyState == 4) {

    results = http.responseText.split("$");
  //   alert("hi"+results);
	if(results == "")
	{
     alert("No course exists with this training type");
	}else{

		 // if(document.getElementById("districtcode").options.length!=1)
		//{
			document.getElementById("insname").options.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=("- - - - - - select - - - - - - -");
                   oOption1.value=("0");
                   document.getElementById("insname").options.add(oOption1);

	         var j=0;
			 var course=document.getElementById("insname");
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{


			       var oOption = document.createElement("OPTION");
                               oOption.text=trim(results1[1]);
                               oOption.value=trim(results1[0]);
                               document.getElementById("insname").options.add(oOption);


				}
			   }


       }

   }
   }   
   function getCatname(v)
   {
      var url = "./ajaxCatgname.jsp?param="; // The server-side script
    //alert(v);
    var statecode= v.value;
    //alert("hi"+statecode);
    //alert(document.forms[0].it[item1].value);
    //alert(document.getElementById("item"));
    http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setCatDetails1;
    http.send(null);
   }
   function setCatDetails1()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     alert("No course exists with this training type");
	}else{

		 // if(document.getElementById("districtcode").options.length!=1)
		//{
			document.getElementById("cat").options.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=("- - - - - - select - - - - - - -");
                   oOption1.value=("0");
                   document.getElementById("cat").options.add(oOption1);

	         var j=0;
			 var course=document.getElementById("cat");
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{


			       var oOption = document.createElement("OPTION");
                               oOption.text=trim(results1[1]);
                               oOption.value=trim(results1[0]);
                               document.getElementById("cat").options.add(oOption);


				}
			   }


       }
	}
   }
 function getInsttype1(obj,val)
   {
       var dest=document.getElementById("item"+val);
       //var url = "./ajaxDist.jsp?param="; // The server-side script
       var url = "./ajaxInstype.jsp?param=";
    var statecode= obj.value;
     var postData="param="+ escape(statecode);
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxInstype.jsp",false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   dest.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   dest.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                  var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  dest.options.add(oOption);
			   }
 // obj.value=val;

   }  
   
 function getInstName1(obj,val)
   {
       var dest=document.getElementById("item1"+val);
       //var url = "./ajaxDist.jsp?param="; // The server-side script
       
       var url = "./ajaxInsname.jsp?param="; // The server-side script
    var dist= document.getElementById("dis"+val).value;
     var dept= document.getElementById("hod1"+val).value;
      var inst= document.getElementById("item"+val).value;
      //alert("dist"+dist+"----dept"+dept+"----inst"+inst);
     //  http.open("GET", url + escape(dist+"-"+dept+"-"+inst), true);
   // var statecode= obj.value;
     var postData="param="+ escape(dist+"-"+dept+"-"+inst);
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxInsname.jsp",false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   dest.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   dest.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                  var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  dest.options.add(oOption);
			   }
 // obj.value=val;

   }
function getCat1(obj,val)
   {
       var dest=document.getElementById("catg"+val);
       //var url = "./ajaxDist.jsp?param="; // The server-side script
       var url = "./ajaxCatgname.jsp?param=";
    var statecode= obj.value;
     var postData="param="+ escape(statecode);
  var openRequest = getAjaxRequest();
   openRequest.open("POST","./ajaxCatgname.jsp",false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   dest.options.length = 0;
    var oOption1 = document.createElement("OPTION");
   oOption1.text=trim("- - - - - - select - - - - - - -");
   oOption1.value=trim("");
   dest.options.add(oOption1);
			for( i=0;i<response.length-1 ;i++)
			   {
                  var responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  dest.options.add(oOption);
			   }
 // obj.value=val;

   }

   //=============================================  END  ==============================================


function getSuperspeciality()
   {
     var url = "./ajaxSuperspecialname.jsp?param="; // The server-side script
    var catg= document.SuperSpecialityForm.catgname.value;
var grade= document.SuperSpecialityForm.gradename.value;
var qual= document.SuperSpecialityForm.coursename.value;


       http.open("GET", url + escape(catg+"-"+grade+"-"+qual), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setSuperspeciality;
    http.send(null);
   }
   function setSuperspeciality()
   {
     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SuperSpecialityForm.specialization.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SuperSpecialityForm.specialization.options.add(oOption1);

	         var j=0;
			 var course=document.SuperSpecialityForm.specialization;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SuperSpecialityForm.specialization.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }




function getSpeciality()
   {
     var url = "./ajaxSpeciallname.jsp?param="; // The server-side script
    var catg= document.SuperSpecialityForm.catgname.value;
var grade= document.SuperSpecialityForm.gradename.value;
    

       http.open("GET", url + escape(catg+"-"+grade), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setSpeciality;
    http.send(null);
   }
   function setSpeciality()
   {
     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.SuperSpecialityForm.coursename.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.SuperSpecialityForm.coursename.options.add(oOption1);

	         var j=0;
			 var course=document.SuperSpecialityForm.coursename;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.SuperSpecialityForm.coursename.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }

   function AjaxFun(destinationname,postData,filenm)
{
   var openRequest = getAjaxRequest();
   openRequest.open("POST",filenm,false);
   openRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   openRequest.send(postData);
   var response = openRequest.responseText.split("$");
   //alert(response);
   document.getElementById(destinationname).options.length = 0;
			for( i=0;i<response.length-1 ;i++)
			   {
                  responseid =response[i].split(";");
    			  var oOption = document.createElement("OPTION");
                  oOption.text=trim(responseid[1]);
                  oOption.value=trim(responseid[0]);
                  document.getElementById(destinationname).options.add(oOption);
			   }
}
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
        
function getExpDet(t)
{
    var k=t;
    
    var url = "./ajaxpostsdetails.jsp?param="; // The server-side script
    
    http.open("GET", url + escape(k), true);
        
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setExpDet;
    http.send(null);
}
function setExpDet()
{
  
  
    if (http.readyState == 4) {
   
        results = http.responseText.split("$");
        //alert(results);
        if(results == "")
        {
        //alert("No course exists with this training type");
        }else{
            /*         
    var tblBody = document.getElementById("EXPDETAILS").tBodies[0];
        alert(tblBody);
  var cell0 = tblBody.insertRow(-1);
    alert(cell0);
 cell0.innerHTML=http.responseText ;
    alert(cell0.innerHTML);
   */
  
            for(var i=0;i<results.length-1;i++)
            {
                            
                results1=results[i].split(";");
                  
                var _table = document.getElementById('EXPDETAILS').insertRow(-1);
                for(var j=0;j<results1.length;j++)
                { 
                    var cell0 = _table.insertCell(j);
                    cell0.innerHTML=results1[j];

                }
                            
                                
            }
  
        /*  var _table = document.getElementById('EXPDETAILS').insertRow(-1);
  var cell0 = _table.insertCell(0);
   cell0.innerHTML = http.responseText;*/
  
        }
    }
function getNativeDistDetails(v,statecode)
{

    var distcode= v.value;
    alert("in Ajax"+distcode);
    var state=statecode.value;
    //alert(param);
    var url = "ajaxDist.jsp?param="; // The server-side script
   // var statecode= SMSForm.distcode.value;
    var param=state;
    http.open("GET", url + escape(param), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setNativeDistDetails;
    http.send(null);
}
function setNativeDistDetails()
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
function getRegDistDetails1(v,statecode)
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
    http.onreadystatechange = setRegDistDetails1;
    http.send(null);
}
function setRegDistDetails1()
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
function getRegDistDetails2(v,statecode)
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
    http.onreadystatechange = setRegDistDetails2;
    http.send(null);
}

function setRegDistDetails2()
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


function setblock()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
	if(results == "")
	{
    // alert("No Block exists with this training type");
	}else{
	//alert("calling---------");
		 // if(document.getElementById("districtcode").options.length!=1)
		//{
               
			 document.myform.block.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.myform.block.options.add(oOption1);

	         var j=0;
			 var course=document.myform.block;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.myform.block.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }

	      
       }
	}

   }

}        
        
        
