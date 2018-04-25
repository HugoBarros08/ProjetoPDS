package br.imd.pds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.model.Equipment;
import br.imd.pds.service.ManagementEquipmentService;


@Controller
@RequestMapping(value = "equipments")
public class EquipmentController {

	
	@Autowired
	private ManagementEquipmentService managementEquipment;
	
	/**
	 * Return equipment with the given serial number
	 * @param serial
	 * @return
	 */
	@RequestMapping(value = "/{serial_number}", method = RequestMethod.GET)
	public String getEquipement(@PathVariable String serial) {
		return "equipments/view";
	}
	
	/**
	 * Returns a list of all equipments
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listEquipment(Model model) {
		model.addAttribute("equipments", managementEquipment.listEquipment());
		return "equipments/list";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String equipmentForm(Model model) {
		model.addAttribute("equipments", new Equipment());
		return "equipments/newEquipment";
	}
	
	/**
	 * Creates a equipment
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String newEquipment(@ModelAttribute Equipment equipment) {
		try {
			managementEquipment.insertEquipment(equipment, true);
		} catch (ExistentObjectException e) {
			e.printStackTrace();
		}
		return "equipments/list";
	}

}
