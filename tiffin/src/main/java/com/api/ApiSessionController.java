package com.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ChangePasswordBean;
import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;
import com.services.MailService;
@RestController
public class ApiSessionController {
	
	@Autowired
	UserDao userDao;

	@Autowired
	MailService mailService;
	
//	@PostMapping("/login")
//	public LoginBean login(Model model) {
//
//		LoginBean loginBean = new LoginBean();// email password
//		model.addAttribute("loginBean", loginBean);
//		return loginBean;
//	}
	
	//login 
	@PostMapping("/api/authenticate")
	public ResponseBean<UserBean> authenticate(LoginBean loginBean, Model model, HttpSession session) {

		ResponseBean<UserBean> response = new ResponseBean<>();
		
		
		UserBean user = userDao.authenticate(loginBean.getEmail(), loginBean.getPassword());

		response.setData(user);
		
		if (user == null) {
			// login error
			response.setMsg("Invalid credentials");
			response.setStatusCode(-1);
		} else {
			 
			response.setMsg("Successfully loggedin");
			response.setStatusCode(200);
		}

		return response;
	}
	
	
	
	 
	//forgetpassword 
	@PostMapping("/api/retrive")
	public LoginBean retrive(LoginBean loginBean,Model model) {
		UserBean user = userDao.retrive(loginBean.getEmail());// dao -> method -> select -> userBean ->
		if(user == null) {
			return loginBean;// userBean null => error =>Forgotpassword.jsp
		}else {
			// userBean fill => mail // mailerservice -> send
			mailService.sendEmailForPassword(user.getEmailId(),user.getPassword());
			// success.jsp-> please check your mail
			return loginBean;
		}
		
	}
	
 
	//change password 
	@PostMapping("/api/updatePassword")
	public ChangePasswordBean updatePassword(ChangePasswordBean changePasswordBean) {
		//ResponseBean<UserBean> response = new ResponseBean<>();
		
 		 	userDao.updatePassword(changePasswordBean.getEmail(), changePasswordBean.getNewPassword());


		return changePasswordBean;
	}

	@PostMapping("/api/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return null;
	}

}
	

