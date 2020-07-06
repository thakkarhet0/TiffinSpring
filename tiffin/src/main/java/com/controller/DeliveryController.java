package com.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.DeliveryBean;
import com.dao.DeliveryDao;

@Controller
public class DeliveryController {

	@Autowired
	DeliveryDao deliveryDao;

	@GetMapping("/newdelivery")
	public String callview(Model model) {
		DeliveryBean deliveryBean = new DeliveryBean();
		model.addAttribute("deliveryBean", deliveryBean);
		System.out.println("newdelivery");
		return "NewDelivery";
	}

	@PostMapping("/adddelivery")
	public String addDelivery(@ModelAttribute("deliveryBean") @Valid DeliveryBean deliveryBean, BindingResult result, Model model) {

		model.addAttribute("deliveryBean", deliveryBean);

		if (result.hasErrors()) {
			return "NewDelivery";
		} else {
			deliveryDao.insertDelivery(deliveryBean);
			System.out.println(deliveryBean.getDeliveryName());
			System.out.println(deliveryBean.getDeliveryStatus());

		}
		return "redirect:/listdelivery";
	}

	@GetMapping("/listdelivery")
	public String listDelivery(Model model) {
		ArrayList<DeliveryBean> deliverys =  deliveryDao.listDelivery();
		model.addAttribute("deliverys",deliverys);
		return "DeliveryList";
	}

}

