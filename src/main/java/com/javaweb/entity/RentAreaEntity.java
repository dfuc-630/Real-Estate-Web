package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id  ;

    @Column(name = "value")
    private Integer value ;

//	@Column(name = "buildingid")
//	private Integer buildingid ;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity building ;

    public BuildingEntity getBuilding() {
        return building;
    }
    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
//	public Integer getBuildingid() {
//		return buildingid;
//	}
//	public void setBuildingid(Integer buildingid) {
//		this.buildingid = buildingid;
//	}
}