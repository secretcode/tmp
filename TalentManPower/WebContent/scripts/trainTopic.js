var APP_PATH = "/tmp/";

$(document).ready(function() {
	initiateCompanyForm();
	console.log("in function");
});
function initiateCompanyForm() {
	console.log("inside init function");
	$("#CompanyName").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#SubmitButton").click();
	}		
	});
	
	$("#CompanyEmail").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#SubmitButton").click();
	}
	});
	$("#CompanyContactNo").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#SubmitButton").click();
	}
	});
	$("#SubmitButton").click(function() {
		alert("Inside click");
		var isError = 0;
		var cName=$("#CompanyName").val();  
		if(cName=="" || cName==$("#CompanyName").attr('placeholder')){
		 alert("enter valid company name");
		 isError = 1;	
		}
		
		var cEmail=$("#CompanyEmail").val();  
		if(cEmail=="" || cEmail==$("#CompanyEmail").attr('placeholder')||(cEmail.search("@")==-1)||(cEmail.search(".com")==-1)){
		alert("enter valid email addresss");
			isError = 1;	
		}
		var cphn=$("#CompanyContactNo").val();  
		if(cphn=="" || cphn==$("#CompanyContactNo").attr('placeholder')||isNan(cphn)){
		alert("enter valid contact no");
			isError = 1;	
		}
		if(isError == 0) {

				
			var CompanyTrainForm = $("#CompanyTrainForm");
			
		alert("Apply Form var: "+ CompanyTrainForm);
			
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',//loginForm.attr('action'),
				data: CompanyTrainForm.serialize(),
				success: function(response){
					alert("Response is: "+response);
					var responseMessage = $.trim(response);
					alert(responseMessage);
					
					if(responseMessage != "1") {
						alert("Inside if");
						//$("#authenticationFailureMessage").show();
					} else {
						alert("Inside else");
						var authenticatedLoginForm = $("#authenticatedLoginForm");
						alert("authenticatedLoginForm: "+authenticatedLoginForm);
						authenticatedLoginForm.attr('action', APP_PATH+'bridge');
						alert("Action for form: "+authenticatedLoginForm.attr('action'));
						authenticatedLoginForm.submit();	
						alert("After Submit");
					}											
				}
			  });
				
			}
	});
}