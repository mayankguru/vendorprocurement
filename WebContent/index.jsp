<HTML>

<HEAD>
<TITLE>Vendor Portal</TITLE>
<link rel="stylesheet" type="text/css" href="./styles/VendorStyle1.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="./js/healthcare.js"></script>
<div align="center" class="div-header">
	<H1>Welcome to Marco Healthcare Supplier Portal</H1>
</div>
<style type="text/css">
	.faq-block .link-item {
		margin-top: 15px;
		margin-bottom: 25px;
	}
	.faq-block .link-item:last-of-type {
		
	}
	.faq-block .link-item p {
		text-align: justify;
	}
	.faq-block .link-item span {
		font-weight: bold;
		margin-bottom: 3px;
		text-shadow: 1px 1px #f2f2f2;
		display: inline-block;
	}
</style>
<script type="text/javascript">
function reloadPage() {
	$('.content-block input[type="text"], .content-block select').val('');
	$('.content-block input[type="text"], .content-block select').attr('value', '');
}
</script>
</HEAD>

<BODY>
	<div class="div-content">
		<div class="div-column col-left">
			<!-- Login Area -->
			<div class="div-title">Login</div>
			<div class="content-block">
				<p>Existing Vendors - Please Login</p>

				<FORM ACTION="LoginServlet" METHOD="post">
					<div class="div-controls">
						<label>User Name:</label> <INPUT type="text" name="username"
							placeholder="User Name"><br>
					</div>
					<div class="div-controls">
						<label>Password:</label> <INPUT type="password" name="password"
							placeholder="Password"><br> <br>
					</div>
					<INPUT type="submit" value="Submit" class="btn btn-submit">

					<INPUT onclick="reloadPage();" type="reset" class="btn btn-default" value="Reset"><br>

				</FORM>
			</div>
			<div class="content-block">
				<div class="link-item">
					<i class="fa fa-pencil" aria-hidden="true"></i> <a
						href="registration.jsp">New Vendor Registration</a>
					<p>Click here to register as a vendor with the Marco Healthcare
						or locate login in with your credentials.</p>
				</div>
				<div class="link-item">
					<i class="fa fa-question" aria-hidden="true"></i> <a href="#">I
						forgot my password</a>
					<p>Click here to reset your password.</p>
				</div>
				<div class="link-item">
					<i class="fa fa-file-text" aria-hidden="true"></i> <a
						target="_blank"
						href="TrainingGuide.pdf">Vendor
						Training Guide</a>
					<p>Click here to view training guides.</p>
				</div>

				<div class="link-item">
					<i class="fa fa-file-text" aria-hidden="true"></i> <a
						href="submitproposal.jsp">Submit a Proposal</a>
					<p>Click here to submit a proposal.</p>
				</div>


			</div>
			<!-- Vendor Info -->
			<div class="div-title">Vendor Information</div>
			<div class="content-block">
				<div class="link-item">
					<i class="fa fa-arrow-right" aria-hidden="true"></i> <a href="#">Vendor
						Resources</a>
				</div>

				<div class="link-item">
					<i class="fa fa-arrow-right" aria-hidden="true"></i> <a href="#">Selling
						Goods & Services</a>
				</div>
				<div class="link-item">
					<i class="fa fa-arrow-right" aria-hidden="true"></i> <a href="#">Official
						Solicitations Announcements</a>
				</div>
				<div class="link-item">
					<i class="fa fa-arrow-right" aria-hidden="true"></i> <a href="#">Business
						Registration</a>
				</div>
				<div class="link-item">
					<i class="fa fa-arrow-right" aria-hidden="true"></i> <a href="#">Department
						of Revenue (DOR)</a>
				</div>
				<div class="link-item">
					<i class="fa fa-arrow-right" aria-hidden="true"></i> <a href="#">Human
						Services</a>
				</div>
			</div>
			<!-- FAQs -->
			<div
				style="background: #fcf8e3; border-radius: 4px; padding: 15px; border: 1px solid #feee9b;">
				<div class="div-title" style="border-bottom: 0px; font-family: cursive; color: orange; font-weight: bold; text-shadow: 1px 1px #db8e00;">Frequently Asked Questions</div>
				<div class="content-block faq-block">
					<div class="link-item">
						<i class="fa fa-question-circle" aria-hidden="true"></i> <span>Whom do I contact to get a Purchase Order (PO) number?</span>
						<p>Contact the department you've been working with to obtain the PO number.</p>
					</div>
					<div class="link-item">
						<i class="fa fa-question-circle" aria-hidden="true"></i> <span>I am having problems in registering online?</span>
						<p>Contact our Help Desk. They provide 24/7 Technical Support. The number to call is 1 888 Marco Support.</p>
					</div>
					<div class="link-item">
						<i class="fa fa-question-circle" aria-hidden="true"></i> <span>When and where is the next vendor training session being held?</span>
						<p>Check the Events section of the Home Page. It is updated every 48 hours. For urgent inquiries contact our Vendor Hotline at 1 888 233 4564</p>
						<p>Generally, vendor training sessions are held in the Packard Auditorium.</p>
					</div>
					<div class="link-item">
						<i class="fa fa-question-circle" aria-hidden="true"></i> <span>Where can I view existing bids</span>
						<p>Click <a href="submitproposal.jsp">here.</a></p> <p>For more information contact our Vendor Hotline at 1 888 233 4564.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="div-column col-right">
			<div class="div-title">Announcements for Vendors</div>
			<div class="content-block">
				<p>
					If you experience issues signing into the Portal or if the pages
					are not loading, please clear your browser cache & then sign in
					again. Instructions for clearing cache: <a href="#">Clear
						Browser History</a>
				</p>
				<p>Vendors can request a copy of the form by calling 1 800 Marco
					Health.</p>
				<p>
					<strong>Marco Health Vendor Help Desk:</strong> Contact Department
					of Administration regarding Log-on and Passwords issues and for
					questions regarding specific events (solicitations), bids,
					proposals or vendor registration
				</p>


				<p>
					<b>TRAINING ON SUPPLIER PORTAL</b> Twice a month Marco Healthcare
					offers training/presentation. During the training sessions vendors
					shall learn how to register and use the Supplier Portal. Vendors
					shall also learn on how to place bids, find Bid Tabulation results,
					and find Bid Events. Training sessions are generally held in Megan
					Conferance Hall in Packard Bldg. Interested vendors should contact
					Shawna Rhoads at 619 777 3425 to register for all trainings.
				</p>

				<div class="div-title">Events</div>
				<div class="content-block">
					<div class="link-item">
						<i class="fa fa-calendar" aria-hidden="true"></i> <a href="#"><span>2017-04-29
								09:00 AM</span>: Chemical Supplies Overview</a>
						<p>Some description for event 1</p>
					</div>
					<div class="link-item">
						<i class="fa fa-calendar" aria-hidden="true"></i> <a href="#"><span>2017-03-28
								01:00 PM</span>: Material Management</a>
						<p>Some description for event 2</p>
					</div>
					<div class="link-item">
						<i class="fa fa-calendar" aria-hidden="true"></i> <a href="#"><span>2017-05-22
								10:00 AM</span>: Laboratory Safety Training</a>
						<p>Some description for event 3</p>
					</div>
				</div>
				<div class="div-title">Solicitations</div>
				<div class="content-block">
					<p>
						<strong>NOTICE - This site is updated every 48 hours. Not
							all solicitations are provided.</strong>
					</p>
					<p>
						<a href="#"> Click here for a current listing of solicitation
							announcements.</a>
					</p>
				</div>
				<div class="div-title">Public Notice</div>
				<div class="content-block">
					<table class="table-info">
						<tr>
							<td><a href="#">Public Information Notice Results</a></td>
							<td>Closed Events-Events that are no longer open for bidding
								and are currently in the evaluation process.</td>
						</tr>
						<tr>
							<td><a href="#">Bid, Proposal or Grant Results</a></td>
							<td>Events that have completed the evaluation process. Note:
								This does not constitute the issuance of a Contract.</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div style="clear: both;"></div>
	<footer>
		<div>© ALL RIGHTS RESERVED</div>
	</footer>
</BODY>

</HTMl>