package com.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.builder.BuildingSearchBuilder;
import com.utils.MapUtil;
@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> param, List<String> buildingtypecode)
	{
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
																						.setName(MapUtil.getObject(param, "name", String.class))
																						.setFloorarea(MapUtil.getObject(param, "floorarea", Integer.class))
																						.setWard(MapUtil.getObject(param, "floorarea", String.class))
																						.setStreet(MapUtil.getObject(param, "street", String.class))
																						.setDistrictid(MapUtil.getObject(param, "districtid", Integer.class))
																						.setNumberOfBasement(MapUtil.getObject(param, "numberofbasement", Integer.class))
																						.setBuildingtypecode(buildingtypecode)
																						.setManagername(MapUtil.getObject(param, "managername", String.class))
																						.setManagerphonenumber(MapUtil.getObject(param, "managerphonenumber", String.class))
																						.setRentpricemin(MapUtil.getObject(param, "rentpricemin", Integer.class))
																						.setRentpricemax(MapUtil.getObject(param, "rentpricemax", Integer.class))
																						.setAreamin(MapUtil.getObject(param, "areamin", Integer.class))
																						.setAreamax(MapUtil.getObject(param, "areamax", Integer.class))
																						.setStaffid(MapUtil.getObject(param, "staffid", Integer.class))
																						.build() ; 
																			 
																				
		return buildingSearchBuilder ; 
	}
}
