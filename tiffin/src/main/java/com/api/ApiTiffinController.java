package com.api;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.TiffinBean;
import com.dao.TiffinDao;

@RestController
public class ApiTiffinController {

	@Autowired
	TiffinDao tiffinDao;

	 

	@PostMapping("/api/addtiffin")
	public String addTiffin(@ModelAttribute("tiffinBean") @Valid TiffinBean tiffinBean, BindingResult result, Model model) {

		model.addAttribute("tiffinBean", tiffinBean);

		if (result.hasErrors()) {
			return "NewTiffin";
		} else {
			tiffinDao.insertTiffin(tiffinBean);
			System.out.println(tiffinBean.getTiffinName());
			System.out.println(tiffinBean.getTiffinDescription());
			System.out.println(tiffinBean.isTiffinActive());
		}
		//responsebean 
		return "redirect:/listtiffin";
	}

	
	//list tiffin 
	@GetMapping("/api/listtiffin")
	public ResponseBean<ArrayList<TiffinBean>> listTiffin() {
		
		ResponseBean<ArrayList<TiffinBean>> responseBean = new ResponseBean<>();
		ArrayList<TiffinBean> tiffins =  tiffinDao.listTiffin();
		responseBean.setData(tiffins);
		responseBean.setMsg("tifin retrvied");
		responseBean.setStatusCode(1);
		
		return responseBean;
	}
}

	

