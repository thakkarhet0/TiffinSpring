package com.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/newuser")
	public String callview(Model model) {
		UserBean userBean = new UserBean();
		model.addAttribute("userBean", userBean);
		System.out.println("newuser");
		return "NewUser";
	}

	@PostMapping("/adduser")
	public String addUser(@ModelAttribute("userBean") @Valid UserBean userBean, BindingResult result, Model model) {

		model.addAttribute("userBean", userBean);

		if (result.hasErrors()) {
			return "NewUser";
		} else {
			userDao.insertUser(userBean);
			System.out.println(userBean.getUserName());
			System.out.println(userBean.getRoleId());
			System.out.println(userBean.getPassword());
			System.out.println(userBean.getEmailId());
			System.out.println(userBean.getCity());
			System.out.println(userBean.getPhone());
 
		}
		return "redirect:/listuser";
	}

	@GetMapping("/listuser")
	public String listUser(Model model) {
		ArrayList<UserBean> users =  userDao.listUser();
		model.addAttribute("users",users);
		return "UserList";
	}

}
