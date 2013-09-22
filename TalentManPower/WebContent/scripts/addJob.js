var APP_PATH = "/tmp/";
var companyData_DB;
var companyDataTableChart;
var companyMapDT;

$(document).ready(function() {
	
	initiateAddJob();
	initiateShowCompanyDT();
	console.log("in function");
});
function initiateShowCompanyDT() {
	$("#getCompanyListButton").click(function() {
		alert("Inside click");
		queryCompanyData();
	});
}
	
function queryCompanyData() {
	console.log("Inside queryCompanyData....: " );
	
	var queryString = APP_PATH+'widget?dataType=getCompany';
	console.log("after query");
	var query = new google.visualization.Query(queryString);
	console.log(queryString);
	query.send(handleCompanyDataResponse); 
	console.log("before response");
}

function handleCompanyDataResponse(response){
	console.log("inside response function");
	if (response.isError()) {		
	     console.log('Error in query: ' + response.getMessage() + ' ' + response.getDetailedMessage());
	      return;
	}
	companyMapDT= response.getDataTable();
	console.log("+++++++++++++++++++++++++++");
	console.log(companyMapDT.getNumberOfRows());
	console.log(companyMapDT);
	initiateCompanyMapDT();
}

function initiateCompanyMapDT(){
	$("#addJobBOx").hide();
	$("companyListContent").show();
	console.log("inside initiate function");
	//companyDataView = new google.visualization.DataView(companyMapDT);
	companyData_DB = new google.visualization.Dashboard(document.getElementById('companyListContent'));
 
 var companyNameFilter = new google.visualization.ControlWrapper({
	   'controlType': 'StringFilter',
	   'containerId': 'companyNameFilter',
	   'options': {
		   'filterColumnIndex' : 2
	   },
   });

 
 companyDataTableChart = new google.visualization.ChartWrapper({
     'chartType': 'Table',
     'containerId': 'companyDataTableChart',
     'options': {
       'width': 890,
       'height': 340,
       'showRowNumber': true
     },
     	'view': {'columns':[ 1,2,3,4 ]}
 });
   
	console.log("data view is ready"); 
	console.log(companyMapDT.getNumberOfRows());
	
	console.log('reached select');
	companyData_DB.bind(companyNameFilter, companyDataTableChart);
	console.log('dt drawn');
	companyData_DB.draw(companyMapDT);
	console.log("dt drawn");	
	
}
function initiateAddJob() {
	console.log("inside init function");
	$("#addJobCategoryListValue").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}		
	});
	
	$("#addJobStreamListValue").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}
	});
	$("#JobDesignation").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}
	});
	$("#Work_Experience").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}		
	});
	
	$("#JobSalary").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}
	});
	$("#Work_Place").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}
	});
	$("#Job_Description").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}
	});
	$("#EMP_Required").keypress(function(e) {
		if(e.keyCode == 13 || e.which == 13) {
			$("#addJobSubmitButton").click();
	}
	});
	$("#addJobSubmitButton").click(function() {
		alert("Inside click");
		var isError = 0;
		var jobCategory=$("#addJobCategoryListValue").val();  
		if(jobCategory=="" || jobCategory==$("#addJobCategoryListValue").attr('placeholder')){
		 alert("enter valid company category");
		 isError = 1;	
		}
		var jobStream=$("#addJobStreamListValue").val();  
		if(jobStream=="" || jobStream==$("#addJobStreamListValue").attr('placeholder')){
		alert("enter valid Stream");
			isError = 1;	
		}
		var jobDesg=$("#JobDesignation").val();  
		if(jobDesg=="" || jobDesg==$("#JobDesignation").attr('placeholder')){
		alert("enter valid Designation");
			isError = 1;	
		}
		var workEx=$("#Work_Experience").val();  
		if(workEx=="" || workEx==$("#Work_Experience").attr('placeholder')){
		 alert("enter valid Job Experience");
		 isError = 1;	
		}
		
		var salary=$("#JobSalary").val();  
		if(salary=="" || salary==$("#JobSalary").attr('placeholder')){
		alert("enter valid Salary");
			isError = 1;	
		}
		var workPlace=$("#Work_Place").val();  
		if(workPlace=="" || workPlace==$("#Work_Place").attr('placeholder')){
		alert("enter valid work place");
			isError = 1;	
		}
		var jobDesc=$("#Job_Description").val();  
		if(jobDesc=="" || jobDesc==$("#Job_Description").attr('placeholder')){
		alert("enter some desciption");
			isError = 1;	
		}
		var empreq=$("#EMP_Required").val();  
		if(empreq=="" || empreq==$("#EMP_Required").attr('placeholder')){
		alert("enter valid work place");
			isError = 1;	
		}	
		if(isError == 0) {
	
		var AddJobForm = $("#AddJobForm");
			
		alert("Apply Form var: "+ AddJobForm);
			
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',//loginForm.attr('action'),
				data: AddJobForm.serialize(),
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

