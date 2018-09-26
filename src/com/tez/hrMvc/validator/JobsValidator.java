package com.tez.hrMvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.tez.hrMvc.model.Jobs;
import com.tez.hrMvc.service.JobsService;

@Component
public class JobsValidator implements Validator {

	@Autowired
	JobsService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Jobs.class.equals(clazz);
	}

	@SuppressWarnings("unused")
	@Override
	public void validate(Object target, Errors errors) {

		Jobs job = (Jobs) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maxSalary", "NotEmpty.countries.countryId");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "minSalary", "NotEmpty.countries.countryId");

		if (job.getMinSalary() > job.getMaxSalary()) {
			errors.rejectValue("minSalary", "Wrong.salaire");
		}
	}

}
