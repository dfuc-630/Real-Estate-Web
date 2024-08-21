package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.repository.entity.BuildingEntity;

public interface buildingRepository {
	List<BuildingEntity> Finall(String name, Integer districtid);

}
