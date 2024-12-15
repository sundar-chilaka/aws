package com.bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Customer;
import com.bank.entity.CustomerProfile;
import com.bank.error.CustomException;
import com.bank.repository.CustomerRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public Customer createCustomer(@Valid Customer customer) {
		return customerRepository.save(customer);
	}
//	@Transactional(readOnly = true)
	@Transactional
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

//	@Transactional
//	public Customer updateCustomer(Long customerId, @Valid Customer customerDetails) {
//	    Customer existingCustomer = customerRepository.findById(customerId)
//	            .orElseThrow(() -> new CustomException("Customer not found with ID: " + customerId));
//
//	    // Update CustomerProfile if it exists
//	    if (customerDetails.getCustomerProfile() != null) {
//	        updateCustomerProfile(existingCustomer.getCustomerProfile(), customerDetails.getCustomerProfile());
//	    }
//
//	    // Save and return the updated customer
//	    return customerRepository.save(existingCustomer);
//	}
//
//	private void updateCustomerProfile(CustomerProfile existingProfile, CustomerProfile newProfile) {
//	    if (newProfile.getFirstName() != null) {
//	        existingProfile.setFirstName(newProfile.getFirstName());
//	    }
//	    if (newProfile.getLastName() != null) {
//	        existingProfile.setLastName(newProfile.getLastName());
//	    }
//	    if (newProfile.getEmail() != null) {
//	        existingProfile.setEmail(newProfile.getEmail());
//	    }
//	    // Update other fields as necessary
//	    // Example for additional fields
//	    // if (newProfile.getPhoneNumber() != null) {
//	    //     existingProfile.setPhoneNumber(newProfile.getPhoneNumber());
//	    // }
//	}



    @Transactional
    public void deleteCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomException("Customer not found with ID: " + customerId);
        }
        customerRepository.deleteById(customerId);
    }

}
