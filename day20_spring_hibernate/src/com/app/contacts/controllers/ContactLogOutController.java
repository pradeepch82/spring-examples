package com.app.contacts.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactLogOutController {
	@RequestMapping("/logout")
	public String logoutContact(Model map,HttpSession hs)
	{
		//store contact under req scope
		//req.setAttribute("contactPOJO",hs.getAttribute("valid_contact"));
		System.out.println("in logout controller");
		map.addAttribute(hs.getAttribute("valid_contact"));
		//invalidate 
		hs.invalidate();
		return "logout";
	}

}
