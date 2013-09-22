$(function(){
	$('#serviceMenu').mouseenter(function(){
		console.log('inside servicemenu mouse enter function');
		$('#serviceDropdown').show();
		
	}).mouseleave(function(){
		$('#serviceDropdown').hide();
	});
});