package com.repository.custom;

import java.util.List;

import com.builder.BuildingSearchBuilder;
import com.repository.entity.BuildingEntity;

//@Repository
public interface BuildingRepositoryCustom {
	List<BuildingEntity> Finall(BuildingSearchBuilder buildingSearchBuilder) ; 
}
