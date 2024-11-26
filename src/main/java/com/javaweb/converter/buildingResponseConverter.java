package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.javaweb.enums.district;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class buildingResponseConverter {
    @Autowired
    private ModelMapper modelMapper ;
    public BuildingSearchResponse buildingConverter(BuildingEntity item)
    {
        BuildingSearchResponse building = modelMapper.map(item, BuildingSearchResponse.class) ;
//        DistrictEntity districtEntity = item.getDistrict() ;
        building.setAddress(item.getStreet() + "," + item.getWard() + "," + district.getDistrictNameByCode(item.getDistrict()));
//
        List<RentAreaEntity> rentTypeEntity = item.getRentAreas() ;
        String rentArea = rentTypeEntity.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
        building.setRentarea(rentArea) ;

        return building ;
    }
}
