package com.repository;

import java.util.List;

import com.repository.entity.RentTypeEntity;

public interface RentTypeRepository {
	List<RentTypeEntity>  FindAreaById(Integer id) ; 
}
