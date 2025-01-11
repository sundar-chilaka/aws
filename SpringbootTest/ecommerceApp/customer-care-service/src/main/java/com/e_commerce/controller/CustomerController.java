package com.e_commerce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.entity.Customer;
import com.e_commerce.service.CustomerService;
import com.e_commerce.service.SendMail;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	   @Autowired
	    private SendMail sendMail;

	@PostMapping("/save")
	public ResponseEntity<Map<String, Object>> saveCustomer(@RequestBody Customer customer) {
		Map<String, Object> response = new HashMap<>();

		try {
			// Save customer via service
			Customer savedCustomer = customerService.saveCustomer(customer);

			// If customer is saved successfully, respond with HTTP 201 (Created)
			response.put("message", "Customer saved successfully");
			response.put("customer", savedCustomer);
			return new ResponseEntity<>(response, HttpStatus.CREATED);

		} catch (IllegalArgumentException e) {
			// Handle invalid email format case
			response.put("error", "Invalid email address.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			// Handle any other exceptions
			response.put("error", "Error saving customer.");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	 @PostMapping("/send-otp")
//	    public String sendOtp(@RequestBody Customer customer) {
//	        
//	        // Generate OTP
//	        String otp = sendMail.generateOTP();
//
//	        // Send OTP to the customer via email
//	        try {
//	            sendMail.sendOTPEmail(customer, otp);
//	            return "OTP has been sent to your email!";
//	        } catch (Exception e) {
//	            return "Failed to send OTP: " + e.getMessage();
//	        }
//	    }
}
