package com.laptrinhjava.repository;

import java.util.List;

import com.laptrinhjava.mapper.RowMapper;

public interface JpaRepository<T> {
	List<T> findAll(String sql, RowMapper<T> rowMapper);
}
