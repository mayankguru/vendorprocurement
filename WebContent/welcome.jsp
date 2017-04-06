<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.vendor.VendorInformation" %>
<%@ page import ="com.vendor.DBVendorConnection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Vendor Registration Information</title>
<link rel="stylesheet" type="text/css" href="VendorStyle1.css">
<link rel="stylesheet" type="text/css" href="./styles/VendorStyle1.css">
<link rel="stylesheet" type="text/css"
	href="./styles/RegisterFormStyle.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<div align="center" class="div-header">
	<H1>Vendor Registration</H1>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="./js/healthcare.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<% VendorInformation vend1 = (VendorInformation) session.getAttribute("vend");%>
</head>
<body>

<% String LoginUser = vend1.getUsername();
   String pass = vend1.getPassword();
   String VendorName="";
   
  
   boolean existuser = false;
   
   LoginUser = LoginUser.trim();
   pass = pass.trim();
   
   DBVendorConnection vendconn =  new DBVendorConnection();
   String vendorID = vendconn.DBRetrieveLoginInfo(LoginUser, pass);
   
   if (vendorID != "")
   {
   		
	   //response.sendRedirect("index.jsp");
	   System.out.println("The user exists in the database");
	   
	   vendconn.DBRetrieveVendorInfo(LoginUser);
	 
	 
   }
   
   else
   {
	   
	   
   }
	   
   //System.out.print("The company Name is " + vend1.getCompanyname());
   System.out.print("The vendor Name is " + vendconn.getCompanyname());
%>
<script type="text/javascript">
	$(document).ready(function() {
		var comtype = '<%=vendconn.getCompanytype() %>';
		var industry = '<%=vendconn.getIndustry() %>';
		var state = "<%=vendconn.getState() %>";
		
		$('select[name="companytype"]').val(comtype);
		$('select[name="industry"]').val(industry);
		$('select[name="state"]').val(state);
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".datepicker").datepicker({
			dateFormat : 'yy-mm-dd'
		});

		$('.justnumber').keyup(function() {
			if (this.value != this.value.replace(/[^0-9\.,]/g, '')) {
				this.value = this.value.replace(/[^0-9\.]/g, '');
			}
		});
		
		$('.justnumber-int').keyup(function() {
			if (this.value != this.value.replace(/[^0-9\.,]/g, '')) {
				this.value = this.value.replace(/[^0-9\.]/g, '');
			}
			this.value = this.value.replace('.', '');
		});

		$('.divdatepicker').on('click', function() {
			$(this).find('input').trigger('focus');
		});
	});

	function validateEmail(email) {
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(email);
	}

	function checkRequiredFields() {
		var allctrls = $('.ctrl-required select, .ctrl-required input');

		var isValid = true;
		for (var i = 0; i < allctrls.length; i++) {
			if ($(allctrls[i]).val() == '') {
				isValid = false;
				break;
			}
		}

		if (!isValid) {
			alert('Please enter data for all required fields.');

			return false;
		}
		
		var website = $('input[name="companywebsite"]').val();
		if (website.indexOf('.') < 0) {
			alert('The website you entered is invalid!');

			return false;
		}

		var email = $('input[name="email"]').val();
		if (!validateEmail(email)) {
			alert('The email you entered is invalid!');

			return false;
		}

		/*var pwd = $('input[name="password"]').val();
		var repwd = $('input[name="reenterpassword"]').val();
		if (pwd != repwd || pwd == '') {
			alert('Password fields are not matched!');

			return false;
		}*/

		return true;
	}
	
	function reloadPage() {
		$('.content-block input[type="text"], .content-block select').val('');
		$('.content-block input[type="text"], .content-block select').attr('value', '');
	}
</script>
		<div class="div-content">
		<div class="div-column" style="width: 98%">
			<!-- Login Area -->
			<div class="div-title">Edit Vendor Registration Form</div>
			<div class="content-block">
				<FORM ACTION="EditRegistrationServlet" METHOD="post">
					<div class="div-controls ctrl-required">
						<label>Name of the Company/Vendor: <span
							class="lbl-required">*</span></label> <INPUT readonly style="color: red;" type="text"
							name="companyname"value="<%= vendconn.getCompanyname()%>" placeholder="Name of the Company/Vendor"><br>
					</div>
					<div class="div-controls ctrl-required">
						<label>Company Registration No.: <span
							class="lbl-required">*</span></label> <INPUT readonly style="color: red;" type="text"
							name="registrationno" value="<%= vendconn.getRegistrationno() %>" placeholder="Company Registration No."><br>
					</div>
					<div class="div-controls ctrl-required">
						<label>Company Type: <span class="lbl-required">*</span></label> <select name="companytype">
							<option value="Sole Proprietership">Proprietary</option>
							<option value="Private ">Private Limited</option>
							<option value="Partnership">Partnership</option>
							<option value="Public">Public</option>
						</select>
					</div>
					<div class="div-controls ctrl-required">
						<label>Industry: <span class="lbl-required">*</span></label> <select name="industry">
							<option value="Energy">Energy</option>
							<option value="Financial">Financial</option>
							<option value="Consulting">Consulting</option>
							<option value="Healthcare">Healthcare</option>
							<option value="Pharmaceutical">Pharmaceutical</option>
							<option value="Manufacturing">Manufacturing</option>
							<option value="Other: Please specify">Other</option>
						</select>
					</div>
				
					<div class="div-controls">
						<label>Company Web Site:</label> <INPUT type="text"
							name="companywebsite" value="<%=vendconn.getCompanywebsite() %>" placeholder="Company Web Site."><br>
					</div>
					
					<div class="div-controls divdatepicker">
						<label>Date Registered:</label> <INPUT type="text"
							value="<%= vendconn.getDateRegistered() %>" name="dateregistered" placeholder="Date Registered" class="datepicker">
					</div>

					<div class="div-controls-line">Registered Office</div>
					<div class="div-controls ctrl-required" >
						<label>Contact Person Name: <span class="lbl-required">*</span></label>
						<INPUT type="text" name="contactpersonname" value="<%= vendconn.getContactpersonname()%>"
							placeholder="Contact Person Name"><br>
					</div>
					<div class="div-controls">
						<label>Address:</label> <INPUT type="text" name="address" value="<%= vendconn.getAddress()%>"
							placeholder="Address Line 1"><br>
					</div>
				
					<div class="div-controls">
						<label>City:</label> <INPUT type="text" name="city" value = "<%= vendconn.getCity()%>"
							placeholder="City"><br>
					</div>
					<div class="div-controls">
						<label>State:</label> <select name="state" value = "<%= vendconn.getState()%>" placeholder="State">
							<option value="AL">Alabama</option>
							<option value="AK">Alaska</option>
							<option value="AZ">Arizona</option>
							<option value="AR">Arkansas</option>
							<option value="CA">California</option>
							<option value="CO">Colorado</option>
							<option value="CT">Connecticut</option>
							<option value="DE">Delaware</option>
							<option value="DC">District Of Columbia</option>
							<option value="FL">Florida</option>
							<option value="GA">Georgia</option>
							<option value="HI">Hawaii</option>
							<option value="ID">Idaho</option>
							<option value="IL">Illinois</option>
							<option value="IN">Indiana</option>
							<option value="IA">Iowa</option>
							<option value="KS">Kansas</option>
							<option value="KY">Kentucky</option>
							<option value="LA">Louisiana</option>
							<option value="ME">Maine</option>
							<option value="MD">Maryland</option>
							<option value="MA">Massachusetts</option>
							<option value="MI">Michigan</option>
							<option value="MN">Minnesota</option>
							<option value="MS">Mississippi</option>
							<option value="MO">Missouri</option>
							<option value="MT">Montana</option>
							<option value="NE">Nebraska</option>
							<option value="NV">Nevada</option>
							<option value="NH">New Hampshire</option>
							<option value="NJ">New Jersey</option>
							<option value="NM">New Mexico</option>
							<option value="NY">New York</option>
							<option value="NC">North Carolina</option>
							<option value="ND">North Dakota</option>
							<option value="OH">Ohio</option>
							<option value="OK">Oklahoma</option>
							<option value="OR">Oregon</option>
							<option value="PA">Pennsylvania</option>
							<option value="RI">Rhode Island</option>
							<option value="SC">South Carolina</option>
							<option value="SD">South Dakota</option>
							<option value="TN">Tennessee</option>
							<option value="TX">Texas</option>
							<option value="UT">Utah</option>
							<option value="VT">Vermont</option>
							<option value="VA">Virginia</option>
							<option value="WA">Washington</option>
							<option value="WV">West Virginia</option>
							<option value="WI">Wisconsin</option>
							<option value="WY">Wyoming</option>
						</select>
					</div>
					<div class="div-controls">
						<label>Country:</label> <INPUT type="text" name="country" value="<%= vendconn.getCountry()%>"
							placeholder="Country"><br>
					</div>
					<div class="div-controls ctrl-required">
						<label>Zip Code: <span class="lbl-required">*</span></label> <INPUT
							type="text" name="zipcode" value="<%= vendconn.getZipcode()%>" placeholder="Zip Code"><br>
					</div>
					<div class="div-controls ctrl-required">
						<label>Telephone No.: <span class="lbl-required">*</span></label>
						<INPUT type="text" name="phone" value="<%= vendconn.getPhone()%>" placeholder="Telephone No."><br>
					</div>
					<div class="div-controls">
						<label>Cell Phone.:</label> <INPUT type="text" name="cellular" value = "<%= vendconn.getCellular()%>"
							placeholder="Cell No."><br>
					</div>
					<div class="div-controls">
						<label>Email Id.:</label> <INPUT type="text" name="email" value = "<%= vendconn.getEmail()%>"
							placeholder="Email Id."><br>
					</div>

					<div class="div-controls-line">Product and Services</div>
					<div class="div-controls ctrl-required">
						<label>Product Name: <span class="lbl-required">*</span></label> <INPUT
							type="text" name="productname" value ="<%= vendconn.getProductname()%>" placeholder="Product Name"><br>
					</div>

					<div class="div-controls">
						<label>Avg. Monthly Production:</label> <INPUT type="text"
							name="avgmonthlyproduction" value="<%= vendconn.getAvgmonthlyproduction()%>" class="justnumber-int"
							placeholder="Avg. Monthly Production"><br>
					</div>
					<div class="div-controls-line">Annual Results For Last 3
						years</div>
					<div class="div-controls-subline">1 Year</div>
					<div class="div-controls">
						<label>No. of Sales:</label> <INPUT type="text" name="noofsales1" value="<%= vendconn.getNoofsales1()%>"
							class="justnumber-int" placeholder="No. of Sales"><br>
					</div>
					<div class="div-controls">
						<label>Profit before Interest/Tax:</label> <INPUT type="text"
							name="profit1" value="<%= vendconn.getProfit1()%>" class="justnumber"
							placeholder="Profit before Interest/Tax"><br>
					</div>

					<div class="div-controls">
						<label>Additional Income:</label> <INPUT type="text"
							name="otherincome1" value="<%= vendconn.getOtherincome1()%>" class="justnumber" placeholder="Other Income"><br>
					</div>
					<div class="div-controls-subline">2 Year</div>
					<div class="div-controls">
						<label>No. of Sales:</label> <INPUT type="text" name="noofsales2" value="<%= vendconn.getNoofsales2()%>"
							class="justnumber-int" placeholder="No. of Sales"><br>
					</div>
					<div class="div-controls">
						<label>Profit before Interest/Tax:</label> <INPUT type="text"
							name="profit2" value="<%= vendconn.getProfit2()%>" class="justnumber"
							placeholder="Profit before Interest/Tax"><br>
					</div>

					<div class="div-controls">
						<label>Additional Income:</label> <INPUT type="text"
							name="otherincome2" value="<%= vendconn.getOtherincome2()%>" class="justnumber" placeholder="Other Income"><br>
					</div>
					<div class="div-controls-subline">3 Year</div>
					<div class="div-controls">
						<label>No. of Sales:</label> <INPUT type="text" name="noofsales3" value="<%= vendconn.getNoofsales3()%>"
							class="justnumber-int" placeholder="No. of Sales"><br>
					</div>
					<div class="div-controls">
						<label>Profit before Interest/Tax:</label> <INPUT type="text"
							name="profit3" value="<%= vendconn.getProfit3()%>" class="justnumber"
							placeholder="Profit before Interest/Tax"><br>
					</div>

					<div class="div-controls">
						<label>Additional Income:</label> <INPUT type="text"
							name="otherincome3" value="<%= vendconn.getOtherincome3()%>" class="justnumber" placeholder="Other Income"><br>
					</div>
					<BR>
					<div class="div-controls">
						<label>User Name:</label> <INPUT type="text" name="username"  value="<%=vendconn.getUserName() %>" readonly
							placeholder="User Name"><br>
					</div>
					<div class="div-controls">
						<label>Password:</label> <INPUT type="password" name="password"
							placeholder="Password"><br>
						<br>
					</div>

					<div class="div-controls">
						<label>Re-Enter Password:</label> <INPUT type="password"
							name="reenterpassword" placeholder="password"><br>
						<br>
					</div>
					<BR>
				
					<div class="div-controls-line"></div>

					<INPUT type="submit" onclick="return checkRequiredFields();"
						value="Update" class="btn btn-submit"> <INPUT type="reset" onclick="reloadPage();" 
						class="btn btn-default" value="Reset"><br>

				</FORM>
			</div>
		</div>
	</div>
	<div style="clear: both;" />
	<footer>
	<div>© ALL RIGHTS RESERVED</div>
	</footer>
   
<a href="index.jsp" class="backtohome"><i class="fa fa-home" aria-hidden="true"></i> Back To Home Page</a>
</body>
</html>