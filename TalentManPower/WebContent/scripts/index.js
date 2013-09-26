
var APP_PATH = "/tmp/";

$(document).ready(function() {
	console.log("b4 hiding");
	$("loginFailureMessage").hide();
	$("#companySignUpOverlay").hide();
	initiateCompanySignUp();
	addJobButtonClick();
	console.log("in function");
	console.log("ready funct");
	initiateLoginBox();
	initiateEmpSignUpBox();
	console.log("in function");
});
function addJobButtonClick(){
	console.log("inside abc function");	
	$('#signUpCompany').click(function(){
		$('#content').hide();
		console.log("inside click of add job");
		$('#companySignUpOverlay').height($(document).height());
		$('#companySignUpOverlay').show();
	});
	$('#companySignUpFormCrossButton').click(function(){
		$('#companySignUpOverlay').hide();
	});
}
function initiateCompanySignUp() {
	console.log("inside init function");
	$("#CompanyUserName").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}		
	});
	
	$("#CompanyPassword").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#ConfirmCompanyPassword").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyEmail").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}		
	});
	
	
	$("#SecondaryCompanyEmail").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyName").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyContactPerson").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyContactPersonDesignation").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyStrength").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}		
	});
	
	$("#CompanyType").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyProfile").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyAddress").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}		
	});
	
	$("#CompanyCity").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyState").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyCountry").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyZip").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	
	$("#CompanyPhone").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyMobile").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyFax").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});
	$("#CompanyURL").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#companySignUpSubmitButton").click();
	}
	});

	$("#companySignUpSubmitButton").click(function() {
		alert("Inside click");
		var isError = 0;
		var comUserName=$("#CompanyUserName").val();  
		if(comUserName=="" || comUserName==$("#CompanyUserName").attr('placeholder')){
			alert("enter valid UserName");
			$('#errorMessageC').html('Enter Valid UserName');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var ComPassword=$("#CompanyPassword").val();  
		if(ComPassword=="" || ComPassword==$("#addJobStreamListValue").attr('placeholder')){
			alert("enter valid Password");
			$('#errorMessageC').html('Enter Valid Password');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var ConfirmCompPassword=$("#ConfirmCompanyPassword").val();  
		if(ConfirmCompPassword!=ComPassword){
			alert("Password does not match");
			$('#errorMessageC').html('Enter Confirm Password');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var CompEmail=$("#CompanyEmail").val();  
		if(CompEmail=="" || CompEmail==$("#CompanyEmail").attr('placeholder')||(CompEmail.search("@")==-1)||(CompEmail.search(".com")==-1)){
			alert("enter valid CompanyEmail");
			$('#errorMessageC').html('Enter Valid Email');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var ComName=$("#CompanyName").val();  
		if(ComName=="" || ComName==$("#JobSalary").attr('placeholder')){
			alert("enter valid Company Name");
			$('#errorMessageC').html('Enter Valid CompanyName');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var ComContactPerson=$("#CompanyContactPerson").val();  
		if(ComContactPerson=="" || ComContactPerson==$("#CompanyContactPerson").attr('placeholder')){
			alert("enter valid Company Contact Person");
			$('#errorMessageC').html('Enter Valid Company Contact Person');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var ComContactPersonDesignation=$("#CompanyContactPersonDesignation").val();  
		if(ComContactPersonDesignation=="" || ComContactPersonDesignation==$("#CompanyContactPersonDesignation").attr('placeholder')){
			alert("enter vaild Company Contact Person designation");
			$('#errorMessage').html('Enter Valid Company Contact Person Designation');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var ComStrength=$("#CompanyStrength").val();  
		if(ComStrength=="" || ComStrength==$("#CompanyStrength").attr('placeholder')){
			alert("enter valid Company Strength");
			$('#errorMessageC').html('Enter Valid Company Strength');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comType=$("#CompanyType").val();  		
		if(comType=="" || comType==$("#CompanyType").attr('placeholder')){
			alert("enter valid company type");
			$('#errorMessageC').html('Enter Valid Company Type');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comProfile=$("#CompanyProfile").val();  
		if(comProfile=="" || comProfile==$("#CompanyProfile").attr('placeholder')){
			alert("enter valid company Profile");
			$('#errorMessageC').html('Enter Valid Company Profile');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comAddress=$("#CompanyAddress").val();  
		if(comAddress=="" || comAddress==$("#CompanyAddress").attr('placeholder')){
			 alert("enter valid Company address");
			 $('#errorMessageC').html('Enter Valid Company Address');
			 $('#errorMessageC').show();
			 isError = 1;	
		}
			
		var comCity=$("#CompanyCity").val();  
		if(comCity=="" || comCity==$("#CompanyCity").attr('placeholder')){
			alert("enter valid City");
			$('#errorMessageC').html('Enter Valid Company City');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comState=$("#CompanyState").val();  	
		if(comState=="" || comState==$("#CompanyContactPerson").attr('placeholder')){
			alert("enter valid Company State");
			$('#errorMessageC').html('Enter Valid Company State');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comCountry=$("#CompanyCountry").val();  
		if(comCountry=="" || comCountry==$("#CompanyCountry").attr('placeholder')){
			alert("enter vaild Company Country");
			$('#errorMessageC').html('Enter Valid Company Country');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comZip=$("#CompanyZip").val();  
		if(comZip=="" || comZip==$("#CompanyZip").attr('placeholder')||isNaN(comZip)||comZip.length>6){
			alert("enter valid Company Zip");
			$('#errorMessageC').html('Enter Valid Company Zip');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comPhone=$("#CompanyPhone").val();  
		if(comPhone=="" || comPhone==$("#CompanyPhone").attr('placeholder')||isNaN(comPhone)){
			alert("enter valid Company Phone");
			$('#errorMessageC').html('Enter Valid Company Phone');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comMobile=$("#CompanyMobile").val();  
		if(comMobile=="" || comMobile==$("#CompanyMobile").attr('placeholder')||isNaN(comMobile)){
			alert("enter vaild Company Mobile");
			$('#errorMessageC').html('Enter Valid Company Mobile');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comFax=$("#CompanyFax").val();  
		if(comFax=="" || comFax==$("#CompanyFax").attr('placeholder')){
			alert("enter valid Company Fax");
			$('#errorMessageC').html('Enter Valid Company Fax');
			$('#errorMessageC').show();
			isError = 1;	
		}
		var comURL=$("#CompanyURL").val();  
		if(comURL=="" || comURL==$("#CompanyURL").attr('placeholder')){
			alert("enter valid Company URL");
			$('#errorMessageC').html('Enter Valid Company URL');
			$('#errorMessageC').show();
			isError = 1;	
		}
		if(isError == 0) {
	
			var companySignUpForm = $("#companySignUpForm");
			
			alert("Apply Form var: "+ companySignUpForm);
			
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',//loginForm.attr('action'),
				data: companySignUpForm.serialize(),
				success: function(response){
					alert("Response is: "+response);
					var responseMessage = $.trim(response);
					alert(responseMessage);
					
					if(responseMessage != "1") {
						alert("Information is not entered correctly..!! have a look at it again:)");
					} else {
						alert("Inside else");
					/*	var authenticatedLoginForm = $("#authenticatedLoginForm");
						alert("authenticatedLoginForm: "+authenticatedLoginForm);
						authenticatedLoginForm.attr('action', APP_PATH+'bridge');
						alert("Action for form: "+authenticatedLoginForm.attr('action'));
						authenticatedLoginForm.submit();	
						alert("After Submit");*/
						alert("data entered uccessfully");
						$('#companySignUpOverlay').hide();
						alert("erty");
						
					}											
				}
			  });
				
			}
	});
}





function initiateEmpSignUpBox() {
	alert("hdcgdh");
	
	$('#signUpEmployee').click(function(){
		$('#content').hide();
		console.log("inside click of emp sign up");
		$('#employeeSignUpOverlay').height($(document).height());
		$('#employeeSignUpOverlay').show();
	});
	$('#employeeSignUpFormCrossButton').click(function(){
		$('#employeeSignUpOverlay').hide();
	});
	
	
	$("#employeeSignUpSubmitButton").click(function() {
		alert("Inside click");
		var isError = 0;
		var name=$("#EmpName").val();  
		alert(name);
		if(name=="" || name==$("#EmpName").attr('placeholder')){
		//  $("#email_error_AF").html("This field is required");
		 alert("enter your name");
		 $('#errorMessage').html('Enter Valid UserName');
		 isError = 1;	
		}
		
		var email=$("#EmpEmail").val();  
		if(email=="" || email==$("#EmpEmail").attr('placeholder')){
			$('#errorMessage').html('Enter Valid Employee Email');
		//  $("#email_error_AF").html("This field is required");
		alert("enter email correctly");
		$('#errorMessage').show();
		isError = 1;	
		}	
		
		var pwd=$("#EmpPassword").val();  
		if(pwd=="" || pwd==$("#EmpPassword").attr('placeholder')){
			$('#errorMessage').html('Enter Valid Employee Password');
		//  $("#email_error_AF").html("This field is required");
		alert("enter password correctly");
		$('#errorMessage').show();
		isError = 1;	
		}
		
	/*	var dob=$("#DateOfBirth").val();  
		if(dob=="" || dob==$("#DateOfBirth").attr('placeholder')){
		//  $("#email_error_AF").html("This field is required");
		alert("enter date of birth correctly");
			isError = 1;	
		}
		*/
		var mobile=$("#EmpMobile").val();  
		if(mobile=="" || mobile==$("#EmpMobile").attr('placeholder')){
			$('#errorMessage').html('Enter Valid Emp Mobile');
		//  $("#email_error_AF").html("This field is required");
		alert("enter mobile correctly");
		$('#errorMessage').show();
		isError = 1;	
		}
		
		var add=$("#Empaddress").val();  
		if(add=="" || add==$("#Empaddress").attr('placeholder')){
		//  $("#email_error_AF").html("This field is required");
		alert("enter address correctly");
		$('#errorMessage').html('Enter Valid Employee Address');
		$('#errorMessage').show();
		isError = 1;	
		}
		
		var edu=$("#EmpCourse").val();  
		if(edu=="--Select--" ){
		//  $("#email_error_AF").html("This field is required");
		alert("enter education  correctly");
		$('#errorMessage').html('Enter Education  Correctly');
		$('#errorMessage').show();
		isError = 1;	
		}
		
		var urself=$("#EmpExperience").val();  
		if(urself=="" || urself==$("#Urself").attr('EmpExperience')){
		//  $("#email_error_AF").html("This field is required");
		alert("enter exprience correctly");
		$('#errorMessage').html('Enter Exprience Correctly');
		$('#errorMessage').show();
		isError = 1;	
		}
		
		
	//	alert("before error check");
		if(isError == 0) {

			//	var dataString='&firstName=' +firstName + '&lastName=' +lastName + '&phone=' +phone + 'email=' +email;
			//    alert(dataString);
				
			var empForm = $("#employeeSignUpForm");
			
		alert("Apply Form var: "+ empForm);
			
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',//loginForm.attr('action'),
				data: empForm.serialize(),
				success: function(response){
					alert("Response is: "+response);
					var responseMessage = $.trim(response);
					alert(responseMessage);
					
					if(responseMessage != "1") {
						alert("data is nt enetered correctly!!");
						//$("#authenticationFailureMessage").show();
					} else {
						alert("data entered uccessfully");
						$('#employeeSignUpOverlay').hide();
				
					}											
				}
			});
		}

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
	$("UserInformation").show();
	console.log("info retrieved");
}
