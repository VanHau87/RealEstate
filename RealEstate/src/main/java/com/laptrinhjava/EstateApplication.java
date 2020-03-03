package com.laptrinhjava;

import java.util.List;

import com.laptrinhjava.builder.BuildingSearchBuilder;
import com.laptrinhjava.dto.BuildingDTO;
import com.laptrinhjava.dto.CategoryDTO;
import com.laptrinhjava.dto.NewsDTO;
import com.laptrinhjava.service.BuildingService;
import com.laptrinhjava.service.CategoryService;
import com.laptrinhjava.service.NewsService;
import com.laptrinhjava.service.impl.BuildingServiceImpl;
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
		CategoryDTO dto = new CategoryDTO();
		dto.setCode("phap-luat");
		dto.setName("Pháp luật");
		categoryService.saveCategory(dto);
		
		NewsService newsService = new NewsServiceImpl();
		/*
		List<NewsDTO> results = newsService.findAllNews();
		for (NewsDTO newsDTO : results) {
			System.out.println(newsDTO.getNewsId());
			System.out.println(newsDTO.getTitle());
			System.out.println(newsDTO.getShortDescription());
			System.out.println(newsDTO.getContent());
			System.out.println("**************");
		}*/
		/*
		NewsDTO dtoNews = new NewsDTO();
		dtoNews.setTitle("Xã hội học");
		dtoNews.setShortDescription("Miêu tả xhh");
		dtoNews.setContent("Nội dung xã hội học");
		newsService.saveNews(dtoNews);
		*/
		BuildingService buildingService = new BuildingServiceImpl();
		String name = "tower";
		String district = "";
		String numberOfBasement = "2";
		String floorArea = "";
		String[] types = new String[] {"TANG_TRET", "NGUYEN_CAN"};
		String rentAreaFrom = "100";
		String rentAreaTo = "650";
		String rentCostFrom = "10";
		String rentCostTo = "25";
		Integer staffId = 1;
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				.setName(name)
				.setDistrict(district)
				.setNumberOfBasement(numberOfBasement)
				.setFloorArea(floorArea)
				.setRentAreaFrom(rentAreaFrom)
				.setRentAreaTo(rentAreaTo)
				.setRentCostFrom(rentCostFrom)
				.setRentCostTo(rentCostTo)
				.setTypes(types)
				.setStaffId(staffId)
				.build();
		List<BuildingDTO> results = buildingService.findByBuilder(builder);
		for (BuildingDTO buildingDTO : results) {
			System.out.println(buildingDTO.getName());
			System.out.println(buildingDTO.getCreatedDate());
		}
	}
}
