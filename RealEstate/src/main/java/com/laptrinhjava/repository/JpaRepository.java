package com.laptrinhjava.repository;

import java.util.List;
import java.util.Map;

public interface JpaRepository<T> {
	List<T> findAll(Map<String, Object> params, Object ...where);
	List<T> findAll(String sql);
	void insert(String sql, Object ...objects);
	void insert(Object object);
	T findById(String columnName, int id);
	void update(Map<String, String> mapValueUpdate, Long id);
	void delete(Long id);
}
