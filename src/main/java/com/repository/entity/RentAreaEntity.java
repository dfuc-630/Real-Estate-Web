package com.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentarea") 
public class RentAreaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id  ;
	
	@Column(name = "value") 
	private String value ; 
	
//	@Column(name = "buildingid") 
//	private Integer buildingid ;
	
	@ManyToOne
	@JoinColumn(name = "buildingid")
	private BuildingEntity building ; 
	
	public BuildingEntity getBuilding() {
		return building;
	}
	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
//	public Integer getBuildingid() {
//		return buildingid;
//	}
//	public void setBuildingid(Integer buildingid) {
//		this.buildingid = buildingid;
//	} 
}