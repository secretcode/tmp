<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<script type="text/javascript" src="../scripts/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="../scripts/webwidget_vertical_menu.js"></script>
		<script type="text/javascript" src="../scripts/ve.js"></script>
		<link href="../style/webwidget_vertical_menu.css" rel="stylesheet" type="text/css">
		<link href="../style/ve.css" rel="stylesheet" type="text/css">
		<link href="../style/index.css" rel="stylesheet" type="text/css">
		<link href="../style/horizontalMenu.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<div id="veGetStartedOverlay">
		<div id ="veGetStartedFormContainer">
			<h1 id ="veGetStartedFormTitle"> Get Started </h1>
			<img id="veGetStartedFormCrossButton" src="../images/crossButton.jpg">
			<form  id="veGetStartedForm"  name="veForm" method="post" action="/tmp/bridge">
				<input type=hidden name="action" value="veForm">
				<span id ="errorMessage" class ="red">
				
				
				
				</span>
				<div>
					<span class="red">* </span> Describe Your Hiring Requirement / Skill Set In Detail<br>
					<textarea name="skillsets" id="skillsets" cols="35" rows="7" ></textarea>
					
				</div>
				<table id ="getStartedFormInput">
					<tr>
						<td>
							<div id="input-msg-block1"></div>
							<div class="columtext">
								<label><span class="red">* </span>Contact Person: </label><br>
								<select name="salutation" id="salutation" class="fild1">
									<option value="">Select</option>
									<option value="Mr">Mr</option>
									<option value="Mrs">Mrs</option>
									<option value="Ms">Ms</option>
									<option value="Dr">Dr</option>
								</select>
								<input type="text" class="nameInput" name="name1" id="name1" onfocus="if (this.value == 'First Name') this.value = '';" onblur="if (this.value == '') this.value = 'First Name';" value="First Name">
								<input type="text" class="nameInput" name="lname1" id="lname1" onfocus="if (this.value == 'Last Name') this.value = '';" onblur="if (this.value == '') this.value = 'Last Name';" value="Last Name">
							</div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Contact No:</label><br>
								<input type="text" class="textbox" name="phone" id="phone" onfocus="if (this.value == 'Contact Number') this.value = '';" onblur="if (this.value == '') this.value = 'Contact Number';" value="Contact Number">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Email Address:</label>
								<input type="text" name="email" id="email" value="" class="textbox">
							</div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Country:</label>
								<select name="country" id="country" class="textbox">
									<option value="">Select</option>
									<option value="1">Australia</option>
									<option value="2">Bahrain</option>
									<option value="3">Bangladesh</option>
									<option value="4">Belgium</option>
									<option value="5">Canada</option>
									<option value="6">Doha</option>
									<option value="7">Dubai</option>
									<option value="8">France</option>
									<option value="9">Germany</option>
									<option value="10">Hong Kong</option>
									<option value="11">India</option>
									<option value="12">Indonesia</option>
									<option value="13">Ireland</option>
									<option value="14">Italy</option>
									<option value="15">Japan</option>
									<option value="16">Kenya</option>
									<option value="17">Kuwait</option>
									<option value="18">Lebanon</option>
									<option value="19">Libya</option>
									<option value="20">Malaysia</option>
									<option value="21">Maldives</option>
									<option value="22">Mauritius</option>
									<option value="23">Mexico</option>
									<option value="24">Nepal</option>
									<option value="25">Netherlands</option>
									<option value="26">New Zealand</option>
									<option value="27">Norway</option>
									<option value="28">Oman</option>
									<option value="29">Pakistan</option>
									<option value="30">Qatar</option>
									<option value="31">Quilon</option>
									<option value="32">Russia</option>
									<option value="33">Saudi Arabia</option>
									<option value="34">Singapore</option>
									<option value="35">South Africa</option>
									<option value="36">South Korea</option>
									<option value="37">Spain</option>
									<option value="38">Sri Lanka</option>
									<option value="39">Sweden</option>
									<option value="40">Switzerland</option>
									<option value="41">Thailand</option>
									<option value="42">UAE</option>
									<option value="43">UK</option>
									<option value="44">US</option>
									<option value="45">Yemen</option>
									<option value="46">Zimbabwe</option>
								</select>
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Company: </label>
								<input type="text" name="company" id="company" value="" class="textbox">
							</div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Website:</label>
								<input type="text" value="" name="website" id="website" class="textbox">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label>Your designation with in the company?</label>
								<select name="designation_within_the_company" id="designation_within_the_company" class="textbox" value="">
									<option value="">Please Select</option>
									<option value="Chief Executive Officer">Chief Executive Officer</option>
									<option value="Chief Operations Officer">Chief Operations Officer</option>
									<option value="Chief Financial Officer">Chief Financial Officer</option>
									<option value="Managing Director">Managing Director</option>
									<option value="HR Manager">HR Manager</option>
									<option value="Other">Other</option>
								</select>
							</div>
						</td>
						<td>
							<div class="columtext_last">
								<label>Skype/Chat ID:</label>
								<input type="text" name="skypeid" id="skypeid" class="textbox" value="">
							</div>
							<div class="clear"></div>
						</td>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Street Address:</label><br>
								<input type="text" name="street" id="street" class="textbox" value="">
							</div>
						</td>
						<td>
							<div class="columtext_last">
								<label>Attach Documents</label>
								<input type="file" name="fileupload" id="fileupload">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
							  <input type="text" class="fild1" name="city" id="city" onfocus="if (this.value == 'City') this.value = '';" onblur="if (this.value == '') this.value = 'City';" value="City"><br>
							  <input type="text" class="fild2"  name="state" id="state" onfocus="if (this.value == 'State') this.value = '';" onblur="if (this.value == '') this.value = 'State';" value="State"><br>
							  <input type="text" class="fild3" name="pincode" id="pincode" onfocus="if (this.value == 'Postal Code') this.value = '';" onblur="if (this.value == '') this.value = 'Postal Code';" value="Postal Code">
							</div>
						</td>
						<td>
							<div class="columtext_last">
							  <label>Enter the code:<br></label>
							  <img style="float:left;" alt="captcha image" src="http://localhost:8080/tmp/captcha" width="100" height="28">
							  <input type="text" maxlength="6" style="width:60px;float:left; margin-left:10px;" size="6" class="input_text" name="captcha" id="captcha">
							  <br><br>(Please enter value from image)
							</div>
						</td>
					</tr>
				</table><br>
				<div id="veGetStartedFormButton"> <a href="#" class="button">Send Enquiry </a></div>			
			</form>
			
			
	
		</div>
	</div>
	<div id="nav">
		<ul>
			<li> <a href="../main.html">Home</a></li>
			<li><a href="aboutUs.html">About</a></li>
			<li><a href="services.html">Services</a>
				<ul>
					<li><a href="train.html">Training</a></li>
					<li><a href="hiring.html">Hiring</a></li>
					<li><a href="#">Virtual Employee</a>
						<ul>
							<li><a href="#">How Does it work</a></li>
							<li><a href="#">Working remotely</a></li>
							<li><a href="#">Your office in India</a></li>
							<li><a href="#">Data Security</a></li>
							<li><a href="#">VE Facilities</a></li>
							<li><a href="#">VE Advantages</a></li>
							<li><a href="#">Get Started</a></li>
						</ul>
					</li>
					
				</ul>
			</li>
			<li><a href="contactUs.html">Contact Us</a></li>
		</ul>
		<div id ="loginSignUpBox" style="float:right;color:#fff" >
			<div id="login"> Login
				<div id="loginBox">
					<form method="post" id ="loginForm">
						<input type="hidden" name ="action" value="loginUser"></input>
						User Name:
						<input id="userName" class="loginInput" name="userName" placeholder="User Name"></input>
						Password:
						<input id="password" class="loginInput"type="password" name="password" placeholder="****"></input>
						<div id ="loginErrorMessage"class="red">password or username is not correct</div>
						<div id ="loginSubmitButton">Login</div>
					</form>
				</div>				
			</div>
			<div id ="signUp"> Signup</div>
		</div>			
	</div>
	<div id="title">
		<strong>
			Talent Manpower 
		</strong><br>
		Training and Recruitment
	</div>
	<hr>
	<img id="frontImage" src="../images/download.jpg" class="stretch" />
	<hr>
	<table >
	<tr>
		<td>
		<div id ="veSideMenuContainer">
		<div id="veSideMenu" class="webwidget_vertical_menu">
		<ul>
			<li><a href="#" id ="howDoWorkLink">How Does it work</a></li>
			<li><a href="#" id="workRemotelyLink">Working Remotely</a></li>
					<li><a href="#" id="officeInIndiaLink">Your office in India</a></li>
					<li><a href="#" id ="dataSecurityLink">Data Security</a></li>
					<li><a href="#" id ="facilityLink">VE Facilities</a></li>
					<li><a href="#" id ="advantagesLink">VE Advantage</a></li>
					<li><a href="#" id ="getStartedLink">Get Started</a></li>
		</ul>
	</div>	
    <div style="clear: both"></div>
	</div>
	</td>
<td><div id ="content">
		<div id ="veContent"> --Some default content--</div>
		<div id="howDoWorkContent"> --Some Content goes here explaining how does it work---</div>
		<div id="workRemotelyContent"> --Some Content goes here explaining how to work remotely---</div>
		<div id="officeInIndiaContent"> --Some Content goes here explaining how your office will be in india---</div>
		<div id="dataSecurityContent"> --Some Content goes here explaining how your data will be safe with us---</div>
		<div id="facilityContent"> --Some Content goes here explaining facilities provided---</div>
		<div id="advantagesContent"> --Some Content goes here explaining advantages of virtual employee---</div>
		<div id="getStartedContent"> --Some Content goes here explaining how to get started with us---</div>
		<br><br>
		<div id ="veLearnMoreButton"> <a href="#" class="button">Learn More </a></div><br><br><br>
		<div id ="veGetStartedButton"> <a href="#" class="button">Get Started </a></div><br>
</div>
</td>
</tr>
</table>
<hr>
<div id ="footer">
virtual emp
<div id="footernavigation">
abc kithe gya siiiiii:-<br>
jindagi k maze leene pub gya si<br>
<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="aboutUs.html">About</a></li>
			<li><a href="services.html">Services</a></li>
			<ul>
				<li><a href="train.html">Training</a></li>
				<li><a href="hiring.html">Hiring</a></li>
				<li><a href="#">Virtual Employee</a></li>
			</ul>
			<li><a href="contactUs.html">Contact Us</a></li>
		</ul>
</div>
</div>
<script language="javascript" type="text/javascript">
     $(function() {
		 $("#veSideMenu").webwidget_vertical_menu({
             menu_width: '200',
             menu_height: '30',
             menu_margin: '3',
             menu_text_size: '15',
             menu_text_color: '#CCC',
             menu_background_color: '#3C4447',
             menu_border_size: '2',
             menu_border_color: '#000',
             menu_border_style: 'solid',
             menu_background_hover_color: '#306FB1',
             directory: 'images'
         });
     });
 </script>
</body>

</html>
