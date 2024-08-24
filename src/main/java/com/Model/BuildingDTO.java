package com.Model;

public class BuildingDTO {
//	private int id ; 
	private String name; 
	private String address ; 
	private Integer NumberOfBasement ;
	private String mangagername ;
	private String managerphonenumber ;
	private Integer floorarea ;
	private Integer rentarea ; 
	private Integer freearea ;
	private Integer rentprice ;
	public String getMangagername() {
		return mangagername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
	public void setMangagername(String mangagername) {
		this.mangagername = mangagername;
	}

	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
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
	public Integer getMGfee() {
		return MGfee;
	}
	public void setMGfee(Integer mGfee) {
		MGfee = mGfee;
	}
	private Integer servicefee ;
	private Integer MGfee ; 
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
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
