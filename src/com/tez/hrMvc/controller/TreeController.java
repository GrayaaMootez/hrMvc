package com.tez.hrMvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tez.hrMvc.model.MenuTree;
import com.tez.hrMvc.service.MenuTreeService;
import com.tez.hrMvc.utils.MenuTreeConverter;

@Controller
@RequestMapping("fragments")
public class TreeController {

	@Autowired
	private MenuTreeService service;

	@Autowired
	private MenuTreeConverter menuTreeConvterer;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(MenuTree.class, this.menuTreeConvterer);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listPersons(Model model) {

		List<MenuTree> root = new ArrayList<>();
		root = service.root();

		model.addAttribute("root", service.root());

		return "fragments/tree";
	}

}
