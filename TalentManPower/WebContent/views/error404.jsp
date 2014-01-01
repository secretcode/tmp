<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
   <meta charset="UTF-8">
   <title>TALENT MAN POWER</title>
   <script type="text/javascript" src="../scripts/jquery-1.3.2.min.js"></script>
   <script type="text/javascript" src="../scripts/index.js"></script>
     <script type="text/javascript" src="../scripts/loginInfo.js"></script>
   
   <link rel="icon" href="images/favicon.gif" type="image/x-icon"/>
   <link rel="shortcut icon" href="images/favicon.gif" type="image/x-icon"/> 
   <link rel="stylesheet" type="text/css" href="../style/temp.css"/>
   </head>
   <body>
   <div id ="LoadingImage" style ="display:none;"></div>
   <div id="companySignUpOverlay" class="overlayPage">
		<div id ="companySignUpFormDiv" class="overlayFormDiv">
			<h1 id ="companySignUpFormTitle" class="overLayFormTitle"> Company Sign Up 
			<img id="companySignUpFormCrossButton" class="overLayFormCrossButton" src="../images/crossButton.jpg">
			</h1>
			
			<form method=POST action="" name="companySignUpForm" id="companySignUpForm" class="overLayForm">
			<input type=hidden name=action value="companySignUpJobForm">
		<span id ="errorMessageC" class ="red"> </span>
				<h2 id="companyAccountInfo" class="" >Account Information</h2>
				<table id ="companyAccountInformation">
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>User Name:</label><br>
								<input type="text" class="textbox" name="ComUserName" id="CompanyUserName" placeholder="Name">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Password:</label><br>
								<input type="password" class="textbox" name="ComPassword" id="CompanyPassword" placeholder="****">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Confirm Password:</label><br>
								<input type="password" class="textbox" name="ConfirmComPassword" id="ConfirmCompanyPassword" placeholder="****">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Primary Email:</label><br>
								<input type="text" class="textbox" name="ComEmail" id="CompanyEmail" placeholder="Email Id">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Secondary Email (Optional):</label><br>
								<input type="text" class="textbox" name="SecondaryComEmail" id="SecondaryCompanyEmail" placeholder="Email Id">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
				</table>
				<br>
				<h2 id="companyInfo" class="" >Company Information</h2>
				<br>
				<table id ="companyInformation">
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Company Name:</label><br>
								<input type="text" class="textbox" name="ComName" id="CompanyName" placeholder="Company Name">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Contact Person:</label><br>
								<input type="text" class="textbox" name="ContactPerson" id="CompanyContactPerson" placeholder="Contact Person Name">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Contact Person Designation:</label><br>
								<input type="text" class="textbox" name="ContactPersonDesignation" id="CompanyContactPersonDesignation" placeholder="Managing Director">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Company Strength:</label><br>
								<input type="text" class="textbox" name="ComStrength" id="CompanyStrength" >
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Company Type:</label>
								<select name="ComType" id="CompanyType" class="textbox">
								<option value="">--Select--</option>
								<option value="1">Accounts/Finance/Tax/Audit/CS</option>
								<option value="2">Agriculture/Diary</option>
								<option value="3">Airlines</option>
								<option value="4">Animation</option>
								<option value="5">Automation/Office Equipment/Furnitures</option>
								<option value="6">Automobile</option>
								<option value="7">Automotive/Auto Ancillary</option>
								<option value="8">Aviation/Aerospace Firms</option>
								<option value="9">Banking/Broking/Financial Services</option>
								<option value="10">BPO/KPO/ITES</option>
								<option value="11">Brewery/Distillery</option>
								<option value="12">Cement</option>
								<option value="13">Ceramics/Sanitaryware</option>
								<option value="14">Chemical/PetroChemical/Plastic/Rubber</option>
								<option value="15">Construction</option>
								<option value="16">Construction</option>
								<option value="17">Consumer Durable</option>
								<option value="18">Courier/Transpiration/Freight</option>
								<option value="19">Defence/Goverment</option>
								<option value="20">Education/Teaching/Training</option>
								<option value="21">Electrical/Switchgears</option>
								<option value="22">Electronics/Semiconductors</option>
								<option value="23">Engineering/Matels/Forging</option>
								<option value="24">Export/Import</option>
								<option value="25">Facility Management</option>
								<option value="26">Fashion</option>
								<option value="27">Fertilizers/Pesticides</option>
								<option value="28">FMCG/Personal Care/Beverages</option>
								<option value="29">Food processing</option>
								<option value="30">Gems/Jewellery</option>
								<option value="31">Glass</option>
								<option value="32">Heat Ventilation Air Conditioning</option>
								<option value="33">Hotel/Restaurants</option>
								<option value="34">Immigartion</option>
								<option value="35">Industrial Product/Heavy Mechinery</option>
								<option value="36">Information Technology</option>
								<option value="37">Insurance</option>
								<option value="38">IT-Hardware/Networkintg</option>
								<option value="39">IT-Software/Software Services</option>
								<option value="40">KPO/Research/Ananlyst</option>
								<option value="41">Legal Law</option>
								<option value="42">Light Industries</option>
								<option value="43">Manufacturing</option>
								<option value="44">Media/Entertainment</option>
								<option value="45">Medical/Healthcare/Hospital</option>
								<option value="46">Mining</option>
								<option value="47">NGO/Social Services</option>
								<option value="48">Oil/Gas/Power/Infrastructures/Energy</option>
								<option value="49">Paper</option>
								<option value="50">Pharma/Biotech/Clinical Search</option>
								<option value="51">Printing/Packaging</option>
								<option value="52">Process Industries</option>
								<option value="53">Publishing</option>
								<option value="54">Real Estate/Property</option>
								<option value="55">Recruitments</option>
								<option value="56">Retail</option>
								<option value="57">Security/Law Enforcements</option>
								<option value="58">Shipping/Marine</option>
								<option value="59">Steel</option>
								<option value="60">Stock Broking</option>
								<option value="61">Strategy/Management Consultant</option>
								<option value="62">Telcom/ISP</option>
								<option value="63">Textile/Garments/Accessories</option>
								<option value="64">Travel</option>
								<option value="65">Tryes</option>
								<option value="66">Watch</option>
								<option value="67">Water Treatment/Waste Management</option>
								<option value="78">Wellness/Fitness/Sports</option>
							</select>
								
							</div>
							<div class="clear"></div>

						</td>
							<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Company Profile:</label><br>
								<input type="text" class="textbox" name="ComProfile" id="CompanyProfile" >
							</div>
							<div class="clear"></div>
						</td>
						
					</tr>
				</table>
				<br>
				<h2 id="companyAccountInfo" class="" >Account Information</h2>
				<br>
				<table id ="companyAccountInformation">
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Address:</label><br>
								<input type="text" class="textbox" name="ComAddress" id="CompanyAddress" >
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>City:</label><br>
								<input type="text" class="textbox" name="ComCity" id="CompanyCity">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>State:</label><br>
								<input type="text" class="textbox" name="ComState" id="CompanyState" >
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Country:</label><br>
								<input type="text" class="textbox" name="ComCountry" id="CompanyCountry" >
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Zip/PIN Code:</label><br>
								<input type="text" class="textbox" name="ComZip" id="CompanyZip">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Phone:</label><br>
								<input type="text" class="textbox" name="ComPhone" id="CompanyPhone">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Mobile:</label><br>
								<input type="text" class="textbox" name="ComMobile" id="CompanyMobile" >
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Fax:</label><br>
								<input type="text" class="textbox" name="ComFax" id="CompanyFax" >
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Website URL:</label><br>
								<input type="text" class="textbox" name="ComURL" id="CompanyURL">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
							  <label>Enter the code:<br></label>
							  <img style="float:left;" alt="captcha image" src="http://localhost:8080/tmp/captcha" width="100" height="28">
							  <input type="text"  style="width:60px;float:left; margin-left:10px;" size="6" class="input_text" name="captcha" id="captcha">
							  <br><br>(Please enter value from image)
							</div>
						</td>
						
					</tr>
				</table>				
				</form>
				<br>
				<div id="companySignUpSubmitButton"> <a href="#" class="overLayFormSubmitButton">Submit</a></div>			
			
		</div>
	</div>
	
	
	<div id="employeeSignUpOverlay" class="overlayPage">
		<div id ="employeeSignUpFormDiv" class="overlayFormDiv">
			<h1 id ="employeeSignUpFormTitle" class="overLayFormTitle"> Employee Sign Up 
			<img id="employeeSignUpFormCrossButton" class="overLayFormCrossButton" src="../images/crossButton.jpg" style="float: right;">
			</h1>
			
			<form method=POST action="" name="employeeSignUpForm" id="employeeSignUpForm" class="overLayForm">
			<input type=hidden name=action value="employeeSignUpJobForm">
				<span id ="errorMessage" class ="red"> </span>
				<table id ="employeePersonalDetails">
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>User Name:</label><br>
								<input type="text" class="textbox" name="EmpName" id="EmpName" placeholder="Full Name">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Password:</label><br>
								<input type="password" class="textbox" name="EmpPassword" id="EmpPassword" placeholder="****">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Confirm Password:</label><br>
								<input type="password" class="textbox" name="ConfirmEmpPassword" id="ConfirmEmpPassword" placeholder="****">
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Email id</label><br>
								<input type="text" class="textbox" name="EmpEmail" id="EmpEmail" placeholder="Email Address">
							</div>
							<div class="clear"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>Mobile:</label><br>
								<input type="text" class="textbox" name="EmpMobile" id="EmpMobile" >
							</div>
							<div class="clear"></div>
						</td>
						<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Address</label><br>
								<input type="text" class="textbox" name="Empaddress" id="Empaddress" >
							</div>
							<div class="clear"></div>
						</td>
						</tr>
						<tr>
						<td>
							<div class="columtext">
								<label><span class="red">* </span>UG Course / Basic qualification:</label><br>
								<select name="EmpCourse" id="EmpCourse" class="textbox">
								<option value="">--Select--</option>
								<option value="B.Tech">B.tech</option>
								<option value="M.Tech">M.Tech</option>
								<option value="MCA">MCA</option>
								<option value="MS">MS</option>
								<option value="CA">CA</option>
								<option value="CS">CS</option>
								<option value="MBA">MBA</option>
							</select>
								
							</div>
							<div class="clear"></div>

						</td>

					<td>
							<div class="columtext_last">
								<label><span class="red">* </span>Work Experience</label><br>
								<input type="text" class="textbox" name="EmpExperience" id="EmpExperience" >
							</div>
							<div class="clear"></div>
						</td>
											
						
				</tr>
				<tr>
						<td>
							<div class="columtext">
							  <label>Enter the code:<br></label>
							  <img style="float:left;" alt="captcha image" src="http://localhost:8080/tmp/captcha" width="100" height="28">
							  <input type="text"  style="width:60px;float:left; margin-left:10px;" size="6" class="input_text" name="captcha" id="captcha">
							  <br><br>(Please enter value from image)
							</div>
						</td>
				</tr>
						
				</table>
				</form>
				<br><br>
				<div id="employeeSignUpSubmitButton"> <a href="#" class="overLayFormSubmitButton">Submit</a></div>			
			</div>
		</div>
   
   
   <div id="container">
   <header>
   <a href="index.html" ><img id="logo" src="../images/logo.PNG" /></a>  	  
   <nav2>
   <ul>
   <li id ="login" ><a href="#" class="currrent">Login</a>
   <div id="loginBox">
			<form method="post" id ="loginForm" action="" name="loginForm">
						<input type="hidden" name ="action" value="loginUser"></input>
						<table>
							<tr>
							
								<td>Email Id:</td>
								<td><input id="loginUserName" class="loginInput" name="Username" placeholder="Email Address"></input></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input id="loginUserPassword" class="loginInput"type="password" name="password" placeholder="****"></input></td>
							</tr>
						</table>
					</form>
				<a href="#" id="forgotPwd" >Forgot Password</a>
				<div id="forgotPwdDetails">
					<form method="post" id="forgotPwdForm" action="" name="forgotPwdForm">
						<input type="hidden" name="action" value="forgotPwd"/>
							Email Id:<input type="text" placeholder="Enter your Email Id" name="PwdemailId" id="PwdemailId" class="loginInput"/>
					</form>
					<div id="forgotPwdBtn" class="button">Email new password</div>
				</div>
					<div id ="loginErrorMessage"class="red">Invalid UserName or password</div>
							<div id ="userLoginButton" class="button">Login</div>
				</div>
   
   </li>
	<li id="signUp"><a href="#" class="currrent">SignUp</a>
	<div id="signUpBox">
		<div id="signUpEmployee" class="button" >Employee</div> 
		<div id="signUpCompany" class="button" >Company</div>  
	</div>
	</li>
   </ul>
   </nav2>
   
   
  <nav3>
   <ul>
   <li id="changePwd"><a href="#" class="currrent">Change Password</a>
   	
   	<div id="changePwdBox">
			<form method="post" id ="changePwdFrm" action="" name="changePwdFrm">
						<input type="hidden" name ="action" value="changePwd"></input>
						<table>
							<tr>
							
								<td>New Password:</td>
								<td><input id="newPwd" class="loginInput" name="newPwd" placeholder="New Password"></input></td>
							</tr>
							<tr>
							
								<td>Confirm Password:</td>
								<td><input id="confPwd" type="password" class="loginInput" name="confPwd" placeholder="Confirm Password"></input></td>
							</tr>
						</table>
					</form>
					<div id ="changePwdFailureDiv"class="red"></div>
							<div id ="changePwdBtn" class="button">Change</div>
				</div>	
   	</li>
   <li id ="logOut" ><a href="#" class="currrent">Log Out</a></li>
   </ul>
   </nav3>
   
   
   
   
   <nav>
   <ul>
   <li><a href="index.html">Home</a></li>
   <li><a href="aboutUs.html">About us</a></li>
   <li><a href="services.html" class="current">Services</a>
	<ul>
		<li><a href="train.html">Training</a></li>
		<li><a href="hiring.html">Hiring</a></li>
		<li><a href="virtualEmp.html">Virtual Employee</a></li>			
	</ul>
  </li>
   <li><a href="contactUs.html">Contact</a></li>
   </ul>
   </nav>
   <div id="UserInformation"> </div>
   </header>
      <div id="intro">
   <img id="frontImage" src="../images/download.PNG"  />
   </div>
   <div class="holder_content">
   <section class="group1">
   <h3 style="font-size: 410%;">404.! PAGE NOT FOUND</h3>
   <ul style="font-size: 200%;"><a>Options For you..!!</a>
   	<li>    <a href="index.html">Redirect to home page.</a></li>
   	<li>    <a href="train.html">Redirect to training page.</a></li>
   	<li>    <a href="hiring.html">Redirect to hiring page.</a></li>
   	<li>    <a href="virtualEmp.html">Redirect to virtual employee page.</a></li>
   </ul>
   

   </div>
   </div>
   <footer>
	   <div class="container">  
  
  			<div id="FooterOne">
    			Call now at,<span id="contactno">09015760571<br></span>
   				Email:admin@talentmanpower.com
   	 		</div>
   			<img id="telephoneimage" src="../images/Telephone.jpg" style="width: 6%;float: right;">
   			<div id="FooterTwo"> � Talent Man Power </div>
   		</div>
   </footer>
   </body>
</html>