package com.app.contacts.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("in hello constr");
	}

	@RequestMapping(value = { "/hello", "/hello1" })
	public String anyName(Model map) {
		
		map.addAttribute("some_name", new Date());
		System.out.println("in hello exec "+map);
		return "welcome";

	}

}
