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

import com.bean.UserBean;
import com.bean.OrderBean;
import com.dao.OrderDao;
import com.dao.UserDao;

@Controller
public class OrderController {

	@Autowired
	OrderDao orderDao;

	@GetMapping("/neworder")
	public String callview(Model model) {
		OrderBean orderBean = new OrderBean();
		model.addAttribute("orderBean", orderBean);
		System.out.println("neworder");
		return "NewOrder";
	}
	
	@GetMapping("/editorder/{id}")
	public String callview(@PathVariable("id") int id, Model model) {
		OrderBean orderBean = orderDao.getDataByPk(id);
		model.addAttribute("orderBean", orderBean);
	//	List<UserBean> users = userDao.listUser();
		//model.addAttribute("users", users);
		return "EditOrder";
	}

	@PostMapping("/addorder")
	public String addOrder(@ModelAttribute("orderBean") @Valid OrderBean orderBean, BindingResult result, Model model) {

		model.addAttribute("orderBean", orderBean);

		if (result.hasErrors()) {
			return "NewOrder";
		} else {
			orderDao.insertOrder(orderBean);
			System.out.println(orderBean.getOrderName());
			System.out.println(orderBean.getOrderDescription());
			System.out.println(orderBean.getOrderStatus());
		}
		return "redirect:/listorder";
	}
	
	@PostMapping("/updateorder")
	public String updateOrder(@ModelAttribute("orderBean") @Valid OrderBean orderBean, BindingResult result,
			Model model) {

		model.addAttribute("orderBean", orderBean);

		if (result.hasErrors()) {
			return "NewOrder";
		} else {
			orderDao.updateOrder(orderBean);
			System.out.println(orderBean.getOrderId());
			System.out.println(orderBean.getOrderName());
			System.out.println(orderBean.getOrderDescription());
			System.out.println(orderBean.getUserId());
		}
		return "redirect:/listorder";
	}
	

	@GetMapping("/listorder")
	public String listOrder(Model model) {
		ArrayList<OrderBean> orders =  orderDao.listOrder();
		model.addAttribute("orders",orders);
		return "OrderList";
	}
	
	@GetMapping("/deleteorder/{id}")
	public String deleteOrder(@PathVariable("id") int id) {

		orderDao.deleteOrder(id);
		return "redirect:/listorder";
	}

}
