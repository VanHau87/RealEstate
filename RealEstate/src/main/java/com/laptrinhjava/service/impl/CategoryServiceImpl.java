package com.laptrinhjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.converter.CategoryConverter;
import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.entity.CategoryEntity;
import com.laptrinhjava.repository.CategoryRepository;
import com.laptrinhjava.repository.impl.CategoryRepositoryImpl;
import com.laptrinhjava.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository = new CategoryRepositoryImpl();
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		entities.stream().map(item -> CategoryConverter.entity2DTO(item))
		.forEach(item ->dtos.add(item));
		return dtos;
	}

	@Override
	public void saveCategory(CategoryDTO dto) {
		categoryRepository.saveCategory(CategoryConverter.dto2Entity(dto));
	}

}
