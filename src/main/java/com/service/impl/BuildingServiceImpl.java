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
	public List<BuildingDTO> Finall(String name, Integer floorarea,Integer districtid, String ward,String street, Integer numberofbasement,
			 String direction, String level, Integer areamin, Integer areamax, Integer rentpricemin,Integer rentpricemax,String managername,
			 String managerphonenumber,Integer staffid,String buildingtypecode) 
	
	{
		List<BuildingEntity> buildingEntities = BuildingRepository.Finall(name, floorarea, districtid, ward, street, 
				 numberofbasement, direction, level, areamin, areamax, rentpricemin, rentpricemax, managername, 
                 managerphonenumber, staffid, buildingtypecode) ; 
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
			building.setFreearea(null) ; 
			building.setRentprice(item.getRentprice());
			building.setServicefee(item.getServicefee());
			building.setMGfee(item.getBrokeragefee());
			result.add(building) ; 
 		}
		return result;
	}

}
