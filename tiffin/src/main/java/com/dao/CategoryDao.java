package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.bean.CategoryBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertCategory(CategoryBean categoryBean) {
		stmt.update("insert into category (category_name,is_active) values (?,?) ", categoryBean.getCategoryName(),
				categoryBean.isActive());
		System.out.println("dao => "+categoryBean.isActive());
	}

	public ArrayList<CategoryBean> listCategory() {
		// TODO Auto-generated method stub
		ArrayList<CategoryBean> categories = (ArrayList<CategoryBean>) stmt.query("select * from Category where is_active = true ", new CM());
		return categories;
	}

	class CM implements RowMapper<CategoryBean> {

		@Override
		public CategoryBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategoryBean Category = new CategoryBean();
			Category.setCategoryName(rs.getString("Category_name"));
			Category.setCategoryId(rs.getInt("Category_id"));
			Category.setActive(rs.getBoolean("is_active"));
			return Category;
		}
	}

	public boolean deleteCategory(int categoryId) {
		stmt.update("delete from category where category_id = ?", categoryId);
		return true;
	}

	public CategoryBean getDataByPk(int categoryId) {

		CategoryBean bean = null;
		bean = (CategoryBean) stmt.queryForObject("select * from category where category_id = " + categoryId,
				new CM());
		return bean;
	}

	public void updateCategory(CategoryBean categoryBean) {

		stmt.update("update category set category_name = ? , is_active = ?  where category_id  = ?",
				categoryBean.getCategoryName(), categoryBean.isActive(), categoryBean.getCategoryId());

	}
}
