package com.twoplus.apartfriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twoplus.apartfriend.service.SampleService;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	@Autowired
	private SampleService service;
	
	@ResponseBody
	@GetMapping("/test")
	public String getTest() {
		return service.getTest();
	}

}
