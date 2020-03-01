package com.laptrinhjava.repository;

import java.util.List;

import com.laptrinhjava.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity> {
	List<NewsEntity> findAllNews();
	void saveNews(NewsEntity entity);
}
