package com.laptrinhjava.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.annotation.Table;
import com.laptrinhjava.mapper.ResultSetMapper;
import com.laptrinhjava.repository.EntityManagerFactory;
import com.laptrinhjava.repository.JpaRepository;

public class JpaRepositoryImpl<T> implements JpaRepository<T> {
	
	private Class<T> zClass;
	
	@SuppressWarnings("unchecked")
	public JpaRepositoryImpl() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	@Override
	public List<T> findAll() {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String tableName = "";
		if (connection != null) {
			try {
				if (zClass.isAnnotationPresent(Table.class)) {
					tableName = zClass.getAnnotation(Table.class).name();
				}
				StringBuilder sql = new StringBuilder("SELECT * FROM ");
				sql.append(tableName);
				statement = connection.prepareStatement(sql.toString());
				resultSet = statement.executeQuery();
				return resultSetMapper.mapRow(resultSet, zClass);
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
