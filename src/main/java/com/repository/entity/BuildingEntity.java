package com.repository.entity;

import org.springframework.web.bind.annotation.RequestParam;

public class BuildingEntity {
	private String name; 
	private Integer floorarea ;
	private Integer districtid;
	private String district ; 
	private String ward; 
	private String street ;
	private int NumberOfBasement ;
	private String direction;
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	private Integer area ; 
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	private String staff ; 
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	private String buildingtype ; 
	public String getBuildingtype() {
		return buildingtype;
	}
	public void setBuildingtype(String buildingtype) {
		this.buildingtype = buildingtype;
	}
	private String level;
	private Integer areamin;
	private  Integer areamax;
	private Integer rentpricemin;
	private  Integer rentpricemax;
	private Integer rentprice ; 
	private Integer servicefee ; 
	private Integer brokeragefee ; 
	private  String managername;
	private  String managerphonenumber;
	private  Integer staffid;
	private  String buildingtypecode;
	private Integer rentarea ;
	private String freearea;
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
	public String getFreearea() {
		return freearea;
	}
	public void setFreearea(String freearea) {
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
	public Integer getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
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
	public Integer getAreamin() {
		return areamin;
	}
	public void setAreamin(Integer areamin) {
		this.areamin = areamin;
	}
	public Integer getAreamax() {
		return areamax;
	}
	public void setAreamax(Integer areamax) {
		this.areamax = areamax;
	}
	public Integer getRentpricemin() {
		return rentpricemin;
	}
	public void setRentpricemin(Integer rentpricemin) {
		this.rentpricemin = rentpricemin;
	}
	public Integer getRentpricemax() {
		return rentpricemax;
	}
	public void setRentpricemax(Integer rentpricemax) {
		this.rentpricemax = rentpricemax;
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
	public Integer getStaffid() {
		return staffid;
	}
	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}
	public String getBuildingtypecode() {
		return buildingtypecode;
	}
	public void setBuildingtypecode(String buildingtypecode) {
		this.buildingtypecode = buildingtypecode;
	}

}
