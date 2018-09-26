package com.tez.hrMvc.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tez.hrMvc.model.Jobs;
import com.tez.hrMvc.service.JobsService;

@Component
public class JobsConverter extends PropertyEditorSupport {
	@Autowired
	private JobsService service;

	// Converts a String to a Country (when submitting form)
	@Override
	public void setAsText(String text) {
		Jobs c = service.findJob(text);

		this.setValue(c);
	}

}