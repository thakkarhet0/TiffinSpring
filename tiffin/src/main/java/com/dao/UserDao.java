package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;

	public void insertUser(UserBean userBean) {
		
		
		
		
		
		
		
		stmt.update("insert into public.user (user_name,password,address,email_id,city,contact,roleid) values (?,?,?,?,?,?,?) ",
				userBean.getUserName(), userBean.getPassword(), userBean.getAddress(), userBean.getEmailId(),
				userBean.getCity(), userBean.getPhone(),userBean.getRoleId());

	}

	public ArrayList<UserBean> listUser() {
		// TODO Auto-generated method stub
		ArrayList<UserBean> users = (ArrayList<UserBean>) stmt.query("select * from public.user", new UM());
		return users;
	}

	class UM implements RowMapper<UserBean> {

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean user = new UserBean();
			user.setUserId(rs.getInt("user_id"));
			user.setRoleId(rs.getInt("roleid"));
			user.setUserName(rs.getString("user_name"));
			user.setPassword(rs.getString("password"));
			user.setAddress(rs.getString("address"));
			user.setEmailId(rs.getString("email_id"));
			user.setCity(rs.getString("city"));
			user.setPhone(rs.getString("contact"));
			return user;
		}
	}

	public UserBean authenticate(String email, String password) {
		UserBean user = null;
		try {
		user = stmt.queryForObject("select * from public.user where email_id = '"+email+"' and password = '"+password+"'", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		System.out.println(user);
		}catch(Exception e) {
			System.out.println("invalid user"+user);
		}
		return user;
	}

	public void updatePassword(String email, String newPassword) {
 		stmt.update("update public.user set password = ? where email_id = ?",newPassword,email);
		
	}
	public UserBean retrive(String email) {
		UserBean user =null;
		try {
			user = stmt.queryForObject("select * from public.user where email_id = '"+email+ "'", new BeanPropertyRowMapper<UserBean>(UserBean.class));
			System.out.println(user);
		}catch(Exception x) {
			System.out.println("invalid email id"+user);
		}
		return user;
	}

}
