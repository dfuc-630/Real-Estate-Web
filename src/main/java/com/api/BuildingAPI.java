package com.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Model.BuildingDTO;
import com.repository.entity.BuildingEntity;
import com.service.BuildingService;


@RestController
public class BuildingAPI {
//	@RequestMapping(value = "/api/building/", method = RequestMethod.GET) 
//	public void building(@RequestParam(value = "name", required = false) String name) {
//		System.out.println(name) ; 	
//		//return 1111 ; 
//	}
//	@GetMapping("/api/building2/")
//	public void building2(@RequestParam(value = "name") String name) {
//		System.out.println(name) ;
//	}
//	@GetMapping("/api/building3/{id}/{name}")
//	public void building3(@PathVariable String id,
//								@PathVariable String name) 
//	{
//		System.out.println(name) ;	
//		System.out.println(id) ;
//	}
//	@GetMapping("api/building4/")
//	public void building4(@RequestParam Map<String, String> params) {
//		System.out.println(params.values());
//	}
//	void validate(BuildingDTO Ex) 
//	{
//		if(Ex.getName() == null || Ex.getName() == "") throw new FieldRequiredException("loi khong ten") ; 
//	}

//	@GetMapping("api/building/")
//	public Object building5(@RequestBody BuildingDTO V) {
//		try 
//		{
//			System.out.println(5/0);
//			validate(V) ; 
//		} 
//		catch (FieldRequiredException e) 
//		{
//			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO() ; 
//			errorResponseDTO.setError(e.getMessage()) ; 
//			List<String> details = new ArrayList<String>() ; 
//			details.add("adu sai roi") ; 
//			errorResponseDTO.setDetail(details) ; 
// 			return errorResponseDTO ; 
//		}
//		BuildingDTO v2 = new BuildingDTO() ; 
//		v2 = V ; 
//	System.out.println(5/0);
//		return null ; 
//	}
	@Autowired
	private BuildingService buildingService ; 
	@GetMapping(value = "api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(name = "name", required = false) String name,
										 @RequestParam(name = "floorarea", required = false) Integer floorarea,
										 @RequestParam(name = "districtid", required = false) Integer districtid,
										 @RequestParam(name = "ward", required = false) String ward,
										 @RequestParam(name = "street", required = false) String street,
										 @RequestParam(name = "numberofbasement", required = false) Integer numberofbasement,
										 @RequestParam(name = "direction", required = false) String direction,
										 @RequestParam(name = "level", required = false) String level,
										 @RequestParam(name = "areamin", required = false) Integer areamin,
										 @RequestParam(name = "areamax", required = false) Integer areamax,
										 @RequestParam(name = "rentpricemin", required = false) Integer rentpricemin,
										 @RequestParam(name = "rentpricemax", required = false) Integer rentpricemax,
										 @RequestParam(name = "managername", required = false) String managername,
										 @RequestParam(name = "managerphonenumber", required = false) String managerphonenumber,
										 @RequestParam(name = "staffid", required = false) Integer staffid,
										 @RequestParam(name = "buildingtypecode", required = false) String buildingtypecode

			)
	{
//		BuildingEntity data = new BuildingEntity(name, floorarea, districtid, ward, street, numberofbasement, direction, 
//												level, areamin, areamax, rentpricemin, rentpricemax, managername, managerphonenumber, staffid, buildingtypecode) ; 
		 List<BuildingDTO> result = buildingService.Finall(name, floorarea, districtid, ward, street, 
				 numberofbasement, direction, level, areamin, 
                 areamax, rentpricemin, rentpricemax, managername, 
                 managerphonenumber, staffid, buildingtypecode);
 	    	  return result ; 
	}
	
}
	