package com.Model;

public class BuildingDTO {
	private int id ; 
	private String name; 
	private String address ; 
	private int NumberOfBasement ; 
	public int getNumberOfBasement() {
		return NumberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		NumberOfBasement = numberOfBasement;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
