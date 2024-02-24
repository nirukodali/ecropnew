/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




$('#DELIVERY_OUTCOME_PREG').change(
    function(){
       
        if ($(this).val() == 'LIVEBIRTH') {
            
            $('#livebirth')[0].style.display='';
            $('#twins')[0].style.display='none';
            
        }
        else if ($(this).val() == 'TWINS'){
          $('#livebirth')[0].style.display='';
          $('#twins')[0].style.display='';
        }
        else {
            $('#livebirth')[0].style.display='none';
          $('#twins')[0].style.display='none';
        }
     
          $('.fromdatepicker1').datepicker("option", "minDate", getMin_MaxOutcomedate('min'));
          $('.fromdatepicker1').datepicker("option", "maxDate", getMin_MaxOutcomedate('max'));
     
    });


$('#REASONS_FOR_STOPPING_PROPHYLAXIS').change(
    function(){
       
        if ($(this).val() == '5') {
            
            $('#otherreason')[0].style.display='';
            
          
        }
        else {
          $('#otherreason')[0].style.display='none';
        }
        
    
    });
    
    
    $('#REASONS_FOR_STOPPING_PROPHYLAXIS1').change(
    function(){
       
        if ($(this).val() == '5') {
            
            $('#otherreason1')[0].style.display='';
            
          
        }
        else {
          $('#otherreason1')[0].style.display='none';
        }
        
    
    });
    




$(function () {
    //alert("HI");
   
   $("#saverecord").on("click", function () {
       // alert("hai");
       //alert($('#tab1').valid());
       var tab1Validator = $('#tab3').validate();
       if ($('#tab3').valid())
       {
           savetab();
       } else {
           tab1Validator.focusInvalid();
           return false;
       }
   });
    $("select").select2();
    $(".datepicker").datepicker({yearRange: '1940:2020', changeMonth: true, changeYear: true,maxDate:'0+', dateFormat: 'dd-mm-yy'})
    $(".eventdatepicker").datepicker({yearRange: '1940:2020', changeMonth: true, changeYear: true,maxDate:'0+', dateFormat: 'dd-mm-yy'})


    $("#DELIVERY_STATECODE").change(function () {
        var str = "";
        $("#DELIVERY_STATECODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {

            // alert("HI"+str);


            $.ajax({
                type: "POST",
                url: "getDistrict.do?method=getDistrictDetails",
                dataType: 'json',
                data: {
                    'statecode': str
                     

                },
                success: function (data, status)
                {

                    if (typeof (data.success) != 'undefined')
                    {

                        $("#DELIVERY_DISTCODE option").remove();
                        $("#DELIVERY_DISTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.district.length; i++) {


                            $("#DELIVERY_DISTCODE").append(
                                    "<option value='" + data.district[i].distid + "'>" + data.district[i].distname + "</option>"


                                    );

                            // $("#mname").val(data.shg[i].shgname);
                        }

                        $("select").select2();

                    }
                    if (typeof (data.error) != 'undefined')
                    {
                        alert(data.error);
                    }
                },
                error: function (data, status, e)
                {
                    // alert('data1');
                }
            }, new function () {
            })
        }
        else
        {
            //alert(str);    



        }

    });



    $("#DELIVERY_DISTCODE").change(function () {
        var str = "";
        $("#DELIVERY_DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {



            $.ajax({
                type: "POST",
                url: "getBlock.do?method=getBlockDetails",
                dataType: 'json',
                data: {
                    'statecode': $("#DELIVERY_STATECODE").val(),
                    'distcode': str

                },
                success: function (data, status)
                {

                    if (typeof (data.success) != 'undefined')
                    {

                        $("#DELIVERY_BLOCK option").remove();
                        $("#DELIVERY_BLOCK").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.block.length; i++) {


                            $("#DELIVERY_BLOCK").append(
                                    "<option value='" + data.block[i].blockid + "'>" + data.block[i].blockname + "</option>"


                                    );

                            // $("#mname").val(data.shg[i].shgname);
                        }

                        $("select").select2();
                    }
                    if (typeof (data.error) != 'undefined')
                    {
                        alert(data.error);
                    }
                },
                error: function (data, status, e)
                {
                    // alert('data1');
                }
            }, new function () {
            })
        }
        else
        {
            //alert(str);    



        }

    });
    
     $('#HIV_INFECT_MOTHER').change(
    function(){
       
        if ($(this).val() == 'HIV I') {
            
            $('#hiv1')[0].style.display='';
            $('#hiv2')[0].style.display='none';
            
        }
        else{
          $('#hiv1')[0].style.display='none';  
          $('#hiv2')[0].style.display='';
        }
    
    });
    
$("#DELIVERY_ART_ANC_INITIATION_DURATION").change(function(){
    if(parseInt($(this).val())<24)
    {
        $("#EXP_PERIOD_ARV_PROPHYLAXIS").val('12')
    }
    else{
        $("#EXP_PERIOD_ARV_PROPHYLAXIS").val('6');
    }
    if(parseInt($(this).val())<6 || parseInt($(this).val())<12 )
    {
        
        $("#divPROPHYLAXIS")[0].style.display='';
        
    }
    else{
        
     $("#divPROPHYLAXIS")[0].style.display='none';
     $("#REASONS_FOR_STOPPING_PROPHYLAXIS").val('').change();
    }
});


 $('.fromdatepicker1').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    maxDate:getMin_MaxOutcomedate('max'),
    changeYear: true,
    minDate:getMin_MaxOutcomedate('min'),
});
$('.todatepicker1').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    changeYear: true,
});
$('.fromdatepicker1').datepicker().bind("change", function () {
    var minValue = $(this).val();
    minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
    $('.todatepicker1').datepicker("option", "minDate", minValue);
    calculate();
});
$('.todatepicker1').datepicker().bind("change", function () {
    var maxValue = $(this).val();
    maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
    $('.fromdatepicker1').datepicker("option", "maxDate", maxValue);
    calculate();
});

$('.fromdatepickerpro').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    changeYear: true,
});
$('.todatepickerpro').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    changeYear: true,
});
$('.fromdatepickerpro').datepicker().bind("change", function () {
    var minValue = $(this).val();
    minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
    $('.todatepickerpro').datepicker("option", "minDate", minValue);
    calculate();
});
$('.todatepickerpro').datepicker().bind("change", function () {
    var maxValue = $(this).val();
    maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
    $('.fromdatepickerpro').datepicker("option", "maxDate", maxValue);
    calculatepro();
});



$('.fromdatepickerpro1').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    changeYear: true,
});
$('.todatepickerpro1').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    changeYear: true,
});
$('.fromdatepickerpro1').datepicker().bind("change", function () {
    var minValue = $(this).val();
    minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
    $('.todatepickerpro1').datepicker("option", "minDate", minValue);
    calculate();
});
$('.todatepickerpro1').datepicker().bind("change", function () {
    var maxValue = $(this).val();
    maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
    $('.fromdatepickerpro1').datepicker("option", "maxDate", maxValue);
    calculatepro1();
});












});

function getMin_MaxOutcomedate(type){
    var lmpdate=$('#MOTHER_LMP_DATE').val();
    var minoutcomedate = null;
    var maxoutcomedate='0+';
   
    if($("#DELIVERY_OUTCOME_PREG").val()=='LIVEBIRTH'||$("#DELIVERY_OUTCOME_PREG").val()=='TWINS')
    {
       // alert(lmpdate);
 minoutcomedate = $.datepicker.parseDate("dd-mm-yy",lmpdate);
 //alert(minoutcomedate)
 minoutcomedate.setMonth(minoutcomedate.getMonth() + 6);
 //alert(minoutcomedate)
        
    }
    else if ($("#DELIVERY_OUTCOME_PREG").val()=='MTP'||$("#DELIVERY_OUTCOME_PREG").val()=='ABORTION')
    {
        minoutcomedate = $.datepicker.parseDate("dd-mm-yy",lmpdate);
        maxoutcomedate = $.datepicker.parseDate("dd-mm-yy", lmpdate);
 maxoutcomedate.setMonth(maxoutcomedate.getMonth()+5);
 //alert(maxoutcomedate)
 //alert(calculateDateDiff(maxoutcomedate,new Date()))
 if(calculateDateDiff(maxoutcomedate,new Date())<0)
 maxoutcomedate='0+';
    }
    //alert(type=='min'?minoutcomedate:maxoutcomedate);
    return type=='min'?minoutcomedate:maxoutcomedate;
}

function calculateDateDiff(fromdate,todate){
     var d1 = fromdate;
    
    var d2 = todate;
    
    var oneDay = 24*60*60*1000;
    var diff = 0;
    if (d1 && d2) {
  
      diff = Math.round(Math.abs((d2.getTime() - d1.getTime())/(oneDay)));
    }
   return diff;
}
function calculate() {
    var d1 = $('.fromdatepicker1').datepicker('getDate');
    
    var d2 = $('.todatepicker1').datepicker('getDate');
    
    var oneDay = 24*60*60*1000;
    var diff = 0;
    if (d1 && d2) {
  
      //diff = Math.round(Math.abs((d2.getTime() - d1.getTime())/(oneDay)));
    }
    $('.calculated1').val(diff);
    
}










function calculatepro() {
    var d1 = $('.fromdatepickerpro').datepicker('getDate');
    
    var d2 = $('.todatepickerpro').datepicker('getDate');
    
    //var oneDay = 24*60*60*1000;
    var diff = 0;
    if (d1 && d2) {
  
      diff = Math.round(Math.abs((d2 - d1)/1000/60/60/24));
    }
    $('.calculatedpro').val(diff);
    
}

function calculatepro1() {
    var d1 = $('.fromdatepickerpro1').datepicker('getDate');
    
    var d2 = $('.todatepickerpro1').datepicker('getDate');
    
    //var oneDay = 24*60*60*1000;
    var diff = 0;
    if (d1 && d2) {
  
      diff = Math.round(Math.abs((d2 - d1)/1000/60/60/24));
    }
    $('.calculatedpro1').val(diff);
    
}





 $(function() {
    $("#DELIVERY_EXPECTED_DATE").attr("placeholder", "Enter Expected Date of Delivery");
    $("#DELIVERY_ACTUAL_OUTCOME_DATE").attr("placeholder", "Enter Date of Outcome");
    $("#DELIVERY_ART_INITIATION_DATE").attr("placeholder", "Enter ART Initiation Date ");
    $("#DELIVERY_ART_ANC_INITIATION_DURATION").attr("placeholder", "Enter Duration of ANC initiated on ART till delivery (in weeks)  ");
    $("#DELIVERY_EXPECTED_PINCODE").attr("placeholder", "Enter Pincode");
   
} );