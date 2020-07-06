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

import com.bean.DishBean;
import com.bean.TiffinBean;
import com.bean.TiffinBean;
import com.dao.TiffinDao;
@Controller
public class TiffinController {
	@Autowired
	TiffinDao tiffinDao;

	@GetMapping("/newtiffin")
	public String callview(Model model) {
		TiffinBean tiffinBean = new TiffinBean();
		model.addAttribute("tiffinBean", tiffinBean);
		System.out.println("newtiffin");
		return "NewTiffin";
	}
	
	@GetMapping("/edittiffin/{id}")
	public String callview(@PathVariable("id") int id, Model model) {
		TiffinBean tiffinBean = tiffinDao.getDataByPk(id);
		model.addAttribute("tiffinBean", tiffinBean);
		return "EditTiffin";
	}

	@PostMapping("/addtiffin")
	public String addTiffin(@ModelAttribute("tiffinBean") @Valid TiffinBean tiffinBean, BindingResult result, Model model) {

		model.addAttribute("tiffinBean", tiffinBean);

		if (result.hasErrors()) {
			return "NewTiffin";
		} else {
			tiffinDao.insertTiffin(tiffinBean);
			System.out.println(tiffinBean.getTiffinName());
			System.out.println(tiffinBean.getTiffinDescription());
			System.out.println(tiffinBean.getAmount());
			System.out.println(tiffinBean.isTiffinActive());
		}
		return "redirect:/listtiffin";
	}
	@PostMapping("/updatetiffin")
	public String updateTiffin(@ModelAttribute("tiffinBean") @Valid TiffinBean tiffinBean, BindingResult result,
			Model model) {

		model.addAttribute("tiffinBean", tiffinBean);

		if (result.hasErrors()) {
			return "NewTiffin";
		} else {
			tiffinDao.updateTiffin(tiffinBean);
			System.out.println(tiffinBean.getTiffinId());
			System.out.println(tiffinBean.getTiffinName());
			System.out.println(tiffinBean.getTiffinDescription());
			System.out.println(tiffinBean.getAmount());
			System.out.println(tiffinBean.isTiffinActive());
		}
		return "redirect:/listtiffin";
	}

	@GetMapping("/listtiffin")
	public String listTiffin(Model model) {
		ArrayList<TiffinBean> tiffins =  tiffinDao.listTiffin();
		model.addAttribute("tiffins",tiffins);
		return "ListTiffin";
	}
	@GetMapping("/deletetiffin/{id}")
	public String deleteTiffin(@PathVariable("id") int id) {

		tiffinDao.deleteTiffin(id);
		return "redirect:/listtiffin";
	}
}
