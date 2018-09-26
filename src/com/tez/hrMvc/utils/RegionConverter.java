package com.tez.hrMvc.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tez.hrMvc.model.Regions;
import com.tez.hrMvc.service.RegionService;

@Component
public class RegionConverter extends PropertyEditorSupport{

	@Autowired
	private  RegionService service;

    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        Regions c = service.findRegions(Integer.parseInt(text));

        this.setValue(c);
    }

}
