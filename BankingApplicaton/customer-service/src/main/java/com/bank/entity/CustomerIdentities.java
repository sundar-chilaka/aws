package com.bank.entity;

import com.bank.validation.ValidAadhar;
import com.bank.validation.ValidPAN;
import com.bank.validation.ValidVoterID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerIdentities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Aadhar is mandatory")
	@ValidAadhar
	private String aadhar;

	@NotBlank(message = "PAN is mandatory")
	  @ValidPAN
	private String pan;

	@NotBlank(message = "Voter ID is mandatory")
    @ValidVoterID
	private String voterId;
}