package com.app.contacts.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.contacts.model.Address;
import com.app.contacts.model.ContactPOJO;
import com.app.contacts.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactAddressController {
	// D.I
	@Autowired
	@Qualifier("contact_service_dao")
	private ContactService service;

	// show adr update form
	@RequestMapping("/update_addr")
	public String showUpdateAddrForm(Model map, HttpSession hs) {
		System.out.println("show update form");
		ContactPOJO ref = (ContactPOJO) hs.getAttribute("valid_contact");
		map.addAttribute(ref.getAddr()==null?new Address():ref.getAddr());
		return "update_addr";
	}

	// process update form
	@RequestMapping(value = "/update_addr", method = RequestMethod.POST)
	public String processUpdateAddrForm(@Valid Address a,
			BindingResult results, HttpSession hs, Model map) {
//		System.out.println("process update form " + a);
		if (results.hasErrors()) {
			System.out.println("pl errs adr");
			return "update_addr";
		}
	//	System.out.println("no pl errs");
		ContactPOJO ref = (ContactPOJO) hs.getAttribute("valid_contact");
//		System.out.println(ref);
		if (ref.getAddr() != null)
			a.setAddressId(ref.getAddr().getAddressId());
		ref.setAddr(a);
		service.updateAddress(ref);
		return "reg_ok";

	}

}
