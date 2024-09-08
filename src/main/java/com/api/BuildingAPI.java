package com.api;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Model.BuildingDTO;
import com.service.BuildingService;


@RestController
@PropertySource("classpath:application.properties") // tai ca nguon cau hinh tu properties
public class BuildingAPI 
{
	@Autowired
	private BuildingService buildingService ; 
	@GetMapping(value = "api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> param,
										 @RequestParam(name = "buildingtypecode", required = false) List<String> buildingtypecode)
	{
		 List<BuildingDTO> result = buildingService.Finall(param, buildingtypecode);
 	    	  return result ; 
	}
	
}
	