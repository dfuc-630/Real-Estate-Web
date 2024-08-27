package com.api;
import java.util.List;
import java.util.Map;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Model.BuildingDTO;
import com.repository.ParamCatcher;
import com.service.BuildingService;


@RestController
public class BuildingAPI 
{
	@Autowired
	private BuildingService buildingService ; 
	@GetMapping(value = "api/building/")
//	public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false) String name,
//										 @RequestParam(name = "floorarea", required = false) Integer floorarea,
//										 @RequestParam(name = "districtid", required = false) Integer districtid,
//										 @RequestParam(name = "ward", required = false) String ward,
//										 @RequestParam(name = "street", required = false) String street,
//										 @RequestParam(name = "numberofbasement", required = false) Integer numberofbasement,
//										 @RequestParam(name = "direction", required = false) String direction,
//										 @RequestParam(name = "level", required = false) String level,
//										 @RequestParam(name = "areamin", required = false) Integer areamin,
//										 @RequestParam(name = "areamax", required = false) Integer areamax,
//										 @RequestParam(name = "rentpricemin", required = false) Integer rentpricemin,
//										 @RequestParam(name = "rentpricemax", required = false) Integer rentpricemax,
//										 @RequestParam(name = "managername", required = false) String managername,
//										 @RequestParam(name = "managerphonenumber", required = false) String managerphonenumber,
//										 @RequestParam(name = "staffid", required = false) Integer staffid,
//										 @RequestParam(name = "buildingtypecode", required = false) String buildingtypecode)
	
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> param,
										 @RequestParam(name = "buildingtypecode", required = false) List<String> buildingtypecode)
	{
//		ParamCatcher request = new ParamCatcher(name, floorarea, districtid, ward, street, 
//				 								numberofbasement, direction, level, areamin, 
//				 								areamax, rentpricemin, rentpricemax, managername, 
//				 								managerphonenumber, staffid, buildingtypecode);
//		
		 List<BuildingDTO> result = buildingService.Finall(param, buildingtypecode);
 	    	  return result ; 
	}
	
}
	