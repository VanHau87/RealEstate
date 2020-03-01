package com.laptrinhjava.converter;

import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.entity.CategoryEntity;

public class CategoryConverter {
	
	public static CategoryDTO entity2DTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setCatId(entity.getCatId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		return dto;
	}
	public static CategoryEntity dto2Entity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		if (dto.getCatId() != null) {
			entity.setCatId(dto.getCatId());
		}
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}
}
