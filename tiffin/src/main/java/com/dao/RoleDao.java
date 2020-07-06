package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;
import com.bean.RoleBean;

@Repository
public class RoleDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertRole(RoleBean roleBean) {
		stmt.update("insert into role (role_name) values (?) ", roleBean.getRoleName());

	}

	public ArrayList<RoleBean> listRole() {
		// TODO Auto-generated method stub
		ArrayList<RoleBean> roles = (ArrayList<RoleBean>) stmt.query("select * from role", new RM());
		return roles;
	}

	class RM implements RowMapper<RoleBean> {

		@Override
		public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleBean role = new RoleBean();
			role.setRoleName(rs.getString("role_name"));
			role.setRoleId(rs.getInt("role_id"));
			return role;
		}
	}
	public boolean deleteRole(int roleId) {
		stmt.update("delete from role where role_id = ?", roleId);
		return true;
	}

	public RoleBean getDataByPk(int roleId) {

		RoleBean bean = null;
		bean = (RoleBean) stmt.queryForObject("select * from role where role_id = " + roleId,
				new BeanPropertyRowMapper(RoleBean.class));
		return bean;
	}

	public void updateRole(RoleBean roleBean) {

		stmt.update("update role set role_name = ? where role_id  = ?",
				roleBean.getRoleName(),  roleBean.getRoleId());

	}

}
