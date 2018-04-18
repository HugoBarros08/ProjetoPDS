package br.imd.pds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.imd.pds.helpers.ExistentObjectException;
import br.imd.pds.model.Sector;
import br.imd.pds.service.ManagementSectorService;

@Controller
@RequestMapping(value = "/sectors")

public class SectorController {
	
	@Autowired
	private ManagementSectorService managementSector;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getSector (@PathVariable Long id) {
		return "sectors/view";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listSector(Model model) {
		model.addAttribute("sectors", managementSector.listSector());
		return "sectors/list";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String sectorForm(Model model) {
		model.addAttribute("sectors", new Sector());
		return "sectors/newSetor";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String newSector(@ModelAttribute Sector sector) {
		try {
			managementSector.insertSector(sector);
		} catch (ExistentObjectException e) {
			e.printStackTrace();
		}
		return "sectors/list";
	}
	
	public ManagementSectorService getManagementSector() {
		return managementSector;
	}
	
	public void setManagementSector(ManagementSectorService managementSector) {
		this.managementSector = managementSector;
	}

}