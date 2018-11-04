/**
 * 
 */
package com.kone.iotassignment.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kone.iotassignment.entity.Equipments;
import com.kone.iotassignment.service.EquipmentsService;

/**
 * @author matarumu
 *
 */

@Controller
@RequestMapping(value = "/equipmentsService")
public class EquipmentsController {

	@Autowired
	EquipmentsService equipmentsService;

	@GetMapping(value = "/")
	public String viewIndex() {
		return "index";
	}

	@GetMapping(value = "/createEquipment")
	public String viewcreateEquipment() {
		return "createEquipment";
	}

	@GetMapping(value = "/searchEquipmentById")
	public String viewgetEquipmentById() {
		return "getEquipmentById";
	}

	@GetMapping(value = "/searchEquipmentByLimit")
	public String viewgetEquipmentByLimit() {
		return "getEquipmentByLimit";
	}

	@GetMapping(value = "/deleteEquipmentById")
	public String viewdeleteEquipmentById() {
		return "deleteEquipmentById";
	}

	@PostMapping(value = "/equipment")
	public String saveEquipments(@ModelAttribute(name = "equipment") Equipments equipment, Model model) {

		try {
			List<Equipments> equipmentList = new ArrayList<Equipments>();
			if (!equipmentsService.doesEquipmentExists(equipment.getEquipmentNumber())) {

				equipmentList = equipmentsService.insertEquipments(equipment);
				model.addAttribute("equipmentList", equipmentList);
				return "equipmentsCreated";
			} else {
				model.addAttribute("message",
						"Equipment with equipment number " + equipment.getEquipmentNumber() + " already exists!");
				return "messageReturned";
			}

		} catch (Exception e) {
			model.addAttribute("message", "Error occured when saving the equipment number "
					+ equipment.getEquipmentNumber() + " Please try again!");
			return "messageReturned";
		}
	}

	@GetMapping(value = "/equipment/equipmentNumber")
	public String getEquipmentsByNumber(@RequestParam("equipmentNumber") Integer equipmentNumber, Model model) {

		try {
			List<Equipments> equipmentList = new ArrayList<Equipments>();
			Equipments equipmentReturned = equipmentsService.getEquipmentById(equipmentNumber);
			equipmentList.add(equipmentReturned);
			model.addAttribute("equipmentList", equipmentList);

			if (equipmentReturned == null) {
				model.addAttribute("message",
						"Equipment with equipment number " + equipmentNumber + " does not exist!");
				return "messageReturned";

			} else {
				return "equipmentReturned";
			}

		} catch (Exception e) {
			model.addAttribute("message", "Error occured when searching equipment with equipment number "
					+ equipmentNumber + " Please try again!");
			return "messageReturned";
		}
	}

	@GetMapping(value = "/equipment/search")
	public String searchEquipmentsByLimit(@RequestParam("limit") Integer limit, Model model) {

		try {
			List<Equipments> equipmentList = new ArrayList<Equipments>();
			Page<Equipments> page = equipmentsService.searchEquipmentsByLimit(limit);

			if (page.getContent() != null) {
				equipmentList = page.getContent();
				model.addAttribute("equipmentList", equipmentList);

				return "equipmentReturned";
			} else {
				model.addAttribute("message", "No equipment available in database!");
				return "messageReturned";
			}
		} catch (Exception e) {
			model.addAttribute("message", "Error occured when searching equipment with limit. Please try again!");
			return "messageReturned";
		}
	}

	@GetMapping(value = "/equipment/delete")
	public String deleteEquipment(@RequestParam("equipmentNumber") Integer equipmentNumber, Model model) {

		try {
			if (equipmentsService.doesEquipmentExists(equipmentNumber)) {
				equipmentsService.deleteEquipment(equipmentNumber);
				model.addAttribute("message",
						"Equipment with equipment number " + equipmentNumber + " deleted successfully!");
				return "messageReturned";
			} else {
				model.addAttribute("message",
						"Equipment with equipment number " + equipmentNumber + " does not exist!");
				return "messageReturned";
			}

		} catch (Exception e) {
			model.addAttribute("message", "Error occured when deleting equipment with equipment number "
					+ equipmentNumber + " Please try again!");
			return "messageReturned";
		}
	}
}
