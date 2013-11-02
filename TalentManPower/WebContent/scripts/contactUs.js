var APP_PATH = "/tmp/";
var isError=0;
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
		if(email=="" || email==$("#contactEmail").attr('placeholder')){
			console.log("enter valid email id");
			$('#errorMessage').html('Enter Valid email id');
			$('#errorMessage').show();
			isError = 1;	
		}
		var phone=$("#contactPhone").val();
		console.log(phone);
		if(phone=="" || phone==$("#contactPhone").attr('placeholder')){
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
						window.location.href="http://talentmanpower.com/tmp/views/contactUs.html";
						
					}	
					$('#LoadingImage').hide();	
					
				}
			  });
		}
	});
});