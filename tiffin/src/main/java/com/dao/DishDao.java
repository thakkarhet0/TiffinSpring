package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.DishBean;
import com.dao.DishDao;

@Repository
public class DishDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertDish(DishBean dishBean) {
		stmt.update("insert into Dish (dish_name,dish_desc,dish_is_active) values (?,?,?) ", dishBean.getDishName(),
				dishBean.getDishDescription(),dishBean.isDishactive());

	}
	public ArrayList<DishBean> listDish() {
		// TODO Auto-generated method stub
		ArrayList<DishBean> dishes = (ArrayList<DishBean>) stmt.query("select * from Dish", new DM());
		return dishes;
	}
	class DM implements RowMapper<DishBean> {

		@Override
		public DishBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DishBean dish = new DishBean();
			dish.setDishId(rs.getInt("dish_id"));
			dish.setDishName(rs.getString("dish_name"));
			dish.setDishDescription(rs.getString("dish_desc"));
			dish.setDishactive(rs.getBoolean("dish_is_active"));
			return dish;
		}
	}
	
	public boolean deleteDish(int dishId) {
		stmt.update("delete from dish where dish_id = ?", dishId);
		return true;
	}

	public DishBean getDataByPk(int dishId) {

		DishBean bean = null;
		bean = (DishBean) stmt.queryForObject("select * from dish where dish_id = " + dishId,
				new DM());
		return bean;
	}
	
	public void updateDish(DishBean dishBean) {

		stmt.update("update dish set dish_name = ?, dish_desc = ?, dish_is_active = ?  where dish_id  = ?",
				dishBean.getDishName(),dishBean.getDishDescription(), dishBean.isDishactive(), dishBean.getDishId());

	}


}