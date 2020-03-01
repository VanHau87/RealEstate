package com.laptrinhjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.converter.NewsConverter;
import com.laptrinhjava.dto.NewsDTO;
import com.laptrinhjava.entity.NewsEntity;
import com.laptrinhjava.repository.NewsRepository;
import com.laptrinhjava.repository.impl.NewsRepositoryImpl;
import com.laptrinhjava.service.NewsService;

public class NewsServiceImpl implements NewsService {
	private NewsRepository newsRepository = new NewsRepositoryImpl();
	@Override
	public List<NewsDTO> findAllNews() {
		List<NewsDTO> dtos = new ArrayList<NewsDTO>();
		List<NewsEntity> entities = newsRepository.findAllNews();
		for (NewsEntity newsEntity : entities) {
			dtos.add(NewsConverter.entity2DTO(newsEntity));
		}
		return dtos;
	}

}
