package com.e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.entity.Customer;
import com.e_commerce.repository.CustomerRepository;

import jakarta.mail.MessagingException;

@Service
public class CustomerService {

	@Autowired private CustomerRepository customerRepository;
	@Autowired private SendMail sendMail;
	
	

	  public Customer saveCustomer(Customer customer) throws MessagingException {
	        // Save customer to the database
	        Customer savedCust = customerRepository.save(customer);
	        boolean validMail=sendMail.isEmailValid(savedCust.getEmail());
	        // Validate email before sending email
	        if (validMail) {
	        	sendMail.sendConfirmationEmail(savedCust);
	        } else {
	            throw new IllegalArgumentException("Invalid email address.");
	        }

	        return savedCust;
	    }
	  
}