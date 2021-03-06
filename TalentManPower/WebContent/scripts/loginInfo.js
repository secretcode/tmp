
var APP_PATH = "/tmp/";
var checkEmail=function(emailAddress)
{
	var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
	return !pattern.test(emailAddress);
};


$(document).ready(function() {
	initiateLoginBox();
	$("#UserInformation").hide();
	$("nav3").hide();
	initiateForgotPwd();
	$("#forgotPwdDetails").hide();
	$.ajax({
		type:"POST",
		url: APP_PATH + "/views/buttonCheck.jsp",
		success: function(response){
			
			var responseMessage = $.trim(response);
			//alert(responseMessage);
			if(responseMessage==1 || responseMessage==2) {
				console.log("resp2");
				$("nav2").hide();
				$("nav3").show();
				initiateUserInfoBox();
			}
		}
		
	});
			
});


function initiateForgotPwd() {
	$("#forgotPwd").click(function() {
		$("#forgotPwdDetails").show();
		$("#forgotPwdBtn").click(function(){
			var ema=$("#PwdemailId").val();
			//alert(ema);
			if(ema=="" || ema==$("#forgotPwdBtn").attr('placeholder')){
				$("#loginErrorMessage").html("Enter EmailId correctly");
				$("#loginErrorMessage").show();
			}
			
			var forgotPwd=$("#forgotPwdForm");
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',
				data: forgotPwd.serialize(),
				success: function(response){
					//alert("Response is: "+response);
					var responseMessage = $.trim(response);
					//alert("msg received is ::  "+responseMessage);
					
					if(responseMessage != "1" ) {
					//	alert("Inside if");
						$("#loginErrorMessage").html("Email id not valid.");
						$("#loginErrorMessage").show();
					} else {
				//	alert("After Submit");
						$("#PwdemailId").html("");
						$("#forgotPwdDetails").hide();
					}										
					document.getElementById("forgotPwdForm").reset();
				}
			});
		});
	});
}

function initiateLoginBox() {
	
	$("#loginUserPassword").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#userLoginButton").click();
	}		
	});
	
	$("#loginEmail").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#userLoginButton").click();
			
	}
	});
	
	$(".error").hide();
	
	$("#userLoginButton").click(function() {
		var password=$("#loginUserPassword").val();  
		if(password=="" || password==$("#loginUserPassword").attr('placeholder')){
		 $("#loginErrorMessage").html("enter password correctly");
		 $("#loginUserPassword").focus();
		 $("#loginErrorMessage").html("enter password correctly");
		 $("#loginErrorMessage").show();
		}
		else if(password.length<6){
			$("#loginErrorMessage").html("password must be of length more than 6 letters");
			 $("#loginUserPassword").focus();
			 $("#loginErrorMessage").show();
		}
		else{
			if(checkEmail($('#loginEmail').val())){
				$("#loginErrorMessage").html("enter Email Id correctly");	
				$('#errorMessage').html('Enter Valid Email Id');
				 $("#loginEmail").focus();
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
					
					$("#loginErrorMessage").html("Invalid loginEmailId and password");
					$("#loginErrorMessage").show();
				} 
				else{
					
					$("nav2").hide();
					$("#loginEmail").html("");
					$("#loginUserPassword").html("");
					initiateUserInfoBox();
				}				
				document.getElementById("loginForm").reset();
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
	$("nav3").show();
	
	console.log("info retrieved");
	
	$("#logOut").click(function() {
		$.ajax({
			type:"POST",
			url: APP_PATH + "/views/sessionInvalidate.jsp",
			success: function(response){
				console.log("session invalidated");
				$("nav2").show();
				$("nav3").hide();
				$("#UserInformation").hide();
			}
		});
	});
	
	$("#changePwdBtn").click(function(){
		
		var password=$("#newPwd").val();  
		var confPass=$("#confPwd").val();
		if(password=="" || password==$("#newPwd").attr('placeholder')){
		//  $("#email_error_AF").html("This field is required");
		 $("#changePwdFailureDiv").html("enter password correctly");
		 $("#changePwdFailureDiv").focus();
		}
		else if(password.length<6){
			//  $("#email_error_AF").html("This field is required");
			$("#changePwdFailureDiv").html("password must be of length more than 6 letters");
			 $("#newPwd").focus();
			 $("#changePwdFailureDiv").show();
		}
		else if(confPass!=password){
			 $("#changePwdFailureDiv").html("Both Passwords doesn't match");
			 $("#changePwdFailureDiv").show();
		}
		else {
			 $("#changePwdFailureDiv").hide();
		var changePwdForm=$("#changePwdFrm");
		$.ajax({
			type:"POST",
			url: APP_PATH+'bridge',
			data: changePwdForm.serialize(),
			success: function(response){
			
				var responseMessage = $.trim(response);	
				if(responseMessage != "1" ) {
				
					$("#changePwdFailureDiv").html("error in changing Password");
					$("#changePwdFailureDiv").show();
				} else {
			
					$("#newPwd").html("");
				}											
				document.getElementById("changePwdFrm").reset();
			}
		  });
		}
	});
}
