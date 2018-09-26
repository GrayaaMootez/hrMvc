package com.tez.hrMvc.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tez.hrMvc.model.Employees;
import com.tez.hrMvc.service.EmployeesService;

@Component
public class EmployeesConverter extends PropertyEditorSupport{

	@Autowired
	EmployeesService service;


    // Converts a String to a Country (when submitting form)
    @Override
    public void setAsText(String text) {
        Employees c = service.findById(Integer.parseInt(text));

        this.setValue(c);
    }

}

