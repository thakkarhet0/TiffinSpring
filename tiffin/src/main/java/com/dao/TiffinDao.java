package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.TiffinBean;
import com.bean.TiffinBean;


@Repository
public class TiffinDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertTiffin(TiffinBean tiffinBean) {
		stmt.update("insert into public.tiffin (tiffin_name,tiffin_desc,amount,is_active) values (?,?,?,?)", tiffinBean.getTiffinName(),tiffinBean.getTiffinDescription(),
				tiffinBean.getAmount(),tiffinBean.isTiffinActive());

	}

	public ArrayList<TiffinBean> listTiffin() {
		// TODO Auto-generated method stub
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
	public boolean deleteTiffin(int tiffinId) {
		stmt.update("delete from tiffin where tiffin_id = ?", tiffinId);
		return true;
	}

	public TiffinBean getDataByPk(int tiffinId) {

		TiffinBean bean = null;
		bean = (TiffinBean) stmt.queryForObject("select * from tiffin where tiffin_id = " + tiffinId,
				new TM());
		return bean;
	}
	
	public void updateTiffin(TiffinBean tiffinBean) {

		stmt.update("update tiffin set tiffin_name = ?, tiffin_desc = ?,amount = ?, is_active = ?  where tiffin_id  = ?",
				tiffinBean.getTiffinName(),tiffinBean.getTiffinDescription(), tiffinBean.getAmount(),tiffinBean.isTiffinActive(), tiffinBean.getTiffinId());

	}

}
