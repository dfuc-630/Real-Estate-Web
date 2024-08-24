package com.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.Model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> Finall(String name,
			 Integer floorarea,
			 Integer districtid,
			 String ward,
			String street,
			Integer numberofbasement,
			 String direction,
			 String level,
			 Integer areamin,
			 Integer areamax,
			 Integer rentpricemin,
			 Integer rentpricemax,
			  String managername,
			 String managerphonenumber,
			 Integer staffid,
			String buildingtypecode);

}
