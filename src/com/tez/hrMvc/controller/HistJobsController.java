package com.tez.hrMvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tez.hrMvc.model.JobHistory;
import com.tez.hrMvc.service.HistJobsService;

@Controller
@RequestMapping("histJob")
public class HistJobsController {

	@Autowired
	private HistJobsService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAll(Model model) {
		List<JobHistory> jobs = service.findAll();
		model.addAttribute("histJobs", jobs);

		return "histJob/list";
	}

	@RequestMapping(value = "{id}/{dat}", method = RequestMethod.GET)
	public String showHist(@PathVariable("id") int emp, @PathVariable("dat") String dat, Model model) {
		try {
			String s = dat;
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
			Date date;
			date = formatter.parse(s);
			System.out.println("dattttttttte" + date);

			JobHistory hist = service.findById(emp, date);
			if (hist == null) {
				model.addAttribute("css", "danger");
				model.addAttribute("msg", "User not found");
			}
			model.addAttribute("hist", hist);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "histJob/show";
	}
}
