package com.tez.hrMvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tez.hrMvc.model.Countries;
import com.tez.hrMvc.model.Locations;
import com.tez.hrMvc.service.CountriesService;
import com.tez.hrMvc.service.LocationsService;
import com.tez.hrMvc.utils.CountriesConverter;

@Controller
@RequestMapping("locations")
public class LocationController {

	@Autowired
	LocationsService service;

	@Autowired
	CountriesService cService;

	@Autowired
	CountriesConverter countriesConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Countries.class, this.countriesConverter);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ListLocation(Model model) {
		model.addAttribute("location", new Locations());
		model.addAttribute("ListLocation", service.findAll());
		return "locations/list";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveOrUpdate(Model model, @ModelAttribute("locationForm") Locations location, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "location/locationForm";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (location.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}
		}
		service.saveOrUpdate(location);

		return "redirect:locations/" + location.getLocationId();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addLocation(Model model) {
		Locations location = new Locations();
		List<Countries> countries = cService.allCountrie();
		model.addAttribute("locationForm", location);
		model.addAttribute("listCountries", countries);

		return "locations/locationForm";

	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	public String deleteLocation(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {

		service.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/locations";

	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String String(@PathVariable("id") Integer id, Model model) {
		Locations location = new Locations();
		location = service.findById(id);
		List<Countries> countries = cService.allCountrie();
		model.addAttribute("locationForm", location);
		model.addAttribute("listCountries", countries);

		return "locations/locationForm";
	}

	// show user
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") Integer id, Model model) {

		Locations location = service.findById(id);
		if (location == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("location", location);

		return "locations/show";

	}

}
