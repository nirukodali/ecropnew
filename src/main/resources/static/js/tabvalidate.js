/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    $(document).ready(function ($) { 
        
        
        
       
$.validator.addMethod("age15to49", function (value, element) {
 return this.optional(element) || /^(1[5-9]|[2-4][0-9])$/i.test(value); 
                }, "Age between 15 to 49");
				
$.validator.addMethod("mobilenumber", function (value, element) {
 return this.optional(element) || /^[0-9]{10}$/i.test(value); 
                }, "Mobile Number Should be 10 digit and Numerics  only Allowed");
                
                
                $.validator.addMethod("gestage", function (value, element) {
                return this.optional(element) || /^([6-9]|1[0-9]|[2-3][0-9]|40)$/i.test(value); 
                }, "Invalid Gestrinal Age in Weeks! Sholud be between 6 to 40");
                
                $.validator.addMethod("adhar", function (value, element) {
                return this.optional(element) || /^[0-9]{12}$/i.test(value); 
                }, "Aadhar No. is Invalid,Please Enter the Valid 12 digit Aadhar Number");
                
                $.validator.addMethod("specialChar", function (value, element) {
                    return this.optional(element) || /^[a-zA-Z _]*$/.test(value); //no special charectres
                }, "Special Charecters and numerics were not allowed");
                
                $.validator.addMethod("alphanumeric", function(value, element) {
        return this.optional(element) || /^([a-zA-Z0-9_-]+)$/.test(value);
                },"Special Charecters and numerics allowed");
                
                $.validator.addMethod("pincode", function (value, element) {
                return this.optional(element) || /^[0-9]{6}$/i.test(value); 
                }, "Pin code is Invalid,Please Enter the Valid 6 digit Pin code ");
                
 
                
              
                
				$('#tab1').validate();
               
               
                
                
               /* $('input,textarea').bind('copy paste', function (e) {
                    e.preventDefault();
                }  );*/
	});
