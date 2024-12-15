package com.bank.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "First name is mandatory")
	private String firstName;

	@NotBlank(message = "Last name is mandatory")
	private String lastName;

	@NotNull(message = "Date of birth is mandatory")
	private LocalDate dob;

	private String occupation;
	private String maritalStatus;

	@DecimalMin(value = "0.0", inclusive = false, message = "Annual income must be positive")
	private Double annualIncome;
}