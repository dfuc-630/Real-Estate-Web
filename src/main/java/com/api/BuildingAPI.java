package com.api;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Model.BuildingDTO;
import com.Model.BuildingRequestDTO;
import com.repository.entity.BuildingEntity;
import com.repository.entity.DistrictEntity;
import com.service.BuildingService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
 

@RestController
@PropertySource("classpath:application.properties") // tai ca nguon cau hinh tu properties
@Transactional

public class BuildingAPI 
{
	@Autowired
	private BuildingService buildingService ; 
	
	@PersistenceContext
	private EntityManager entityManager ;
	
	@GetMapping(value = "api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> param,
										 @RequestParam(name = "buildingtypecode", required = false) List<String> buildingtypecode)
	{
		 List<BuildingDTO> result = buildingService.Finall(param, buildingtypecode);
 	    	  return result ; 
	}
	
	@PostMapping(value = "/api/building/")
	public void createBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO)
	{
		BuildingEntity buildingEntity = new BuildingEntity() ; 
		String name = buildingRequestDTO.getName() ; 
		buildingEntity.setName(name) ;
		
		String street = buildingRequestDTO.getStreet() ; 
		buildingEntity.setStreet(street) ; 
		
		String ward = buildingRequestDTO.getWard() ;
		buildingEntity.setWard(ward) ;
	
		DistrictEntity districtEntity = new DistrictEntity() ;
		Integer id = buildingRequestDTO.getDistrictid() ; 
		districtEntity.setId(id) ; 
		buildingEntity.setDistrict(districtEntity) ;
		entityManager.persist(buildingEntity) ; 
		System.out.print("ok") ; 
	}
	
	@PutMapping(value = "/api/building/")
	public void updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO)
	{
		BuildingEntity buildingEntity = new BuildingEntity() ; 
		buildingEntity.setId(5) ; 
		
		String name = buildingRequestDTO.getName() ; 
		buildingEntity.setName(name) ;
		
		String street = buildingRequestDTO.getStreet() ; 
		buildingEntity.setStreet(street) ; 
		
		String ward = buildingRequestDTO.getWard() ;
		buildingEntity.setWard(ward) ;
	
		DistrictEntity districtEntity = new DistrictEntity() ;
		Integer districid = buildingRequestDTO.getDistrictid() ; 
		districtEntity.setId(districid) ; 
		buildingEntity.setDistrict(districtEntity) ;
		entityManager.merge(buildingEntity) ; 
		System.out.print("ok") ; 
	}
	
	@DeleteMapping(value = "/api/building/")
	public void deleteBuilding(@PathVariable Integer id) 
	{
		BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, id) ; 
		entityManager.remove(buildingEntity) ; 
		
	}
}
	