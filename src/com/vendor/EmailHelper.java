package com.vendor;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailHelper {
	static final String EMAIL_USERNAME = "marcohealth1@gmail.com";
	static final String EMAIL_NAME = "System Admin";
	static final String EMAIL_PASSWORD = "training6";
	static final String EMAIL_HOST = "smtp.gmail.com";
	static final String EMAIL_PORT = "587";

	public void SendEmail(String toEmail, String subject, String body) {
		// Recipient's email ID needs to be mentioned.
		String to = toEmail;// change accordingly

		// Sender's email ID needs to be mentioned
		String from = EMAIL_USERNAME;// change accordingly
		final String username = EMAIL_NAME;// change accordingly
		final String password = EMAIL_PASSWORD;// change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		String host = EMAIL_HOST;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", EMAIL_PORT);
		System.out.println("Mail Server Properties have been setup successfully..");

		try {
			System.out.println("\n\n 2nd ===> get Mail Session..");
			Session getMailSession = Session.getDefaultInstance(props, null);
			MimeMessage generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			// generateMailMessage.addRecipient(Message.RecipientType.CC, new
			// InternetAddress("test2@crunchify.com"));
			generateMailMessage.setSubject(subject);
			String emailBody = body;
			generateMailMessage.setContent(emailBody, "text/html");
			System.out.println("Mail Session has been created successfully..");

			// Step3
			System.out.println("\n\n 3rd ===> Get Session and Send mail");
			javax.mail.Transport transport = getMailSession.getTransport("smtp");

			// Enter your correct gmail UserID and Password
			// if you have 2FA enabled then provide App Specific Password
			transport.connect("smtp.gmail.com", EMAIL_USERNAME, EMAIL_PASSWORD);
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();
		} catch (Exception ex) {

		}
	}
}
