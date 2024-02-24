//-------func-----


function selectopt(opt,v) 
{ 
	for(i=0;i<opt.length;i++) 
	{ 
	   if(opt[i].value==v)
	  {  
		  opt[i].selected=1; break; 
	  }	
     }  
}

function insert()
{
	var yr = document.forms[0].year.value;
	var a = yr.split("-");
	document.forms[0].TS.value = yr;
	var t1 = a[0]+"";
	var t2 = a[1]+"";
	var nextyear1 = parseInt(t1)+1;
	var nextyear2 = parseInt(t2)+1;
	var nextyear = nextyear1 + "-" + nextyear2;
	if(yr!="")
	document.forms[0].TR.value = nextyear;
	else
	document.forms[0].TR.value = "";

}

function insert1()
{
	var yr = document.forms[0].year.value;
	var a = yr.split("-");
	document.forms[0].TS.value = yr;
	document.forms[0].TS1.value = yr;
	document.forms[0].TS2.value = yr;
	var t1 = a[0]+"";
	var t2 = a[1]+"";
	var nextyear1 = parseInt(t1)+1;
	var nextyear2 = parseInt(t2)+1;
	var nextyear = nextyear1 + "-" + nextyear2;
	if(yr!="")
	{
	document.forms[0].TR.value = nextyear;
	document.forms[0].TR1.value = nextyear;
	}
	else
	{
	document.forms[0].TR.value = "";
	}

}

function insert2()
{
	var yr = document.forms[0].year.value;
	
	document.forms[0].TS.value = yr;
	document.forms[0].TS1.value = yr;
}
function insert3()
{
	var yr = document.forms[0].year.value;
	var a = yr.split("-");
	document.forms[0].TS.value = yr;
	document.forms[0].TS1.value = yr;
	document.forms[0].TS2.value = yr;
	var t1 = a[0]+"";
	var t2 = a[1]+"";
	var nextyear1 = parseInt(t1)+1;
	var nextyear2 = parseInt(t2)+1;
	var nextyear = nextyear1 + "-" + nextyear2;
	if(yr!="")
	{
	document.forms[0].TR.value = nextyear;
	document.forms[0].TR1.value = nextyear;
	document.forms[0].TR2.value = nextyear;
	document.forms[0].TR3.value = nextyear;
	}
	else
	{
	document.forms[0].TR.value = "";
	document.forms[0].TR1.value = "";
	document.forms[0].TR2.value = "";
	document.forms[0].TR3.value = "";
	}
}
function insert4()
{
	var com1=0,yr=0;
	

	yr = document.forms[0].actexp.value;
	coml = document.forms[0].comliab.value;
	if(yr==0)
	document.forms[0].centrlass.value=parseFloat(coml);
	else
	{
	var a = yr-coml;
	document.forms[0].centrlass.value = parseFloat(a);
	}
	
}
function insert5()
{
	var ar=0,to=0,t=0,ac=0,co=0,du=0;
	ar = document.forms[0].arrears.value;
	to = document.forms[0].totexp.value;
	t = document.forms[0].total.value;
	if(ar==0&&to==0&&t==0)
document.forms[0].actexp1.value =0;
	else
document.forms[0].actexp1.value =parseFloat(ar)+parseFloat(to)+parseFloat(t);
if(ar==0)
	document.forms[0].actexp1.value = parseFloat(to)+parseFloat(t);
if(to==0)
	document.forms[0].actexp1.value = parseFloat(ar)+parseFloat(t);
if(t==0)
	document.forms[0].actexp1.value = parseFloat(ar)+parseFloat(to);
if(ar==0&&to==0)
	document.forms[0].actexp1.value =parseFloat(t);
if(ar==0&&t==0)
	document.forms[0].actexp1.value =parseFloat(to);
if(to==0&&t==0)
	document.forms[0].actexp1.value =parseFloat(ar);

	

ac = document.forms[0].actexp1.value;
co = document.forms[0].comliab1.value;
du=parseFloat(ac)-parseFloat(co);
if(ac==0||co==0)
	document.forms[0].duecentral.value = 0;
if(co==0)
	document.forms[0].duecentral.value = parseFloat(ac);
	else
   document.forms[0].duecentral.value =parseFloat(du);
	}
//---------------------------------
//------basic data-----------
function dyn_table_add_category() {
var tbody = document.getElementById("dyn_table_categories");

// count up all the existing categories on the screen
var category_id = 1;
while (true)
{
category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
}

var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);

var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");
textfield1.setAttribute("width","192");
textfield1.setAttribute("height","50");

var input_other1= document.createElement("textarea");
//input_other1.setAttribute("type","text");
input_other1.setAttribute("name","other1");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","20");
textfield1.appendChild(input_other1);

var textfield2 = document.createElement("td");
textfield1.setAttribute("align","center");
textfield1.setAttribute("width","192");
textfield1.setAttribute("height","50");

var input_desc= document.createElement("input");
input_desc.setAttribute("type","text");
input_desc.setAttribute("name","desc");
input_desc.setAttribute("id", "desc"+category_id);
input_desc.setAttribute("size","20");
textfield2.appendChild(input_desc);

tr.appendChild(textfield1);
tr.appendChild(textfield2);

tbody.appendChild(tr); 

}




//----------------------disb_prof------------------------

function dyn_table_add_category1() {
var tbody = document.getElementById("dyn_table_categories");


var category_id = 1;
while (true)
{
category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
}

var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);

var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");
textfield1.setAttribute("width","192");
textfield1.setAttribute("height","50");

var input_time= document.createElement("input");
input_time.setAttribute("type","text");
input_time.setAttribute("name","nameofinstitute");
input_time.setAttribute("id", "time"+category_id);
input_time.setAttribute("size","20");
textfield1.appendChild(input_time);


var textfield2 = document.createElement("td");
textfield2.setAttribute("align","center");

var input_other1= document.createElement("textarea");
//input_other1.setAttribute("type","text");
input_other1.setAttribute("name","address");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","20");
textfield2.appendChild(input_other1);

var textfield3 = document.createElement("td");
textfield3.setAttribute("align","center");

 var input_session= document.createElement("select");
    input_session.setAttribute("name","category");
    input_session.setAttribute("id", "session"+category_id);
    textfield3.appendChild(input_session);




var textfield4 = document.createElement("td");
textfield4.setAttribute("align","center");


var input_order= document.createElement("input");
input_order.setAttribute("type","text");
input_order.setAttribute("name","noofbeneficiaries");
input_order.setAttribute("id", "order"+category_id);
input_order.setAttribute("size","20");
textfield4.appendChild(input_order);



var textfield5 = document.createElement("td");
textfield5.setAttribute("align","center");
textfield5.setAttribute("width","268");
textfield5.setAttribute("height","50");

var input_basic= document.createElement("input");
input_basic.setAttribute("type","text");
input_basic.setAttribute("name","amount");
input_basic.setAttribute("id", "basic"+category_id);
input_basic.setAttribute("size","20");
textfield5.appendChild(input_basic);






tr.appendChild(textfield1);
tr.appendChild(textfield2);
tr.appendChild(textfield3);
tr.appendChild(textfield4);
tr.appendChild(textfield5);



tbody.appendChild(tr); 

var se=input_session.getAttribute("id");
   var oOption2 = document.createElement("OPTION");
   oOption2.text="--- select ---";
   oOption2.value="";
  document.getElementById(se).options.add(oOption2);
  
  var oOption3 = document.createElement("OPTION");
   oOption3.text="Government";
   oOption3.value="Government";
  document.getElementById(se).options.add(oOption3);
  
var oOption4 = document.createElement("OPTION");
   oOption4.text="Private";
   oOption4.value="Private";
  document.getElementById(se).options.add(oOption4);
  

}


//---------------annual_Sc--------------

function dyn_table_add_category2() {
var tbody = document.getElementById("dyn_table_categories");


var category_id = 1;
while (true)
{
category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
}

var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);

var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");

 var input_session= document.createElement("select");
    input_session.setAttribute("name","annualfee");
    input_session.setAttribute("id", "session"+category_id);
    textfield1.appendChild(input_session);

var textfield2 = document.createElement("td");
textfield2.setAttribute("align","center");

var input_time= document.createElement("input");
input_time.setAttribute("type","text");
input_time.setAttribute("name","actual");
input_time.setAttribute("id", "time"+category_id);
input_time.setAttribute("size","20");
textfield2.appendChild(input_time);


var textfield3 = document.createElement("td");
textfield3.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","proposed");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","20");
textfield3.appendChild(input_other1);



tr.appendChild(textfield1);
tr.appendChild(textfield2);
tr.appendChild(textfield3);




tbody.appendChild(tr); 

var se=input_session.getAttribute("id");
   var oOption2 = document.createElement("OPTION");
   oOption2.text="-----Select Fee Range-------";
   oOption2.value="";
   document.getElementById(se).options.add(oOption2);
  
  var oOption3 = document.createElement("OPTION");
   oOption3.text="Less than 25,000";
   oOption3.value="1";
  document.getElementById(se).options.add(oOption3);
  
var oOption4 = document.createElement("OPTION");
   oOption4.text="25,001 to 75,000";
   oOption4.value="2";
  document.getElementById(se).options.add(oOption4);
  
var oOption5 = document.createElement("OPTION");
   oOption5.text="75,001 to 1,25,000";
   oOption5.value="3";
  document.getElementById(se).options.add(oOption5);

  var oOption6 = document.createElement("OPTION");
   oOption6.text="1,25,001 to 2,00,000";
   oOption6.value="4";
  document.getElementById(se).options.add(oOption6);

  var oOption7 = document.createElement("OPTION");
   oOption7.text="2,00,001 to 3,00,000";
   oOption7.value="5";
  document.getElementById(se).options.add(oOption7);

  var oOption8 = document.createElement("OPTION");
   oOption8.text="3,00,001 to 4,00,000";
   oOption8.value="6";
  document.getElementById(se).options.add(oOption8);

  var oOption9 = document.createElement("OPTION");
   oOption9.text="4,00,001 to 5,00,000";
   oOption9.value="7";
  document.getElementById(se).options.add(oOption9);

  var oOption10 = document.createElement("OPTION");
   oOption10.text="5,00,001 to 7,00,000";
   oOption10.value="8";
  document.getElementById(se).options.add(oOption10);

  var oOption11 = document.createElement("OPTION");
   oOption11.text="7,00,001 to 10,00,000";
   oOption11.value="9";
  document.getElementById(se).options.add(oOption11);

  var oOption12 = document.createElement("OPTION");
   oOption12.text="More than 10,00,000";
   oOption12.value="10";
  document.getElementById(se).options.add(oOption12);
}


//----------Expenditure---------------

function dyn_table_add_category3() {
var tbody = document.getElementById("dyn_table_categories");
var category_id = 1;
var grp=new Array(5);
while (true)
{
	category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
if(category_id==2)
	{
	 var rs=document.forms[0].group.value;
	 grp[rs]=rs;
	}else
	{
 var rs=document.getElementById("session1"+(category_id-1)).value;
 grp[rs]=rs;
	}


}
if(category_id==2)
	{
	var rs=document.forms[0].group.value;
	 grp[rs]=rs;
	}else
	{
 var rs=document.getElementById("session1"+(category_id-1)).value;
 grp[rs]=rs;
	}

if(category_id<=5)
{
var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);

var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");

 var input_session= document.createElement("select");
    input_session.setAttribute("name","grouptype");
    input_session.setAttribute("id", "session"+category_id);
    textfield1.appendChild(input_session);

	var textfield2 = document.createElement("td");
textfield2.setAttribute("align","center");

 var input_session1= document.createElement("select");
    input_session1.setAttribute("name","group");
    input_session1.setAttribute("id", "session1"+category_id);
    textfield2.appendChild(input_session1);



var textfield3 = document.createElement("td");
textfield3.setAttribute("align","center");

var input_time= document.createElement("input");
input_time.setAttribute("type","text");
input_time.setAttribute("name","scactual");
input_time.setAttribute("id", "time"+category_id);
input_time.setAttribute("size","15");
textfield3.appendChild(input_time);


var textfield4 = document.createElement("td");
textfield4.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","maintenanceactual");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield4.appendChild(input_other1);

var textfield5 = document.createElement("td");
textfield5.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","feeactual");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield5.appendChild(input_other1);

var textfield6 = document.createElement("td");
textfield6.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","scanti");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield6.appendChild(input_other1);

var textfield7 = document.createElement("td");
textfield7.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","maintenanceanti");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield7.appendChild(input_other1);

var textfield8 = document.createElement("td");
textfield8.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","feeanti");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield8.appendChild(input_other1);


tr.appendChild(textfield1);
tr.appendChild(textfield2);
tr.appendChild(textfield3);
tr.appendChild(textfield4);
tr.appendChild(textfield5);
tr.appendChild(textfield6);
tr.appendChild(textfield7);
tr.appendChild(textfield8);




tbody.appendChild(tr); 

var se=input_session.getAttribute("id");
   var oOption2 = document.createElement("OPTION");
   oOption2.text="-----Select-------";
   oOption2.value="";
   document.getElementById(se).options.add(oOption2);
  
  var oOption3 = document.createElement("OPTION");
   oOption3.text="Hostellers";
   oOption3.value="1";
  document.getElementById(se).options.add(oOption3);
  
var oOption4 = document.createElement("OPTION");
   oOption4.text="Day Scholars";
   oOption4.value="2";
  document.getElementById(se).options.add(oOption4);


var sd=input_session1.getAttribute("id");
    var oOption2 = document.createElement("OPTION");
   oOption2.text="-------------Select-----------------";
   oOption2.value="";
   document.getElementById(sd).options.add(oOption2);
 if(grp[1]!=1)
	{
  var oOption3 = document.createElement("OPTION");
   oOption3.text="I";
   oOption3.value="1";
  document.getElementById(sd).options.add(oOption3);
	}
	if(grp[2]!=2)
	{
var oOption4 = document.createElement("OPTION");
   oOption4.text="II";
   oOption4.value="2";
  document.getElementById(sd).options.add(oOption4);
	}
	if(grp[3]!=3)
	{
var oOption5 = document.createElement("OPTION");
   oOption5.text="III";
   oOption5.value="3";
  document.getElementById(sd).options.add(oOption5);
	}
	if(grp[4]!=4)
	{
  var oOption6 = document.createElement("OPTION");
   oOption6.text="IV";
   oOption6.value="4";
  document.getElementById(sd).options.add(oOption6);
	}
	if(grp[5]!=5)
	{
  var oOption7 = document.createElement("OPTION");
   oOption7.text="Correspondence Courses";
   oOption7.value="5";
  document.getElementById(sd).options.add(oOption7);
	}
}

  

}


//----------auditposition-----------


function dyn_table_add_category4() {
var tbody = document.getElementById("dyn_table_categories");


var category_id = 1;
while (true)
{
category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
}

var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);


var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");

 var input_session= document.createElement("select");
    input_session.setAttribute("name","year");
    input_session.setAttribute("id", "session"+category_id);
    textfield1.appendChild(input_session);




var textfield2 = document.createElement("td");
textfield2.setAttribute("align","center");


var input_order= document.createElement("input");
input_order.setAttribute("type","text");
input_order.setAttribute("name","expenditure");
input_order.setAttribute("id", "order"+category_id);
input_order.setAttribute("size","20");
textfield2.appendChild(input_order);



tr.appendChild(textfield1);
tr.appendChild(textfield2);



tbody.appendChild(tr); 

var se=input_session.getAttribute("id");
   var oOption2 = document.createElement("OPTION");
   oOption2.text="--- select ---";
   oOption2.value="";
  document.getElementById(se).options.add(oOption2);
  
  var oOption3 = document.createElement("OPTION");
   oOption3.text="2009-10";
   oOption3.value="2009-10";
  document.getElementById(se).options.add(oOption3);
  
var oOption4 = document.createElement("OPTION");
   oOption4.text="2010-11";
   oOption4.value="2010-11";
  document.getElementById(se).options.add(oOption4);

  var oOption5 = document.createElement("OPTION");
   oOption5.text="2011-12";
   oOption5.value="2011-12";
  document.getElementById(se).options.add(oOption5);

  var oOption6 = document.createElement("OPTION");
   oOption6.text="2012-13";
   oOption6.value="2012-13";
  document.getElementById(se).options.add(oOption6);

  var oOption7 = document.createElement("OPTION");
   oOption7.text="2013-14";
   oOption7.value="2013-14";
  document.getElementById(se).options.add(oOption7);

  var oOption8 = document.createElement("OPTION");
   oOption8.text="2014-15";
   oOption8.value="2014-15";
  document.getElementById(se).options.add(oOption8);

  var oOption9 = document.createElement("OPTION");
   oOption9.text="2015-16";
   oOption9.value="2015-16";
  document.getElementById(se).options.add(oOption9);

  var oOption10 = document.createElement("OPTION");
   oOption10.text="2016-17";
   oOption10.value="2016-17";
  document.getElementById(se).options.add(oOption10);
  
  var oOption11 = document.createElement("OPTION");
   oOption11.text="2017-18";
   oOption11.value="2017-18";
  document.getElementById(se).options.add(oOption11);

  var oOption12 = document.createElement("OPTION");
   oOption12.text="2018-19";
   oOption12.value="2018-19";
  document.getElementById(se).options.add(oOption12);

  var oOption13 = document.createElement("OPTION");
   oOption13.text="2019-20";
   oOption13.value="2019-20";
  document.getElementById(se).options.add(oOption13);
  

}


//------yearwisestatement--------------------


function dyn_table_add_category5() {
var tbody = document.getElementById("dyn_table_categories");


var category_id = 1;
while (true)
{
category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
}

var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);


var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");


var input_order= document.createElement("input");
input_order.setAttribute("type","text");
input_order.setAttribute("name","awardsact");
input_order.setAttribute("id", "order"+category_id);
input_order.setAttribute("size","15");
textfield1.appendChild(input_order);

var textfield2 = document.createElement("td");
textfield2.setAttribute("align","center");


var input_order= document.createElement("input");
input_order.setAttribute("type","text");
input_order.setAttribute("name","expenact");
input_order.setAttribute("id", "order"+category_id);
input_order.setAttribute("size","15");
textfield2.appendChild(input_order);

var textfield3 = document.createElement("td");
textfield3.setAttribute("align","center");


var input_order= document.createElement("input");
input_order.setAttribute("type","text");
input_order.setAttribute("name","awardsanti");
input_order.setAttribute("id", "order"+category_id);
input_order.setAttribute("size","15");
textfield3.appendChild(input_order);

var textfield4 = document.createElement("td");
textfield4.setAttribute("align","center");


var input_order= document.createElement("input");
input_order.setAttribute("type","text");
input_order.setAttribute("name","expenanti");
input_order.setAttribute("id", "order"+category_id);
input_order.setAttribute("size","15");
textfield4.appendChild(input_order);

tr.appendChild(textfield1);
tr.appendChild(textfield2);
tr.appendChild(textfield3);
tr.appendChild(textfield4);



tbody.appendChild(tr); 


}

//----------Disabled-------------
function dyn_table_add_category6() {
var tbody = document.getElementById("dyn_table_categories");
var category_id = 1;
var grp=new Array(5);
while (true)
{
	category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
if(category_id==2)
	{
	 var rs=document.forms[0].group.value;
	 grp[rs]=rs;
	}else
	{
 var rs=document.getElementById("session1"+(category_id-1)).value;
 grp[rs]=rs;
	}


}
if(category_id==2)
	{
	var rs=document.forms[0].group.value;
	 grp[rs]=rs;
	}else
	{
 var rs=document.getElementById("session1"+(category_id-1)).value;
 grp[rs]=rs;
	}

if(category_id<=5)
{
var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);

var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");

 var input_session= document.createElement("select");
    input_session.setAttribute("name","grouptype");
    input_session.setAttribute("id", "session"+category_id);
    textfield1.appendChild(input_session);

	var textfield2 = document.createElement("td");
textfield2.setAttribute("align","center");

 var input_session1= document.createElement("select");
    input_session1.setAttribute("name","group");
	input_session1.setAttribute("id", "session1"+category_id);
    textfield2.appendChild(input_session1);



var textfield3 = document.createElement("td");
textfield3.setAttribute("align","center");

var input_time= document.createElement("input");
input_time.setAttribute("type","text");
input_time.setAttribute("name","boysact");
input_time.setAttribute("id", "time"+category_id);
input_time.setAttribute("size","15");
textfield3.appendChild(input_time);


var textfield4 = document.createElement("td");
textfield4.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","girlsact");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield4.appendChild(input_other1);

var textfield5 = document.createElement("td");
textfield5.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","boysanti");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield5.appendChild(input_other1);

var textfield6 = document.createElement("td");
textfield6.setAttribute("align","center");

var input_other1= document.createElement("input");
input_other1.setAttribute("type","text");
input_other1.setAttribute("name","girlsanti");
input_other1.setAttribute("id", "other1"+category_id);
input_other1.setAttribute("size","15");
textfield6.appendChild(input_other1);






tr.appendChild(textfield1);
tr.appendChild(textfield2);
tr.appendChild(textfield3);
tr.appendChild(textfield4);
tr.appendChild(textfield5);
tr.appendChild(textfield6);




tbody.appendChild(tr); 


var se=input_session.getAttribute("id");
   var oOption2 = document.createElement("OPTION");
   oOption2.text="-----Select-------";
   oOption2.value="";
   document.getElementById(se).options.add(oOption2);
  
  var oOption3 = document.createElement("OPTION");
   oOption3.text="Hostellers";
   oOption3.value="1";
  document.getElementById(se).options.add(oOption3);
  
var oOption4 = document.createElement("OPTION");
   oOption4.text="Day Scholars";
   oOption4.value="2";
  document.getElementById(se).options.add(oOption4);


var sd=input_session1.getAttribute("id");
    var oOption2 = document.createElement("OPTION");
   oOption2.text="-------------Select-----------------";
   oOption2.value="";
   document.getElementById(sd).options.add(oOption2);

   if(grp[1]!=1)
	{
	 var oOption3 = document.createElement("OPTION");
   oOption3.text="I";
   oOption3.value="1";
  document.getElementById(sd).options.add(oOption3);
	}
if(grp[2]!=2)
	{
var oOption4 = document.createElement("OPTION");
   oOption4.text="II";
   oOption4.value="2";
  document.getElementById(sd).options.add(oOption4);
	}
	if(grp[3]!=3)
	{
var oOption5 = document.createElement("OPTION");
   oOption5.text="III";
   oOption5.value="3";
  document.getElementById(sd).options.add(oOption5);
	}
	if(grp[4]!=4)
	{
  var oOption6 = document.createElement("OPTION");
   oOption6.text="IV";
   oOption6.value="4";
  document.getElementById(sd).options.add(oOption6);
	}
	if(grp[5]!=5)
	{
  var oOption7 = document.createElement("OPTION");
   oOption7.text="Correspondence Courses";
   oOption7.value="5";
  document.getElementById(sd).options.add(oOption7);

	}
}
}

//--------higer_maintenance----------


function dyn_table_add_category7() {
var tbody = document.getElementById("dyn_table_categories");


var category_id = 1;
while (true)
{
category_id++;
var row = document.getElementById("category"+category_id);
if (!row) {
break;
}
}

var tr = document.createElement("tr");
tr.setAttribute("id", "category"+category_id);

var textfield1 = document.createElement("td");
textfield1.setAttribute("align","center");

 var input_session= document.createElement("select");
    input_session.setAttribute("name","grouptype");
    input_session.setAttribute("id", "session"+category_id);
    textfield1.appendChild(input_session);

	var textfield2 = document.createElement("td");
textfield2.setAttribute("align","center");

 var input_session1= document.createElement("select");
    input_session1.setAttribute("name","group");
    input_session1.setAttribute("id", "session1"+category_id);
    textfield2.appendChild(input_session1);



var textfield3 = document.createElement("td");
textfield3.setAttribute("align","center");

var input_time= document.createElement("input");
input_time.setAttribute("type","text");
input_time.setAttribute("name","maintenance");
input_time.setAttribute("id", "time"+category_id);
input_time.setAttribute("size","15");
textfield3.appendChild(input_time);







tr.appendChild(textfield1);
tr.appendChild(textfield2);
tr.appendChild(textfield3);





tbody.appendChild(tr); 

var se=input_session.getAttribute("id");
   var oOption2 = document.createElement("OPTION");
   oOption2.text="-----Select-------";
   oOption2.value="";
   document.getElementById(se).options.add(oOption2);
  
  var oOption3 = document.createElement("OPTION");
   oOption3.text="Hostellers";
   oOption3.value="1";
  document.getElementById(se).options.add(oOption3);
  
var oOption4 = document.createElement("OPTION");
   oOption4.text="Day Scholars";
   oOption4.value="2";
  document.getElementById(se).options.add(oOption4);


var sd=input_session1.getAttribute("id");
    var oOption2 = document.createElement("OPTION");
   oOption2.text="-----Select-------";
   oOption2.value="";
   document.getElementById(sd).options.add(oOption2);
 
  var oOption3 = document.createElement("OPTION");
   oOption3.text="I";
   oOption3.value="1";
  document.getElementById(sd).options.add(oOption3);
  
var oOption4 = document.createElement("OPTION");
   oOption4.text="II";
   oOption4.value="2";
  document.getElementById(sd).options.add(oOption4);

var oOption5 = document.createElement("OPTION");
   oOption5.text="III";
   oOption5.value="3";
  document.getElementById(sd).options.add(oOption5);

  var oOption6 = document.createElement("OPTION");
   oOption6.text="IV";
   oOption6.value="4";
  document.getElementById(sd).options.add(oOption6);

  var oOption7 = document.createElement("OPTION");
   oOption7.text="Correspondence Courses";
   oOption7.value="5";
  document.getElementById(sd).options.add(oOption7);

}

//-----ajax-------
function initRequest()
	 {
          if (window.XMLHttpRequest) 
		  {
              return new XMLHttpRequest();
          } else if (window.ActiveXObject) {
              isIE = true;
              return new ActiveXObject("Microsoft.XMLHTTP");
          }
      }
function fillSelect()
	{
		var mins=document.form.ministry.value;
		
		 var req = initRequest();
			document.getElementById("ministry").options.length=0;
		req.onreadystatechange=function(){
			    if (req.readyState == 4)
			    {
                  if (req.status == 200) 
				   {
						var optn1=document.createElement("OPTION");
						optn1.text="--Select--";
						optn1.value="";
						document.getElementById("ministry").options.add(optn1);
					  	   var res=req.responseXML;
						   var messages=res.getElementsByTagName('messages')[0];
					   		for(loop=0;loop<messages.childNodes.length;loop++)
							{
								message=messages.childNodes[loop];
								var value1=message.childNodes[0].nodeValue;
								//s=value1.split(",");
								var optn=document.createElement("OPTION");
								optn.text=value1;
								optn.value=value1;
								document.getElementById("ministry").options.add(optn);
							}
					   
                   }
				    
               }
           };
           req.open("GET","./validaidnames1.jsp?ministry="+mins, true);
           req.send(null);
    
   }