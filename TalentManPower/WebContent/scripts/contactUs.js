var APP_PATH = "/tmp/";
var isError=0;
var checkPhone=function(phone)
{
	var pattern = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;  
	return !pattern.test(phone);
};  
var checkEmail=function(emailAddress)
{
	var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
	return !pattern.test(emailAddress);
};

$(document).ready(function() {
	console.log("in contactus.js");
	$("#contactSubmitBtn").click(function() {
		console.log("in submit btn");
		var name=$("#contactName").val();
		console.log(name);
		if(name=="" || name==$("#contactName").attr('placeholder')){
			console.log("enter valid Name");
			$('#errorMessage').html('Enter Valid UserName');
			$('#errorMessage').show();
			isError = 1;	
		}
		
		var email=$("#contactEmail").val();
		console.log(email);
		if(checkEmail($('#contactEmail').val())){
			console.log("enter valid email id");
			$('#errorMessage').html('Enter Valid email id');
			$('#errorMessage').show();
			isError = 1;	
		}
		var phone=$("#contactPhone").val();
		console.log(phone);
		if(checkPhone($('#contactPhone').val())){	
			console.log("enter valid contact phone no.");
			$('#errorMessage').html('Enter Valid phone no.');
			$('#errorMessage').show();
			isError = 1;	
		}
		var subject=$("#contactSubject").val();
		console.log(subject);
		if(subject=="" || subject==$("#contactSubject").attr('placeholder')){
			console.log("enter valid csubject.");
			$('#errorMessage').html('Enter subject.');
			$('#errorMessage').show();
			isError = 1;	
		}
		
		
		if(isError==0) {
			console.log("no error found");
			$('#LoadingImage').show();	
			
			var contactForm = $("#contactForm");
			console.log("form "+ contactForm);
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',//loginForm.attr('action'),
				data: contactForm.serialize(),
				success: function(response){
					console.log("Response is: "+response);
					var responseMessage = $.trim(response);
					console.log(responseMessage);
					
					if(responseMessage != "1") {
						console.log("Information is not entered correctly..!! have a look at it again:)");
					} else {
						console.log("Inside else");
						console.log("data entered uccessfully");
						document.getElementById("contactForm").reset();	
					}	
					$('#LoadingImage').hide();	
					
				}
			  });
		}
	});
});