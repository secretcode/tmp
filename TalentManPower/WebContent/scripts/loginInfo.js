

var APP_PATH = "/tmp/";

$(document).ready(function() {
	initiateLoginBox();
	$("#UserInformation").hide();
	$("#logOut").hide();
	initiateForgotPwd();
	$.ajax({
		type:"POST",
		url: APP_PATH + "/views/buttonCheck.jsp",
		success: function(response){
			alert("Response is: "+response);
			var responseMessage = $.trim(response);
			alert(responseMessage);
			if(responseMessage==1 || responseMessage==2) {
				console.log("resp2");
				$("nav2").hide();
				$("#logOut").show();
				initiateUserInfoBox();
			}
		}
	});
			
});


function initiateForgotPwd() {
	$("#forgotPwd").click(function() {
		
	});
}

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
		//alert("Inside click");
		var password=$("#loginUserPassword").val();  
		if(password=="" || password==$("#loginUserPassword").attr('placeholder')){
		//  $("#email_error_AF").html("This field is required");
		 $("#loginErrorMessage").html("enter password correctly");
		 $("#loginUserPassword").focus();
		 $("#loginErrorMessage").html("enter password correctly");
		 $("#loginErrorMessage").show();
		}
		else if(password.length<6){
			//  $("#email_error_AF").html("This field is required");
			$("#loginErrorMessage").html("password must be of length more than 6 letters");
			 $("#loginUserPassword").focus();
			 $("#loginErrorMessage").show();
		}
		else{
			var name=$("#loginUserName").val();  
			if(name=="" || name==$("#loginUserName").attr('placeholder')){
				$("#loginErrorMessage").html("enter username correctly");	
				$('#errorMessage').html('Enter Valid UserName');
				 $("#loginUserName").focus();
				 $("#loginErrorMessage").show();
			}
			else{
				//var dataString='&firstName=' +firstName + '&lastName=' +lastName + '&phone=' +phone + 'email=' +email;
			    //console.log(dataString);
				
			var loginForm = $("#loginForm");
			$("#loginErrorMessage").hide();
		//alert("Apply Form var: "+ loginForm);
			
		$.ajax({
			type:"POST",
			url: APP_PATH+'bridge',
			data: loginForm.serialize(),
			success: function(response){
				//alert("Response is: "+response);
				var responseMessage = $.trim(response);
				//alert("msg received is ::  "+responseMessage);
				
				if(responseMessage != "1" ) {
					alert("Inside if");
					$("#loginErrorMessage").show();
				} else {
			//	alert("After Submit");
					$("#loginUserName").html("");
					$("#loginUserPassword").html("");
					$("nav2").hide();
					
				initiateUserInfoBox();
				}											
			}
		  });
			}
		}
				
		
	});
	
}

function initiateUserInfoBox() {
	console.log("in user info box");
	$("#UserInformation").load(APP_PATH+"/views/dashBoard.jsp", function(response,status,xhr){console.log("information extracted");});
	console.log($("#UserInformation").text());
	$("#UserInformation").show();
	$("#logOut").show();
	
	console.log("info retrieved");
	
	$("#logOut").click(function() {
		$.ajax({
			type:"POST",
			url: APP_PATH + "/views/sessionInvalidate.jsp",
			success: function(response){
				console.log("session invalidated");
				$("nav2").show();
				$("#logOut").hide();
				$("#UserInformation").hide();
			}
		});
	});
	
}
