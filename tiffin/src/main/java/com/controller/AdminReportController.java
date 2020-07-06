package com.controller;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.TiffinBean;
import com.dao.AdminReportDao;

@Controller
public class AdminReportController {

	@Autowired
	AdminReportDao dao;

	@GetMapping("/listtiffins")
	public String listtiffins(Model model) {

		ArrayList<TiffinBean> tiffins = dao.getTiffins();
		System.out.println("total tiffin "+tiffins.size());
		model.addAttribute("tiffins",tiffins);
		return "AdminReportTiffin";

	}

	// listrder
	// listpastorders
	// listusers

}
