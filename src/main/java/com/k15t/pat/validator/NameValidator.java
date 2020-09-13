package com.k15t.pat.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

	@Override
	public void initialize(ValidName constraintAnnotation) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return (validateName(name));
	}

	private boolean validateName(String name) {
		try {
			Double.parseDouble(name);
		} catch (NumberFormatException nfe) {
			return true;
		}
		return false;
	}
}
