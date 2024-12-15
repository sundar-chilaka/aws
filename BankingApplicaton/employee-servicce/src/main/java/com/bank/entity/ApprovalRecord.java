package com.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class ApprovalRecord {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Digits(integer = 6, fraction = 0)
    private Integer approvalId;

    @NotNull
    @Digits(integer = 8, fraction = 0)
    private Long approverId;

    private String approvalDate;

    @NotNull
    private String entityType; // Consider using an enum for this

    @NotNull
    private Long entityId;

    private String status;
}
