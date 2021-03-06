package com.laptrinhjava.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjava.builder.BuildingSearchBuilder;
import com.laptrinhjava.converter.BuildingConverter;
import com.laptrinhjava.dto.BuildingDTO;
import com.laptrinhjava.entity.BuildingEntity;
import com.laptrinhjava.repository.BuildingRepository;
import com.laptrinhjava.repository.impl.BuildingRepositoryImpl;
import com.laptrinhjava.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
	private BuildingRepository buildingRepository = new BuildingRepositoryImpl();
	@Override
	public List<BuildingDTO> findByBuilder(BuildingSearchBuilder builder) {
		/*
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", builder.getName());
		params.put("district", builder.getDistrict());
		params.put("numberOfBasement", 
				(StringUtils.isNotBlank(builder.getNumberOfBasement()))? Integer.parseInt(builder.getNumberOfBasement()): null);
		params.put("floorArea", 
				(StringUtils.isNotBlank(builder.getFloorArea()))? Integer.parseInt(builder.getFloorArea()): null);
		*/
		Map<String, Object> params = convertToMapProperties(builder);
		List<BuildingEntity> entities = buildingRepository.findBuildingByBuilder(params, builder);
		List<BuildingDTO> dtos = entities.stream().map(item -> BuildingConverter.entity2DTO(item))
				.collect(Collectors.toList());
		return dtos;
	}
	private Map<String, Object> convertToMapProperties(BuildingSearchBuilder builder) {
		Map<String, Object> properties = new HashMap<String, Object>();
		Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
		for (Field field : fields) {
			try {
				if (!field.getName().startsWith("rent") && !field.getName().equals("types")
						&& !field.getName().equals("staffId")) {
					field.setAccessible(true);
					if (field.get(builder) instanceof String) {
						properties.put(field.getName().toLowerCase(), field.get(builder));
					} else {
						Object value = (field.get(builder)!=null && StringUtils.isNotEmpty(field.get(builder).toString())) 
								? Integer.parseInt(field.get(builder).toString()) : null;
						properties.put(field.getName().toLowerCase(), value);
					}	
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	@Override
	public void saveBuilding(BuildingDTO dto) {
		buildingRepository.insert(BuildingConverter.dto2Entity(dto));	
	}
	@Override
	public BuildingDTO findById(int id) {
		BuildingEntity entity = buildingRepository.findById(id);
		return BuildingConverter.entity2DTO(entity);
	}
	@Override
	public void updateBuilding(Map<String, String> mapValueUpdate, Long id) {
		buildingRepository.update(mapValueUpdate, id);
		
	}
	@Override
	public void deleteBuilding(Long buildingid) {
		buildingRepository.delete(buildingid);
	}
	@Override
	public void deleteByProperty(String property, Object value) {
		buildingRepository.deleteByProperty(property, value);
		
	}

}
