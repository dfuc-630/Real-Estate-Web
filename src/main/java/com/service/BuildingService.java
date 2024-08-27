package com.service;

import java.util.List;
import java.util.Map;

import com.Model.BuildingDTO;
import com.repository.ParamCatcher;

public interface BuildingService {
	List<BuildingDTO> Finall(Map<String, Object> param);

}
