package com.javaweb.builder;

import java.util.List;

public class BuildingSearchBuilder {
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



    private BuildingSearchBuilder(Builder builder)
    {
        this.staffid = builder.staffid;
        this.name = builder.name;
        this.ward = builder.ward;
        this.street = builder.street;
        this.district = builder.district;
        this.managername = builder.managername;
        this.managerphone = builder.managerphone;
        this.floorarea = builder.floorarea;
        this.freearea = builder.freearea;
        this.rentpricemin = builder.rentpricemin;
        this.rentpricemax = builder.rentpricemax;
        this.areamin = builder.areamin;
        this.areamax = builder.areamax;
        this.servicefee = builder.servicefee;
        this.brokeragefee = builder.brokeragefee;
        this.buildingtypecode = builder.buildingtypecode;
        this.numberofbasement = builder.numberofbasement;
        this.direction = builder.direction;
        this.level = builder.level;
    }
    public Integer getStaffid() {
        return staffid;
    }
    public String getName() {
        return name;
    }
    public String getWard() {
        return ward;
    }
    public String getStreet() {
        return street;
    }
    public String getDistrict() {
        return district;
    }
    public String getManagername() {
        return managername;
    }
    public String getManagerphone() {
        return managerphone;
    }
    public Integer getFloorarea() {
        return floorarea;
    }
    public Integer getFreearea() {
        return freearea;
    }
    public Integer getRentpricemin() {
        return rentpricemin;
    }
    public Integer getRentpricemax() {
        return rentpricemax;
    }
    public Integer getAreamin() {
        return areamin;
    }
    public Integer getAreamax() {
        return areamax;
    }
    public Integer getServicefee() {
        return servicefee;
    }
    public Integer getBrokeragefee() {
        return brokeragefee;
    }
    public List<String> getBuildingtypecode() {
        return buildingtypecode;
    }
    public Integer getNumberOfBasement() {
        return numberofbasement;
    }
    public String getDirection() {
        return direction;
    }
    public String getLevel() {
        return level;
    }
    public static class Builder
    {
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
        private	Integer numberofbasement ;
        private String direction;
        private String level;
        public Builder setStaffid(Integer staffid) {
            this.staffid = staffid;
            return this ;
        }
        public Builder setName(String name) {
            this.name = name; return this ;
        }
        public Builder setWard(String ward) {
            this.ward = ward; return this ;
        }

        public Builder setStreet(String street) {
            this.street = street;return this ;
        }

//        public Builder setNumberofbasement(Integer numberofbasement) {
//            this.numberofbasement = numberofbasement;return this ;
//        }

        public Builder setDistrict(String districtid) {
            this.district = districtid; return this ;
        }
        public Builder setManagername(String managername) {
            this.managername = managername; return this ;
        }
        public Builder setManagerphone(String managerphonenumber) {
            this.managerphone = managerphonenumber; return this ;
        }
        public Builder setFloorarea(Integer floorarea) {
            this.floorarea = floorarea; return this ;
        }
        public Builder setFreearea(Integer freearea) {
            this.freearea = freearea; return this ;
        }
        public Builder setRentpricemin(Integer rentpricemin) {
            this.rentpricemin = rentpricemin; return this ;
        }
        public Builder setRentpricemax(Integer rentpricemax) {
            this.rentpricemax = rentpricemax; return this ;
        }
        public Builder setAreamin(Integer areamin) {
            this.areamin = areamin; return this ;
        }
        public Builder setAreamax(Integer areamax) {
            this.areamax = areamax; return this ;
        }
        public Builder setServicefee(Integer servicefee) {
            this.servicefee = servicefee; return this ;
        }
        public Builder setBrokeragefee(Integer brokeragefee) {
            this.brokeragefee = brokeragefee; return this ;
        }
        public Builder setBuildingtypecode(List<String> buildingtypecode) {
            this.buildingtypecode = buildingtypecode; return this ;
        }
        public Builder setNumberOfBasement(Integer numberofbasement) {
            this.numberofbasement = numberofbasement; return this ;
        }
        public Builder setDirection(String direction) {
            this.direction = direction; return this ;
        }
        public Builder setLevel(String level) {
            this.level = level; return this ;
        }
        public BuildingSearchBuilder build()
        {
            return new BuildingSearchBuilder(this) ;
        }
    }
}
