var APP_PATH = "/tmp/";
var flag=0;
var empflag=0;
var allCompanyData_DB;
var allCompanyDataTableChart;
var allEmployeeDataTableChart;
var trainingTableChart;
$(document).ready(function() {
	//$('#mainCompanyHiringBox').show();
	$('#mainEmployeeHiringBox').hide();	
	$("#addJobOverlay").hide();
	$("#allCompanyListContent").show();
	$("#allEmployeeListContent").hide();
	$("#mainCompanyHiringBox").hide();
	$("#mainEmployeeHiringBox").hide();
	initiateAllCategoryCompanyDT();
	initiateAllCategoryEmployeeDT();
	uploadResumeClick();
	addEmployeeEmployerClick();
	console.log("in function");
	
});

function initiateButtonCheck() {
	$.ajax({
		type:"POST",
		url: APP_PATH + "/views/buttonCheck.jsp",
		success: function(response){
			alert("Response is: "+response);
			var responseMessage = $.trim(response);
			alert(responseMessage);
			if(responseMessage==0){
				console.log("resp0");
				$("#updateResumeEmployeeButton").hide();
				$("#addJobButton").hide();
			}
			else if(responseMessage==1) {
				console.log("resp1");
				$("#updateResumeEmployeeButton").show();
				$("#addJobButton").hide();
			
			}
			else if(responseMessage==2) {
				console.log("resp2");
				$("#updateResumeEmployeeButton").hide();
				$("#addJobButton").show();
			
			}
		}
	});
			
}

function uploadResumeClick() {
	$("#updateResumeEmployeeButton").click(function() {
		$("#UploadResume").show();
	});
}

function initiateAllCategoryDT(){
	initiateAllCategoryEmployeeDT();
	initiateAllCategoryCompanyDT();
}

function addEmployeeEmployerClick(){
	console.log("inside abc function");	
	initiateButtonCheck();
	$('#getEmployeeDetailsButton').click(function(){
		document.getElementById('getEmployeeDetailsButton').className = 'current';
		document.getElementById('getEmployerDetailsButton').className = 'none';
		$('#mainEmployeeHiringBox').show();
		$('#mainCompanyHiringBox').hide();
		
	});
	$('#getEmployerDetailsButton').click(function(){
		document.getElementById('getEmployeeDetailsButton').className = 'none';
		document.getElementById('getEmployerDetailsButton').className = 'current';
		$('#mainCompanyHiringBox').show();
		$('#mainEmployeeHiringBox').hide();
		
	});
	
}


function initiateAllCategoryCompanyDT() {
	console.log("inside initiateAllCategoryCompanyDT function in hiring.js");

	queryAllCompanyData();
	$("#getAccountCompanyListButton").click(function() {
		alert("Inside click");
		$("#allEmployeeListContent").hide();
		alert("inside account buttn");
		$('#hringDataTables').show();
		queryAllCompanyData();
		flag=1;
	});
	$("#getManagementCompanyListButton").click(function() {
		alert("Inside click");
		$("#allEmployeeListContent").hide();
		$('#hringDataTables').show();
		queryAllCompanyData();
		flag=2;
	});
	$("#getEnggCompanyListButton").click(function() {
		alert("Inside click");
		$("#allEmployeeListContent").hide();
		$('#hringDataTables').show();
		queryAllCompanyData();
		flag=3;
	});
	$("#getSalesCompanyListButton").click(function() {
		alert("Inside click");
		$("#allEmployeeListContent").hide();
		$('#hringDataTables').show();
		queryAllCompanyData();
		flag=4;
	});
	
	
	$("#backToHiringPageButtonForCompany").click(function() {
		alert("Gong back to hiring page");
		$('#content').show();
		
		$('#mainCompanyHiringBox').show();
		
	});
	
	$('#addJobButton').click(function(){
		alert("inside add job click button");
		initiateAddJob();
		
		$('#content').hide();
		console.log("inside click of add job");
		$('#addJobOverlay').height($(document).height());
		$('#addJobOverlay').show();
	});
	$('#addJobFormCrossButton').click(function(){
		$('#content').show();
		$('#addJobOverlay').hide();
	});
	
}
function initiateAllCategoryEmployeeDT() {
	console.log("in initiateAllCategoryEmployeeDT function");
	$("#getAccountEmployeeListButton").click(function() {
		empflag=1;
		alert("Inside getAccountEmployeeListButton click");
		$("#allCompanyListContent").hide();
		$('#hringDataTables').show();
		queryAllEmployeeData();
		
	});
	$("#getManagementEmployeeListButton").click(function() {
		empflag=2;
		alert("Inside  getManagementEmployeeListButton click");
		$('#hringDataTables').show();
		$("#allCompanyListContent").hide();
		queryAllEmployeeData();
		
	});
	$("#getEnggEmployeeListButton").click(function() {
		empflag=3;
		alert("Inside getEnggEmployeeListButton click");
		$('#hringDataTables').show();
		$("#allCompanyListContent").hide();
		queryAllEmployeeData();
		
	});
	$("#getSalesEmployeeListButton").click(function() {
		empflag=4;
		alert("Inside getSalesEmployeeListButton click");
		$('#hringDataTables').show();
		$("#allCompanyListContent").hide();
		queryAllEmployeeData();
		
	});
	$("#backToHiringPageButtonForEmployee").click(function() {
		alert("Gong back to hiring page");
		$('#content').show();
		$('#allEmployeeListContent').hide();
		$('#mainEmployeeHiringBox').show();
		
	});
	$("#backToHiringPageButtonForCompany").click(function() {
		alert("Gong back to hiring page");
		$('#content').show();
		$('#allEmployeeListContent').hide();
		$('#mainEmployeeHiringBox').show();
		
	});
}

function queryAllEmployeeData() {
	$("#allEmployeeListContent").show();
	console.log("Inside queryAllEmployeeData....: " );
	var queryString1 = APP_PATH+'widget?dataType=getDiffEmp&flag='+empflag;
	console.log("after query"+empflag);
	var query1 = new google.visualization.Query(queryString1);
	console.log(queryString1);
	query1.send(handleAllEmployeeDataResponse); 
	console.log("before response");
}
function handleAllEmployeeDataResponse(response){
	console.log("inside response function");
	if (response.isError()) {		
	     console.log('Error in query: ' + response.getMessage() + ' ' + response.getDetailedMessage());
	      return;
	}
	allEmployeeMapDT= response.getDataTable();
	console.log("+++++++++++++++++++++++++++");
	console.log(allEmployeeMapDT.getNumberOfRows());
	console.log(allEmployeeMapDT);
	initiateallEmployeeMapDT();
}
function initiateallEmployeeMapDT(){
	console.log("inside initiate function");
	allEmployeeData_DB = new google.visualization.Dashboard(document.getElementById('allEmployeeListContent'));
	var allEmployeeNameFilter = new google.visualization.ControlWrapper({
	   'controlType': 'StringFilter',
	   'containerId': 'allEmployeeNameFilter',
	   'options': {
		   'filterColumnIndex' : 2
	   },
   });

 
 allEmployeeDataTableChart = new google.visualization.ChartWrapper({
     'chartType': 'Table',
     'containerId': 'allEmployeeDataTableChart',
     'options': {
       'width': 890,
       'height': 340,
       'showRowNumber': false
     },
     	'view': {'columns':[ 0,1,2,3]}
 });
   
	console.log("data view is ready"); 
	console.log(allEmployeeMapDT.getNumberOfRows());
	
	console.log('reached select');
	allEmployeeData_DB.bind(allEmployeeNameFilter, allEmployeeDataTableChart);
	console.log('dt drawn');
	
	allEmployeeData_DB.draw(allEmployeeMapDT);
	console.log("dt drawn");
	//google.visualization.events.addListener(allEmployeeData_DB, 'ready', console.log("dashboard ready"));
	google.visualization.events.addListener(allEmployeeDataTableChart, 'select', initiateEmpSelection);

}

function initiateEmpSelection() {
	console.log("in function initiatempselectn");
	
		alert("btn clickd");
		var selectedRow=allEmployeeDataTableChart.getChart().getSelection();
		alert(selectedRow);
		var EmpTableChartDT = allEmployeeDataTableChart.getDataTable();
		var uid=EmpTableChartDT.getValue(selectedRow[0].row, 0);
		alert(uid);
//		$("#DownloadConfirmation").load(APP_PATH+"bridge?action=downloadresume&uid="+uid, function(response,status,xhr){console.log("resume downloaded");});
		console.log("b4 ajax call");
		
		
		document.getElementById("EmpUid").value=uid;
	/*	$.ajax({
			type:"GET",
			url: APP_PATH+'download?uid='+uid,//loginForm.attr('action'),
			
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

		*/
	
}




function queryAllCompanyData() {
	$("#allCompanyListContent").show();
	console.log("Inside queryAllCompanyData....: " );
	var queryString = APP_PATH+'widget?dataType=getDiffCompany&flag='+flag;
	console.log("after query"+flag);
	var query = new google.visualization.Query(queryString);
	console.log(queryString);
	query.send(handleAllCompanyDataResponse); 
	console.log("before response");
}


function handleAllCompanyDataResponse(response){
	console.log("inside response function");
	if (response.isError()) {		
	     console.log('Error in query: ' + response.getMessage() + ' ' + response.getDetailedMessage());
	      return;
	}
	allCompanyMapDT= response.getDataTable();
	console.log("+++++++++++++++++++++++++++");
	console.log(allCompanyMapDT.getNumberOfRows());
	console.log(allCompanyMapDT);
	initiateallCompanyMapDT();
}

function initiateallCompanyMapDT(){
	$("#addJobBOx").hide();
	console.log("inside initiate function");
	allCompanyData_DB = new google.visualization.Dashboard(document.getElementById('allCompanyListContent'));
 
 var allCompanyNameFilter = new google.visualization.ControlWrapper({
	   'controlType': 'StringFilter',
	   'containerId': 'allCompanyNameFilter',
	   'options': {
		   'filterColumnIndex' : 2
	   },
   });

 
 allCompanyDataTableChart = new google.visualization.ChartWrapper({
     'chartType': 'Table',
     'containerId': 'allCompanyDataTableChart',
     'options': {
       'width': 890,
       'height': 340,
       'showRowNumber': true
     },
     	'view': {'columns':[ 1,2,3,4 ]}
 });
   
	console.log("data view is ready"); 
	console.log(allCompanyMapDT.getNumberOfRows());
	
	console.log('reached select');
	allCompanyData_DB.bind(allCompanyNameFilter, allCompanyDataTableChart);
	console.log('dt drawn');
	allCompanyData_DB.draw(allCompanyMapDT);
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
						$("#addJobFormCrossButton").click();
					}											
				}
			  });
				
			}
	});
}
