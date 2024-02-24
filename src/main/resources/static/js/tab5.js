     $(document).ready(function() {
         $( "#saverecord" ).on( "click", function() {
       // alert("hai");
                  var tab1Validator = $('#tab2').validate();
       if ($('#tab2').valid())
       {
           savetab();
       } else {
           tab1Validator.focusInvalid();
           return false;
       }
            });
            
           $(function() {
    var availableTags = [
      "1.Tubectomy:Laparoscopic or Tubal ligation",
      "2.No Scalpel Vasectomy (NSV)",
      "3.Not using any family planning method",
      
    ];
    function split( val ) {
      return val.split( /,\s*/ );
    }
    function extractLast( term ) {
      return split( term ).pop();
    }
 
    $( "#tags" )
      // don't navigate away from the field on tab when selecting an item
      .bind( "keydown", function( event ) {
        if ( event.keyCode === $.ui.keyCode.TAB &&
            $( this ).autocomplete( "instance" ).menu.active ) {
          event.preventDefault();
        }
      })
      .autocomplete({
        minLength: 0,
        source: function( request, response ) {
          // delegate back to autocomplete, but extract the last term
          response( $.ui.autocomplete.filter(
            availableTags, extractLast( request.term ) ) );
        },
        focus: function() {
          // prevent value inserted on focus
          return false;
        },
        select: function( event, ui ) {
          var terms = split( this.value );
          // remove the current input
          terms.pop();
          // add the selected item
          terms.push( ui.item.value );
          // add placeholder to get the comma-and-space at the end
          terms.push( "" );
          this.value = terms.join( ", " );
          return false;
        }
      });
  });
  
  
   $(function() {
    var availableTags = [
        "1.Male Condoms ",
        "2.Female Condoms",
      "3.Oral Contraceptive Pills (OCPs)",
      "4.PPIUCD",
      "5.Copper T(380-A)",
      "6.Traditional Method",
    ];
    function split( val ) {
      return val.split( /,\s*/ );
    }
    function extractLast( term ) {
      return split( term ).pop();
    }
 
    $( "#tags1" )
      // don't navigate away from the field on tab when selecting an item
      .bind( "keydown", function( event ) {
        if ( event.keyCode === $.ui.keyCode.TAB &&
            $( this ).autocomplete( "instance" ).menu.active ) {
          event.preventDefault();
        }
      })
      .autocomplete({
        minLength: 0,
        source: function( request, response ) {
          // delegate back to autocomplete, but extract the last term
          response( $.ui.autocomplete.filter(
            availableTags, extractLast( request.term ) ) );
        },
        focus: function() {
          // prevent value inserted on focus
          return false;
        },
        select: function( event, ui ) {
          var terms = split( this.value );
          // remove the current input
          terms.pop();
          // add the selected item
          terms.push( ui.item.value );
          // add placeholder to get the comma-and-space at the end
          terms.push( "" );
          this.value = terms.join( ", " );
          return false;
        }
      });
  });
           
           
            $('input:radio[Id="WHETHER_SPOUSE_PARTNER_TESTED_FOR_HIV_NOW"]').change(
    function(){
       
        if ($(this).is(':checked') && $(this).val() == 'yes') {
            
           
             $('#confdt')[0].style.display='';
              $('#reason')[0].style.display='none';
             $('#REASON_FOR_NOT_TESTING_THE_SPOUSE').val('');
              $('#SPOUSE_PREART_REG_NUM').prop('disabled',false);
             $('#SPOUSE_PID').prop('disabled',false);
        }
        else{
            
          //  $('#ART_TB_ATT_STARTDATE').val('');
          //  $('#ART_TB_ATT_ENDDATE').val('');
             $('#reason')[0].style.display='';
             $('#confdt')[0].style.display='none';
             $('#SPOUSE_PREART_REG_NUM').prop('disabled',true);
             $('#SPOUSE_PID').prop('disabled',true);
              $('#SPOUSE_HIV_CONF_DATE').val('');
               $('#SPOUSE_PREART_REG_NUM').val('');
               $('#SPOUSE_PID').val('');
                $('input[Id="SPOUSE_HIV_STATUS"]').prop('checked', false);
        }
    
    });
           
       $('#SPOUSE_OCCUPATION').change(
    function(){
       
        if ($(this).val() == '15') {
            
            $('#divOtherspouseOccupation')[0].style.display='';
            
        }
        else{
           $('#divOtherspouseOccupation')[0].style.display='none';
           $('#SPOUSE_OCCUPATION_OTHER').val('');
        }
    
    });
    
     $('#NUM_CHILDREN_TESTED').change(
    function(){
       
        if ($(this).val() > $('#NUM_CHILDREN').val()) {
            
           $(this).val('');
            
        }
        
    
    }, "Invalid" );
    
    
     
      $('input:radio[Id="SPOUSE_FAMILY_PLANING"]').change(
    function(){
       
        if ($(this).is(':checked') && $(this).val() == 'yes') {
            
            $('#temp')[0].style.display='';
            $('#per')[0].style.display='none';
        }
        else{
          $('#temp')[0].style.display='none';  
          $('#per')[0].style.display='';
        }
    
    });
    
    $('input:radio[Id="SPOUSE_HIV_STATUS"]').change(
    function(){
       
        if ($(this).is(':checked') && $(this).val() == 'positive') {
            
            $('#SPOUSE_PREART_REG_NUM').prop('disabled',false);
            
        }
        else{
           $('#SPOUSE_PREART_REG_NUM').prop('disabled',true);
        }
    
    });
       
       $('input:radio[name="spouse_hiv_positive_case"]').change(
    function(){
       
        if ($(this).is(':checked') && $(this).val() == 'positive') {
            
            $('#hiv')[0].style.display='none';
        }
        else{
            
          //  $('#ART_TB_ATT_STARTDATE').val('');
          //  $('#ART_TB_ATT_ENDDATE').val('');
             $('#hiv')[0].style.display='';
        }
    
    });
    
    
    
     $('input:radio[name="address"]').change(
    function(){
       
        if ($(this).is(':checked') && $(this).val() == 'no') {
            
            $('#addressdetails')[0].style.display='';
        }
        else{
            
           
             $('#addressdetails')[0].style.display='none';
        }
    
    });
       
		$(document).ready(function ()
		{
		$("select").select2();
		});
		          
    $(function () {
    
            $(".datepicker").datepicker({ yearRange: '1940:2020', changeMonth: true, changeYear: true,maxDate:'0+', dateFormat: 'dd-mm-yy' })
        });
        
        
        $(function() {
	$('#MOTHER_REG_YEAR').datepicker({
		changeMonth: true,
		changeYear: true,
		showButtonPanel: true,
		dateFormat: 'MM yy'
	}).focus(function() {
		var thisCalendar = $(this);
		$('.ui-datepicker-calendar').detach();
		$('.ui-datepicker-close').click(function() {
var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
thisCalendar.datepicker('setDate', new Date(year, month, 1));
		});
	});
});
        
         $("#SPOUSE_OCCUPATION").change(function (){
      
       if($(this).val()==15)
       {
       $("#divOtherspouseOccupation").css("display","block");
       }
       else
       {
           $("#SPOUSE_OCCUPATION_OTHER").val('');
           $("#divOtherspouseOccupation").css("display","none");
       }
   });
        
   
    $("#SPOUSE_TESTING_STATECODE").change(function () {
        var str = "";
        $("#SPOUSE_TESTING_STATECODE option:selected").each(function () {
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
                                   
                    $("#SPOUSE_TESTING_DISTCODE option").remove();
                    $( "#SPOUSE_TESTING_DISTCODE" ).append(                                      
                    "<option value='0'>--select--</option>"
                                                      
                                       
                );
                                  
                    for( var i = 0; i < data.district.length; i++ ){
                                        
                                                      
                        $("#SPOUSE_TESTING_DISTCODE").append(                                      
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
    
    $("#SPOUSE_TESTING_DISTCODE").change(function () {
        var str = "";
        $("#SPOUSE_TESTING_DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";
             
        });
        
              
        if(str.length>1)
           {  
           
                    
                         
        $.ajax(
                {
            type:"POST",
            url:"getIctc.do?method=getIctc",
            dataType: 'json',
            data:{
                'statecode':$("#SPOUSE_TESTING_STATECODE").val(),
                'distcode': str                
                                
            },
            success: function (data, status)
            {
                
                if(typeof(data.success) != 'undefined')
                {
                                   
                    $("#SPOUSE_TESTING_ICTSCODE option").remove();
                    $( "#SPOUSE_TESTING_ICTSCODE" ).append(                                      
                    "<option value='0'>--select--</option>"
                                                      
                                       
                );
                                  
                    for( var i = 0; i < data.ictc.length; i++ ){
                                        
                                                      
                        $("#SPOUSE_TESTING_ICTSCODE").append(                                      
                        "<option value='"+data.ictc[i].ictcid+"'>"+data.ictc[i].ictcname+"</option>"
                                                      
                                       
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
    
    
    
    
   
    $(function() {
        $('.fromdatepicker').datepicker({
    dateFormat: 'dd-mm-yy',
    maxDate:'0+',
    changeMonth: true,
    changeYear: true,
    yearRange:'2004:+0',
});
$('.todatepicker').datepicker({
    dateFormat: 'dd-mm-yy',
    changeMonth: true,
    changeYear: true,
});
$('.fromdatepicker').datepicker().bind("change", function () {
    var minValue = $(this).val();
    minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
    minValue.setMonth(minValue.getMonth() + 9)
 
    minValue.setDate(minValue.getDate() + 7);   
  // alert(minValue);
  $('.todatepicker').datepicker("setDate",minValue);
    $('.todatepicker').datepicker("option", "minDate", minValue);
    $('.todatepicker').datepicker("option", "yearRange",(new Date(minValue)).getFullYear() +':+0');
    //calculate();
});
$('.todatepicker').datepicker().bind("change", function () {
    var maxValue = $(this).val();
   
    maxValue = $.datepicker.parseDate("dd-mm-yy",maxValue);
     maxValue.setMonth(maxValue.getMonth() - 9) 
    maxValue.setDate(maxValue.getDate() - 7); 
    $('.fromdatepicker').datepicker("setDate", maxValue);
    $('.fromdatepicker').datepicker("option", "maxDate", maxValue);
   // calculate();
});
    });
    
    
     $("#ART_STATECODE").change(function () {
        var str = "";
        $("#ART_STATECODE option:selected").each(function () {
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
                                   
                    $("#ART_DISTCODE option").remove();
                    $( "#ART_DISTCODE" ).append(                                      
                    "<option value='0'>--select--</option>"
                                                      
                                       
                );
                                  
                    for( var i = 0; i < data.district.length; i++ ){
                                        
                                                      
                        $("#ART_DISTCODE").append(                                      
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
    
    
    $("#ART_DISTCODE").change(function () {
        var str = "";
        $("#ART_DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";
             
        });
        
              
        if(str.length>1)
           {  
           
                    
                         
        $.ajax({
            type:"POST",
            url:"getART.do?method=getArtDetails",
            dataType: 'json',
            data:{
                'statecode':$("#ART_STATECODE").val(),
                'distcode': str                
                                
            },
            success: function (data, status)
            {
                
                if(typeof(data.success) != 'undefined')
                {
                                   
                    $("#ART_ARTCODE option").remove();
                    $( "#ART_ARTCODE" ).append(                                      
                    "<option value='0'>--select--</option>"
                                                      
                                       
                );
                                  
                    for( var i = 0; i < data.art.length; i++ ){
                                        
                                                      
                        $("#ART_ARTCODE").append(                                      
                        "<option value='"+data.art[i].artid+"'>"+data.art[i].artname+"</option>"
                                                      
                                       
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
     
      $('#MOTHER_ORDER_PREGNANCY').change(
    function(){
       
        if ($(this).val() == '1'||$(this).val() == '0') {
            
            $('#orderpreg1')[0].style.display='none';
           
        }
        else{
           $('#orderpreg1')[0].style.display='';
        }
    
    });
    $(function() {
    
    $("#SPOUSE_PID").attr("placeholder", "Enter the spouse PID");
    $("#SPOUSE_ADHAR_NO").attr("placeholder", "Enter 12 digit ADHAR No. in numerics ");
    $("#SPOUSE_MOBILE").attr("placeholder", "Enter the 10 digit  Mobile No");
    $("#SPOUSE_NAME").attr("placeholder", "Enter the Spouse name");
    
} );
     
    
    
    
    
    
