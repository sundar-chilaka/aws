package com.bank.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer employeeId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String role;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String contactNumber;

    @NotNull
    private String department;

    @NotNull
    private String assignedBranch;

}

