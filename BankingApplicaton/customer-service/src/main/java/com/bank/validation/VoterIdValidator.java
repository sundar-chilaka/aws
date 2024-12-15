package com.bank.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VoterIdValidator implements ConstraintValidator<ValidVoterID, String>{
	@Override
    public boolean isValid(String voterId, ConstraintValidatorContext context) {
        return voterId != null && voterId.matches("[A-Z]{3}[0-9]{7}");
    }
}
