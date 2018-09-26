package com.tez.hrMvc.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tez.hrMvc.model.Countries;
import com.tez.hrMvc.service.CountriesService;

@Component
public class CountriesConverter extends PropertyEditorSupport {
	@Autowired
	private CountriesService service;

	// Converts a String to a Country (when submitting form)
	@Override
	public void setAsText(String text) {
		Countries c = service.findCountrie(text);

		this.setValue(c);
	}

}