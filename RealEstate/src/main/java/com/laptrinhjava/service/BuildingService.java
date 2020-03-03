package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.builder.BuildingSearchBuilder;
import com.laptrinhjava.dto.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findByBuilder(BuildingSearchBuilder builder);
}
