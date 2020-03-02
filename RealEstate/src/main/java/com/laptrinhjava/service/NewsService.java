package com.laptrinhjava.service;

import java.util.List;

import com.laptrinhjava.dto.NewsDTO;

public interface NewsService {
	List<NewsDTO> findAllNews();
	void saveNews(NewsDTO dto);
}
