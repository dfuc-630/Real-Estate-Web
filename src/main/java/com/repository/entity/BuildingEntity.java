package com.repository.entity;

public class BuildingEntity {
	private String name; 
	private Integer floorarea ;
	private String district ; 
	private String ward; 
	private String street ;
	private int NumberOfBasement ;
	private String direction;
	private String level;
	private Integer rentprice ; 
	private Integer servicefee ; 
	private Integer brokeragefee ; 
	private String managername;
	private String managerphonenumber;
	private Integer rentarea ;
	private Integer freearea;
	private String staff ; 
	private Integer area ; 
	private String buildingtype ; 
	public  String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getBuildingtype() {
		return buildingtype;
	}
	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}
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
	public Integer getRentarea() {
		return rentarea;
	}
	public void setRentarea(Integer rentarea) {
		this.rentarea = rentarea;
	}
	public Integer getFreearea() {
		return freearea;
	}
	public void setFreearea(Integer freearea) {
		this.freearea = freearea;
	}
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
	public int getNumberOfBasement() {
		return NumberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		NumberOfBasement = numberOfBasement;
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
