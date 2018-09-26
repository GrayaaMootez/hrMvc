package com.tez.hrMvc.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tez.hrMvc.model.MenuTree;
import com.tez.hrMvc.service.MenuTreeService;

@Component
public class MenuTreeConverter extends PropertyEditorSupport{

	@Autowired
	private  MenuTreeService service;

    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        MenuTree c = service.findById(Integer.parseInt(text));

        this.setValue(c);
    }

}