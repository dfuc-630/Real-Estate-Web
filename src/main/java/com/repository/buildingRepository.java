package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.repository.entity.BuildingEntity;

public interface buildingRepository {
	List<BuildingEntity> Finall(String name,
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
