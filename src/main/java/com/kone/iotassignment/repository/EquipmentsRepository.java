/**
 * 
 */
package com.kone.iotassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kone.iotassignment.entity.Equipments;

/**
 * @author matarumu
 *
 */
public interface EquipmentsRepository extends JpaRepository<Equipments, Integer> {
	
}
