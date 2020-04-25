package com.twoplus.apartfriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twoplus.apartfriend.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@ResponseBody
	@GetMapping("/test")
	public String getTest() {
		return testService.getTest();
	}
}
