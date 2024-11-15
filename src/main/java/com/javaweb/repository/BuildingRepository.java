package com.javaweb.repository;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer>, BuildingRepositoryCustom {
//    void deleteByIdIn(List<Integer> ids) ;
//    List<BuildingEntity> findByNameContaining(String s) ;
//    List<BuildingEntity> findByNameContainingAndStreet(String name, String street) ;
}
