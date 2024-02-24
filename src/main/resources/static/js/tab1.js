$(document).ready(function () {
   /* $('.required').bind('blur', function () {

        if (!($(this).valid()))
        {
            return;
        }
    });*/


    $("#saverecord").on("click", function () {
        // alert("hai");
        //alert($('#tab1').valid());
        var tab1Validator = $('#tab1').validate();
        if ($('#tab1').valid())
        {
            savetab();
        } else {
            tab1Validator.focusInvalid();
            return false;
        }
    });

    $('input:radio[Id="HIV_POSITIVE_CASE"]').change(
            function () {
//alert($(this).val());
                if ($(this).is(':checked') && $(this).val() == 'positive') {
                    //$("#tab1")[0].reset();
                    $('#main')[0].style.display = '';
                    $('#hiv')[0].style.display = 'none';
                    // $('#HIV_POSITIVE_CASE')[0].style.disable=false;

                    var mindate = new Date();

                    mindate.setDate(mindate.getDate() - 315);
                    $('.anc_reg_date').datepicker("option", "minDate", mindate);
                    $('.dateLMP').datepicker("option", "minDate", mindate);
                }
                else {

                    var mindate = new Date('01/01/2010');

                    $('.anc_reg_date').datepicker("option", "minDate", mindate);
                    $('.dateLMP').datepicker("option", "minDate", mindate);
                    //  $("#tab1")[0].reset();
                    //  $('#ART_TB_ATT_STARTDATE').val('');
                    //  $('#ART_TB_ATT_ENDDATE').val('');
                    $('#main')[0].style.display = '';
                    $('#hiv')[0].style.display = '';
                    $('#post')[0].style.display = 'none';
                    //  $('#HIV_POSITIVE_CASE')[0].style.display='negative';


                }

            });



    $('#MOTHER_ORDER_PREGNANCY').change(
            function () {

                if ($(this).val() == '1' || $(this).val() == '0') {

                    $('#orderpreg')[0].style.display = 'none';
                    //  $('#WHETHER_NVP_GIVEN').val('false');
                    $('input[Id="WHETHER_NVP_GIVEN"]').prop('checked', false);

                }
                else {
                    $('#orderpreg')[0].style.display = '';
                }

            });


    $('input:radio[Id="WHETHER_TESTED_FOR_TB"]').change(
            function () {

                if ($(this).is(':checked') && $(this).val() == 'yes') {

                    $('#tbresult')[0].style.display = '';
                    $('#attresult')[0].style.display = 'none';
                    $('input[Id="WHETHER_STARTED_ON_ATT"]').prop('checked', false);
                }
                else {

                    $('#tbresult')[0].style.display = 'none';
                    $('#attresult')[0].style.display = 'none';
                    $('input[Id="ART_TB_DIAGNOZIED"]').prop('checked', false);
                    $('input[Id="WHETHER_STARTED_ON_ATT"]').prop('checked', false);
                }

            });


    $('input:radio[Id="ART_TB_DIAGNOZIED"]').change(
            function () {

                if ($(this).is(':checked') && $(this).val() == 'positive') {

                    $('#attresult')[0].style.display = '';
                }
                else {

                    $('#attresult')[0].style.display = 'none';
                    $('input[Id="WHETHER_STARTED_ON_ATT"]').prop('checked', false);
                }

            });




    $('input:radio[Id="WHETHER_TESTED_FOR_SYPHILIS"]').change(
            function () {

                if ($(this).is(':checked') && $(this).val() == 'yes') {

                    $('#syphilresult')[0].style.display = '';
                }
                else {

                    $('#syphilresult')[0].style.display = 'none';
                    $('input[Id="SYPHILIS_DIAGNOZIED"]').prop('checked', false);
                }

            });





    $('input:radio[Id="art_reg"]').change(
            function () {

                if ($(this).is(':checked') && $(this).val() == 'no') {

                    $('#pre')[0].style.display = 'none';
                }
                else {


                    $('#pre')[0].style.display = '';
                }

            });


    $('input:radio[Id="ON_ART"]').change(
            function () {

                if ($(this).is(':checked') && $(this).val() == 'no') {

                    $('#artregno')[0].style.display = 'none';
                    $('#ART_REG_NUMBER').val('');
                }
                else {


                    $('#artregno')[0].style.display = '';
                }

            });

    $('input:radio[Id="ART_REG"]').change(
            function () {

                if ($(this).is(':checked') && $(this).val() == 'no') {

                    $('#preartregno')[0].style.display = 'none';
                    $('#PRE_ART_REG_NUMBER').val('');
                }
                else {


                    $('#preartregno')[0].style.display = '';
                }

            });






    $('input:radio[Id="ADDRESS"]').change(
            function () {

                if ($(this).is(':checked') && $(this).val() == 'no') {

                    $('#addressdetails')[0].style.display = '';
                }
                else {


                    $('#addressdetails')[0].style.display = 'none';
                }

            });

    $(document).ready(function ()
    {
        $("select").select2();
    });

    $(function () {

        $(".datepicker").datepicker({yearRange: '1940:2020', changeMonth: true, changeYear: true, maxDate: '0+', dateFormat: 'dd-mm-yy'})
    });


    $(function () {
        $('#MOTHER_REG_YEAR').datepicker({
            changeMonth: true,
            changeYear: true,
            showButtonPanel: true,
            dateFormat: 'MM yy'
        }).focus(function () {
            var thisCalendar = $(this);
            $('.ui-datepicker-calendar').detach();
            $('.ui-datepicker-close').click(function () {
                var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                thisCalendar.datepicker('setDate', new Date(year, month, 1));
            });
        });
    });




    $("#MOTHER_FACILITY_STATECODE").change(function () {
        var str = "";
        $("#MOTHER_FACILITY_STATECODE option:selected").each(function () {
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

                        $("#MOTHER_FACILITY_DISTCODE option").remove();
                        $("#MOTHER_FACILITY_DISTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.district.length; i++) {


                            $("#MOTHER_FACILITY_DISTCODE").append(
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

    // 

    $('#MOTHER_OCCUPATION').change(
            function () {

                if ($(this).val() == '15') {

                    $('#divOtherOccupation')[0].style.display = '';

                }
                else {
                    $('#divOtherOccupation')[0].style.display = 'none';
                    $('#MOTHER_OCCUPATION_OTHER').val('');

                }

            });
    $("#MOTHER_REFERED_FROM").change(function () {
        if ($(this).val() == 17)
        {
            $("#divOtherReferral").css("display", "block");
        }
        else
        {
            $("#MOTHER_REFERED_FROM_OTHER").val('');
            $("#divOtherReferral").css("display", "none");
        }
    });

    $("#MOTHER_SPOUSE_STATECODE").change(function () {
        var str = "";
        $("#MOTHER_SPOUSE_STATECODE option:selected").each(function () {
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

                        $("#MOTHER_SPOUSE_DISTCODE option").remove();
                        $("#MOTHER_SPOUSE_DISTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.district.length; i++) {


                            $("#MOTHER_SPOUSE_DISTCODE").append(
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



    $("#MOTHER_SPOUSE_DISTCODE").change(function () {
        var str = "";
        $("#MOTHER_SPOUSE_DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {



            $.ajax({
                type: "POST",
                url: "getBlock.do?method=getBlockDetails",
                dataType: 'json',
                data: {
                    'statecode': $("#MOTHER_SPOUSE_STATECODE").val(),
                    'distcode': str

                },
                success: function (data, status)
                {

                    if (typeof (data.success) != 'undefined')
                    {

                        $("#MOTHER_SPOUSE_BLOCK option").remove();
                        $("#MOTHER_SPOUSE_BLOCK").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.block.length; i++) {


                            $("#MOTHER_SPOUSE_BLOCK").append(
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



    $("#MOTHER_FATHER_STATECODE").change(function () {
        var str = "";
        $("#MOTHER_FATHER_STATECODE option:selected").each(function () {
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

                        $("#MOTHER_FATHER_DISTCODE option").remove();
                        $("#MOTHER_FATHER_DISTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.district.length; i++) {


                            $("#MOTHER_FATHER_DISTCODE").append(
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


    $("#MOTHER_FATHER_DISTCODE").change(function () {
        var str = "";
        $("#MOTHER_FATHER_DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {


            $.ajax({
                type: "POST",
                url: "getBlock.do?method=getBlockDetails",
                dataType: 'json',
                data: {
                    'statecode': $("#MOTHER_FATHER_STATECODE").val(),
                    'distcode': str

                },
                success: function (data, status)
                {

                    if (typeof (data.success) != 'undefined')
                    {

                        $("#MOTHER_FATHER_BLOCK option").remove();
                        $("#MOTHER_FATHER_BLOCK").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.block.length; i++) {


                            $("#MOTHER_FATHER_BLOCK").append(
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



    $("#MOTHER_ICTCSTATECODE").change(function () {
        var str = "";
        $("#MOTHER_ICTCSTATECODE option:selected").each(function () {
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

                        $("#MOTHER_ICTCDISTCODE option").remove();
                        $("#MOTHER_ICTCDISTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.district.length; i++) {


                            $("#MOTHER_ICTCDISTCODE").append(
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


    $("#MOTHER_ICTCDISTCODE").change(function () {
        var str = "";
        $("#MOTHER_ICTCDISTCODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {



            $.ajax(
                    {
                        type: "POST",
                        url: "getIctc.do?method=getIctc",
                        dataType: 'json',
                        data: {
                            'statecode': $("#MOTHER_ICTCSTATECODE").val(),
                            'distcode': str

                        },
                        success: function (data, status)
                        {

                            if (typeof (data.success) != 'undefined')
                            {

                                $("#MOTHER_ICTCCODE option").remove();
                                $("#MOTHER_ICTCCODE").append(
                                        "<option value='0'>--select--</option>"


                                        );

                                for (var i = 0; i < data.ictc.length; i++) {


                                    $("#MOTHER_ICTCCODE").append(
                                            "<option value='" + data.ictc[i].ictcid + "'>" + data.ictc[i].ictcname + "</option>"


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




    $("#MOTHER_TESTING_STATECODE").change(function () {
        var str = "";
        $("#MOTHER_TESTING_STATECODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {

            //alert("HI"+str);


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

                        $("#MOTHER_TESTING_DISTCODE option").remove();
                        $("#MOTHER_TESTING_DISTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.district.length; i++) {


                            $("#MOTHER_TESTING_DISTCODE").append(
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


    $("#MOTHER_TESTING_DISTCODE").change(function () {
        var str = "";
        $("#MOTHER_TESTING_DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {



            $.ajax({
                type: "POST",
                url: "getIctc.do?method=getIctc",
                dataType: 'json',
                data: {
                    'statecode': $("#MOTHER_TESTING_STATECODE").val(),
                    'distcode': str

                },
                success: function (data, status)
                {

                    if (typeof (data.success) != 'undefined')
                    {

                        $("#MOTHER_TESTING_ICTSCODE option").remove();
                        $("#MOTHER_TESTING_ICTSCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.ictc.length; i++) {


                            $("#MOTHER_TESTING_ICTSCODE").append(
                                    "<option value='" + data.ictc[i].ictcid + "'>" + data.ictc[i].ictcname + "</option>"


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


    $(function () {
        $('.dateLMP').datepicker({
            dateFormat: 'dd-mm-yy',
            maxDate: '0+',
            changeMonth: true,
            changeYear: true,
            yearRange: '2004:+0',
        });
        $('.todatepicker').datepicker({
            dateFormat: 'dd-mm-yy',
            changeMonth: true,
            changeYear: true,
        });
        $('.dateLMP').datepicker().bind("change", function () {
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
            minValue.setMonth(minValue.getMonth() + 9)

            minValue.setDate(minValue.getDate() + 7);
            // alert(minValue);           
            
            $('.todatepicker').datepicker("setDate", minValue);
            $('.todatepicker').datepicker("option", "minDate", minValue);
            $('.todatepicker').datepicker("option", "yearRange", (new Date(minValue)).getFullYear() + ':+0');
            //calculate();
        });
        $('.todatepicker').datepicker().bind("change", function () {
            var maxValue = $(this).val();

            maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
            maxValue.setMonth(maxValue.getMonth() - 9)
            maxValue.setDate(maxValue.getDate() - 7);
            $('.dateLMP').datepicker("setDate", maxValue);
            $('.dateLMP').datepicker("option", "maxDate", maxValue);
            // calculate();
        });
        $('.datefirstvisit').datepicker({
            dateFormat: 'dd-mm-yy',
            maxDate: '0+',
            changeMonth: true,
            changeYear: true,
        });
        

        $('.datefirstvisit').datepicker().bind("change", function () {
            
            $('#MOTHER_GEST_AGE').val(calculateGestAge($('.dateLMP').datepicker('getDate'), $(this).datepicker('getDate')))
        });
        $('.dateLMP').datepicker().bind("change", function () {
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("dd-mm-yy", minValue);

            $('.datefirstvisit').datepicker("option", "minDate", minValue);
            $('#MOTHER_GEST_AGE').val(calculateGestAge($(this).datepicker('getDate'), $('.datefirstvisit').datepicker('getDate')))
        });
    });




    function calculateGestAge(fromdate, todate)
    {
        var weekdiff;
        if (fromdate != '' && todate != '')
        {

            weekdiff = Math.round(((todate - fromdate) / 1000 / 60 / 60 / 24) / 7);
        }
        return weekdiff;

    }


    $("#ART_STATECODE").change(function () {
        var str = "";
        $("#ART_STATECODE option:selected").each(function () {
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

                        $("#ART_DISTCODE option").remove();
                        $("#ART_DISTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.district.length; i++) {


                            $("#ART_DISTCODE").append(
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


    $("#ART_DISTCODE").change(function () {
        var str = "";
        $("#ART_DISTCODE option:selected").each(function () {
            str += $(this).val() + " ";

        });


        if (str.length > 1)
        {



            $.ajax({
                type: "POST",
                url: "getART.do?method=getArtDetails",
                dataType: 'json',
                data: {
                    'statecode': $("#ART_STATECODE").val(),
                    'distcode': str

                },
                success: function (data, status)
                {

                    if (typeof (data.success) != 'undefined')
                    {

                        $("#ART_ARTCODE option").remove();
                        $("#ART_ARTCODE").append(
                                "<option value='0'>--select--</option>"


                                );

                        for (var i = 0; i < data.art.length; i++) {


                            $("#ART_ARTCODE").append(
                                    "<option value='" + data.art[i].artid + "'>" + data.art[i].artname + "</option>"


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



});

$(function () {
    setANCRegDate();
    
$('.anc_reg_date').datepicker().bind("change", function () {
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
           
            
            $('.datefirstvisit').datepicker("option", "minDate", minValue);
           
           
           var maxValue = $(this).val();
            
            maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
            maxValue.setDate(maxValue.getDate()-1);
           
            if (CheckHIV_POSITIVE_CASE() == "positive")
    {
                var minimumdate=new Date();
                 alert(minimumdate);
               // minimumdate=$.datepicker.parseDate("dd-mm-yy", minimumdate);
                minimumdate.setDate(minimumdate.getDate()-315);
               
                $('.dateLMP').datepicker("option", "minDate", minimumdate);
            }
            $('.dateLMP').datepicker("option", "maxDate", maxValue);
            //calculate();
        });
});
$(function () {
    $("#MOTHER_REG_YEAR").attr("placeholder", "Enter the Mother REG YEAR");
    $("#MOTHER_PID").attr("placeholder", "Enter the OLD PID");
    $("#MOTHER_ADHAR_NO").attr("placeholder", "Enter 12 Digit ADHAR No. In Numerics ");
    $("#MOTHER_AGE").attr("placeholder", "Enter the Age in Numerics between 15 to 49  ");
    $("#MOTHER_GEST_AGE").attr("placeholder", "Enter the  Gestational Age between 6 to 40  in Numerics");
    $("#MOTHER_MOBILE").attr("placeholder", "Enter the 10 digit  Mobile No");
    $("#MOTHER_MOTHER_NAME").attr("placeholder", "Enter the ANC/PNC Name");
    $("#MOTHER_LMP_DATE").attr("placeholder", "Enter LMP Date");
    $("#MOTHER_FATHER_NAME").attr("placeholder", "Enter the Father Name");
    $("#MOTHER_FATHER_LOCATION").attr("placeholder", "Enter Father Address");
    $("#MOTHER_FATHER_PINCODE").attr("placeholder", "Enter Father Pincode");
    $("#MOTHER_SPOUSE_NAME").attr("placeholder", "Enter the Spouse Name");
    $("#MOTHER_SPOUSE_LOCATION").attr("placeholder", "Enter the Spouse Address  ");
    $("#MOTHER_SPOUSE_PINCODE").attr("placeholder", "Enter Spouse Pincode");

});
function CheckHIV_POSITIVE_CASE() {
    var result = '';
    $('input:radio[Id="HIV_POSITIVE_CASE"]').each(function() {
        var checked = $(this).find('input:radio:checked');
        if (checked.length == 0) {
            result = $(this).val();
            return;
        }
    });
    return result;
}
function setANCRegDate()
{
    var mindate = '01-01-2010';
   // alert($('input:radio[Id="HIV_POSITIVE_CASE"]').val());
    if (CheckHIV_POSITIVE_CASE() == "positive")
    {
        mindate = new Date();

        mindate.setDate(mindate.getDate() - 315);
    }

    $(".anc_reg_date").datepicker({
        dateFormat: 'dd-mm-yy',
        changeMonth: true,
        changeYear: true,
        minDate: mindate,
        maxDate: '0+',
    });
}


function submitTab1() {
    var form1 = $(document.forms[0]);
    //alert(24+form1+"   "+form1.serialize())
    $.ajax({
        type: "POST",
        url: 'LagacyDataEntry.do?mode=submitTab1',
        dataType: 'json',
        data: form1.serialize(),
        dataType: 'json',
                success: function (data, status)
                {
                    if (typeof (data.success) != 'undefined')
                    {

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
    })
}



