package com.tez.hrMvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import com.tez.hrMvc.model.Jobs;
import com.tez.hrMvc.service.DepartmentsService;
import com.tez.hrMvc.service.EmployeesService;
import com.tez.hrMvc.service.JobsService;
import com.tez.hrMvc.utils.DeparmtmentsConverter;
import com.tez.hrMvc.utils.EmployeesConverter;
import com.tez.hrMvc.utils.JobsConverter;

@Controller
@RequestMapping("employees")
public class EmployeesController {

	@Autowired
	EmployeesService service;
	@Autowired
	DepartmentsService dService;
	@Autowired
	JobsService jService;
	@Autowired
	EmployeesConverter employeesConverter;
	@Autowired
	DeparmtmentsConverter departmentsConverter;
	@Autowired
	JobsConverter jobsConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Employees.class, this.employeesConverter);
		binder.registerCustomEditor(Departments.class, this.departmentsConverter);
		binder.registerCustomEditor(Jobs.class, this.jobsConverter);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listEmp(Model model) {
		Employees emp = new Employees();

		model.addAttribute("emp", emp);
		model.addAttribute("listEmp", service.findAll());

		return "employees/list";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showEmp(@PathVariable("id") Integer id, Model model) {

		Employees emp = new Employees();
		emp = service.findById(id);

		if (emp == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("emp", emp);

		return "employees/show";

	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteEmp(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		service.delete(id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		return ("redirect:/employees");

	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateEmp(@PathVariable("id") Integer id, Model model) {
		Employees emp = service.findById(id);
		List<Employees> emps = service.findAll();
		List<Jobs> jobs = jService.allJobs();
		List<Departments> deps = dService.allDeps();
		model.addAttribute("listEmp", emps);
		model.addAttribute("listJos", jobs);
		model.addAttribute("listDeps", deps);
		model.addAttribute("empForm", emp);
		return ("employees/empForm");

	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		Employees emp = new Employees();
		List<Employees> emps = service.findAll();
		List<Jobs> jobs = jService.allJobs();
		List<Departments> deps = dService.allDeps();
		model.addAttribute("listEmp", emps);
		model.addAttribute("listJos", jobs);
		model.addAttribute("listDeps", deps);
		model.addAttribute("empForm", emp);

		return "employees/empForm";

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("empForm") Employees emp, BindingResult result, Model model,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "employees/empForm";
		} else {

			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			if (emp.isNew()) {
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			} else {
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}

			service.saveOrUpdate(emp);

			// POST/REDIRECT/GET
			return "redirect:/employees/" + emp.getEmployeeId();

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

}
