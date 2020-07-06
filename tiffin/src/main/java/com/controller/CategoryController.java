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

import com.bean.CategoryBean;
import com.dao.CategoryDao;

@Controller
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/newcategory")
	public String callview(Model model) {
		CategoryBean categoryBean = new CategoryBean();
		model.addAttribute("categoryBean", categoryBean);
		System.out.println("newcategory");
		return "NewCategory";
	}

	@GetMapping("/editcategory/{id}")
	public String callview(@PathVariable("id") int id, Model model) {
		CategoryBean categoryBean = categoryDao.getDataByPk(id);
		model.addAttribute("categoryBean", categoryBean);
		return "EditCategory";
	}

	@PostMapping("/addcategory")
	public String addCategory(@ModelAttribute("categoryBean") @Valid CategoryBean categoryBean, BindingResult result,
			Model model) {

		model.addAttribute("categoryBean", categoryBean);

		if (result.hasErrors()) {
			return "NewCategory";
		} else {

			System.out.println(categoryBean.getCategoryName());
			System.out.println(categoryBean.isActive());
			categoryDao.insertCategory(categoryBean);
		}
		return "redirect:/listcategory";
	}

	@PostMapping("/updatecategory")
	public String updateCategory(@ModelAttribute("categoryBean") @Valid CategoryBean categoryBean, BindingResult result,
			Model model) {

		model.addAttribute("categoryBean", categoryBean);

		if (result.hasErrors()) {
			return "NewCategory";
		} else {
			categoryDao.updateCategory(categoryBean);
			System.out.println(categoryBean.getCategoryName());
			System.out.println(categoryBean.isActive());
		}
		return "redirect:/listcategory";
	}

	@GetMapping("/listcategory")
	public String listCategory(Model model) {
		ArrayList<CategoryBean> categories = categoryDao.listCategory();
		model.addAttribute("categories", categories);
		return "ListCategory";
	}

	@GetMapping("/deletecategory/{id}")
	public String deleteCategory(@PathVariable("id") int id) {

		categoryDao.deleteCategory(id);
		return "redirect:/listcategory";
	}

}
