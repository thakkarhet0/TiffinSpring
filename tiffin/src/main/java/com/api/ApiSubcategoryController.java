package com.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CategoryBean;
import com.bean.SubcategoryBean;
import com.dao.CategoryDao;
import com.dao.SubcategoryDao;

@RestController
public class ApiSubcategoryController {
	
	@Autowired
	SubcategoryDao subcategoryDao;
	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/api/newsubcategory")
	public String callview(Model model) {
		SubcategoryBean subcategoryBean = new SubcategoryBean();
		model.addAttribute("subcategoryBean", subcategoryBean);
		System.out.println("newsubcategory");
		List<CategoryBean> categories = categoryDao.listCategory();
		model.addAttribute("categories", categories);
		return "NewSubcategory";
	}
	@GetMapping("/api/editsubcategory/{id}")
	public String callview(@PathVariable("id") int id, Model model) {
		SubcategoryBean subcategoryBean = subcategoryDao.getDataByPk(id);
		model.addAttribute("subcategoryBean", subcategoryBean);
		List<CategoryBean> categories = categoryDao.listCategory();
		model.addAttribute("categories", categories);
		return "EditSubcategory";
	}


	@PostMapping("/api/addsubcategory")
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
	
	
	@PostMapping("/api/updatesubcategory")
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
	

	@GetMapping("/api/listsubcategory")
	public String listSubcategory(Model model) {
		ArrayList<SubcategoryBean> subcategorys =  subcategoryDao.listSubcategory();
		model.addAttribute("subcategorys",subcategorys);
		return "ListSubcategory";
	}
	@GetMapping("/api/deletesubcategory/{id}")
	public String deleteSubcategory(@PathVariable("id") int id) {

		subcategoryDao.deleteSubcategory(id);
		return "redirect:/listsubcategory";
	}


}
