package com.javaweb.model.dto;

import java.util.List;

public class AssignmentBuildingDTO {
    private Integer buildingId;
    private List<Integer> staffs;

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public List<Integer> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Integer> staffs) {
        this.staffs = staffs;
    }
}
