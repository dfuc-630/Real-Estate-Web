package com.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Model.BuildingDTO;
import com.repository.entity.BuildingEntity;
import com.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConverter {

	@Autowired 
	private ModelMapper modelMapper ; 
	public BuildingDTO buildingConverter(BuildingEntity item) 
	{
			BuildingDTO building = modelMapper.map(item, BuildingDTO.class) ; 
//			DistrictEntity districtEntity = item.getDistrict() ; 
			building.setAddress(item.getStreet() + "," + item.getWard() + "," + item.getDistrict().getName());
			
			List<RentAreaEntity> rentTypeEntity = item.getRentAreas() ; 
			String rentArea = rentTypeEntity.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(",")); 
			building.setRentarea(rentArea) ;

			return building ; 
	}
}
