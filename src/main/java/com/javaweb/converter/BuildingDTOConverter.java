package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingDTOConverter {
    @Autowired
    private ModelMapper modelMapper ;

    public BuildingEntity DTOConverter(BuildingDTO item)
    {
        BuildingEntity building = modelMapper.map(item, BuildingEntity.class) ;
        if(item.getType().size() > 0) {
            String s = String.join(",", item.getType()) ;
            building.setType(s);
        }
//        DistrictEntity districtEntity = item.getDistrict() ;
//        building.setAddress(item.getStreet() + "," + item.getWard() + "," + district.getDistrictNameByCode(item.getDistrict()));
//
//        List<RentAreaEntity> rentTypeEntity = item.getRentAreas() ;
//        String rentArea = rentTypeEntity.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
//        building.setRentarea(rentArea) ;

        return building ;
    }
}
