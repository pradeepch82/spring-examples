package com.app.contacts.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.contacts.model.ContactPOJO;
import com.app.contacts.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactCRUDController {
	// D.I
	@Autowired
	@Qualifier("contact_service_dao")
	private ContactService service;

	@RequestMapping("/register")
	public String showRegForm(Model map) {
		// As compared to Struts 2 --
		// Action cls --- imple MDI --- getModel() --- rets empty model inst
		// In spring web mvc --- as there is no ValueStack --- prog MUST create
		// empty
		// model inst & store it as model attribute
		// req.setAttribute("contactPOJO",new ConatctPOJO());
		map.addAttribute(new ContactPOJO());
		System.out.println("in show reg form " + map);
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegForm(
			@Valid/* @ModelAttribute("contactPOJO") */ContactPOJO c,
			BindingResult results, Model map, HttpSession hs) {
		// @Valid ContactPOJO c --- Tells SC to apply conversion & validation
		// constraints
		// from supplied POJO type --- if any errors (P.L errs) -- stored under
		// BindingResult & populated POJO inst is available under --- c
		System.out.println("in process reg form " + c);
		System.out.println("in process reg form P.L results " + results);
		System.out.println("model attr map " + map);
		// chk for P.L errs
		if (results.hasErrors()) {
			System.out.println("P.L errs");
			return "register";
		}
		// no p.l errs
		System.out.println("No P.L errs");
		// invoke B.L using injected service ref.
		c = service.registerContact(c);
		System.out.println("contact reted from service layer " + c);
		// B. L errs
		if (c == null) {
			map.addAttribute("sts_mesg", "Reg Failed : Email alrdy exists");
			return "register";
		}
		// add validated(P.L & B.L) contact -- session scope
		hs.setAttribute("valid_contact", c);
	
		// chk role
		if (c.getRole().equals("admin")) {
			map.addAttribute("sts_mesg","Admin user Page:  Registered successfully");
			return "admin_ok";
		}
		map.addAttribute("sts_mesg", "Registered Contact successfully....");
		return "reg_ok";
	}

	@RequestMapping("/login")
	public String showLoginForm(Model map) {
		// As compared to Struts 2 --
		// Action cls --- imple MDI --- getModel() --- rets empty model inst
		// In spring web mvc --- as there is no ValueStack --- prog MUST create
		// empty
		// model inst & store it as model attribute
		// req.setAttribute("contactPOJO",new ConatctPOJO());
		map.addAttribute(new ContactPOJO());
		System.out.println("in show login form " + map);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLoginForm(
			@Valid/* @ModelAttribute("contactPOJO") */ContactPOJO c,
			BindingResult results, Model map, HttpSession hs) {
		// @Valid ContactPOJO c --- Tells SC to apply conversion & validation
		// constraints
		// from supplied POJO type --- if any errors (P.L errs) -- stored under
		// BindingResult & populated POJO inst is available under --- c
		System.out.println("in process login form " + c);
		System.out.println("in process login form P.L results " + results);
		System.out.println("model attr map " + map);
		// chk for P.L errs
		if (results.hasFieldErrors("email")
				|| results.hasFieldErrors("password")) {
			System.out.println("P.L errs in login");
			return "login";
		}
		// no p.l errs
		System.out.println("No P.L errs login");
		// invoke B.L using injected service ref.
		c = service.validateContact(c);
		System.out.println("contact reted from service layer " + c);
		// B. L errs
		if (c == null) {
			map.addAttribute("sts_mesg",
					"Login Failed : Invalid Password or email");
			return "login";
		}
		// add validated(P.L & B.L) contact -- session scope
		hs.setAttribute("valid_contact", c);
		// chk role
		if (c.getRole().equals("admin")) {
			map.addAttribute("sts_mesg","Admin user Page");
			return "admin_ok";
		}
		map.addAttribute("sts_mesg", "Validated Contact successfully....");
		return "reg_ok";
	}
	@RequestMapping("/view")
	public String showContacts(Model map) {
		
		map.addAttribute("contact_list",service.viewAllContacts());
		System.out.println("in show contacts " + map);
		return "view";
	}
	//show jsp page 
	@RequestMapping("/{dest}")
	public String showPage(@PathVariable("dest") String dest123) {
		
		
		System.out.println("in show page "+dest123 );
		return dest123;
	}
	
	


}
