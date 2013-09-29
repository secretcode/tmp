

var APP_PATH = "/tmp/";

$(document).ready(function() {
	initiateLoginBox();
	$.ajax({
		type:"POST",
		url: APP_PATH + "/views/buttonCheck.jsp",
		success: function(response){
			alert("Response is: "+response);
			var responseMessage = $.trim(response);
			alert(responseMessage);
			if(responseMessage==1 || responseMessage==2) {
				console.log("resp2");
				initiateUserInfoBox();
			}
		}
	});
			
});

function initiateLoginBox() {
	
	$("#loginUserPassword").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#userLoginButton").click();
	}		
	});
	
	$("#loginUserName").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#userLoginButton").click();
	}
	});
	
	$(".error").hide();
	
	$("#userLoginButton").click(function() {
		alert("Inside click");
		var isError = 0;
		var password=$("#loginUserPassword").val();  
		if(password=="" || password==$("#loginUserPassword").attr('placeholder')){
		//  $("#email_error_AF").html("This field is required");
		 alert("enter password correctly");
		 isError = 1;	
		 $("#loginUserPassword").focus();
		}
		
		if(password.length<6){
			//  $("#email_error_AF").html("This field is required");
			 alert("password must be of length more than 6 letters");
			 isError = 1;	
			 $('#errorMessage').html('Enter Valid UserName');
			 $("#loginUserPassword").focus();
		}
		

		
		var name=$("#loginUserName").val();  
		if(name=="" || name==$("#loginUserName").attr('placeholder')){
		//  $("#email_error_AF").html("This field is required");
		alert("enter username correctly");
			isError = 1;	
			$('#errorMessage').html('Enter Valid UserName');
			 $("#loginUserName").focus();
		}		
		
		if(isError == 0) {

			//	var dataString='&firstName=' +firstName + '&lastName=' +lastName + '&phone=' +phone + 'email=' +email;
			//    alert(dataString);
				
			var loginForm = $("#loginForm");
			
		alert("Apply Form var: "+ loginForm);
			
		$.ajax({
			type:"POST",
			url: APP_PATH+'bridge',
			data: loginForm.serialize(),
			success: function(response){
				//alert("Response is: "+response);
				var responseMessage = $.trim(response);
				alert("msg received is ::  "+responseMessage);
				
				if(responseMessage != "1" ) {
			//		alert("Inside if");
					$("#loginFailureMessage").show();
				} else {
				alert("After Submit");
				initiateUserInfoBox();
				}											
			}
		  });
				
			}
		
	});
	
}

function initiateUserInfoBox() {
	console.log("in user info box");
	$("#UserInformation").load(APP_PATH+"/views/dashBoard.jsp", function(response,status,xhr){console.log("information extracted");});
	console.log($("#UserInformation").text());
	$("#loggedInBox").show();
	$("#loginSignUpBox").hide();
	console.log("info retrieved");
	
	$("#logOut").click(function() {
		$.ajax({
			type:"POST",
			url: APP_PATH + "/views/sessionInvalidate.jsp",
			success: function(response){
				console.log("session invalidated");
				$("#loginSignUpBox").show();
				$("#loggedInBox").hide();
			}
		});
	});
	
}
