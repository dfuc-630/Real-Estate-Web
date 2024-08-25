package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.BuildingDTO;
import com.repository.ParamCatcher;
import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;
import com.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private buildingRepository BuildingRepository ; 
	@Override
	public List<BuildingDTO> Finall(ParamCatcher V) 
	
	{
		List<BuildingEntity> buildingEntities = BuildingRepository.Finall(V) ; 
		List<BuildingDTO> result = new ArrayList<BuildingDTO>() ;
		for(BuildingEntity item: buildingEntities)
		{
			BuildingDTO building = new BuildingDTO() ;
			building.setName(item.getName());
			building.setAddress(item.getStreet() + "," + item.getWard() + "," + item.getDistrict());
			building.setNumberOfBasement(item.getNumberOfBasement());
			building.setMangagername(item.getManagername());
			building.setManagerphonenumber(item.getManagerphonenumber());
			building.setFloorarea(item.getFloorarea());
			building.setRentarea(item.getRentarea()) ; 
			building.setFreearea(item.getFreearea()) ; 
			building.setRentprice(item.getRentprice());
			building.setServicefee(item.getServicefee());
			building.setBrokeragefee(item.getBrokeragefee());
			result.add(building) ; 
 		}
		return result;
	}

}
