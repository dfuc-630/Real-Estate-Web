package com.repository;

import java.util.List;

import com.builder.BuildingSearchBuilder;
import com.repository.entity.BuildingEntity;

public interface buildingRepository {
	List<BuildingEntity> Finall(BuildingSearchBuilder buildingSearchBuilder );

}
