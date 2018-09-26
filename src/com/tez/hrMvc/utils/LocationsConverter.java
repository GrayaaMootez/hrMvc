package com.tez.hrMvc.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tez.hrMvc.model.Locations;
import com.tez.hrMvc.service.LocationsService;

@Component
public class LocationsConverter extends PropertyEditorSupport{

	@Autowired
	private  LocationsService service;

    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        Locations c = service.findById(Integer.parseInt(text));

        this.setValue(c);
    }

}
