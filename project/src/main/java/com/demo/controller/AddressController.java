package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;

	public AddressController() {
	}

	@RequestMapping("/deleteAddress")
	public String toDelete(@RequestParam int id) {
		System.out.println(id+"-----");
		int deleteAddress = addressService.deleteAddress(id);

		return "redirect:/getOrderItem";

	}

}
