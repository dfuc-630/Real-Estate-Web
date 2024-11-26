package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
//import com.javaweb.converter.CreateBuildingConverter;
import com.javaweb.converter.buildingResponseConverter;
import com.javaweb.entity.AssignBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.AssignBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.AssignBuildingService;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.RentAreaService;
import com.javaweb.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
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
    @Autowired
    private BuildingDTOConverter buildingDTOConverter ;
//    @Autowired
//    private BuildingDTO buildingDTO ;
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
    @Override
    public void sendBuilding(BuildingDTO buildingDTO)
    {
        BuildingEntity buildingEntity =  buildingDTOConverter.DTOConverter(buildingDTO) ;
        if (buildingEntity.getType() != null) {
            buildingRepository.save(buildingEntity);
            System.out.println("ok") ;
        }
//        else {
//            // Xử lý trường hợp buildingEntity là null (ví dụ: ghi log hoặc ném ngoại lệ)
//            throw new IllegalArgumentException("Building entity cannot be null");
//        }
    }
    @Autowired
    private RentAreaService rentAreaService ;
    @Override
    public BuildingDTO addOrUpdateBuilding(BuildingDTO buildingDTO)
    {
        Integer buildingId = buildingDTO.getId() ;
        BuildingEntity buildingEntity =  buildingDTOConverter.DTOConverter(buildingDTO) ;
        buildingRepository.save(buildingEntity);
        //buildingDTO.setId(buildingEntity.getId());
        if(StringUtils.check(buildingDTO.getRentarea())) rentAreaService.addRentArea(buildingDTO) ;
        return buildingDTO ;
    }
    @Override
    public void updateBuilding(Integer id, BuildingDTO buildingDTO)
    {
        BuildingEntity building = buildingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Building not found!"));

        // Ánh xạ DTO sang Entity
        modelMapper.map(buildingDTO, building);

        buildingRepository.save(building);
    }
    @Autowired
    private AssignBuildingService assignBuildingService ;
    @Transactional
    @Override
    public void deleteBuilding(List<Integer> ids)
    {
        rentAreaService.deleteByBuildings(ids) ;
        assignBuildingService.deleteByBuildingIn(ids) ;
        for (Integer id : ids) {
            buildingRepository.deleteById(id);
        }
        System.out.println("ok");
    }

    @Autowired
    private ModelMapper modelMapper ;
    public BuildingDTO findBuilding(Integer id)
    {
        BuildingEntity building = buildingRepository.findById(id).get() ;
        BuildingDTO buildingDTO = modelMapper.map(building, BuildingDTO.class) ;
        if (building.getType() != null) {
            String typeString = building.getType(); // Chuỗi từ DB
            List<String> typeList = Arrays.asList(typeString.split(","));
            buildingDTO.setType(typeList);
        }
        return buildingDTO ;
    }
    @Autowired
    private AssignBuildingRepository assignBuildingRepository;
    @Override
    public void updateAssignment(AssignmentBuildingDTO assignmentBuildingDTO)
    {
        Integer buildingId = assignmentBuildingDTO.getBuildingId() ;
        List<Long> staffIds = assignmentBuildingDTO.getStaffs() ;
        BuildingEntity building = buildingRepository.findById(buildingId).get() ;

        for (Long staffId : staffIds) {
            UserEntity staff = userRepository.findById(staffId)
                    .orElseThrow(() -> new IllegalArgumentException("Staff with ID " + staffId + " not found"));


            AssignBuildingEntity assignment = new AssignBuildingEntity();
            assignment.setBuildingEntity(building);
            assignment.setUserEntity(staff);

            assignBuildingRepository.save(assignment); // Lưu vào database
            System.out.println("ok") ;
        }
    }
}
