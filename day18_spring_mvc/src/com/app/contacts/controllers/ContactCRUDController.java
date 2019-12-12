package com.app.contacts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.contacts.model.ContactPOJO;

@Controller
@RequestMapping("/contacts")
public class ContactCRUDController {
	//D.I
	@RequestMapping("/register")
	public String showRegForm(Model map)
	{
		//As compared to Struts 2 --
		//Action cls --- imple MDI --- getModel() --- rets empty model inst
		//In spring web mvc --- as there is no ValueStack --- prog MUST create empty
		//model inst & store it as model attribute
		map.addAttribute(new ContactPOJO());
		System.out.println("in show reg form "+map);
		return "register";
	}

}
