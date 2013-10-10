var APP_PATH = "/tmp/";
var isError=0;
$(document).ready(function() {
	alert("in contactus.js");
	$("#contactSubmitBtn").click(function() {
		console.log("in submit btn");
		var name=$("#contactName").val();
		alert(name);
		if(name=="" || name==$("#contactName").attr('placeholder')){
			alert("enter valid Name");
			$('#errorMessage').html('Enter Valid UserName');
			$('#errorMessage').show();
			isError = 1;	
		}
		
		var email=$("#contactEmail").val();
		alert(email);
		if(email=="" || email==$("#contactEmail").attr('placeholder')){
			alert("enter valid email id");
			$('#errorMessage').html('Enter Valid email id');
			$('#errorMessage').show();
			isError = 1;	
		}
		var phone=$("#contactPhone").val();
		alert(phone);
		if(phone=="" || phone==$("#contactPhone").attr('placeholder')){
			alert("enter valid contact phone no.");
			$('#errorMessage').html('Enter Valid phone no.');
			$('#errorMessage').show();
			isError = 1;	
		}
		var subject=$("#contactSubject").val();
		alert(subject);
		if(subject=="" || subject==$("#contactSubject").attr('placeholder')){
			alert("enter valid csubject.");
			$('#errorMessage').html('Enter subject.');
			$('#errorMessage').show();
			isError = 1;	
		}
		
		
		if(isError==0) {
			alert("no error found");
			
			var contactForm = $("#contactForm");
			alert("form "+ contactForm);
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',//loginForm.attr('action'),
				data: contactForm.serialize(),
				success: function(response){
					alert("Response is: "+response);
					var responseMessage = $.trim(response);
					alert(responseMessage);
					
					if(responseMessage != "1") {
						alert("Information is not entered correctly..!! have a look at it again:)");
					} else {
						alert("Inside else");
						alert("data entered uccessfully");
						alert("erty");
						window.location.href="http://localhost:8080/tmp/views/contactUs.html";
						
					}											
				}
			  });
		}
	});
});