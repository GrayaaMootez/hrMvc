package com.tez.hrMvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tez.hrMvc.model.Countries;

@Component
public class CountriesValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Countries.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Countries c = (Countries) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryId", "NotEmpty.countries.countryId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryName", "NotEmpty.countries.countryName");

		if (c.getCountryId().length()>2) {
			errors.rejectValue("countryId", "Lenght.countries");
		}

	}
}
