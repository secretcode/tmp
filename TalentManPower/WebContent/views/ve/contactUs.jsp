<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<form class="form" method="post" action="submit_get_started2.php">
  
   <div class="get_row">
      <label class="hdfrm">      
      We have received your enquiry. Thanks for your interest in our services.
      </label>
    <label class="hdfrm"> 
     Please help us get the most suitable resource for you by providing more details of your job requirements
     </label>
    </div>
    
     <div class="get_row">
  <label><h2 class="sub_title_heading">Employee Information</h2></label>
   </div>
    <div class="get_row">
      <label>Please let us know about the roles and responsibilities of the employee you seek to hire:</label>
      <textarea name="roles_responsibilities" cols="" rows="3" class="textarea"></textarea>
    </div>
    
     <div class="get_row">
      <label>Please let us know a little about your project/ work domain: </label>
      <textarea name="project_work_domain" cols="" rows="3" class="textarea"></textarea>
    </div>
    
     <div class="get_row">
      <label>How many years of experience should employee have in domain/skill set specified above:</label>
      <textarea name="years_of_experience_required" cols="" rows="3" class="textarea"></textarea>
      <label class="msgtext">(Please note you can specify a range of years and if unsure please write don't know/unsure. If varying years of experience in different technologies are required please specify. For e.g. 2 years Joomla, 2 years Drupal)</label>
    </div>
    <div id="input-msg-block1"></div>
     
     <div class="get_row">
      <div class="columtext">
        <label><span class="red"><span class="red">*</span></span> How long do you envisage yourself hiring a Virtual Employee?</label>
       <select name="tenure_of_employment" id="tenure_of_employment" class="textbox">
<option value="">Please Select</option>
<option value="1 Month or Less">1 month or less</option>
<option value="1 to 3 Months">1 to 3 Months</option>
<option value="3 to 6 Months">3 to 6 Months</option>
<option value="6 Months to 1 Year">6 Months to 1 Year</option>
<option value="More Than 1 Year">More Than 1 Year</option>
<option value="Do not know">Don’t know</option>
<option value="Not Sure">Not sure</option>
</select>
      </div>
      <div class="columtext_last">
        <label><span class="red">*</span> What working shift hours would you like your employee to work? </label>
        <select name="shift_timings" id="shift_timings" class="textbox">
<option value="">Please Select</option>
<option value="Exactly The Same Hours As Me">Exactly the same hours as me</option>
<option value="Half Indian Work Hours">Half Indian work hours</option>
<option value="Any Shift Hours">Any shift hours</option>
<option value="Not Sure">Not Sure</option>
</select>
      </div> 
      <div class="clear"></div>
    </div>


<div class="get_row">
      <div class="columtext">
        <label><span class="red">*</span> Is this a full time or part time position? </label>
        <select name="full_time_part_time" id="full_time_part_time" class="textbox">
<option value="">Please Select</option>
<option value="Full Time">Full Time</option>
<option value="Part Time">Part Time</option>
<option value="Not Sure">Not Sure </option>
</select>
      </div>
      
      <div class="columtext_last">
         <label><span class="red">*</span> When do you want your employee to start?</label>
        <select name="employee_to_start" id="employee_to_start" class="textbox">
<option value="">Please Select</option>
<option value="As soon as possible">As soon as possible</option>
<option value="Beginning of next month">Beginning of next month</option>
<option value="After 2 months">After 2 months</option>
<option value="I am flexible">I am flexible</option>
<option value="Just considering/Enquiring">Just considering/Enquiring</option>
<option value="Not Sure/Do not Know">Not Sure/Don’t Know</option>
</select>
      </div>
      <div class="clear"></div>
    </div>


<div class="get_row">
 <label>Are you technically proficient in the field in which you are looking to hire an employee?</label>
      <select name="technically_proficient" id="technically_proficient" class="textbox">
<option value="0">Please Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
<option value="Partially">Partially</option>
<option value="I am not,but my colleagues are">I am not,but my colleagues are</option>
</select>
<label class="msgtext">
(E.g. If you want to hire PHP programmer are you technically proficient in PHP? If you want to hire a mechanical engineer are you technically proficient in mechanical engineering? Etc)
</label>
  <div class="clear"></div>
</div>


<div class="get_row">
 <div class="columtext">
        <label>Have You Outsourced Before?</label>
      </div>
      <div class="columtext_last">
<input type="radio" name="outsourced_before" onclick="checkOutsource('y');" value="Yes" id="outsourced_before"> Yes <input type="radio" name="outsourced_before" value="No" checked="checked" onclick="checkOutsource('n');" id="outsourced_before">No
      
      
      
      
      
      </div>
        <div class="clear"></div>
    </div>

<div class="get_row" style="display:none;" id="hiddenoutsource">
  <label> <textarea name="outsourced_details" cols="" rows="3" class="textarea"></textarea></label>
   </div>



  <div class="get_row">
  <label><strong>Bussines Infomation</strong></label>
   </div>
   
<div class="get_row">
      <label>Please tell us about your business entity,(e.g. sole proprietorship, partnership, corporation, cooperative)</label>
      <textarea name="business_entity_information" cols="" rows="3" class="textarea"></textarea>
    </div>
    
    <div class="get_row">
      <label>Please tell us a little about your business domain/area of operations:</label>
      <textarea name="business_domain_area_of_operations" cols="" rows="3" class="textarea"></textarea>
    </div>
  
  
  <div class="get_row">
      <div class="columtext">
        <label>How long has your company been in operation? </label>
        <select name="in_operations_since" id="in_operations_since" class="textbox">
<option>Please Select</option>
<option value="Less than 1 year">Less than 1 year</option>
<option value="1-2years">1-2years</option>
<option value="2-3 years">2-3 years</option>
<option value="3-5 years">3-5 years</option>
<option value="5-10 years">5-10 years</option>
<option value="More than 10 years">More than 10 years</option>
</select>
      </div>
      
      <div class="columtext_last">
         <label>What is your company's annual turnover?</label>
       <select name="company_annual_turnover" id="company_annual_turnover" class="textbox">
<option value="0">Please Select</option>
<option value="Do not wish to disclose">Do not wish to disclose</option>
<option value="Company is a start up">Company is a start up</option>
<option value="Less than $100,000">Less than $100,000</option>
<option value="$100,000 - $250,000">$100,000 – $250,000</option>
<option value="$250,000 - $500,000">$250,000 – $500,000</option>
<option value="$500,000 - $1 million">$500,000 – $1 million</option>
<option value="$1 million - $5 million">$1 million – $5 million</option>
<option value="$5 million - $10 million">$5 million – $10 million</option>
<option value="$10 million - $20 million">$10 million – $20 million</option>
<option value="$20 million - $50 million">$20 million – $50 million</option>
<option value="$50 million+">$50 million+</option>
</select>
      </div>
      <div class="clear"></div>
    </div>
   
  <div class="get_row">
      <label class="getbtn">
      
      <input type="submit" onclick="return frm_getstarted2();" value="SUBMIT NOW" class="wpcf7-form-control  wpcf7-submit">
      <input type="hidden" name="steps" value="next5">
      </label>
    </div>
<div class="clear"></div>
      </form>