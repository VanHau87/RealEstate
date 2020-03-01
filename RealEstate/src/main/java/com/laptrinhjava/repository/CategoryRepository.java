package com.laptrinhjava.repository;

import java.util.List;

import com.laptrinhjava.entity.CategoryEntity;

public interface CategoryRepository {
	List<CategoryEntity> findAll();
}
