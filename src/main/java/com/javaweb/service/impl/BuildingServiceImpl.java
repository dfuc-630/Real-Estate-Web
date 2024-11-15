package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.converter.buildingResponseConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements IBuildingService {
    @Autowired
    private BuildingRepository buildingRepository ;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private buildingResponseConverter BuildingResponseConverter ;
    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter ;
    @Override
    public ResponseDTO listStaffs(Integer buildingId) {
        BuildingEntity building = buildingRepository.findById(buildingId).get() ;
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF") ;
        List<UserEntity> staffAssignment = building.getUserEntities() ;
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>() ;
        ResponseDTO responseDTO = new ResponseDTO() ;
        for(UserEntity it: staffs)
        {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO() ;
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if(staffAssignment.contains(it))
            {
                staffResponseDTO.setChecked("checked");
            }
            else
            {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO) ;
        }
        responseDTO.setData(staffResponseDTOS) ;
        responseDTO.setMessage("success");
        return responseDTO;
    }
    @Override
    public List<BuildingSearchResponse> Finall(BuildingSearchRequest buildingSearchRequest)
    {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(buildingSearchRequest) ;
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder) ;
//		BuildingEntity buildingEntities = BuildingRepository.findById(1).get() ;
        List<BuildingSearchResponse> result = new ArrayList<BuildingSearchResponse>() ;
        for(BuildingEntity item: buildingEntities)
        {
            BuildingSearchResponse building = BuildingResponseConverter.buildingConverter(item) ;
            result.add(building) ;
        }
        return result;
//        return null ;
    }
}
