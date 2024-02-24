     $(document).ready(function() {
         $( "#saverecord" ).on( "click", function() {
        //alert("hai");
                  savetab();
            }); 
       
       
		$(document).ready(function ()
		{
		$("select").select2();
		});
		          
                                $(function () {
    
            $(".datepicker").datepicker({ yearRange: '1940:2020', changeMonth: true, changeYear: true,  dateFormat: 'dd-mm-yy' })
        });
        
        
       
	$('#REG_YEAR').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'yyyy'
	}).focus(function() {
		var thisCalendar = $(this);
		$('.ui-datepicker-calendar').detach();
		$('.ui-datepicker-close').click(function() {
var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
thisCalendar.datepicker('setDate', new Date(year, month, 1));
		});
	});
$('#REG_MONTH').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'MM'
	}).focus(function() {
		var thisCalendar = $(this);
		$('.ui-datepicker-calendar').detach();
		$('.ui-datepicker-close').click(function() {
var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
thisCalendar.datepicker('setDate', new Date(year, month, 1));
		});
	});

        
        
        
   
    $("#ICTC_STATECODE").change(function () {
        var str = "";
        $("#ICTC_STATECODE option:selected").each(function () {
            str += $(this).val() + " ";
             
        });
        
              
        if(str.length>1)
           {  
           
          // alert("HI"+str);
           
                         
        $.ajax({
            type:"POST",
            url:"getDistrict.do?method=getDistrictDetails",
            dataType: 'json',
            data:{
                'statecode':str
                                
                                
            },
            success: function (data, status)
            {
                
                if(typeof(data.success) != 'undefined')
                {
                                   
                    $("#ICTC_DISTCODE option").remove();
                    $( "#ICTC_DISTCODE" ).append(                                      
                    "<option value='0'>--select--</option>"
                                                      
                                       
                );
                                  
                    for( var i = 0; i < data.district.length; i++ ){
                                        
                                                      
                        $("#ICTC_DISTCODE").append(                                      
                        "<option value='"+data.district[i].distid+"'>"+data.district[i].distname+"</option>"
                                                      
                                       
                    );
                                                            
                        // $("#mname").val(data.shg[i].shgname);
                    }
                    
		$("select").select2();
                                    
                }
                if(typeof(data.error) != 'undefined')
                {
                    alert(data.error);
                }
            },
            error: function (data, status, e)
            {
               // alert('data1');
            }
        },new function(){})
      }
                else
                {
                      //alert(str);    
                   
                                 
                    
                }        
              
    });
    
    // 
   $("#OCCUPATION").change(function (){
      
       if($(this).val()==15)
       {
       $("#divOtherOccupation").css("display","block");
       $("#REFERED_FROM_REASON_T1NGO").val('');       
        $("#divReferralT1NGO").css("display","none");
       
       }
       else if($(this).val()==1)
       {
       $("#divReferralT1NGO").css("display","block");
       $("#OCCUPATION_OTHER").val('');       
        $("#divOtherOccupation").css("display","none");
       }
       
       else
       {
            $("#REFERED_FROM_REASON_T1NGO").val('');       
        $("#divReferralT1NGO").css("display","none");
           $("#OCCUPATION_OTHER").val('');
           $("#divOtherOccupation").css("display","none");
       }
   });
    $('input:radio[name="SPOUSE_TESTING_DONE"]').change(
    function(){
        
        if ($(this).is(':checked') && $(this).val() == 'Yes') {
            
            $('#divSpousePID')[0].style.display='';
        }
        else{
            
            $('#SPOUSE_PID').val('');
            $('#SPOUSE_TEST_RESULT').val('');
             $('#divSpousePID')[0].style.display='none';
        }
    
    });
    $("#SPOUSE_REMARKS").change(function (){
      
       if($(this).val()==15)
       {
       $("#divSpouseRemarks").css("display","block");
       $("#PATIENT_DEATH_DATE").val('');
           $("#divPatientDeathdate").css("display","none");
       
       }
       else if($(this).val()==2)
       {
       $("#divPatientDeathdate").css("display","block");
      $("#SPOUSE_REMARKS_OTHER").val('');
           $("#divSpouseRemarks").css("display","none");
       
       }
     
       else
       {
            $("#PATIENT_DEATH_DATE").val('');
           $("#divPatientDeathdate").css("display","none");
           $("#SPOUSE_REMARKS_OTHER").val('');
           $("#divSpouseRemarks").css("display","none");
       }
   });
   $("#MARRITAL_STATUS").change(function (){
      
       if($(this).val()==7)
       {
       $("#divMaritalStatus").css("display","block");
      
       
       }
     
       else
       {
            
           $("#Marital_Status_OTHER").val('');
           $("#divMaritalStatus").css("display","none");
       }
   });
   $("#REFERED_FROM").change(function (){
      if($(this).val()==17)
       {
       $("#divGeneralOtherReferral").css("display","block");
       }
       else
       {
           $("#GENERAL_REFERED_FROM_OTHER").val('');
           $("#divGeneralOtherReferral").css("display","none");
       }
   });
   
$("#STATECODE").change(function () {
        var str = "";
        $("#STATECODE option:selected").each(function () {
            str += $(this).val() + " ";
             
        });
        
              
        if(str.length>1)
           {  
           
          // alert("HI"+str);
           
                         
        $.ajax({
            type:"POST",
            url:"getDistrict.do?method=getDistrictDetails",
            dataType: 'json',
            data:{
                'statecode':str
                                
                                
            },
            success: function (data, status)
            {
                
                if(typeof(data.success) != 'undefined')
                {
                                   
                    $("#DISTCODE option").remove();
                    $( "#DISTCODE" ).append(                                      
                    "<option value='0'>--select--</option>"
                                                      
                                       
                );
                                  
                    for( var i = 0; i < data.district.length; i++ ){
                                        
                                                      
                        $("#DISTCODE").append(                                      
                        "<option value='"+data.district[i].distid+"'>"+data.district[i].distname+"</option>"
                                                      
                                       
                    );
                                                            
                        // $("#mname").val(data.shg[i].shgname);
                    }
                    
		$("select").select2();
                                    
                }
                if(typeof(data.error) != 'undefined')
                {
                    alert(data.error);
                }
            },
            error: function (data, status, e)
            {
               // alert('data1');
            }
        },new function(){})
      }
                else
                {
                      //alert(str);    
                   
                                 
                    
                }        
              
    });
    
    
    
    $("#DISTCODE").change(function () {
        var str = "";
        $("#DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";
             
        });
        
              
        if(str.length>1)
           {  
           
                    
                         
        $.ajax({
            type:"POST",
            url:"getBlock.do?method=getBlockDetails",
            dataType: 'json',
            data:{
                'statecode':$("#STATECODE").val(),
                'distcode': str                
                                
            },
            success: function (data, status)
            {
                
                if(typeof(data.success) != 'undefined')
                {
                                   
                    $("#LOCATION option").remove();
                    $( "#LOCATION" ).append(                                      
                    "<option value='0'>--select--</option>"
                                                      
                                       
                );
                                  
                    for( var i = 0; i < data.block.length; i++ ){
                                        
                                                      
                        $("#LOCATION").append(                                      
                        "<option value='"+data.block[i].blockid+"'>"+data.block[i].blockname+"</option>"
                                                      
                                       
                    );
                                                            
                        // $("#mname").val(data.shg[i].shgname);
                    }
                      
		$("select").select2();              
                }
                if(typeof(data.error) != 'undefined')
                {
                    alert(data.error);
                }
            },
            error: function (data, status, e)
            {
               // alert('data1');
            }
        },new function(){})
      }
                else
                {
                      //alert(str);    
                   
                                 
                    
                }        
              
    }); 
    
    
    
    
    
    
    
     });
     
     
    
     
    function submitTab1(){
        var form1=$(document.forms[0]);
        //alert(24+form1+"   "+form1.serialize())
        $.ajax({
            type:"POST",
            url:'LagacyDataEntry.do?mode=submitTab1',
            dataType: 'json',
            data: form1.serialize(),
            dataType: 'json',
            success: function (data, status)
            {
                if(typeof(data.success) != 'undefined')
                {
                                    
                }
                if(typeof(data.error) != 'undefined')
                {
                    alert(data.error);
                }
            },
            error: function (data, status, e)
            {
               // alert('data1');
            }
        })
    }
