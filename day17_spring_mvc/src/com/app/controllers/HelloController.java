package com.app.controllers;

import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("in hello constr");
	}

	@RequestMapping("/hello")
	public String welcomeUser() {
		System.out.println("in exec of welcome user");
		return "welcome";
	}

	@RequestMapping("/hello1")
	public ModelAndView welcomeUser1() {
		System.out.println("in exec of welcome user 1");
		// ModelAndView --- convenience class meant for packing --- logical view
		// name
		// & results to be pushed (sent) to the view layer.
		// ModelAndView(String viewName,String modelAttrName,Object atrValue)
		return new ModelAndView("welcome", "server_date", new Date());
	}

	@RequestMapping("/hello2")
	public String welcomeUser2(Model map) {
		System.out.println("in exec of welcome user 2 model =" + map);
		// Model --- i/f --- Map<S,O> --- refers to int imple. class.
		// Model --- map of model attrs --- will be taken by D.S --- & added
		// into
		// req scope.
		// Method of Model ---
		// void addAttribute(String attrName,Object val)
		map.addAttribute("server_date", new Date());
		map.addAttribute("name_list", Arrays.asList("abc", "1234", "xyz"));
		//map.addAttribute("date",new Date());
		map.addAttribute(new Date());
		System.out.println("end of  welcome user 2 model =" + map);
		return "welcome";
	}
	@RequestMapping("/hello3")
	public @ResponseBody String welcomeUser3()
	{
		return "<h3>Response generated directly by Controller</h>";
	}
	
	
	

}
