package com.laptrinhjava.repository.impl;

import java.util.List;

import com.laptrinhjava.entity.NewsEntity;
import com.laptrinhjava.repository.NewsRepository;

public class NewsRepositoryImpl extends JpaRepositoryImpl<NewsEntity> implements NewsRepository{

	@Override
	public List<NewsEntity> findAllNews() {
		return super.findAll();
	}
	
}
