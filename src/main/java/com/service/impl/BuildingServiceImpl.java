package com.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.BuildingDTO;
import com.builder.BuildingSearchBuilder;
import com.converter.BuildingDTOConverter;
import com.converter.BuildingSearchBuilderConverter;
import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;
import com.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private buildingRepository BuildingRepository ; 
	
	@Autowired 
	private BuildingDTOConverter buildingDTOConverter ;
	
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter ; 
	
	@Override
	public List<BuildingDTO> Finall(Map<String, Object> param, List<String> buildingtypecode) 
	
	{
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(param, buildingtypecode) ; 
		List<BuildingEntity> buildingEntities = BuildingRepository.Finall(buildingSearchBuilder) ; 
//		BuildingEntity buildingEntities = BuildingRepository.findById(1).get() ;
		List<BuildingDTO> result = new ArrayList<BuildingDTO>() ;
		for(BuildingEntity item: buildingEntities)
		{
				BuildingDTO building = buildingDTOConverter.buildingConverter(item) ;
				result.add(building) ;
 		}
		
		
		return result;
	}

}