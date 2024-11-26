package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;

import java.util.List;


public interface RentAreaService {
     void deleteByBuildings(List<Integer> ids) ;
     void addRentArea(BuildingDTO buildingDTO) ;
}
