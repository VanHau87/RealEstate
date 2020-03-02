package com.laptrinhjava.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjava.dto.BuildingDTO;
import com.laptrinhjava.entity.BuildingEntity;

public class BuildingConverter {
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static BuildingEntity dto2Entity(BuildingDTO dto) {
		return modelMapper.map(dto, BuildingEntity.class);
	}
	public static BuildingDTO entity2DTO(BuildingEntity entity) {
		return modelMapper.map(entity, BuildingDTO.class);
	}
}
