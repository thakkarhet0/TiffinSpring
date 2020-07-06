package com.controller;


import java.util.ArrayList;
import java.util.List;

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
import com.bean.SubcategoryBean;
import com.dao.CategoryDao;
import com.dao.SubcategoryDao;

@Controller
public class SubcategoryController {

	@Autowired
	SubcategoryDao subcategoryDao;
	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/newsubcategory")
	public String callview(Model model) {
		SubcategoryBean subcategoryBean = new SubcategoryBean();
		model.addAttribute("subcategoryBean", subcategoryBean);
		System.out.println("newsubcategory");
		List<CategoryBean> categories = categoryDao.listCategory();
		model.addAttribute("categories", categories);
		return "NewSubcategory";
	}
	@GetMapping("/editsubcategory/{id}")
	public String callview(@PathVariable("id") int id, Model model) {
		SubcategoryBean subcategoryBean = subcategoryDao.getDataByPk(id);
		model.addAttribute("subcategoryBean", subcategoryBean);
		List<CategoryBean> categories = categoryDao.listCategory();
		model.addAttribute("categories", categories);
		return "EditSubcategory";
	}


	@PostMapping("/addsubcategory")
	public String addSubcategory(@ModelAttribute("subcategoryBean") @Valid SubcategoryBean subcategoryBean, BindingResult result, Model model) {

		model.addAttribute("subcategoryBean", subcategoryBean);

		if (result.hasErrors()) {
			return "NewSubcategory";
		} else {
			subcategoryDao.insertSubcategory(subcategoryBean);
			System.out.println(subcategoryBean.getSubcategoryName());
			System.out.println(subcategoryBean.getSubcategoryDescription());

		}
		return "redirect:/listsubcategory";
	}
	
	
	@PostMapping("/updatesubcategory")
	public String updateSubcategory(@ModelAttribute("subcategoryBean") @Valid SubcategoryBean subcategoryBean, BindingResult result,
			Model model) {

		model.addAttribute("subcategoryBean", subcategoryBean);

		if (result.hasErrors()) {
			return "NewSubcategory";
		} else {
			subcategoryDao.updateSubcategory(subcategoryBean);
			System.out.println(subcategoryBean.getSubcategoryId());
			System.out.println(subcategoryBean.getSubcategoryName());
			System.out.println(subcategoryBean.getSubcategoryDescription());
			System.out.println(subcategoryBean.getCategoryId());
		}
		return "redirect:/listsubcategory";
	}
	

	@GetMapping("/listsubcategory")
	public String listSubcategory(Model model) {
		ArrayList<SubcategoryBean> subcategorys =  subcategoryDao.listSubcategory();
		model.addAttribute("subcategorys",subcategorys);
		return "ListSubcategory";
	}
	@GetMapping("/deletesubcategory/{id}")
	public String deleteSubcategory(@PathVariable("id") int id) {

		subcategoryDao.deleteSubcategory(id);
		return "redirect:/listsubcategory";
	}


}
