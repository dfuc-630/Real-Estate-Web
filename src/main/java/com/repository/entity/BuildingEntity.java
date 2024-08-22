package com.repository.entity;

public class BuildingEntity {
	private int id ; 
	private String name; 
	private String street ;
	private String ward; 
	private int NumberOfBasement ; 
	public int getNumberOfBasement() {
		return NumberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		NumberOfBasement = numberOfBasement;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
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
