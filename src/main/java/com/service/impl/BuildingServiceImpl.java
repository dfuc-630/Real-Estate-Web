package com.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<BuildingDTO> Finall(Map<String, Object> param) 
	
	{
		List<BuildingEntity> buildingEntities = BuildingRepository.Finall(param) ; 
		List<BuildingDTO> result = new ArrayList<BuildingDTO>() ;
		Map<String, List<Integer>> buildingAreas = new HashMap<>();
		Map<String, Integer> wordCount = new HashMap<>();
		for(BuildingEntity item: buildingEntities)
		{
			addArea(buildingAreas, item.getName(), item.getRentarea());
		}
		
		for(BuildingEntity item: buildingEntities)
		{
			if(!wordCount.containsKey(item.getName())) 
			{
				wordCount.put(item.getName(), 1);
				BuildingDTO building = new BuildingDTO() ;
				building.setName(item.getName());
				building.setAddress(item.getStreet() + "," + item.getWard() + "," + item.getDistrict());
				building.setNumberOfBasement(item.getNumberOfBasement());
				building.setMangagername(item.getManagername());
				building.setManagerphonenumber(item.getManagerphonenumber());
				building.setFloorarea(item.getFloorarea());
				building.setRentarea(buildingAreas.get(item.getName())) ; 
				building.setFreearea(item.getFreearea()) ; 
				building.setRentprice(item.getRentprice());
				building.setServicefee(item.getServicefee());
				building.setBrokeragefee(item.getBrokeragefee());
				result.add(building) ;
			}
//			else 
//			{
//				building.setRentarea(building.getRentarea() + "," + item.getRentarea()) ; 
//			}
			
 		}
		return result;
	}
	private static void addArea(Map<String, List<Integer>> map, String buildingName, int area) {
        // Kiểm tra xem tòa nhà đã có trong Map chưa
        if (!map.containsKey(buildingName)) {
            // Nếu chưa có, tạo một danh sách mới và thêm vào Map
            map.put(buildingName, new ArrayList<>());
        }
        // Thêm diện tích vào danh sách của tòa nhà
        map.get(buildingName).add(area);
    }

}
