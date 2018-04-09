package br.imd.pds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.model.User;
import br.imd.pds.service.ManagementUser;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private ManagementUser managementUser;
	
	/**
	 * Return user with the given id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable Long id) {
		return ("redirect:/list.html");
	}
	
	/**
	 * Returns a list of all users
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUser() {
		return ("redirect:/list.html");
	}
	
	/**
	 * Creates a user
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String newUser(User user) {
		try {
			user.setRegistration("08386670401");
			user.setName("Heytor");
			user.setEmail("hmesquita26@outlook.com");
			managementUser.insertUser(user);
		} catch (ExistentObjectException e) {
			e.printStackTrace();
		}
		return ("redirect:/list.html");
	}

	public ManagementUser getManagementUser() {
		return managementUser;
	}

	public void setManagementUser(ManagementUser managementUser) {
		this.managementUser = managementUser;
	}

	
}
