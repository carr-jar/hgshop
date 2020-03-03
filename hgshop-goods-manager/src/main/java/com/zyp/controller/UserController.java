package com.zyp.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyp.bean.User;
import com.zyp.service.UserService;

@Controller
public class UserController {
	
	
	@Reference(timeout=2000,version="1.0.0")
	UserService userService;
	
	
	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("login")
	public String login(String name,String password ) {
		User user = userService.login(name, password);
		if(user!=null)
			return "redirect:/";
		else {
			return "login";
		}
	}

}
