package com.laptrinhjava.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjava.dto.NewsDTO;
import com.laptrinhjava.entity.NewsEntity;

public class NewsConverter {
	private static ModelMapper modelMapper = new ModelMapper();
	public static NewsDTO entity2DTO(NewsEntity entity) {
		return modelMapper.map(entity, NewsDTO.class);
	}
	public static NewsEntity dto2Entity(NewsDTO dto) {
		return modelMapper.map(dto, NewsEntity.class);
	}
}
