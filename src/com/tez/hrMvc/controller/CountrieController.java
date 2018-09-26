package com.tez.hrMvc.controller;

import java.util.List;

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

import com.tez.hrMvc.model.Countries;
import com.tez.hrMvc.model.Regions;
import com.tez.hrMvc.service.CountriesService;
import com.tez.hrMvc.service.RegionService;
import com.tez.hrMvc.utils.RegionConverter;
import com.tez.hrMvc.validator.CountriesValidator;

@Controller
@RequestMapping("countries")
public class CountrieController {

	@Autowired
	CountriesService service;

	@Autowired
	RegionService rService;

	@Autowired
	private RegionConverter regionConverter;

	@Autowired
	private CountriesValidator countriesValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Regions.class, this.regionConverter);
		binder.setValidator(countriesValidator);
	}
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * index(Model model) { return "redirect:/countries"; }
	 */

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("countries", new Countries());
		model.addAttribute("listCountries", service.allCountrie());
		return "countries/list";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("countrieForm") @Validated Countries countrie, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "countries/countrForm";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (countrie.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			service.saveOrUpdate(countrie);

			// POST/REDIRECT/GET
			return "redirect:/countries/" + countrie.getCountryId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	@ModelAttribute("contactTypeSelect")
	public List<Regions> regionList() {
	    return rService.regions();
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		List<Regions> regions = rService.regions();
		Countries countrie = new Countries();
		model.addAttribute("countrieForm", countrie);
		model.addAttribute("regionName", regions);

		return "countries/countrForm";

	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") String id, Model model) {

		Countries countrie = service.findCountrie(id);

		List<Regions> regions = rService.regions();

		model.addAttribute("countrieForm", countrie);
		model.addAttribute("regionName", regions);

		return "countries/countrForm";

	}

	// delete user
	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") String id, final RedirectAttributes redirectAttributes) {

		service.deleteCountrie(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/countries";

	}

	// show user
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") String id, Model model) {

		Countries countrie = service.findCountrie(id);
		if (countrie == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("countrie", countrie);

		return "countries/show";

	}

}
