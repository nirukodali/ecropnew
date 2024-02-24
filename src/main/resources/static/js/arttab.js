/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("#saverecord").on("click", function () {
        var tab1Validator = $('#tab1').validate();
        if ($('#tab1').valid())
        {
            savetab();
        } else {
            tab1Validator.focusInvalid();
            return false;
        }
    });


    $(document).ready(function () {
        $("select").select2();

        if ($('#ART_TB_DIAGNOZIED').is(':checked') && $('#ART_TB_DIAGNOZIED').val() === 'yes') {
            $('#divATTandCPTdetails')[0].style.display = '';
        } else {
            $('#divATTandCPTdetails')[0].style.display = 'none';
        }

        if ($('#ART_NOT_INITIATION_REASON').val() === '5') {
            $('#ART_NOT_INITIATION_REASON_OTHER_DIV').show();
        } else {
            $('#ART_NOT_INITIATION_REASON_OTHER_DIV').hide();
        }

        if ($('#ART_CURRENT_REGIMEN_INITIATED').val() === '6') {
            $('#ART_CURRENT_REGIMEN_INITIATED_OTHER_DIV').show();
        } else {
            $('#ART_CURRENT_REGIMEN_INITIATED_OTHER_DIV').hide();
        }
    });


    $('#ART_NOT_INITIATION_REASON').change(function () {
        if ($('#ART_NOT_INITIATION_REASON').val() === '5') {
            $('#ART_NOT_INITIATION_REASON_OTHER_DIV').show();
        } else {
            $('#ART_NOT_INITIATION_REASON_OTHER_DIV').hide();
            $('#ART_NOT_INITIATION_REASON_OTHER').val('');
        }
    });

    $('#ART_CURRENT_REGIMEN_INITIATED').change(function () {
        if ($('#ART_CURRENT_REGIMEN_INITIATED').val() === '6') {
            $('#ART_CURRENT_REGIMEN_INITIATED_OTHER_DIV').show();
        } else {
            $('#ART_CURRENT_REGIMEN_INITIATED_OTHER_DIV').hide();
            $('#ART_CURRENT_REGIMEN_INITIATED_OTHER').val('');
        }
    });

    $(".datepicker").datepicker({yearRange: '1940:2020', changeMonth: true, changeYear: true, maxDate: '0+', dateFormat: 'dd-mm-yy'});

    $('input:radio[name="property(ART_TB_DIAGNOZIED)"]').change(
            function () {
                if ($(this).is(':checked') && $(this).val() == 'yes') {
                    $('#divATTandCPTdetails')[0].style.display = '';
                } else {
                    $("input:radio[name='property(ART_ATT_DOTS)']").each(function (i) {
                        this.checked = false;
                    });
                    $("input:radio[name='property(ART_CPT_STARTED)']").each(function (i) {
                        this.checked = false;
                    });
                    $('#divATTandCPTdetails')[0].style.display = 'none';
                }
            });
            
            
           
            
            

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


    $(function () {
        var hiv_cnfm_date = $('#hiv_cnfm_date').text();
        //var afterHivCfmDate = new Date(hiv_cnfm_date);
        //afterHivCfmDate.setDate(afterHivCfmDate.getDate() + 1);
        $('.fromdatepicker').datepicker({
            dateFormat: 'dd-mm-yy',
            minDate: hiv_cnfm_date,
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

        $('.baselinedatepicker').datepicker({
            dateFormat: 'dd-mm-yy',
            changeMonth: true,
            changeYear: true,
        });

        $('.fromdatepicker').datepicker().bind("change", function () {
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
            $('.todatepicker').datepicker("option", "minDate", minValue);
            $('.todatepicker').datepicker("option", "yearRange", (new Date(minValue)).getFullYear() + ':+0');
            //calculate();
        });
        $('.todatepicker').datepicker().bind("change", function () {
            var maxValue = $(this).val();
            maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
            $('.fromdatepicker').datepicker("option", "maxDate", maxValue);
            // calculate();
            var minValue = $(this).val();
            minValue = $.datepicker.parseDate("dd-mm-yy", minValue);
            $('.baselinedatepicker').datepicker("option", "minDate", minValue);
            $('.baselinedatepicker').datepicker("option", "yearRange", (new Date(minValue)).getFullYear() + ':+0');


        });

        $('.baselinedatepicker').datepicker().bind("change", function () {
            var maxValue = $(this).val();
            maxValue = $.datepicker.parseDate("dd-mm-yy", maxValue);
            $('.todatepicker').datepicker("option", "maxDate", maxValue);
            // calculate();
        });


    });











});

function calculate() {
    var d1 = $('.fromdatepicker').datepicker('getDate');
    var d2 = $('.todatepicker').datepicker('getDate');
    var oneDay = 24 * 60 * 60 * 1000;
    var diff = 0;
    if (d1 && d2) {

        diff = Math.round(Math.abs((d2.getTime() - d1.getTime()) / (oneDay)));
    }
    $('.calculated').val(diff);

}






