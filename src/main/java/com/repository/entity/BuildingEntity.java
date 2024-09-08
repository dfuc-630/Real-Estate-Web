package com.repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "building") 
public class BuildingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ; 
	
	@Column(name = "name") 
	private String name; 	
	
	@Column(name = "ward")  
	private String ward; 
	
	@Column(name = "street")  
	private String street ;	
	
//	@Column(name = "districtid")  
//	private Integer districtid ;
	
	@Column(name = "managername")  
	private String managername;
	
	@Column(name = "managerphonenumber")  
	private String managerphonenumber;
	
	@Column(name = "floorarea") 
	private Integer floorarea ;	
	
//	@Column(name = "freearea")  
//	private Integer freearea;
	
	@Column(name = "rentprice")  
	private Integer rentprice ;
	
	@Column(name = "servicefee")  
	private Integer servicefee ;
	
	@Column(name = "brokeragefee")  
	private Integer brokeragefee ;
	
	@Column(name = "numberofbasement")  
	private Integer numberofbasement ;
	
	@Column(name = "direction")  
	private String direction;
	
	@Column(name = "level")  
	private String level;
	
//	@Column(name = "rentarea")  
//	private String rentarea ;

	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity district ; 
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreas = new ArrayList<>() ;
	
	
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public List<RentAreaEntity> getRentAreas() {
		return rentAreas;
	}
	public void setRentAreas(List<RentAreaEntity> rentAreas) {
		this.rentAreas = rentAreas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public Integer getDistrictid() {
//		return districtid;
//	}
//	public void setDistrictid(Integer districtid) {
//		this.districtid = districtid;
//	}
	public Integer getRentprice() {
		return rentprice;
	}
	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}
	public Integer getServicefee() {
		return servicefee;
	}
	public void setServicefee(Integer servicefee) {
		this.servicefee = servicefee;
	}
	public Integer getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(Integer brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
//	public String getRentarea() {
//		return rentarea;
//	}
//	public void setRentarea(String rentarea) {
//		this.rentarea = rentarea;
//	}
//	public Integer getFreearea() {
//		return freearea;
//	}
//	public void setFreearea(Integer freearea) {
//		this.freearea = freearea;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumberOfBasement() {
		return numberofbasement;
	}
	public void setNumberOfBasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}

}
