function addVisitDetails()
{
    var rowid=$("#babyvisit tbody").children().length+1;
    var row="<tr><td><input type='text' id='EIDTEST_VISIT_DATE_"+rowid+"' name='property(EIDTEST_VISIT_DATE_"+rowid+")' size='15' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control todatepicker'/></td>"+
            "<td><input type='text' id='EIDTEST_VISIT_AGE_"+rowid+"' name='property(EIDTEST_VISIT_AGE_"+rowid+")' size='3' maxlength='3' onkeypress='return charCheck(event,\"0123456789\");' /></td>"+
            "<td><input type='text' id='EIDTEST_BABY_WEIGHT_"+rowid+"' name='property(EIDTEST_BABY_WEIGHT_"+rowid+")' size='3' maxlength='3' onkeypress='return charCheck(event,\"0123456789\");' /></td>"+
            "<td><select name='property(EIDTEST_CFP_"+rowid+")' id='EIDTEST_CFP_"+rowid+"'><option value='1'>EBF</option><option value='2'>ERF</option><option value='3'>Mixed Feeds</option><option value='4'>Semi Solids</option></select></td>"+
            "<td><input type='radio' name='property(EIDTEST_VISIT_TYPE_"+rowid+")' value='1' onclick='getSubRow(1,"+rowid+",this)' id='EIDTEST_VISIT_TYPE_"+rowid+"'/>DBS- DNA PCR <br>"+
            "<input type='radio' name='property(EIDTEST_VISIT_TYPE_"+rowid+")' value='2' onclick='getSubRow(1,"+rowid+",this)' id='EIDTEST_VISIT_TYPE_"+rowid+"'/>Antibody testing</td>"+
            "<td><input type='radio' name='property(EIDTEST_VISIT_RESULT_"+rowid+")' value='1' onclick='getSubRow(2,"+rowid+",this)' id='EIDTEST_VISIT_RESULT_"+rowid+"'/> Positive<br>"+
            "<input type='radio' name='property(EIDTEST_VISIT_RESULT_"+rowid+")' value='2' onclick='getSubRow(2,"+rowid+",this)' id='EIDTEST_VISIT_RESULT_"+rowid+"'/> Negative<br>"+
            "<input type='radio' name='property(EIDTEST_VISIT_RESULT_"+rowid+")' value='3' onclick='getSubRow(2,"+rowid+",this)' id='EIDTEST_VISIT_RESULT_"+rowid+"'/> Awaiting&nbsp;results"+
            "<div id='RESULT_ID_"+rowid+"_1'></div><div id='RESULT_ID_"+rowid+"_2'></div><div id='RESULT_ID_"+rowid+"_3'></div>"+
            "</td>"+
            "<td><input type='text' id='EIDTEST_RESULT_DATE_"+rowid+"' name='property(EIDTEST_RESULT_DATE_"+rowid+")' size='15' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control todatepicker'/></td>"+
            "</tr>";
    $("#babyvisit tbody").append(row);
    $(".datepicker").datepicker({yearRange: '1940:2020', changeMonth: true, changeYear: true,maxdate:'0+',dateFormat: 'dd-mm-yy'});
    
     var minValue = $(".fromdatepicker").val();
    minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
   // $('.todatepicker').datepicker("option", "minDate", minValue);
    $('.todatepicker').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    changeYear: true,
    minDate:minValue
});

    
}
var t1=new Array(),r1=new Array();
function getSubRow(tp,r,t)
{
   // alert("#EIDTEST_VISIT_TYPE_"+r+""+$("#EIDTEST_VISIT_TYPE_"+r+" input[type='radio']:checked").val()+"   "+$("input[id='EIDTEST_VISIT_TYPE_"+r+"']:checked").length);
    if(tp==1)
    {
        t1[r]=t.value;
    }
    if(tp==2)
    {
        r1[r]=t.value;
    }
    //alert(t1[r]+"    "+r1[r])
    document.getElementById("RESULT_ID_"+r+"_1").innerHTML="";
    document.getElementById("RESULT_ID_"+r+"_2").innerHTML="";
    document.getElementById("RESULT_ID_"+r+"_3").innerHTML="";
    if(t1[r]==1&&r1[r]==1)
    {
        document.getElementById("RESULT_ID_"+r+"_1").innerHTML=
                "<br/><div class='row col-lg-12'><div class='col-lg-12'><div class='form-group'>"+
                "<div class='panel panel-green'><div class='panel-heading'>&nbsp;</div><label>Date of dispatching Confirmatory DBS /WBS </label>"+
                "<input type='text' id='DATE_DISPATCH_CONF_DBS_"+r+"' name='property(DATE_DISPATCH_CONF_DBS_"+r+")' size='15' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Date of obtaining the result of Confirmatory DBS/WBS </label>"+
                "<input type='text' id='DATE_RESULT_CONF_DBS_"+r+"' name='property(DATE_RESULT_CONF_DBS_"+r+")' size='15' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Result of Confirmatory DBS/WBS</label><br>"+
                "<input type='radio' name='property(RESULT_CONFIRMATORY_DBS_"+r+")' value='1' onclick='getSubRow1(2,"+r+",this)' id='RESULT_CONFIRMATORY_DBS_"+r+"' class='required'/>Positive"+
                "<input type='radio' name='property(RESULT_CONFIRMATORY_DBS_"+r+")' value='2' onclick='getSubRow1(2,"+r+",this)' id='RESULT_CONFIRMATORY_DBS_"+r+"' class='required'/>Negative"+
                "</div></div></div></div>"+
                "";
        $(function() {
        
    });
    }
    else if(t1[r]==2&&r1[r]==1)
    {
        document.getElementById("RESULT_ID_"+r+"_1").innerHTML=
                "<br/><div class='row col-lg-12'><div class='col-lg-12'><div class='form-group'>"+
                "<div class='panel panel-green'><div class='panel-heading'>&nbsp;</div><label>Date of DBS Sample Dispatched</label> "+
                "<input type='text' id='DATE_DBS_DISPATCHING_"+r+"' name='property(DATE_DBS_DISPATCHING_"+r+")' size='15' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Date of obtaining the result</label> "+
                "<input type='text' id='DATE_OBTAINING_RESULT_"+r+"' name='property(DATE_OBTAINING_RESULT_"+r+")' size='15' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Result of the test </label><br>"+
                "<input type='radio' name='property(RESULT_DBS_TEST_"+r+")' value='1' onclick='getSubRow1(2,"+r+",this)' id='RESULT_DBS_TEST_"+r+"' class='required'/>Positive"+
                "<input type='radio' name='property(RESULT_DBS_TEST_"+r+")' value='2' onclick='getSubRow1(2,"+r+",this)' id='RESULT_DBS_TEST_"+r+"' class='required'/>Negative"+
                "</div></div></div></div>"+
                ""+
                "";
    }
     
}
function getDatePicker1(t)
{
    $(t).datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'dd-mm-yy',
                minDate:new Date($("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[2], $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[1]-1, $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[0])
                ,maxDate:new Date()
	}); 
}
function getSubRow1(tp,r,t)
{
    document.getElementById("RESULT_ID_"+r+"_2").innerHTML="";
    document.getElementById("RESULT_ID_"+r+"_3").innerHTML="";
    if(t1[r]==1&&r1[r]==1&&t.value==2)
    {
        document.getElementById("RESULT_ID_"+r+"_2").innerHTML=
                 "<br/><div class='row col-lg-12'><div class='col-lg-12'><div class='form-group'>"+
                "<div class='panel panel-red'><div class='panel-heading'>&nbsp;</div><label>Date of dispatching Second Confirmatory DBS/Whole blood </label> "+
                "<input type='text' id='DATE_DISPATCH_SECOND_CONF_DBS_"+r+"' name='property(DATE_DISPATCH_SECOND_CONF_DBS_"+r+")' size='15' maxlength='10'  onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Date of obtaining the result of second confirmatory DBS/ Whole Blood</label> "+
                "<input type='text' id='DATE_OBTAIN_SECOND_CONF_DBS_"+r+"' name='property(DATE_OBTAIN_SECOND_CONF_DBS_"+r+")' size='15' maxlength='10'  onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Result of second confirmatory DBS/ Whole Blood</label><br>"+
                "<input type='radio' name='property(RESULT_SECOND_CONF_DBS_"+r+")' value='1'  id='RESULT_SECOND_CONF_DBS_"+r+"' class='required'/>Positive"+
                "<input type='radio' name='property(RESULT_SECOND_CONF_DBS_"+r+")' value='2'  id='RESULT_SECOND_CONF_DBS_"+r+"' class='required'/>Negative"+
                "</div></div></div></div>"+
                ""+"";
    }
    else if(t1[r]==2&&r1[r]==1&&t.value==1)
    {        
        document.getElementById("RESULT_ID_"+r+"_2").innerHTML=
                "<br/><div class='row col-lg-12'><div class='col-lg-12'><div class='form-group'>"+
                "<div class='panel panel-green'><div class='panel-heading'>&nbsp;</div><label>Date of Confirmatory DBS/ Whole Blood </label>  "+
                "<input type='text' id='DATE_CONF_DBS_"+r+"' name='property(DATE_CONF_DBS_"+r+")' size='15' maxlength='10'  onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Date of obtaining the result </label>"+
                "<input type='text' id='DATE_OBTAIN_RESULT_"+r+"' name='property(DATE_OBTAIN_RESULT_"+r+")' size='15' maxlength='10'  onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Result of Confirmatory DBS/Whole Blood</label><br>"+
                "<input type='radio' name='property(RESULT_CONF_DBS_"+r+")' value='1' onclick='getSubRow2(2,"+r+",this)' id='RESULT_CONF_DBS_"+r+"' class='required'/>Positive"+
                "<input type='radio' name='property(RESULT_CONF_DBS_"+r+")' value='2' onclick='getSubRow2(2,"+r+",this)' id='RESULT_CONF_DBS_"+r+"' class='required'/>Negative"+
                "</div></div></div></div>"+
                ""+"";
    }
}

function getSubRow2(tp,r,t)
{
    document.getElementById("RESULT_ID_"+r+"_3").innerHTML="";
    if(t1[r]==2&&r1[r]==1&&t.value==2)
    {            
        document.getElementById("RESULT_ID_"+r+"_3").innerHTML=
                "<br/><div class='row col-lg-12'><div class='col-lg-12'><div class='form-group'>"+
                "<div class='panel panel-red'><div class='panel-heading'>&nbsp;</div><label>Date of Second Confirmatory DBS/ Whole Blood </label>   "+
                "<input type='text' id='DATE_SECOND_CONF_DBS_"+r+"' name='property(DATE_SECOND_CONF_DBS_"+r+")' size='15' maxlength='10'  onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Date of obtaining the result</label> "+
                "<input type='text' id='DATE_OBTAIN_RESULT1_"+r+"' name='property(DATE_OBTAIN_RESULT1_"+r+")' size='15' maxlength='10'  onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control  required' readonly='readonly' onfocus='getDatePicker1(this)' onmouseover='getDatePicker1(this)'/>"+
                "<label>Result of second  Confirmatory DBS/Whole Blood </label><br>"+
                "<input type='radio' name='property(RESULT_SECOND_CONF_DBS1_"+r+")' value='1' id='RESULT_SECOND_CONF_DBS1_"+r+"' class='required'/>Positive"+
                "<input type='radio' name='property(RESULT_SECOND_CONF_DBS1_"+r+")' value='2' id='RESULT_SECOND_CONF_DBS1_"+r+"' class='required'/>Negative"+
                "</div></div></div></div>"+
                ""+"";
    }
}
function submitTab5()
{
    var form=document.forms[0];
        if(validateRequired(form)&&validateMask(form))
        { 
            
        }
}

    function formBean_required()
    {
        var j=0;
        var values=new Array();
        values[j++]=new Array('property(EIDTEST_INFANT_NAME)', 'Complete name of the infant is required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(EIDTEST_ICTC_ID)', 'ICTC Id of the infant is required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(EIDTEST_DNA_PCR_CODE)', 'Unique DNA PCR Code of Infant is required.', new Function ('varName', ' return this[varName];'));
        values[j++]=new Array('property(EIDTEST_BABY_GENDER)', 'Gender of the Baby is required.', new Function ('varName', ' return this[varName];'));
        var rowid=$("#babyvisit tbody").children().length;
        for(var i3=1;i3<=rowid;i3++)
        {
            values[j++]=new Array('property(EIDTEST_VISIT_DATE_'+i3+')', 'visit date is required.', new Function ('varName', ' return this[varName];'));
            values[j++]=new Array('property(EIDTEST_BABY_AGE_'+i3+')', 'baby age is required.', new Function ('varName', ' return this[varName];'));
            values[j++]=new Array('property(EIDTEST_TEST_TYPE_'+i3+')', 'test type is required.', new Function ('varName', ' return this[varName];'));
            values[j++]=new Array('property(EIDTEST_RESULT_TYPE_'+i3+')', 'result type is required.', new Function ('varName', ' return this[varName];'));
        }
        for(var i1=0;i1<values.length;i1++)
        {
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', new Function('varName', ' return this[varName];'));");
        }
    }
function formBean_mask(A)
{
        var j=0;
        var values=new Array();
        values[j++]=new Array('property(EIDTEST_INFANT_NAME)', 'Complete name of the infant is invalid.', new Function ('varName', 'this.mask=/^[a-z A-Z0-9]*$/; return this[varName];'));
        values[j++]=new Array('property(EIDTEST_ICTC_ID)', 'ICTC Id of the infant is invalid.', new Function ('varName', 'this.mask=/^[a-z A-Z0-9]*$/; return this[varName];'));
        values[j++]=new Array('property(EIDTEST_DNA_PCR_CODE)', 'Unique DNA PCR Code of Infant is invalid.', new Function ('varName', 'this.mask=/^[a-z A-Z0-9]*$/; return this[varName];'));
        values[j++]=new Array('property(EIDTEST_BABY_GENDER)', 'Gender of the Baby is invalid.', new Function ('varName', 'this.mask=/^[0-9]*$/; return this[varName];'));
        var rowid=$("#babyvisit tbody").children().length;
        for(var i3=1;i3<=rowid;i3++)
        {
            values[j++]=new Array('property(EIDTEST_VISIT_DATE_'+i3+')', 'visit date is invalid.', new Function ('varName', 'this.mask=/^[\-0-9]*$/; return this[varName];'));
            values[j++]=new Array('property(EIDTEST_BABY_AGE_'+i3+')', 'baby age is invalid.', new Function ('varName', 'this.mask=/^[0-9]*$/; return this[varName];'));
            values[j++]=new Array('property(EIDTEST_TEST_TYPE_'+i3+')', 'test type is invalid.', new Function ('varName', 'this.mask=/^[0-9]*$/; return this[varName];'));
            values[j++]=new Array('property(EIDTEST_RESULT_TYPE_'+i3+')', 'result type is invalid.', new Function ('varName', 'this.mask=/^[0-9]*$/; return this[varName];'));
        }
        for(var i1=0;i1<values.length;i1++)
        {
            eval("this.a" + (i1) + "= new Array('"+values[i1][0]+"', '"+values[i1][1]+"', "+values[i1][2]+");");
        }
}

function calculate(todate) {
   
    var d1 = $('.fromdatepicker').datepicker('getDate');
    var d2 = $(todate).datepicker('getDate');
    var rowid=($(todate)[0].id).substring(($(todate)[0].id).lastIndexOf("_") + 1,($(todate)[0].id).length);
    
    var oneDay = 24*60*60*1000;
    var diff = 0;
    if (d1 && d2) {
  
      diff = Math.round(Math.abs((d2.getTime() - d1.getTime())/(oneDay)));
    }
     
    if(diff>=0)
    $("[id$='EIDTEST_VISIT_AGE_"+rowid+"']").val(diff);
   
   
    
}
$(function() {
    $("#EIDTEST_INFANT_NAME").attr("placeholder", "Enter Complete name of the infant");
    $("#EIDTEST_ICTC_ID").attr("placeholder", "Enter ICTC ID of the infant");
    $("#EIDTEST_DNA_PCR_CODE").attr("placeholder", "Enter Unique DNA PCR Code of Infant");
    
   
} );
/*
$('.todatepicker').datepicker().bind("change", function () {
    var maxValue = $(this).val();
   // maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
    //$('.fromdatepicker').datepicker("option", "maxDate", maxValue);
    //calculate(this);
});*/
function setCalDates()
{
/*$('.todatepicker').datepicker().bind("change", function () {
    var maxValue = $(this).val();
    maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
    //$('.fromdatepicker').datepicker("option", "maxDate", maxValue);
    calculate(this);
});
*/
$(function () {
    $("#DELIVERY_ACTUAL_OUTCOME_DATE").datepicker({yearRange: '1940:2020', changeMonth: true, changeYear: true,maxDate:'0+', dateFormat: 'dd-mm-yy'})
});
$('.todatepicker').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'dd-mm-yy',
                minDate:new Date($("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[2], $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[1]-1, $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[0])
                ,maxDate:new Date()
	});
var bcountval=$("#bcount").val();
$(function() {
for(var bc1=1;bc1<=bcountval;bc1++)
{
	$('#DATE_INITIATION_CPT_'+bc1+',#DATE_STOPPING_CPT_'+bc1+',#DATE_VISIT_'+bc1+'').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'dd-mm-yy',
                minDate:new Date($("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[2], $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[1]-1, $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[0])
                ,maxDate:new Date()
	});
        
        $('#RESULT_DATE_'+bc1+'').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'dd-mm-yy',
                minDate:+0
	});
$('#DATE_INITIATION_CPT_'+bc1+'').datepicker().bind("change", function () {
    //var maxValue = $(this).val();
    //maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);    
    //$('#DATE_STOPPING_CPT_1').datepicker("option", "maxDate", maxValue);
    var n1=$(this).attr("id").split("_");
   $('#DURATION_CPT_'+n1[n1.length-1]+'').val(calculateAge($(this).datepicker('getDate'),$('#DATE_STOPPING_CPT_'+n1[n1.length-1]+'').datepicker('getDate')))
});
$('#DATE_STOPPING_CPT_'+bc1+'').datepicker().bind("change", function () {
    //var minValue = $(this).val();   
    //minValue = $.datepicker.parseDate("dd-mm-yy",minValue);
    //$('#DATE_INITIATION_CPT_1').datepicker("option", "minDate", minValue);
    var n1=$(this).attr("id").split("_");
   $('#DURATION_CPT_'+n1[n1.length-1]+'').val( calculateAge($('#DATE_INITIATION_CPT_'+n1[n1.length-1]+'').datepicker('getDate'),$(this).datepicker('getDate')))
});
$('#DATE_VISIT_'+bc1+'').datepicker().bind("change", function () {   
            //$('#DATE_STOPPING_CPT_1').datepicker("option", "maxDate", maxValue);
    var n1=$(this).attr("id").split("_");
            $('#AGE_VISIT_'+n1[n1.length-1]+'').val(calculateWeekAge($('#DELIVERY_ACTUAL_OUTCOME_DATE').datepicker('getDate'),$(this).datepicker('getDate')))
});
}
$('#RESULT_DATE_'+bc1+'').datepicker().bind("change", function () {   
            //$('#DATE_STOPPING_CPT_1').datepicker("option", "maxDate", maxValue);
            if(calculateAge($('#DELIVERY_ACTUAL_OUTCOME_DATE').datepicker('getDate'),$(this).datepicker('getDate'))>181)
            {
                $("#babyage6months1").html("<div class='col-lg-12'>"+
                "   <div class='panel panel-default'>   "+
                   "    <div class='panel-heading'></div>   "+
                    "   <div class='panel-body'>   "+
                    "   <label>History of Breast Feeding during the first 6 months</label>    "+
                    "<select name='property(HISTORY_BREAST_FEEDING_6_MONTHS)' id='HISTORY_BREAST_FEEDING_6_MONTHS' class='required'><option value=''>Select</option><option value='1'>Exclusive Breast Feeding </option><option value='2'>Exclusive Replacement feeding </option><option value='3'>Mixed Feeding (Breast feed+ Other milk products)</option></select>"+
                    
                    "   <label>Date of Stopping Breast Feeds</label>    "+
                    "   <input type='text' name='property(DATE_STOP_BREAST_FEED)' id='DATE_STOP_BREAST_FEED' size='15' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");' class='required'/>"+
                    
                    "   <label>Expected date of Third follow-up</label>    "+
                    "   <input type='text' name='property(EXPECTED_DATE_3_FOLLOWUP)' id='EXPECTED_DATE_3_FOLLOWUP' class='required'/>"+
                    
                    "  </div> </div> </div>");
            }
            else
                {
                    $("#babyage6months1").html("");
                }
});

    
});
}
function calculateAge(fromdate,todate)
    {   
        var agediff;
        if(fromdate!=''&& todate!='')
        {
            agediff=Math.round(((todate - fromdate)/1000/60/60/24));
            if(agediff<0)agediff=0;
        }
        return agediff;
    }
    function calculateWeekAge(fromdate,todate)
    {   
        var agediff;
        if(fromdate!=''&& todate!='')
        {
            agediff=Math.round(((todate - fromdate)/1000/60/60/24/7));
            if(agediff<0)agediff=0;
        }
        return agediff;
    }
setCalDates();
    function calculateDeliveryDate(t)
    {
        var date=new Date();
        if(t.value.length>0)
            {
                var date1=new Date(date-parseInt(t.value)*1000*60*60*24*7);
                var day1=date1.getDate();
                if(day1<10)day1="0"+day1;
                var month1=date1.getMonth()+1;
                if(month1<10) month1="0"+month1;
                var year1=date1.getYear()+1900;
                $("#DELIVERY_ACTUAL_OUTCOME_DATE").val(day1+"-"+month1+"-"+year1);
    $("#DELIVERY_ACTUAL_OUTCOME_DATE").datepicker({yearRange: '1940:2020', changeMonth: true, changeYear: true,maxDate:'0+', dateFormat: 'dd-mm-yy'})
            }
            setCalDates();
            $('#DATE_INITIATION_CPT_1,#DATE_STOPPING_CPT_1,#DATE_VISIT_1,#RESULT_DATE_1').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'dd-mm-yy',
                minDate:new Date($("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[2], $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[1]-1, $("#DELIVERY_ACTUAL_OUTCOME_DATE").val().split("-")[0])
                ,maxDate:new Date()
	});
        
    }
   
 $(document).ready(function() {
       $("#saverecord").on("click", function () 
       {
       var tab1Validator = $('#tab4').validate();
       if ($('#tab4').valid())
       {
           savetab();
       } else {
           tab1Validator.focusInvalid();
           return false;
       }
   });
 });