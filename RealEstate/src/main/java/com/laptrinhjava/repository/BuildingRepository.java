package com.laptrinhjava.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjava.builder.BuildingSearchBuilder;
import com.laptrinhjava.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity> {
	List<BuildingEntity> findBuildingByBuilder(Map<String, Object> params, BuildingSearchBuilder builder);

	BuildingEntity findById(int id);

}
