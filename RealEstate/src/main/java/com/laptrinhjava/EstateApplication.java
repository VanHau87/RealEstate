package com.laptrinhjava;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		/*
		 * CategoryService categoryService = new CategoryServiceImpl();
		List<CategoryDTO> results = categoryService.findAll();
		for (CategoryDTO categoryDTO : results) {
			System.out.println(categoryDTO.getCode());
			System.out.println(categoryDTO.getName());
		}*/
		/*
		CategoryDTO dto = new CategoryDTO();
		dto.setCode("phap-luat");
		dto.setName("Pháp luật");
		categoryService.saveCategory(dto);
		*/
		
		/*
		 * NewsService newsService = new NewsServiceImpl();
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
		/*
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
		*/
		
		//FIND BY ID and UPDATE
		/*
		int id = 6;
		BuildingDTO dto = buildingService.findById(id);
		System.out.println(dto.getName());
		System.out.println(dto.getWard());
		
		dto.setName("Number Two Building Tower");
		dto.setWard("Phường 10");
		Map<String, String> mapValueUpdate = new HashMap<String, String>();
		mapValueUpdate.put("name", dto.getName());
		mapValueUpdate.put("ward", dto.getWard());
		buildingService.updateBuilding(mapValueUpdate, dto.getBuildingId());
		System.out.println("done");
		*/
		/*DELETE BY ID
		Long buildingid = 5L;
		buildingService.deleteBuilding(buildingid);
		System.out.println("delete thành công");
		*/
		//DELETE BY PROPERTY
		String property = "type";
		Object value = "NGUYEN_CAN";
		buildingService.deleteByProperty(property, value);
		System.out.println("delete thành công");
		/*
		BuildingDTO dto = new BuildingDTO();
		dto.setName("ABCD Tower");
		dto.setDistrict("Phường 2");
		dto.setStreet("108 Lý Chính Thắng");
		dto.setNumberOfBasement(2);
		dto.setFloorarea(500);
		dto.setRentCost(10);
		dto.setCostDescription("10 triệu/m2");
		dto.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		dto.setCreatedBy("Nhân viên A");
		BuildingService buildingService = new BuildingServiceImpl();
		buildingService.saveBuilding(dto);
		*/
	}
}




