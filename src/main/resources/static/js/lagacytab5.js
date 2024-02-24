function addVisitDetails()
{
    var rowid=$("#babyvisit tbody").children().length+1;
    var row="<tr><td><input type='text' id='EIDTEST_VISIT_DATE_"+rowid+"' name='property(EIDTEST_VISIT_DATE_"+rowid+")' size='10' maxlength='10' onkeypress='return charCheck(event,\"0123456789-\");'  class='form-control todatepicker'/></td>"+
            "<td><input type='text' id='EIDTEST_VISIT_AGE_"+rowid+"' name='property(EIDTEST_VISIT_AGE_"+rowid+")' size='3' maxlength='3' onkeypress='return charCheck(event,\"0123456789\");' /></td>"+
            "<td><input type='radio' name='property(EIDTEST_VISIT_TYPE_"+rowid+")' value='1'/>DBS- DNA PCR "+
            "<input type='radio' name='property(EIDTEST_VISIT_TYPE_"+rowid+")' value='2'/>Antibody testing</td>"+
            "<td><input type='radio' name='property(EIDTEST_VISIT_RESULT_"+rowid+")' value='1'/> Positive"+
            "<input type='radio' name='property(EIDTEST_VISIT_RESULT_"+rowid+")' value='2'/> Negative"+
            "<input type='radio' name='property(EIDTEST_VISIT_RESULT_"+rowid+")' value='3'/> Awaiting&nbsp;results"+
            "</td>"+
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
    minDate:minValue,
});

$('.todatepicker').datepicker().bind("change", function () {
    var maxValue = $(this).val();
    maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
    //$('.fromdatepicker').datepicker("option", "maxDate", maxValue);
    calculate(this);
});
    
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
     
    
    $("[id$='EIDTEST_VISIT_AGE_"+rowid+"']").val(diff);
   
   
    
}
$(function() {
    $("#EIDTEST_INFANT_NAME").attr("placeholder", "Enter Complete name of the infant");
    $("#EIDTEST_ICTC_ID").attr("placeholder", "Enter ICTC ID of the infant");
    $("#EIDTEST_DNA_PCR_CODE").attr("placeholder", "Enter Unique DNA PCR Code of Infant");
    
   
} );