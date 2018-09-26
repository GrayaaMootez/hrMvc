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

import com.tez.hrMvc.model.Departments;
import com.tez.hrMvc.model.Employees;
import com.tez.hrMvc.model.Locations;
import com.tez.hrMvc.service.DepartmentsService;
import com.tez.hrMvc.service.EmployeesService;
import com.tez.hrMvc.service.LocationsService;
import com.tez.hrMvc.utils.EmployeesConverter;
import com.tez.hrMvc.utils.LocationsConverter;

@Controller
@RequestMapping("departments")
public class DepartmentsController {

	@Autowired
	DepartmentsService service;

	@Autowired
	EmployeesService eservice;

	@Autowired
	LocationsService lservice;

	@Autowired
	EmployeesConverter employeesConverter;
	@Autowired
	LocationsConverter locationConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Locations.class, this.locationConverter);
		binder.registerCustomEditor(Employees.class, this.employeesConverter);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("dep", new Departments());
		model.addAttribute("listDeps", service.allDeps());
		return "departments/list";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("depForm") Departments dep, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {

			return "departments/depForm";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (dep.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			service.saveOrUpdate(dep);

			// POST/REDIRECT/GET
			return "redirect:/departments/" + dep.getDepartmentId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		Departments dep = new Departments();
		List<Employees> empList = eservice.findAll();
		List<Locations> locList = lservice.findAll();

		model.addAttribute("depForm", dep);
		model.addAttribute("empList", empList);
		model.addAttribute("locList", locList);

		return "departments/depForm";

	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") Integer id, Model model) {
		Departments dep=new Departments();
		dep = service.findDep(id);
		List<Employees> empList = eservice.findAll();
		List<Locations> locList = lservice.findAll();

		model.addAttribute("depForm", dep);
		model.addAttribute("empList", empList);
		model.addAttribute("locList", locList);
		return "departments/depForm";

	}

	// delete user
	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {

		service.deleteDep(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/departments";

	}

	// show user
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") Integer id, Model model) {

		Departments dep = service.findDep(id);
		if (dep == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("dep", dep);

		return "departments/show";

	}

}
