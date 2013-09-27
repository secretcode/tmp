var APP_PATH = "/tmp/";
var trainingMapDT;
$(document).ready(function() {
	console.log("in traning.js");
	initiateTrainingDT();
	$("registerBtnOverlay").hide();
	console.log("b4 functn");
	initiateRegisterButton();
	console.log("after functn");
	initiateUserInfoBox();

});

function initiateUserInfoBox() {
	console.log("in user info box");
	$("#UserInformation").load(APP_PATH+"/views/dashBoard.jsp", function(response,status,xhr){console.log("information extracted");});
	$("UserInformation").show();
	console.log("info retrieved");

}
function initiateRegisterButton() {
	$("#registerNow").click( function() {
		alert("button clikd");
		$('#registerBtnOverlay').height($(document).height());
		$("#registerBtnOverlay").show();
		console.log("b4 function loading course");
		$("#LoadCourses").load(APP_PATH+"bridge?action=loadCourses", function(response,status,xhr){console.log("courses load");});
		
		
	});
	
	
	$("#registerSubmitButton").click(function() {
		var isError=0;
		var CompEmail=$("#CompanyEmail").val();  
		if(CompEmail=="" || CompEmail==$("#CompanyEmail").attr('placeholder')||(CompEmail.search("@")==-1)||(CompEmail.search(".com")==-1)){
			alert("enter valid CompanyEmail");
			isError = 1;	
		}
		var ComName=$("#CompanyName").val();  
		if(ComName=="" || ComName==$("#JobSalary").attr('placeholder')){
			alert("enter valid Company Name");
			isError = 1;	
		}
	
		var ComName=$("#CompanyContactNo").val();  
		if(ComName=="" || ComName==$("#CompanyContactNo").attr('placeholder')){
			alert("enter valid Contct no.");
			isError = 1;	
		}
	
		console.log("b4 ajax call");
		if(isError == 0) {
			
			var registerBtnForm = $("#registerBtnForm");
			
			alert("Apply Form var: "+ registerBtnForm);
			
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',
				data: registerBtnForm.serialize(),
				success: function(response){
					alert("Response is: "+response);
					var responseMessage = $.trim(response);
					alert(responseMessage);
					
					if(responseMessage != "1") {
						alert("Information is not entered correctly..!! have a look at it again:)");
					} else {
						alert("Inside else");
						alert("data entered uccessfully");
						$('#registerBtnOverlay').hide();
						alert("erty");
						
					}											
				}
			  });
			
		}

	
	});
	
	
	$('#registerBtnFormCrossButton').click(function(){
		$('#registerBtnOverlay').hide();
	});

}


function initiateTrainingDT() {
	var queryString = APP_PATH + 'widget?dataType=trainingDT';
	var query = new google.visualization.Query(queryString);
	console.log(query);
	query.send(handleTrainingResponse);

}

function handleTrainingResponse(response) {
	if(response.isError()) {
		alert("error in making dt");
		return;
	}
	trainingMapDT=response.getDataTable();
	console.log("dashboard started");
	trainingDB=new google.visualization.Dashboard(document.getElementById('trainingListContent'));
	var fieldsFilter = new google.visualization.ControlWrapper({
		'controlType' : 'StringFilter',
		'containerId' : 'fieldsFilter',
		'options' : {
			'filterColumnIndex' : 1
		}
	});
	
	
	trainingTableChart=new google.visualization.ChartWrapper(
			{
				'chartType' : 'Table',
				'containerId' : 'trainingTableChart',
				'options' : {
					'width' : 890,
					'height' : 340,
					'showRowNumber' : true
				},
				'view': {'columns':[ 1,2 ]}
			 });
	
	
	
	trainingDB.bind(fieldsFilter, trainingTableChart);
	console.log(trainingMapDT.getNumberOfRows());


	trainingDB.draw(trainingMapDT);
	console.log("dt drawn");
	console.log(trainingTableChart);
	google.visualization.events.addListener(trainingTableChart, 'select', initiateSelection);
	
			   			
}

function initiateSelection() {
	var selectedRow=trainingTableChart.getChart().getSelection();
	alert(selectedRow);
	var trainingTableChartDT = trainingTableChart.getDataTable();
	var field1=trainingTableChartDT.getValue(selectedRow[0].row, 1);
	var course1=trainingTableChartDT.getValue(selectedRow[0].row, 2);
	alert(field1);
	alert(course1);
	var field=field1.replace(/\s+/g,"");
	var course=course1.replace(/\s+/g,"");
	alert(course);
	alert(field);
	window.location.href="http://localhost:8080/tmp/views/training/"+field+"/"+course+".html";
}