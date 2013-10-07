$( document ).ajaxError(function() {
  console.log('ajax error');
});
$(function(){
	var APP_PATH = "/tmp/";
	$('#loadingImage').hide();
	
	$('#howDoWorkLink').click(function(){
		document.getElementById('howDoWorkLink').className = 'current';
		document.getElementById('workRemotelyLink').className = 'none';
		document.getElementById('officeInIndiaLink').className = 'none';
		document.getElementById('dataSecurityLink').className = 'none';
		document.getElementById('facilityLink').className = 'none';
		document.getElementById('advantagesLink').className = 'none';
		document.getElementById('getStartedLink').className = 'none';
		
		$('#howDoWorkContent').show();
		$('#veContent').hide();
		$('#workRemotelyContent').hide();
		$('#officeInIndiaContent').hide();
		$('#dataSecurityContent').hide();
		$('#facilityContent').hide();
		$('#advantagesContent').hide();
		$('#getStartedContent').hide();
	});
	$('#workRemotelyLink').unbind('click');
	$('#workRemotelyLink').click(function(){
		document.getElementById('howDoWorkLink').className = 'none';
		document.getElementById('workRemotelyLink').className = 'current';
		document.getElementById('officeInIndiaLink').className = 'none';
		document.getElementById('dataSecurityLink').className = 'none';
		document.getElementById('facilityLink').className = 'none';
		document.getElementById('advantagesLink').className = 'none';
		document.getElementById('getStartedLink').className = 'none';
		
		console.log('inside work remotely link click function');
		$('#workRemotelyContent').show();
		$('#veContent').hide();
		$('#howDoWorkContent').hide();
		$('#officeInIndiaContent').hide();
		$('#dataSecurityContent').hide();
		$('#facilityContent').hide();
		$('#advantagesContent').hide();
		$('#getStartedContent').hide();
		console.log('going outside work remotely link click function');
	});
	$('#officeInIndiaLink').click(function(){
		document.getElementById('howDoWorkLink').className = 'none';
		document.getElementById('workRemotelyLink').className = 'none';
		document.getElementById('officeInIndiaLink').className = 'current';
		document.getElementById('dataSecurityLink').className = 'none';
		document.getElementById('facilityLink').className = 'none';
		document.getElementById('advantagesLink').className = 'none';
		document.getElementById('getStartedLink').className = 'none';
		$('#workRemotelyContent').hide();
		$('#veContent').hide();
		$('#howDoWorkContent').hide();
		$('#officeInIndiaContent').show();
		$('#dataSecurityContent').hide();
		$('#facilityContent').hide();
		$('#advantagesContent').hide();
		$('#getStartedContent').hide();
	});
	$('#dataSecurityLink').click(function(){
		document.getElementById('howDoWorkLink').className = 'none';
		document.getElementById('workRemotelyLink').className = 'none';
		document.getElementById('officeInIndiaLink').className = 'none';
		document.getElementById('dataSecurityLink').className = 'current';
		document.getElementById('facilityLink').className = 'none';
		document.getElementById('advantagesLink').className = 'none';
		document.getElementById('getStartedLink').className = 'none';
		$('#workRemotelyContent').hide();
		$('#veContent').hide();
		$('#howDoWorkContent').hide();
		$('#officeInIndiaContent').hide();
		$('#dataSecurityContent').show();
		$('#facilityContent').hide();
		$('#advantagesContent').hide();
		$('#getStartedContent').hide();
	});
	$('#facilityLink').click(function(){
		document.getElementById('howDoWorkLink').className = 'none';
		document.getElementById('workRemotelyLink').className = 'none';
		document.getElementById('officeInIndiaLink').className = 'none';
		document.getElementById('dataSecurityLink').className = 'none';
		document.getElementById('facilityLink').className = 'current';
		document.getElementById('advantagesLink').className = 'none';
		document.getElementById('getStartedLink').className = 'none';
		$('#workRemotelyContent').hide();
		$('#veContent').hide();
		$('#howDoWorkContent').hide();
		$('#officeInIndiaContent').hide();
		$('#dataSecurityContent').hide();
		$('#facilityContent').show();
		$('#advantagesContent').hide();
		$('#getStartedContent').hide();
	});
	$('#advantagesLink').click(function(){
		document.getElementById('howDoWorkLink').className = 'none';
		document.getElementById('workRemotelyLink').className = 'none';
		document.getElementById('officeInIndiaLink').className = 'none';
		document.getElementById('dataSecurityLink').className = 'none';
		document.getElementById('facilityLink').className = 'none';
		document.getElementById('advantagesLink').className = 'current';
		document.getElementById('getStartedLink').className = 'none';
		$('#workRemotelyContent').hide();
		$('#veContent').hide();
		$('#howDoWorkContent').hide();
		$('#officeInIndiaContent').hide();
		$('#dataSecurityContent').hide();
		$('#facilityContent').hide();
		$('#advantagesContent').show();
		$('#getStartedContent').hide();
	});
	$('#getStartedLink').click(function(){
		document.getElementById('howDoWorkLink').className = 'none';
		document.getElementById('workRemotelyLink').className = 'none';
		document.getElementById('officeInIndiaLink').className = 'none';
		document.getElementById('dataSecurityLink').className = 'none';
		document.getElementById('facilityLink').className = 'none';
		document.getElementById('advantagesLink').className = 'none';
		document.getElementById('getStartedLink').className = 'current';
		$('#workRemotelyContent').hide();
		$('#veContent').hide();
		$('#howDoWorkContent').hide();
		$('#officeInIndiaContent').hide();
		$('#dataSecurityContent').hide();
		$('#facilityContent').hide();
		$('#advantagesContent').hide();
		$('#getStartedContent').show();
	});
	$('#veGetStartedButton').click(function(){
		$('#veGetStartedOverlay').height($(document).height());
		$('#veGetStartedOverlay').show();
	});
	$('#veGetStartedFormCrossButton').click(function(){
		$('#veGetStartedOverlay').hide();
	});
	var checkPhone=function()
	{
		var pattern = /^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$/;  
		return !pattern.test($('#phone').val());
	};  
	var checkEmail=function(emailAddress)
	{
		var pattern = new RegExp(/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
		return !pattern.test(emailAddress);
	};
	var checkWebsite=function(website)
	{
		var urlregex = new RegExp("^(http:\/\/www.|https:\/\/www.|ftp:\/\/www.|www.){1}([0-9A-Za-z]+\.)");
		return !urlregex.test(website);
	};
	
	var initiateAttachDocuments=function(response,status,xhr)
	{
		//console.log('mubarak '+ response);
		$('#errorMessage').show();
		console.log($('#errorMessage').html());
		if ($.trim($('#errorMessage').html())==''){
				$('#veGetStartedFormContainer').load(APP_PATH+"views/ve/contactUs.jsp",bindContactUs);
				$("#veGetStartedFormTitle").html("Contact Us");
				$("#veFormContainer").css("height","1200px");
			}
		else
			{
				$('#captcha').attr('src',APP_PATH+'captcha');
			}
		$("#veLoadingImage").hide();
	};
	
	$("#veGetStartedFormButton").click(function() {
//		console.log('virtual employee ka form submit ho raha h');
//		console.log($('#file').val());
		if ($('#skillsets').val()=='')
		{
			console.log('skillsets to batao');
			$('#errorMessage').html('Enter something in skill sets required');
			$('#errorMessage').show();
		}
		else if ($('#salutation').val()==''||$('#name1').val()==''||$('#name1').val()=='First Name')
		{
			$('#errorMessage').html('Enter Your Name Properly');
			$('#errorMessage').show();
		}
		else if (checkPhone())
		{
			$('#errorMessage').html('Contact Number is not correct');
			$('#errorMessage').show();
		}
		else if (checkEmail($('#email').val()))
		{
			$('#errorMessage').html('Enter a valid email address');
			$('#errorMessage').show();
		}
		else if ($('#country').val()=='')
		{
			$('#errorMessage').html('Please select the country');
			$('#errorMessage').show();
		}
		else if ($('#company').val()=='')
		{
			$('#errorMessage').html('Enter your company name');
			$('#errorMessage').show();
		}
		else if (checkWebsite($('#website').val()))
		{
			$('#errorMessage').html('Website entered is not correct');
			$('#errorMessage').show();
		}
		else if ($('#street').val()==''||$('#city').val()==''||$('#city').val()=='City'||$('#state').val()==''||$('#state').val()=='State'||$('#pincode').val()==''||$('#pincode').val()=='Postal Code')
		{
			$('#errorMessage').html('Enter complete address');
			$('#errorMessage').show();
		}
		else
			{
				$('#veLoadingImage').show();
				$("#errorMessage").load(APP_PATH+"bridge?"+$('#veGetStartedForm').serialize(), initiateAttachDocuments);
			}
	});
	function bindContactUs(){
		console.log("binding contact us");
		$("#veContactUsFormButton").unbind('click');
		$("#veContactUsFormButton").bind('click',function() {
		console.log('contact us virtual employee  ka form submit ho raha h');
		if ($('#tenure_of_employment').val()=='')
		{
			$('#errorMessage').html('Enter something in tenure of employment');
			$('#errorMessage').show();
		}
		else if ($('#shift_timings').val()=='')
		{
			$('#errorMessage').html('Enter something in shift timings');
			$('#errorMessage').show();
		}
		else if ($('#full_time_part_time').val()=='')
		{
			$('#errorMessage').html('Enter whether the employment is full time or part time');
			$('#errorMessage').show();
		}
		else if ($('#time_to_start').val()=='')
		{
			$('#errorMessage').html('Enter something about time of starting of the employment');
			$('#errorMessage').show();
		}
		else
			{
				$('#loadingImage').show();
				$("#errorMessage").load(APP_PATH+"bridge?"+$('#veContactUsForm').serialize());
			}
	});
	}
	

});


