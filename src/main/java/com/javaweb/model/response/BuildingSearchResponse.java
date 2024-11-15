package com.javaweb.model.response;


import com.javaweb.model.dto.AbstractDTO;

public class BuildingSearchResponse extends AbstractDTO {
	private Integer id;
	private String name;
	private String address;
	private Integer numberofbasement;
	private String managername;
	private String managerphone;
	private Integer floorarea;
	private String rentarea;
    private String emptyarea;
    private Integer rentprice;
    private String servicefee;
    private Double brokeragefee;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNumberofbasement() {
		return numberofbasement;
	}

	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagerphone() {
		return managerphone;
	}

	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
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

	public String getEmptyarea() {
		return emptyarea;
	}

	public void setEmptyarea(String emptyarea) {
		this.emptyarea = emptyarea;
	}

	public Integer getRentprice() {
		return rentprice;
	}

	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}

	public String getServicefee() {
		return servicefee;
	}

	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}

	public Double getBrokeragefee() {
		return brokeragefee;
	}

	public void setBrokeragefee(Double brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
}
