/**
 * 
 */
package com.kone.iotassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author matarumu
 *
 */

@Entity
@Table(name = "equipments")
public class Equipments {

	@Id
	@Column(name = "equipment_number")
	private Integer equipmentNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "contract_start_date")
	private String contractStartDate;

	@Column(name = "contract_end_date")
	private String contractEndDate;

	@Column(name = "status")
	private String status;

	/**
	 * @return the equipmentNumber
	 */
	public Integer getEquipmentNumber() {
		return equipmentNumber;
	}

	/**
	 * @param equipmentNumber
	 *            the equipmentNumber to set
	 */
	public void setEquipmentNumber(Integer equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the contractStartDate
	 */
	public String getContractStartDate() {
		return contractStartDate;
	}

	/**
	 * @param contractStartDate
	 *            the contractStartDate to set
	 */
	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	/**
	 * @return the contractEndDate
	 */
	public String getContractEndDate() {
		return contractEndDate;
	}

	/**
	 * @param contractEndDate
	 *            the contractEndDate to set
	 */
	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
