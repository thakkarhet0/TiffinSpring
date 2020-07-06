package com.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.RoleBean;
import com.bean.RoleBean;
import com.dao.RoleDao;

@Controller
public class RoleController {

	@Autowired
	RoleDao roleDao;

	@GetMapping("/newrole")
	public String callview(Model model) {
		RoleBean roleBean = new RoleBean();
		model.addAttribute("roleBean", roleBean);
		System.out.println("newrole");
		return "NewRole";
	}
	
	@GetMapping("/editrole/{id}")
	public String callview(@PathVariable("id") int id, Model model) {
		RoleBean roleBean = roleDao.getDataByPk(id);
		model.addAttribute("roleBean", roleBean);
		return "EditRole";
	}

	@PostMapping("/addrole")
	public String addRole(@ModelAttribute("roleBean") @Valid RoleBean roleBean, BindingResult result, Model model) {

		model.addAttribute("roleBean", roleBean);

		if (result.hasErrors()) {
			return "NewRole";
		} else {
			roleDao.insertRole(roleBean);
			System.out.println(roleBean.getRoleName());
			System.out.println(roleBean.getRoleId());
		}
		return "redirect:/listrole";
	}
	
	@PostMapping("/updaterole")
	public String updateRole(@ModelAttribute("roleBean") @Valid RoleBean roleBean, BindingResult result,
			Model model) {

		model.addAttribute("roleBean", roleBean);

		if (result.hasErrors()) {
			return "NewRole";
		} else {
			roleDao.updateRole(roleBean);
			System.out.println(roleBean.getRoleId());
			System.out.println(roleBean.getRoleName());
			
		}
		return "redirect:/listrole";
	}

	@GetMapping("/listrole")
	public String listRole(Model model) {
		ArrayList<RoleBean> roles =  roleDao.listRole();
		model.addAttribute("roles",roles);
		return "ListRole";
	}
	
	@GetMapping("/deleterole/{id}")
	public String deleteRole(@PathVariable("id") int id) {

		roleDao.deleteRole(id);
		return "redirect:/listrole";
	}

}
