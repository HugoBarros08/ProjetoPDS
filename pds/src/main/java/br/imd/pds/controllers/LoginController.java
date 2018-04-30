package br.imd.pds.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView welcomePageAdmin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePageAdmin");
		return model;
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView welcomePageUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePageUser");
		return model;
	}
	
	@RequestMapping(value = {"/homePageAdmin"}, method = RequestMethod.GET)
	public ModelAndView homePageAdmin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePageAdmin");
		return model;
	}
	
	@RequestMapping(value = {"/homePageUser"}, method = RequestMethod.GET)
	public ModelAndView homePageUser() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePageUser");
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from SNMP successfully.");
		}
		model.setViewName("login");
		return model;
	}
}
