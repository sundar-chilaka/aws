package com.bank.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AadharValidator implements ConstraintValidator<ValidAadhar, String> {
    @Override
    public boolean isValid(String aadhar, ConstraintValidatorContext context) {
        return aadhar != null && aadhar.matches("\\d{12}");
    }
}
