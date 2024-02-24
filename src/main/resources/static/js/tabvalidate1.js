/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    $(document).ready(function ($) {
	
       $.validator.addMethod("specialChar", function (value, element) {
                    return this.optional(element) || /^[a-zA-Z]*$/.test(value); //no special charectres
                }, "Special Charecters and numerics were not allowed");


$.validator.addMethod("babyweight", function (value, element) {
                return this.optional(element) || /^[1-6]+(?:\.\d?)?$|^7$/i.test(value); 
                }, "Baby Weight in 1 to 7 in KGS");
                
$.validator.addMethod("pincode", function (value, element) {
                return this.optional(element) || /^[0-9]{6}$/i.test(value); 
                }, "Pin code is Invalid,Please Enter the Valid 6 digit Pin code ");      

				
$.validator.addMethod("mobilenumber", function (value, element) {
 return this.optional(element) || /^[0-9]{10}$/i.test(value); 
                }, "Mobile Number Should be 10 digit and Numerics  only Allowed");
                // add the rule here
 
  $.validator.addMethod("adhar", function (value, element) {
                return this.optional(element) || /^[0-9]{12}$/i.test(value); 
                }, "Aadhar No. is Invalid,Please Enter the Valid 12 digit Aadhar Number");
                
 $.validator.addMethod("pid", function (value, element) {
                return this.optional(element) || /^[0-9]{12}$/i.test(value); 
                }, "Aadhar No. is Invalid,Please Enter the Valid 24 digit Aadhar Number");               
                
              
                
				$('#tab2').validate();
               
               
                
                
               /* $('input,textarea').bind('copy paste', function (e) {
                    e.preventDefault();
                }  );*/
	});
