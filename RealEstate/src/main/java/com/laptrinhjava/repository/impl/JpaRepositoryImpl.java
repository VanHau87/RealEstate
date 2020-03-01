package com.laptrinhjava.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.mapper.RowMapper;
import com.laptrinhjava.repository.EntityManagerFactory;
import com.laptrinhjava.repository.JpaRepository;

public class JpaRepositoryImpl<T> implements JpaRepository<T> {

	@Override
	public List<T> findAll(String sql, RowMapper<T> rowMapper) {
		List<T> entities = new ArrayList<T>();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					entities.add(rowMapper.mapRow(resultSet));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return new ArrayList<T>();
			} finally {
				try {
					if (resultSet != null) {
						resultSet.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return new ArrayList<T>();
				}
				
			}
		}
		return null;
	}
	
}
