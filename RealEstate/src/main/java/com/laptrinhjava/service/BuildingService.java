package com.laptrinhjava.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjava.builder.BuildingSearchBuilder;
import com.laptrinhjava.dto.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findByBuilder(BuildingSearchBuilder builder);
	void saveBuilding(BuildingDTO dto);
	BuildingDTO findById(int id);
	void updateBuilding(Map<String, String> mapValueUpdate, Long id);
	void deleteBuilding(Long buildingid);
}
