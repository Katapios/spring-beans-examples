package com.katapios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	@RequestMapping("/loginfail")
	public String loginFail(Model uiModel) {
		System.out.println("login failed");
		return "courses/list";
	}

}
