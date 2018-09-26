package com.tez.hrMvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tez.hrMvc.model.Regions;
import com.tez.hrMvc.service.RegionService;

@Component
public class RegionFormValidator implements Validator {

	@Autowired
	RegionService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Regions.class.equals(clazz);
	}

	@SuppressWarnings("unused")
	@Override
	public void validate(Object target, Errors errors) {

		Regions region = (Regions) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "regionId", "NotEmpty.regionForm.regionId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "regionName", "NotEmpty.regionForm.regionName");

	}

}
