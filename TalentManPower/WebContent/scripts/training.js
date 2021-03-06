var APP_PATH = "/tmp/";
var trainingMapDT;
$(document).ready(function() {
	console.log("in traning.js");
	initiateTrainingDT();
	$("registerBtnOverlay").hide();
	console.log("b4 functn");
	initiateRegisterButton();
	console.log("after functn");
	

});

function initiateRegisterButton() {
	$("#registerNow").click( function() {
		
		$('#registerBtnOverlay').height($(document).height());
		$("#registerBtnOverlay").show();
		console.log("b4 function loading course");
		$('#LoadingImage').show();
		$("#LoadCourses").load(APP_PATH+"bridge?action=loadCourses", function(response,status,xhr){console.log("courses load");});
		$('#LoadingImage').hide();
		
		
	});
	
	
	$("#registerSubmitButton").click(function() {
		var isError=0;
		var CompEmail=$("#RegCompanyEmail").val();  
		if(CompEmail=="" || CompEmail==$("#RegCompanyEmail").attr('placeholder')||(CompEmail.search("@")==-1)||(CompEmail.search(".com")==-1)){
			$("#registerBtnErrors").html("Enter valid Company EmailId");
			$("#registerBtnErrors").show();
			isError = 1;	
		}
		var ComName=$("#RegCompanyName").val();  
		if(ComName=="" || ComName==$("#RegCompanyName").attr('placeholder')){
			$("#registerBtnErrors").html("Enter valid Company Name");
			$("#registerBtnErrors").show();
			
			isError = 1;	
		}
	
		var ComContct=$("#CompanyContactNo").val();  
		if(ComContct=="" || ComContct==$("#CompanyContactNo").attr('placeholder')){
			$("#registerBtnErrors").html("Enter valid Company Contact No.");
			$("#registerBtnErrors").show();
			
			isError = 1;	
		}
	
		console.log("b4 ajax call");
		if(isError == 0) {
			
			var registerBtnForm = $("#registerBtnForm");
			
			
			$('#LoadingImage').show();
			$.ajax({
				type:"POST",
				url: APP_PATH+'bridge',
				data: registerBtnForm.serialize(),
				success: function(response){
					$('#LoadingImage').hide();
					var responseMessage = $.trim(response);
				
					
					if(responseMessage != "1") {
						$("#registerBtnErrors").html("Error in submitting forms ");
					} else {
						document.getElementById("registerBtnForm").reset();
						$('#registerBtnOverlay').hide();
						
						
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
	window.location.href="http://talentmanpower.com/tmp/views/training/"+field+"/"+course+".html";
}