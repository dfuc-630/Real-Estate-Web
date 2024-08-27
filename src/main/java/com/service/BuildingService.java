package com.service;

import java.util.List;
import java.util.Map;

import com.Model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> Finall(Map<String, Object> param, List<String> buildingtypecode);

}
