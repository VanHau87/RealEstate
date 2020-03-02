package com.laptrinhjava.repository;

import java.util.List;

public interface JpaRepository<T> {
	List<T> findAll();
	void insert(String sql, Object ...objects);
	void insert(Object object);
}
