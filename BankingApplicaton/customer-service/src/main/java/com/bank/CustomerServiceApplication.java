package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		System.out.println("Test push...");
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
