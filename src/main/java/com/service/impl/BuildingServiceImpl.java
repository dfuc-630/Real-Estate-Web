package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.standard.expression.Fragment;

import com.Model.BuildingDTO;
import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;
import com.repository.impl.BuildingRepositoryImpl;
import com.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private buildingRepository BuildingRepository ; 
	@Override
	public List<BuildingDTO> Finall(String name, Integer districtid) {
		List<BuildingEntity> buildingEntities = BuildingRepository.Finall(name, districtid) ; 
		List<BuildingDTO> result = new ArrayList<BuildingDTO>() ;
		for(BuildingEntity item: buildingEntities)
		{
			BuildingDTO building = new BuildingDTO() ;
			building.setName(item.getName());
			building.setAddress(item.getStreet() + "," + item.getWard());
			building.setNumberOfBasement(item.getNumberOfBasement());
			result.add(building) ; 
 		}
		return result;
	}

}
