package com.repository.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.builder.BuildingSearchBuilder;
import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Repository
@Primary
public class BuildingRepositoryImpl implements buildingRepository {
	@PersistenceContext
	private EntityManager entityManager ; 
	
	@Override 
	public List<BuildingEntity> Finall(BuildingSearchBuilder buildingSearchBuilder)
	{
		//JPQL 
//		String sql = "FROM BuildingEntity b WHERE b.name = 1 " ; 
//		Query query = entityManager.createQuery(sql, BuildingEntity.class) ; 
		
		//Sql Native:
		String sql = "SELECT * FROM building b WHERE b.name like '%building%'" ; 
		Query query = entityManager.createNativeQuery(sql, BuildingEntity.class) ; 
		return query.getResultList() ; 
	}
	
}
