package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.ChangePasswordBean;
import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.services.MailService;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@Autowired
	MailService mailService;

	@GetMapping("/login")
	public String login(Model model) {

		LoginBean loginBean = new LoginBean();// email password
		model.addAttribute("loginBean", loginBean);
		return "Login";
	}

	@PostMapping("/authenticate")
	public String authenticate(LoginBean loginBean, Model model, HttpSession session) {

		UserBean user = userDao.authenticate(loginBean.getEmail(), loginBean.getPassword());
		if (user == null) {
			// login error
			model.addAttribute("error", "Invalid Credentials");
			return "Login";
		} else {
			session.setAttribute("user", user);
			if (user.getRoleId() == 1) {
				return "AdminDashboard";
			} else if (user.getRoleId() == 2) {
				return "Home";
			} else if (user.getRoleId() == 3) {
				return "DelHome";
			} else if (user.getRoleId() == 4) {
				return "VendorHome";
			}
		}
		return "Error";
	}

	@GetMapping("/forgotpassword")
	public String forgotpassword(Model model) {
		LoginBean loginBean = new LoginBean();
		model.addAttribute("loginBean", loginBean);
		return "ForgotPassword";
	}

	@PostMapping("/retrive")
	public String retrive(LoginBean loginBean,Model model) {
		UserBean user = userDao.retrive(loginBean.getEmail());// dao -> method -> select -> userBean ->
		if(user == null) {
			return "ForgotPassword";// userBean null => error =>Forgotpassword.jsp
		}else {
			// userBean fill => mail // mailerservice -> send
			mailService.sendEmailForPassword(user.getEmailId(),user.getPassword());
			// success.jsp-> please check your mail
			return "Success";
		}
		
	}

	@GetMapping("/changepassword")
	public String changePassword(Model model) {
		ChangePasswordBean changePasswordBean = new ChangePasswordBean();
		model.addAttribute("changePasswordBean", changePasswordBean);
		return "ChangePassword";
	}

	@PostMapping("/updatePassword")
	public String updatePassword(ChangePasswordBean changePasswordBean, HttpSession session, Model model) {
		UserBean user = (UserBean) session.getAttribute("user");

		if (user.getPassword().equals(changePasswordBean.getOldPassword())) {
			userDao.updatePassword(user.getEmailId(), changePasswordBean.getNewPassword());
		} else {
			model.addAttribute("error", "Old Password is incorrect!!");
			return "ChangePassword";
		}
		model.addAttribute("error", "Password Successfully updated!!!");

		return "ChangePassword";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("signup")
		public String signup() {
			return "signup";
		}
	}

