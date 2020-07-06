package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.SubcategoryBean;

@Repository
public class SubcategoryDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertSubcategory(SubcategoryBean subcategoryBean) {
		stmt.update("insert into subcategory (subcategory_name,subcategory_description,category_id) values (?,?,?) ",
				subcategoryBean.getSubcategoryName(), subcategoryBean.getSubcategoryDescription(),
				subcategoryBean.getCategoryId());

	}

	public ArrayList<SubcategoryBean> listSubcategory() {
		// TODO Auto-generated method stub
		ArrayList<SubcategoryBean> subcategorys = (ArrayList<SubcategoryBean>) stmt.query(
				"select s.subcategory_id,s.subcategory_name,s.subcategory_description,s.category_id,c.category_name from subcategory s,category c where s.category_id = c.category_id",
				new SM());
		return subcategorys;
	}

	class SM implements RowMapper<SubcategoryBean> {

		@Override
		public SubcategoryBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			SubcategoryBean subcategory = new SubcategoryBean();
			subcategory.setSubcategoryId(rs.getInt("subcategory_id"));
			subcategory.setCategoryId(rs.getInt("category_id"));
			subcategory.setSubcategoryName(rs.getString("subcategory_name"));
			subcategory.setSubcategoryDescription(rs.getString("subcategory_description"));
			subcategory.setCategoryName(rs.getString("category_name"));
			return subcategory;
		}
	}

	public boolean deleteSubcategory(int subcategoryId) {
		stmt.update("delete from subcategory where subcategory_id = ?", subcategoryId);
		return true;
	}

	public SubcategoryBean getDataByPk(int subcategoryId) {

		SubcategoryBean bean = null;
		bean = (SubcategoryBean) stmt.queryForObject(
				"select * from subcategory where subcategory_id = " + subcategoryId,
				new BeanPropertyRowMapper(SubcategoryBean.class));
		return bean;
	}

	public void updateSubcategory(SubcategoryBean subcategoryBean) {

		stmt.update("update subcategory set subcategory_name = ? , subcategory_description = ? ,category_id = ? where subcategory_id  = ?",
				subcategoryBean.getSubcategoryName(), subcategoryBean.getSubcategoryDescription(),subcategoryBean.getCategoryId(),
				subcategoryBean.getSubcategoryId());

	}

}
