package com.api;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Model.BuildingDTO;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
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
										 @RequestParam(name = "districtid", required = false) Integer districtid)
	{
		List<BuildingDTO> result = buildingService.Finall(name, districtid) ; 
 	    	  return result ; 
	}
	
}
	