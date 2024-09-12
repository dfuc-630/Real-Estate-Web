package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repository.custom.BuildingRepositoryCustom;
import com.repository.entity.BuildingEntity;

public interface buildingRepository extends JpaRepository<BuildingEntity, Integer>, BuildingRepositoryCustom{
//	List<BuildingEntity> Finall(BuildingSearchBuilder buildingSearchBuilder );
	void deleteByIdIn(List<Integer> ids) ; 
	List<BuildingEntity> findByNameContaining(String s) ; 
	List<BuildingEntity> findByNameContainingAndStreet(String name, String street) ; 
}
