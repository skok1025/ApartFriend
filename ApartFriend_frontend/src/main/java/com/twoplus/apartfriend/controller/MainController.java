package com.twoplus.apartfriend.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twoplus.apartfriend.security.SecurityUser;


@Controller
public class MainController {

	@GetMapping("/login")
	public String getTest() {
		return "index/login";
	}
	
	@GetMapping("/index")
	@ResponseBody
	public String index(@AuthenticationPrincipal SecurityUser user) {
		return user.getName();
	}
}
