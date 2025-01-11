package com.e_commerce.service;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.e_commerce.entity.Customer;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendMail {
	
	@Autowired private JavaMailSender mailSender;
	
	// This regex pattern checks if the email is in a valid format
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	
    // OTP Length
    private static final int OTP_LENGTH = 6;
	
	public void sendConfirmationEmail(Customer customer) throws MessagingException {
		String subject ="Customer Details Saved Successfully!";
		
		String htmlContent= "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Customer Details Saved</title>\r\n"
				+ "    <style>\r\n"
				+ "        /* General styles for email body */\r\n"
				+ "        body {\r\n"
				+ "            font-family: Arial, sans-serif;\r\n"
				+ "            margin: 0;\r\n"
				+ "            padding: 0;\r\n"
				+ "            background-color: #f4f4f4;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        table {\r\n"
				+ "            width: 100%;\r\n"
				+ "            max-width: 600px;\r\n"
				+ "            margin: 20px auto;\r\n"
				+ "            border-collapse: collapse;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        td {\r\n"
				+ "            padding: 10px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        h2 {\r\n"
				+ "            color: #333;\r\n"
				+ "            font-size: 24px;\r\n"
				+ "            margin-bottom: 10px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        p {\r\n"
				+ "            font-size: 16px;\r\n"
				+ "            color: #555;\r\n"
				+ "            line-height: 1.5;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Button styles */\r\n"
				+ "        .button {\r\n"
				+ "            display: inline-block;\r\n"
				+ "            padding: 12px 30px;\r\n"
				+ "            margin-top: 20px;\r\n"
				+ "            background-color: #007bff;\r\n"
				+ "            color: white;\r\n"
				+ "            text-decoration: none;\r\n"
				+ "            font-weight: bold;\r\n"
				+ "            border-radius: 5px;\r\n"
				+ "            text-align: center;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .button:hover {\r\n"
				+ "            background-color: #0056b3;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        /* Footer styles */\r\n"
				+ "        .footer {\r\n"
				+ "            text-align: center;\r\n"
				+ "            font-size: 14px;\r\n"
				+ "            color: #999;\r\n"
				+ "            margin-top: 30px;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "    <table>\r\n"
				+ "        <tr>\r\n"
				+ "            <td style=\"background-color: #ffffff; border-radius: 5px; padding: 30px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\">\r\n"
				+ "                <h2>Hello&nbsp;&nbsp;"+customer.getName()+",</h2>\r\n"
				+ "                <p>We're excited to let you know that your details have been saved successfully! We value your business and are committed to providing you with the best experience.</p>\r\n"
				+ "                \r\n"
				+ "                <p>Here's a summary of your account:</p>\r\n"
				+ "                <ul>\r\n"
				+ "                    <li><strong>Name:&nbsp;</strong>"+customer.getName()+"</li>\r\n"
				+ "                    <li><strong>Email:&nbsp;</strong>"+customer.getEmail()+"</li>\r\n"
				+ "                    <li><strong>Address:&nbsp;</strong>"+customer.getAddress()+"</li>\r\n"
				+ "                </ul>\r\n"
				+ "                \r\n"
				+ "                <a href=\"https://www.yourwebsite.com/dashboard\" class=\"button\">View Your Dashboard</a>\r\n"
				+ "\r\n"
				+ "                <div class=\"footer\">\r\n"
				+ "                    <p>Thank you for being a valued customer.</p>\r\n"
				+ "                    <p>If you have any questions or need assistance, feel free to <a href=\"mailto:support@yourwebsite.com\">contact us</a>.</p>\r\n"
				+ "                    <p>&copy; 2025 Your Company. All rights reserved.</p>\r\n"
				+ "                </div>\r\n"
				+ "            </td>\r\n"
				+ "        </tr>\r\n"
				+ "    </table>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "";
		
		MimeMessage message= mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		helper.setTo(customer.getEmail());
        helper.setSubject(subject);
        helper.setText(htmlContent, true);
        helper.setFrom("sundar3.ch@gmail.com");
        
        mailSender.send(message);
		
	}
	public void sendOTPEmail(Customer customer, String otp) throws MessagingException {
        String subject = "Your OTP for Validation";

        String htmlContent = "<!DOCTYPE html>\r\n"
                + "<html lang=\"en\">\r\n"
                + "<head>\r\n"
                + "    <meta charset=\"UTF-8\">\r\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                + "    <title>OTP Validation</title>\r\n"
                + "    <style>\r\n"
                + "        body {\r\n"
                + "            font-family: Arial, sans-serif;\r\n"
                + "            margin: 0;\r\n"
                + "            padding: 0;\r\n"
                + "            background-color: #f4f4f4;\r\n"
                + "        }\r\n"
                + "        table {\r\n"
                + "            width: 100%;\r\n"
                + "            max-width: 600px;\r\n"
                + "            margin: 20px auto;\r\n"
                + "            border-collapse: collapse;\r\n"
                + "        }\r\n"
                + "        td {\r\n"
                + "            padding: 10px;\r\n"
                + "        }\r\n"
                + "        h2 {\r\n"
                + "            color: #333;\r\n"
                + "            font-size: 24px;\r\n"
                + "            margin-bottom: 10px;\r\n"
                + "        }\r\n"
                + "        p {\r\n"
                + "            font-size: 16px;\r\n"
                + "            color: #555;\r\n"
                + "            line-height: 1.5;\r\n"
                + "        }\r\n"
                + "        .otp {\r\n"
                + "            font-size: 32px;\r\n"
                + "            font-weight: bold;\r\n"
                + "            color: #007bff;\r\n"
                + "            padding: 20px;\r\n"
                + "            text-align: center;\r\n"
                + "        }\r\n"
                + "        .footer {\r\n"
                + "            text-align: center;\r\n"
                + "            font-size: 14px;\r\n"
                + "            color: #999;\r\n"
                + "            margin-top: 30px;\r\n"
                + "        }\r\n"
                + "    </style>\r\n"
                + "</head>\r\n"
                + "<body>\r\n"
                + "    <table>\r\n"
                + "        <tr>\r\n"
                + "            <td style=\"background-color: #ffffff; border-radius: 5px; padding: 30px; box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\">\r\n"
                + "                <h2>Hello " + customer.getName() + ",</h2>\r\n"
                + "                <p>We have received your request. Please use the following OTP to validate your mobile number:</p>\r\n"
                + "                <div class=\"otp\">" + otp + "</div>\r\n"
                + "                <p>If you did not request this, please ignore this email.</p>\r\n"
                + "                <div class=\"footer\">\r\n"
                + "                    <p>Thank you for being a valued customer.</p>\r\n"
                + "                    <p>If you have any questions or need assistance, feel free to <a href=\"mailto:support@yourwebsite.com\">contact us</a>.</p>\r\n"
                + "                    <p>&copy; 2025 Your Company. All rights reserved.</p>\r\n"
                + "                </div>\r\n"
                + "            </td>\r\n"
                + "        </tr>\r\n"
                + "    </table>\r\n"
                + "</body>\r\n"
                + "</html>\r\n";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(customer.getEmail());
        helper.setSubject(subject);
        helper.setText(htmlContent, true);
        helper.setFrom("sundar3.ch@gmail.com");

        mailSender.send(message);
    }
	 // Generate OTP (6 digits)
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // Generates a 6-digit OTP
        return String.valueOf(otp);
    }
	  // Method to validate email address using regex
    boolean isEmailValid(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
