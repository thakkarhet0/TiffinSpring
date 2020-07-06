package com.api;

import java.util.ArrayList;

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
import com.bean.ResponseBean;
import com.dao.CategoryDao;

@RestController
public class ApiCategoryController {
	
	@Autowired
	CategoryDao categoryDao;
	
	 
	@PostMapping("/api/addcategory")
	public CategoryBean addCategory(@ModelAttribute("categoryBean") @Valid CategoryBean categoryBean, BindingResult result,
			Model model) {

		model.addAttribute("categoryBean", categoryBean);

		if (result.hasErrors()) {
		//	return "NewCategory";
		} else {

			System.out.println(categoryBean.getCategoryName());
			System.out.println(categoryBean.isActive());
			categoryDao.insertCategory(categoryBean);
		}
		return categoryBean;
	}
	
	@PostMapping("/api/updatecategory")
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

	@GetMapping("/api/listcategory")
	public String listCategory(Model model) {
		ArrayList<CategoryBean> categories = categoryDao.listCategory();
		model.addAttribute("categories", categories);
		return "ListCategory";
	}

	@GetMapping("/api/deletecategory/{id}")
	public ResponseBean<ArrayList<CategoryBean>> deleteCategory(@PathVariable("id") int id) {

		ResponseBean<ArrayList<CategoryBean>> responseBean = new ResponseBean<>();
		categoryDao.deleteCategory(id);
		ArrayList<CategoryBean> categories = categoryDao.listCategory();		
		responseBean.setData(categories);
		responseBean.setMsg("category deleted");
		responseBean.setStatusCode(1);
		
		return responseBean;

	}

	
}
