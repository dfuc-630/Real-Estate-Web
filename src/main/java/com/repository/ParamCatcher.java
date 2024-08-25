package com.repository;

public class ParamCatcher {
	  public   String name = "";
	  public   Integer floorarea = null;
	  public   Integer districtid = null;
	  public   String ward = "";
	  public   String street = "";
	  public   Integer numberofbasement = null;
	  public   String direction = "";
	  public   String level = "";
	  public   Integer areamin = null;
	  public   Integer areamax = null;
	  public   Integer rentpricemin = null;
	  public   Integer rentpricemax = null;
	  public   String managername = "";
	  public   String managerphonenumber = "";
	  public   Integer staffid = null;
	  public   String buildingtypecode = "";
	public ParamCatcher(String name, Integer floorarea, Integer districtid, String ward, String street,
			Integer numberofbasement, String direction, String level, Integer areamin, Integer areamax,
			Integer rentpricemin, Integer rentpricemax, String managername, String managerphonenumber, Integer staffid,
			String buildingtypecode) {
		super();
		this.name = name;
		this.floorarea = floorarea;
		this.districtid = districtid;
		this.ward = ward;
		this.street = street;
		this.numberofbasement = numberofbasement;
		this.direction = direction;
		this.level = level;
		this.areamin = areamin;
		this.areamax = areamax;
		this.rentpricemin = rentpricemin;
		this.rentpricemax = rentpricemax;
		this.managername = managername;
		this.managerphonenumber = managerphonenumber;
		this.staffid = staffid;
		this.buildingtypecode = buildingtypecode;
	}
	  
	  
}
