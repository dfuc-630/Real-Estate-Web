package com.Model;

public class BuildingDTO 
{
	private String name; 
	private String address ; 
	private Integer NumberOfBasement ;
	private String managername ;
	private String managerphonenumber ;
	private Integer floorarea ;
	private String rentarea ; 
	private Integer freearea ;
	private Integer rentprice ;
	private Integer servicefee ;
	private Integer brokeragefee ; 
	public String getManagername() {
		return managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
	public void setManagername(String mangagername) {
		this.managername = mangagername;
	}

	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public String getRentarea() {
		return rentarea;
	}
	public void setRentarea(String rentarea) {
		this.rentarea = rentarea;
	}
	public Integer getFreearea() {
		return freearea;
	}
	public void setFreearea(Integer freearea) {
		this.freearea = freearea;
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
	public Integer getNumberOfBasement() {
		return NumberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		NumberOfBasement = numberOfBasement;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
