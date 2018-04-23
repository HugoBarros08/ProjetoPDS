package br.imd.pds.controllers;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.helpers.InexistentObjectException;
import br.imd.pds.model.User;
import br.imd.pds.service.ManagementUserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private ManagementUserService managementUser;
	
	/**
	 * Exemplo populando o banco de dados em memória.
	 */
	@PostConstruct
	public void init() throws ExistentObjectException {
		managementUser.insertUser(new User("123123", "Joao", "joao@gmail.com"));
		managementUser.insertUser(new User("456789", "Maria", "maria@gmail.com"));
		managementUser.insertUser(new User("998877", "Ricardo", "ricardo@gmail.com"));
		
		try {
			managementUser.deleteUser(managementUser.searchUser("998877"));			
		} catch(InexistentObjectException e) {
			
		}
	}
	
	/**
	 * Return user with the given id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable Long id) {
		return "users/view";
	}
	
	/**
	 * Returns a list of all users
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listUser(Model model) {
		model.addAttribute("users", managementUser.listUser());
		return "users/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String userForm(Model model) {
		model.addAttribute("users", new User());
		return "users/newUser";
	}
	
	/**
	 * Creates a user
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String newUser(@Valid @ModelAttribute User user, BindingResult results) {
		
		if (results.hasErrors()) {
			
		}
		
		try {
			managementUser.insertUser(user);
		} catch (ExistentObjectException e) {
			e.printStackTrace();
		}
		return "users/list";
	}
	


	public ManagementUserService getManagementUser() {
		return managementUser;
	}

	public void setManagementUser(ManagementUserService managementUser) {
		this.managementUser = managementUser;
	}
	
}
