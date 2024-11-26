package com.javaweb.model.dto;

import java.util.List;

public class AssignmentBuildingDTO {
    private Integer buildingId;
    private List<Long> staffs;

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public List<Long> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Long> staffs) {
        this.staffs = staffs;
    }
}
