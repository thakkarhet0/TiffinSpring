package com.api;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class ApiUserController {
	@Autowired
	UserDao userDao;
 
	
	
	//signup 
	@PostMapping("/api/adduser")
	public ResponseBean<UserBean> addUser(@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result, Model model) {

		ResponseBean<UserBean> response = new ResponseBean<>();

		response.setData(userBean);
		if (result.hasErrors()) {

			response.setMsg("Something went wrong please try again!!!");
			response.setStatusCode(-1);
		} else {
			userDao.insertUser(userBean);
			System.out.println(userBean.getUserName());
			System.out.println(userBean.getRoleId());
			System.out.println(userBean.getPassword());
			
			System.out.println(userBean.getEmailId());
			System.out.println(userBean.getCity());
			System.out.println(userBean.getPhone());
			response.setMsg("User Added Successfully");
			response.setStatusCode(1);
		}

		return response;
	}

	@GetMapping("/api/listuser")
	public ResponseBean<ArrayList<UserBean>> listUser() {
		
		
		ResponseBean<ArrayList<UserBean>>  responseBean = new ResponseBean<>();
		ArrayList<UserBean> users =  userDao.listUser();
		responseBean.setData(users);
		responseBean.setMsg("list successfully retrived");
		responseBean.setStatusCode(1);
		
		return responseBean;
	}

}


