package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;

public interface IBuildingService {
    ResponseDTO listStaffs(Integer buildingId);
    List<BuildingSearchResponse> Finall(BuildingSearchRequest buildingSearchRequest) ;
    BuildingDTO findBuilding(Integer id) ;
    BuildingDTO addOrUpdateBuilding(BuildingDTO buildingDTO) ;
    void sendBuilding(BuildingDTO buildingDTO) ;
    void deleteBuilding(List<Integer> ids) ;
    void updateBuilding(Integer id, BuildingDTO buildingDTO) ;
    void updateAssignment(AssignmentBuildingDTO assignmentBuildingDTO);

}
