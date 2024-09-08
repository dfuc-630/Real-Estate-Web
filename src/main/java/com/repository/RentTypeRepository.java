package com.repository;

import java.util.List;

import com.repository.entity.RentAreaEntity;

public interface RentTypeRepository {
	List<RentAreaEntity>  FindAreaById(Integer id) ; 
}
