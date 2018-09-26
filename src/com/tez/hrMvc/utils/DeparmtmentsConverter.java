package com.tez.hrMvc.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tez.hrMvc.model.Departments;
import com.tez.hrMvc.service.DepartmentsService;

@Component
public class DeparmtmentsConverter extends PropertyEditorSupport {
	@Autowired
	private DepartmentsService service;

	// Converts a String to a Country (when submitting form)
	@Override
	public void setAsText(String text) {
		Departments c = service.findDep(Integer.parseInt(text));

		this.setValue(c);
	}

}
