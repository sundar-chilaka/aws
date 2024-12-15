package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginCredentials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Customer ID is mandatory")
	private Long customerId;

	@NotBlank(message = "Username is mandatory")
	private String username;

	@NotBlank(message = "Password is mandatory")
	private String password;

	@NotBlank(message = "Transaction password is mandatory")
	private String transactionPassword;

	@Min(value = 0, message = "Login attempts must be 0 or greater")
	private int loginAttempts;

	@NotNull(message = "Is locked status is mandatory")
	private Boolean isLocked;

}
