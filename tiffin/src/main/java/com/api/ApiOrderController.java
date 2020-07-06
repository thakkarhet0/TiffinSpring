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

import com.bean.OrderBean;
import com.dao.OrderDao;

@RestController
public class ApiOrderController {
	@Autowired
	OrderDao orderDao;

	@PostMapping("/api/addorder")
	public OrderBean addOrder(@ModelAttribute("orderBean") @Valid OrderBean orderBean, BindingResult result,
			Model model) {

		model.addAttribute("orderBean", orderBean);

		orderBean.setOrderId(orderDao.insertOrder(orderBean));
		System.out.println(orderBean.getOrderName());
		System.out.println(orderBean.getOrderDescription());
		System.out.println(orderBean.getOrderStatus());
		return orderBean;
	}

	
	//appi -- orderid status
	@PostMapping("/api/updateorder")
	public String updateOrder(@ModelAttribute("orderBean") @Valid OrderBean orderBean, BindingResult result,
			Model model) {

		model.addAttribute("orderBean", orderBean);

		if (result.hasErrors()) {
			return "NewOrder";
		} else {
			orderDao.updateOrder(orderBean);

		}
		return "redirect";
	}

	@GetMapping("/api/listorder")
	public String listOrder(Model model) {
		ArrayList<OrderBean> orders = orderDao.listOrder();
		model.addAttribute("orders", orders);
		return "OrderList";
	}

	@GetMapping("/api/deleteorder/{id}")
	public String deleteOrder(@PathVariable("id") int id) {

		orderDao.deleteOrder(id);
		return "redirect";
	}

}
