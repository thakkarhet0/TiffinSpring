package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.DeliveryBean;

@Repository
public class DeliveryDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertDelivery(DeliveryBean deliveryBean) {
		stmt.update("insert into delivery (delivery_name,delivery_status) values (?,?) ", deliveryBean.getDeliveryName(),
				deliveryBean.getDeliveryStatus());

	}

	public ArrayList<DeliveryBean> listDelivery() {
		// TODO Auto-generated method stub
		ArrayList<DeliveryBean> deliverys = (ArrayList<DeliveryBean>) stmt.query("select * from delivery", new DEM());
		return deliverys;
	}

	class DEM implements RowMapper<DeliveryBean> {

		@Override
		public DeliveryBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeliveryBean delivery = new DeliveryBean();
			delivery.setDeliveryName(rs.getString("delivery_name"));
			delivery.setDeliveryStatus(rs.getInt("delivery_status"));
			return delivery;
		}
	}

}
