package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.OrderBean;

@Repository
public class OrderDao {
	@Autowired
	JdbcTemplate stmt;

	public int insertOrder(OrderBean orderBean) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		stmt.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"insert into public.order (order_name,order_desc,order_status) values (?,?,?)",new String[] {"order_id"});

				ps.setString(1, orderBean.getOrderName());
				ps.setString(2, orderBean.getOrderDescription());
				ps.setString(3, orderBean.getOrderStatus());

				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();

 	}
	
	
	//add order detail 
	
	//

	public ArrayList<OrderBean> listOrder() {
		// TODO Auto-generated method stub
		ArrayList<OrderBean> orders = (ArrayList<OrderBean>) stmt
				.query("\"select o.order_id,o.order_name,o.order_desc,o.user_id,u.user_name from"
						+ " order o,user u where o.user_id = u.user_id\"", new OM());
		return orders;
	}

	class OM implements RowMapper<OrderBean> {

		@Override
		public OrderBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderBean order = new OrderBean();
			order.setOrderName(rs.getString("order_name"));
			order.setOrderDescription(rs.getString("order_desc"));
			order.setOrderStatus(rs.getString("order_status"));
			return order;
		}
	}

	public boolean deleteOrder(int orderId) {
		stmt.update("delete from order where order_id = ?", orderId);
		return true;
	}

	public OrderBean getDataByPk(int orderId) {

		OrderBean bean = null;
		bean = (OrderBean) stmt.queryForObject("select * from order where order_id = " + orderId,
				new BeanPropertyRowMapper(OrderBean.class));
		return bean;
	}

	public void updateOrder(OrderBean orderBean) {

		stmt.update("update order set order_status  = ? where order_id  = ?",
				orderBean.getOrderStatus(),
				orderBean.getOrderId());

	}

}
