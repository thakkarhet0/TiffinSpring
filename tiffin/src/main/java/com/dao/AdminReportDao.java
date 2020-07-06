package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.TiffinBean;
import com.dao.TiffinDao.TM;

@Repository
public class AdminReportDao {

	@Autowired
	JdbcTemplate stmt;

	public ArrayList<TiffinBean> getTiffins() {

		ArrayList<TiffinBean> tiffins = (ArrayList<TiffinBean>) stmt.query("select * from tiffin", new TM());
		return tiffins;
	}

	class TM implements RowMapper<TiffinBean> {

		@Override
		public TiffinBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TiffinBean tiffin = new TiffinBean();
			tiffin.setTiffinId(rs.getInt("tiffin_id"));
			tiffin.setTiffinName(rs.getString("tiffin_name"));
			tiffin.setTiffinDescription(rs.getString("tiffin_desc"));
			tiffin.setAmount(rs.getInt("amount"));
			tiffin.setTiffinActive(rs.getBoolean("is_active"));
			return tiffin;
		}
	}

}
