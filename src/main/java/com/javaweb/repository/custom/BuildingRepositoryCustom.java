package com.javaweb.repository.custom;
import java.util.List;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) ;
}