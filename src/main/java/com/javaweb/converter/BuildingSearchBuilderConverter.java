package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.MapUtil;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest)
    {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MapUtils.getObject(buildingSearchRequest.getName(), String.class))
                .setFloorarea(MapUtils.getObject(buildingSearchRequest.getFloorarea(), Integer.class))
                .setWard(MapUtils.getObject(buildingSearchRequest.getWard(), String.class))
                .setStreet(MapUtils.getObject(buildingSearchRequest.getStreet(), String.class))
                .setDistrict(MapUtils.getObject(buildingSearchRequest.getDistrict(), String.class))
                .setNumberOfBasement(MapUtils.getObject(buildingSearchRequest.getNumberofbasement(), Integer.class))
//                .setDirection(MapUtils.getObject(buildingSearchRequest.getDirection(), String.class))
//                .setLevel(MapUtils.getObject(buildingSearchRequest.getLevel(), String.class))
                .setBuildingtypecode(buildingSearchRequest.getBuildingtypecode())
                .setManagername(MapUtils.getObject(buildingSearchRequest.getManagername(), String.class))
                .setManagerphone(MapUtils.getObject(buildingSearchRequest.getManagerphone(), String.class))
                .setRentpricemin(MapUtils.getObject(buildingSearchRequest.getRentpricemin(), Integer.class))
                .setRentpricemax(MapUtils.getObject(buildingSearchRequest.getRentpricemax(), Integer.class))
                .setAreamin(MapUtils.getObject(buildingSearchRequest.getAreamin(), Integer.class))
                .setAreamax(MapUtils.getObject(buildingSearchRequest.getAreamax(), Integer.class))
                .setStaffid(MapUtils.getObject(buildingSearchRequest.getStaffid(), Integer.class))
                .build() ;

        return buildingSearchBuilder ;
    }
}

