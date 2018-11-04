/**
 * 
 */
package com.kone.iotassignment.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.kone.iotassignment.entity.Equipments;

/**
 * @author matarumu
 *
 */
public interface EquipmentsService {

	public List<Equipments> insertEquipments(Equipments equipments);
	
	public Equipments getEquipmentById(Integer equipmentId);
	
	public Page<Equipments> searchEquipmentsByLimit(Integer limit);
	
	public boolean doesEquipmentExists(Integer equipmentId);
	
	public void deleteEquipment(Integer equipmentId);
}
