/**
 * 
 */
package com.kone.iotassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kone.iotassignment.entity.Equipments;
import com.kone.iotassignment.repository.EquipmentsRepository;

/**
 * @author matarumu
 *
 */

@Service
public class EquipmentsServiceImpl implements EquipmentsService {

	@Autowired
	EquipmentsRepository equipmentRepository;
	
	@Override
	public List<Equipments> insertEquipments(Equipments equipments) {
		
		equipmentRepository.save(equipments);
        return equipmentRepository.findAll();
	}

	@Override
	public Equipments getEquipmentById(Integer equipmentId) {
		
		return equipmentRepository.findOne(equipmentId);
	}

	@Override
	public Page<Equipments> searchEquipmentsByLimit(Integer limit) {
		
		Pageable limitPageable = new PageRequest(0, limit);
		return equipmentRepository.findAll(limitPageable);
	}

	@Override
	public boolean doesEquipmentExists(Integer equipmentId) {
		
		return equipmentRepository.exists(equipmentId);
	}

	@Override
	public void deleteEquipment(Integer equipmentId) {
		
		equipmentRepository.delete(equipmentId);
	}

}
