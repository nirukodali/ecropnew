/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    
    $( "#saverecord" ).on( "click", function() {
        
                  savetab();
            }); 
         $(".datepicker").datepicker({ yearRange: '1940:2020', changeMonth: true, changeYear: true,maxDate:'0+ ', dateFormat: 'dd-mm-yy' })
        
    
});
    function difAdressno() {


        $("#divATTdetails1").css("display", "block")
    };

    function difAdressyes() {


        $("#divATTdetails1").css("display", "none")
    };

    function nagativeYes() {


        $("#negative").css("display", "none")
    }

    function nagativeNo() {


        $("#negative").css("display", "block")
    }

$(function() {
    $("#FEEDING_DURING_BREST").attr("placeholder", "Enter Duration of Exclusive Breastfeeding(in Weeks)");
    $("#FEEDING_DURING_COMPLEMENTARY").attr("placeholder", "Enter Duration of Breast Feeding including Complementary Feeding");
    $("#FEEDING_ANTIBODY_TESTING_DATE").attr("placeholder", "Date of the 18th month Antibody testing");
    $("#FEEDING_AGE_CHILD").attr("placeholder", "Enter Age of child  ");
    $("#FEEDING_RESULTS_ANTIBODY_TEST").attr("placeholder", "Enter Confirmatory Antibody Test Result");
    $("#FEEDING_DATE_STOP_CONTRIMOX").attr("placeholder", "Enter Date of Stopping of Co-trimoxazole (CPT) in HIV Negative babies");
    $("#FEEDING_DUR_CONTRIMOX").attr("placeholder", "Enter Duration of Co-trimoxazole Prophylactic Therapy");
    $("#FEEDING_CURRENT_STATUS_BABY").attr("placeholder", "Enter Current status of the Baby (if baby is not getting followed up) ");
    $("#FEEDING_DATE_DNA_PCR_TEST").attr("placeholder", "Enter Date of Follow up DNA PCR test if Antibody test is negative");
   $("#result_DNA_PCR_test").attr("placeholder", "Enter Result of Follow up DNA PCR if Antibody test negative");
    $("#FEEDING_ART_STATUS_CHILD").attr("placeholder", "Enter ART Status of Child at or beyond 18 months");
    $("#FEEDING_PID_SPOUSE").attr("placeholder", "Enter PID Number of Spouse) ");
    $("#FEEDING_DATE_SPOUSE_TESTING").attr("placeholder", "Enter Spouse testing Date ");
    $("#FEEDING_SPOUSE_TESTING_RESULT").attr("placeholder", "Enter Spouse HIV Test Result");
    $("#FEEDING_SPOUSE_PRE_ART_REGNO").attr("placeholder", "Enter Spouse Pre ART Reg. Number ");
    $("#FEEDING_NUM__CHILDREN_MOTHER").attr("placeholder", "Enter Number of other older children to this AN/PN mother ");
    $("#FEEDING_NUM_CHILDREN_MOTHER_TESTED_HIV").attr("placeholder", "Enter Number of other older children of this AN/PN mother tested for HIV");
    $("#FEEDING_FAMILY_PLANNING_MEASURES").attr("placeholder", "Enter Family Planning Measures");
    $("#FEEDING_DATE_PRE_ART_REGIST").attr("placeholder", "Enter Date of Pre ART registration of child");
    $("#FEEDING_PRE_ART_NUMBER").attr("placeholder", "Enter Pre ART Number OF child ");
    $("#FEEDING_BASELINE_CD4").attr("placeholder", "Enter Baseline CD4 % of child ");
    $("#FEEDING_DATE_INITIATION_ART_TO_CHILD").attr("placeholder", "Enter Date of Initiation of  ART for the HIV +ve Child");
    $("#FEEDING_ART_REGISTRATION_NUMBER_INFANT").attr("placeholder", "Enter On ART registration Number of infant");
    $("#REMARKS").attr("placeholder", "Enter Remarks");
   
   
} );