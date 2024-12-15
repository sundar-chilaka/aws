package com.bank.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PanValidator implements ConstraintValidator<ValidPAN, String> {
    @Override
    public boolean isValid(String pan, ConstraintValidatorContext context) {
        return pan != null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    }
}
