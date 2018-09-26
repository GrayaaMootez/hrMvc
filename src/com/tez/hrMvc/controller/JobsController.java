package com.tez.hrMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tez.hrMvc.model.Jobs;
import com.tez.hrMvc.service.JobsService;
import com.tez.hrMvc.validator.JobsValidator;

@Controller
@RequestMapping("jobs")
public class JobsController {

	@Autowired
	JobsService service;
	@Autowired
	JobsValidator valid;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(valid);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("job", new Jobs());
		model.addAttribute("listJobs", service.allJobs());
		return "jobs/list";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("jobForm") @Validated Jobs job, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + job.isNew());
			return "jobs/jobForm";
		} else {

			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + job.isNew());

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (job.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			service.saveOrUpdate(job);

			// POST/REDIRECT/GET
			return "redirect:/jobs/" + job.getJobId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		Jobs job = new Jobs();
		model.addAttribute("jobForm", job);

		return "jobs/jobForm";

	}

	// show update form
	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") String id, Model model) {

		Jobs job = service.findJob(id);
		model.addAttribute("jobForm", job);

		return "jobs/jobForm";

	}

	// delete user
	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

		service.deleteJob(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/jobs";

	}

	// show user
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") String id, Model model) {

		Jobs job = service.findJob(id);
		if (job == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("job", job);

		return "jobs/show";

	}

}
