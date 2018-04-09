package br.imd.pds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.imd.pds.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository uRespository;
	
	@RequestMapping(value = "/addNewUser.html", method = RequestMethod.POST);
	public String newUser(UserRepository user) {
		
		UserRepository.save(user);
		return ("redirect:/list.html");
	}
	
	
}
