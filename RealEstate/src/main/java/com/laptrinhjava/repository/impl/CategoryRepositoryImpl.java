package com.laptrinhjava.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjava.entity.CategoryEntity;
import com.laptrinhjava.repository.CategoryRepository;
import com.laptrinhjava.repository.EntityManagerFactory;

public class CategoryRepositoryImpl implements CategoryRepository {

	@Override
	public List<CategoryEntity> findAll() {
		/*Login code:
		 * 	- execute query statement => get data and put into ResultSet
		 *  - go into ResultSet, loop through every row
		 *  	- in row: get value in every column (based on the column name) => put into properties of java object 
		 * */
		List<CategoryEntity> entities = new ArrayList<CategoryEntity>();
		Connection connection = EntityManagerFactory.getConnection();
		String sql = "SELECT * FROM category";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					CategoryEntity entity = new CategoryEntity();
					entity.setCatId(resultSet.getInt("catid"));
					entity.setCode(resultSet.getString("code"));
					entity.setName(resultSet.getString("name"));
					entities.add(entity);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return new ArrayList<CategoryEntity>();
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
					return new ArrayList<CategoryEntity>();
				}
				
			}
		}
		return entities;
	}

	@Override
	public void saveCategory(CategoryEntity entity) {
		Connection connection = EntityManagerFactory.getConnection();;
		PreparedStatement statement = null;
		String sql = "INSERT INTO category(code, name) VALUES(?, ?)";
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setString(1, entity.getCode());
			statement.setString(2, entity.getName());
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
