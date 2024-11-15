package com.javaweb.model.request;

import com.javaweb.model.dto.AbstractDTO;

import java.util.List;

public class BuildingSearchRequest extends AbstractDTO {
    private Integer staffid ;
    private String name;
    private String ward;
    private String street ;
    private String district ;
    private String managername;
    private String managerphone;
    private Integer floorarea ;
    private Integer freearea;
    private Integer rentpricemin ;
    private Integer rentpricemax ;
    private Integer areamin ;
    private Integer areamax ;
    private Integer servicefee ;
    private Integer brokeragefee ;
    private List<String> buildingtypecode ;
    private Integer numberofbasement ;
    private String direction;
    private String level;

    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public void setManagerphone(String managerphonenumber) {
        this.managerphone = managerphonenumber;
    }

    public Integer getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(Integer floorarea) {
        this.floorarea = floorarea;
    }

    public Integer getFreearea() {
        return freearea;
    }

    public void setFreearea(Integer freearea) {
        this.freearea = freearea;
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

    public List<String> getBuildingtypecode() {
        return buildingtypecode;
    }

    public void setBuildingtypecode(List<String> buildingtypecode) {
        this.buildingtypecode = buildingtypecode;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(Integer numberofbasement) {
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
}
