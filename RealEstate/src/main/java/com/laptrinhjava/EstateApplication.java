package com.laptrinhjava;

import java.util.List;

import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.service.CategoryService;
import com.laptrinhjava.service.impl.CategoryServiceImpl;

public class EstateApplication {
	
	public static void main(String[] args) {
		CategoryService categoryService = new CategoryServiceImpl();
		List<CategoryDTO> results = categoryService.findAll();
		for (CategoryDTO categoryDTO : results) {
			System.out.println(categoryDTO.getCode());
			System.out.println(categoryDTO.getName());
		}
	}
}
