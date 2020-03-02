package com.laptrinhjava.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.annotation.Column;
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

	@Override
	public void insert(String sql, Object... objects) {
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			int index = 1;
			for (Object object : objects) {
				statement.setObject(index, object);
				index++;
			}
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}	
	}

	@Override
	public void insert(Object object) {
		StringBuilder sql = createSQLInsert();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql.toString());
			//convert object => object class
			Class<?> aClass = object.getClass();
			int index = 1;
			Field[] fields = aClass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				statement.setObject(index, field.get(object));
				index++;
			}
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}

	private StringBuilder createSQLInsert() {
		StringBuilder sql = new StringBuilder("INSERT INTO ");
		String tableName = "";
		StringBuilder fields = new StringBuilder();
		StringBuilder params = new StringBuilder();
		if (zClass.isAnnotationPresent(Table.class)) {
			tableName = zClass.getAnnotation(Table.class).name();
		}
		Field[] fieldsOfClass = zClass.getDeclaredFields();
		for (Field field : fieldsOfClass) {
			String columnName = field.getAnnotation(Column.class).name();
			if (fields.length() > 0) {
				fields.append(",");
				params.append(",");
			}
			fields.append(columnName);
			params.append("?");
		}
		sql.append(tableName);
		sql.append("(").append(fields.toString()).append(")");
		sql.append(" VALUES(").append(params.toString()).append(")");
		return sql;
	}
}
