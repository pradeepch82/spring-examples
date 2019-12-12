package com.app.contacts.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.contacts.model.ContactPOJO;
import com.app.contacts.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactDeleteController {
	@Autowired
	@Qualifier("contact_service_dao")
	private ContactService service;
	@RequestMapping("/delete/{contactId}")
	public String logoutContact(@PathVariable int contactId)
	{
		System.out.println("in delete controller "+contactId);
		ContactPOJO c=service.unsubscribeContact(contactId);
		return "redirect:/contacts/view";
	
	}

}
