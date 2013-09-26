

var APP_PATH = "/tmp/";

$(document).ready(function() {
	initiateUserInfoBox();
});

function initiateUserInfoBox() {
	console.log("in user info box");
	$("#UserInformation").load(APP_PATH+"/views/dashBoard.jsp", function(response,status,xhr){console.log("information extracted");});
	$("UserInformation").show();
	console.log("info retrieved");
}
