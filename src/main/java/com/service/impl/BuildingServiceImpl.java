package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.BuildingDTO;
import com.repository.DistrictRepository;
import com.repository.RentTypeRepository;
import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;
import com.repository.entity.DistrictEntity;
import com.repository.entity.RentTypeEntity;
import com.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private buildingRepository BuildingRepository ; 
	
	@Autowired
	private DistrictRepository districtRepository ; 
	
	@Autowired
	private RentTypeRepository rentTypeRepository ; 
	@Override
	public List<BuildingDTO> Finall(Map<String, Object> param, List<String> buildingtypecode) 
	
	{
		List<BuildingEntity> buildingEntities = BuildingRepository.Finall(param, buildingtypecode) ; 
		List<BuildingDTO> result = new ArrayList<BuildingDTO>() ;
		for(BuildingEntity item: buildingEntities)
		{
				BuildingDTO building = new BuildingDTO() ;
				building.setName(item.getName());
				
				DistrictEntity districtEntity = districtRepository.findNameById(item.getDistrictid()) ; 
				building.setAddress(item.getStreet() + "," + item.getWard() + "," + districtEntity.getName());
				
				building.setNumberOfBasement(item.getNumberOfBasement());
				building.setMangagername(item.getManagername());
				building.setManagerphonenumber(item.getManagerphonenumber());
				building.setFloorarea(item.getFloorarea());
//				building.setRentarea(buildingAreas.get(item.getName())) ; 
				
				List<RentTypeEntity> rentTypeEntity = rentTypeRepository.FindAreaById(item.getId()) ; 
				String rentArea = rentTypeEntity.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(",")); 
				
				building.setRentarea(rentArea) ;
				
				building.setFreearea(item.getFreearea()) ; 
				building.setRentprice(item.getRentprice());
				building.setServicefee(item.getServicefee());
				building.setBrokeragefee(item.getBrokeragefee());
				result.add(building) ;
//			}
			
 		}
		return result;
	}

}
