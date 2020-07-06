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

import com.bean.DishBean;
import com.dao.DishDao;


@RestController
public class ApiDishCnotroller {
	
	
	@Autowired
	DishDao dishDao;

	@GetMapping("/api/newdish")
	public String callview(Model model) {
		DishBean dishBean = new DishBean();
		model.addAttribute("dishBean", dishBean);
		System.out.println("newdish");
		return "NewDish";
	}
	
	@GetMapping("/api/editdish/{id}")
	public String callview(@PathVariable("id") int id, Model model) {
		DishBean dishBean = dishDao.getDataByPk(id);
		model.addAttribute("dishBean", dishBean);
		return "EditDish";
	}

	
	@PostMapping("/api/adddish")
	public String addDish(@ModelAttribute("DishBean") @Valid DishBean dishBean, BindingResult result, Model model) {

		model.addAttribute("dishBean", dishBean);

		if (result.hasErrors()) {
			return "NewDish";
		} else {
			dishDao.insertDish(dishBean);
			System.out.println(dishBean.getDishId());
			System.out.println(dishBean.getDishName());
			System.out.println(dishBean.getDishDescription());
			System.out.println(dishBean.isDishactive());
		}
		return "redirect:/listdish";
	}
	
	@PostMapping("/api/updatedish")
	public String updateDish(@ModelAttribute("dishBean") @Valid DishBean dishBean, BindingResult result,
			Model model) {

		model.addAttribute("dishBean", dishBean);

		if (result.hasErrors()) {
			return "NewDish";
		} else {
			dishDao.updateDish(dishBean);
			System.out.println(dishBean.getDishId());
			System.out.println(dishBean.getDishName());
			System.out.println(dishBean.getDishDescription());
		}
		return "redirect:/listdish";
	}
	
	@GetMapping("/api/listdish")
	public String listRole(Model model) {
		ArrayList<DishBean> dishes =  dishDao.listDish();
		model.addAttribute("dishes",dishes);
		return "ListDish";
	}
	@GetMapping("/api/deletedish/{id}")
	public String deleteDish(@PathVariable("id") int id) {

		dishDao.deleteDish(id);
		return "redirect:/listdish";
	}
}
