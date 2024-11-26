package com.javaweb.service;

import com.javaweb.entity.AssignBuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignBuildingService {
    void deleteByBuildingIn(List<Integer> ids) ;
}
