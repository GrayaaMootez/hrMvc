package com.tez.hrMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tez.hrMvc.model.Regions;
import com.tez.hrMvc.service.RegionService;
import com.tez.hrMvc.validator.RegionFormValidator;

@Controller
@RequestMapping("regions")
public class RegionController {

	@Autowired
	RegionService service;

	@Autowired
	RegionFormValidator regionFormValidator;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(regionFormValidator);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/regions";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("region", new Regions());
		model.addAttribute("listRegions", service.regions());
		return "regions/list";
	}

	// save or update user
	// 1. @ModelAttribute bind form value
	// 2. @Validated form validator
	// 3. RedirectAttributes for flash value
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("regionForm") Regions region, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			for (Object object : result.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fieldError = (FieldError) object;
				}
			}
			return "regions/regionForm";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (region.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			service.saveOrUpdate(region);

			// POST/REDIRECT/GET
			return "redirect:/regions/" + region.getRegionId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	// show add user form
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		Regions region = new Regions();
		model.addAttribute("regionForm", region);

		System.out.println(region.toString());

		return "regions/regionForm";

	}

	// show update form
	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") Integer id, Model model) {

		Regions region = service.findRegions(id);
		model.addAttribute("regionForm", region);

		return "regions/regionForm";

	}

	// delete user
	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {

		service.deleteRegion(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/regions";

	}

	// show user
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") Integer id, Model model) {

		Regions region = service.findRegions(id);
		if (region == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("region", region);

		return "regions/show";

	}

}
