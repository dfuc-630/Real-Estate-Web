package com.repository;

import java.util.List;
import java.util.Map;

import com.repository.entity.BuildingEntity;

public interface buildingRepository {
	List<BuildingEntity> Finall(Map<String, Object> param);

}
