package com.laptrinhjava;

import java.util.List;

import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.dto.NewsDTO;
import com.laptrinhjava.service.CategoryService;
import com.laptrinhjava.service.NewsService;
import com.laptrinhjava.service.impl.CategoryServiceImpl;
import com.laptrinhjava.service.impl.NewsServiceImpl;

public class EstateApplication {
	
	public static void main(String[] args) {
		CategoryService categoryService = new CategoryServiceImpl();
		/*
		List<CategoryDTO> results = categoryService.findAll();
		for (CategoryDTO categoryDTO : results) {
			System.out.println(categoryDTO.getCode());
			System.out.println(categoryDTO.getName());
		}*/
		NewsService newsService = new NewsServiceImpl();
		List<NewsDTO> results = newsService.findAllNews();
		for (NewsDTO newsDTO : results) {
			System.out.println(newsDTO.getNewsId());
			System.out.println(newsDTO.getTitle());
			System.out.println(newsDTO.getShortDescription());
			System.out.println(newsDTO.getContent());
			System.out.println("**************");
		}
	}
}
