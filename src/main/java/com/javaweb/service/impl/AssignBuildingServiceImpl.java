package com.javaweb.service.impl;

import com.javaweb.entity.AssignBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.AssignBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.service.AssignBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssignBuildingServiceImpl implements AssignBuildingService {
    @Autowired
    private AssignBuildingRepository assignBuildingRepository ;
    @Autowired
    private BuildingRepository buildingRepository ;
    @Override
    public void deleteByBuildingIn(List<Integer> ids)
    {
        for(Integer id: ids)
        {
            BuildingEntity buildingEntity = buildingRepository.findById(id).get() ;
            assignBuildingRepository.deleteByBuildingEntity(buildingEntity) ;
        }
    }
}
