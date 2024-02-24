
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
//======================================= distic Details ==========================================
function getDistDetails()
   {
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.forms[0].state.value;
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
               
			 document.forms[0].district.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].district.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].district;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].district.options.add(oOption);

				}
                               
			   }

	      
       }
	}

   }


function getMandDetails()
   {
     var url = "./ajaxMand.jsp?param="; // The server-side script
    var statecode= document.forms[0].state.value;
    var distcode= document.forms[0].district.value;
       http.open("GET", url + escape(statecode+"-"+distcode), true);
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

			 document.forms[0].mandal.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].mandal.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].mandal;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].mandal.options.add(oOption);

				}

			   }


       }
	}

   }


function getMandDetail()
   {
     var url = "./ajaxMand.jsp?param="; // The server-side script
    var statecode= document.forms[0].stateaddr.value;
    var distcode= document.forms[0].districtaddr.value;
       http.open("GET", url + escape(statecode+"-"+distcode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setMandDetail;
    http.send(null);
   }
   function setMandDetail()
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

			 document.forms[0].mandaddr.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].mandaddr.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].mandaddr;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].mandaddr.options.add(oOption);

				}

			   }


       }
	}

   }




function getVillDetails()
   {
     var url = "./ajaxVill.jsp?param="; // The server-side script
    var statecode= document.forms[0].state.value;
    var distcode= document.forms[0].district.value;
    var mandcode= document.forms[0].mandal.value;
       http.open("GET", url + escape(statecode+"-"+distcode+"-"+mandcode), true);
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

			 document.forms[0].village.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].village.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].village;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].village.options.add(oOption);

				}

			   }


       }
	}

   }


function getVillDetail()
   {
     var url = "./ajaxVill.jsp?param="; // The server-side script
    var statecode= document.forms[0].stateaddr.value;
    var distcode= document.forms[0].districtaddr.value;
    var mandcode= document.forms[0].mandaddr.value;
       http.open("GET", url + escape(statecode+"-"+distcode+"-"+mandcode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setVillDetail;
    http.send(null);
   }
   function setVillDetail()
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

			 document.forms[0].villaddr.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].villaddr.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].villaddr;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].villaddr.options.add(oOption);

				}

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




 function getPostDetails1()
   {

     var url = "./ajaxPost.jsp?param="; // The server-side script
    var coursecode= document.PostApplyForm.advt.value;

    http.open("GET", url + escape(coursecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setPostDetails1;
    http.send(null);
   }
   function setPostDetails1()
   {


     if (http.readyState == 4) {

    results = http.responseText.split("$");

	if(results == "")
	{
     //alert("No course exists with this training type");
	}else{

		 // if(document.getElementById("districtcode").options.length!=1)
		//{

			 document.PostApplyForm.posts.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");

                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.PostApplyForm.posts.options.add(oOption1);

	         var j=0;

		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");

				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);

                   oOption.value=trim(results1[0]);
                   document.PostApplyForm.posts.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }


   
function getDistDetail()
   {
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.forms[0].stateaddr.value;
       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setDistDetail;
    http.send(null);
   }
   function setDistDetail()
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

			 document.forms[0].districtaddr.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].districtaddr.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].districtaddr;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].districtaddr.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }
 
function getjobDistDetail()
   {
     var url = "./ajaxDist.jsp?param="; // The server-side script
    var statecode= document.forms[0].joblocation.value;
       http.open("GET", url + escape(statecode), true);
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setjobDistDetail;
    http.send(null);
   }
   function setjobDistDetail()
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

			 document.forms[0].districtaddr.length = 0;
		//}
				 var oOption1 = document.createElement("OPTION");
                   oOption1.text=trim("- - - - - - select - - - - - - -");
                   oOption1.value=trim("");
                   document.forms[0].districtaddr.options.add(oOption1);

	         var j=0;
			 var course=document.forms[0].districtaddr;
		    for(var i=0;i<results.length-1;i++)
			{
                results1=results[i].split(";");
				for(var j=0;j<results1.length-1;j++)
				{
			       var oOption = document.createElement("OPTION");
                   oOption.text=trim(results1[1]);
                   oOption.value=trim(results1[0]);
                   document.forms[0].districtaddr.options.add(oOption);

				}
                                //document.forms[0].districtcode.value='08';
			   }


       }
	}

   }


function getExpDet(t)
   {
      var k=t;
      //alert("k::"+k);
    var url = "./ajaxColumn.jsp?param="; // The server-side script
    var statecode= 0;
       http.open("GET", url + escape(k), true);
        
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setExpDet;
    http.send(null);
   }
   function setExpDet()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
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
                  
                 var _table = document.getElementById('DYNDETAILS').insertRow(-1);
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

   }
   
   function getExpDet1(t)
   {
      var k=t;
      //alert("k::"+k);
    var url = "./ajaxField.jsp?param="; // The server-side script
    var statecode= 0;
       http.open("GET", url + escape(k), true);
        
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setExpDet1;
    http.send(null);
   }
   function setExpDet1()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
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
                  
                 var _table = document.getElementById('DYNFIELDDETAILS').insertRow(-1);
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

   }


function getEduDet(t)
   {
      var k=t;
      //alert("k::"+k);
    var url = "./ajaxEduDetails.jsp?param="; // The server-side script
    var statecode= 0;
       http.open("GET", url + escape(k), true);
        
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setEduDet;
    http.send(null);
   }
   function setEduDet()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
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
                  
                 var _table = document.getElementById('EDUDETAILS').insertRow(-1);
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
//======================================= Post Details ==========================================




/*function getPostDetails()
{
   //alert("hiiiii");
    var url = "ajaxPost.jsp?param="; // The server-side script
    var postcode=document.forms[0].advt_no.value;
   // alert(postcode);
    http.open("GET", url + escape(postcode), true);
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
        alert("No course exists with this training type");
        }
        else{

           // if(document.getElementById("distcode").options.length!=1)
            ///{
             // document.getElementById("post_no").option.length = 0;
            //}
          //  var oOption1 = document.createElement("OPTION");
           // oOption1.text=("- - - - - - select - - - - - - -");
          //  oOption1.value=("");
          //  document.forms[0].post_no.options.add(oOption1);

            var j=0;
            var course=document.forms[0].post_no;
            for(var i=0;i<results.length-1;i++)
            {
                results1=results[i].split(";");
                for(var j=0;j<results1.length-1;j++)
                {
                    var oOption = document.createElement("OPTION");
                    oOption.text=(results1[1]);
                    oOption.value=(results1[0]);
                    document.forms[0].post_no.options.add(oOption);

                }
            }


        }
    }

}
*/


   function setExpDet1()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
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
                  
                 var _table = document.getElementById('DYNFIELDDETAILS').insertRow(-1);
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

   }
   
   function getAndroid1(t)
   {
      var k=t;
      //alert("k::"+k);
    var url = "./ajaxAndroidField1.jsp?param="; // The server-side script
    var statecode= 0;
       http.open("GET", url + escape(k), true);
        
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setExpDet2;
    http.send(null);
   }
   function setExpDet2()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
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
                  
                 var _table = document.getElementById('DYNFIELDDETAILS1').insertRow(-1);
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

   }
   
   
   
   
   function getAndroid2(t)
   {
      var k=t;
      //alert("k::"+k);
    var url = "./ajaxAndroidField2.jsp?param="; // The server-side script
    var statecode= 0;
       http.open("GET", url + escape(k), true);
        
    http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    http.onreadystatechange = setExpDet3;
    http.send(null);
   }
   function setExpDet3()
   {
  
  
     if (http.readyState == 4) {
   
    results = http.responseText.split("$");
   
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
                  
                 var _table = document.getElementById('DYNFIELDDETAILS2').insertRow(-1);
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

   }

   //=============================================  END  ==============================================




