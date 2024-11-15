//package com.javaweb.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "district")
//public class DistrictEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id ;
//
//    @Column(name = "code")
//    private String code ;
//
//    @Column(name = "name")
//    private String name ;
//
//    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
//    private List<BuildingEntity> buildings = new ArrayList<>() ;
//
//    public List<BuildingEntity> getBuildings() {
//        return buildings;
//    }
//    public void setBuildings(List<BuildingEntity> buildings) {
//        this.buildings = buildings;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//    public void setId(Integer id) {
//        this.id = id;
//    }
//    public String getCode() {
//        return code;
//    }
//    public void setCode(String code) {
//        this.code = code;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//}