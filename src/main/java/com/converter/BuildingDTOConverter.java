package com.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Model.BuildingDTO;
import com.repository.DistrictRepository;
import com.repository.RentTypeRepository;
import com.repository.entity.BuildingEntity;
import com.repository.entity.DistrictEntity;
import com.repository.entity.RentTypeEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictRepository districtRepository ; 
	
	@Autowired
	private RentTypeRepository rentTypeRepository ; 
	
	@Autowired 
	private ModelMapper modelMapper ; 
	public BuildingDTO buildingConverter(BuildingEntity item) 
	{
			BuildingDTO building = modelMapper.map(item, BuildingDTO.class) ; 
			DistrictEntity districtEntity = districtRepository.findNameById(item.getDistrictid()) ; 
			building.setAddress(item.getStreet() + "," + item.getWard() + "," + districtEntity.getName());
			
			List<RentTypeEntity> rentTypeEntity = rentTypeRepository.FindAreaById(item.getId()) ; 
			String rentArea = rentTypeEntity.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(",")); 
			building.setRentarea(rentArea) ;
			
//			building.setNumberOfBasement(item.getNumberOfBasement());
//			building.setMangagername(item.getManagername());
//			building.setManagerphonenumber(item.getManagerphonenumber());
//			building.setFloorarea(item.getFloorarea());
//			building.setName(item.getName());
//			building.setFreearea(item.getFreearea()) ; 
//			building.setRentprice(item.getRentprice());
//			building.setServicefee(item.getServicefee());
//			building.setBrokeragefee(item.getBrokeragefee());
			return building ; 
	}
}
