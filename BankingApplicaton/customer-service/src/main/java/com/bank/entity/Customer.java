package com.bank.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull(message = "Customer profile is mandatory")
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerProfile customerProfile;

    @NotNull(message = "Customer contact is mandatory")
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerContact customerContact;

    @NotNull(message = "Customer address is mandatory")
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerAddress customerAddress;

    @NotNull(message = "Customer identities are mandatory")
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerIdentities customerIdentities;

    @NotNull(message = "Login credentials are mandatory")
    @OneToOne(cascade = CascadeType.ALL)
    private LoginCredentials loginCredentials;

}
