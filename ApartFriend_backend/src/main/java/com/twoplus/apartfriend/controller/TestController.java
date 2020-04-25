package com.twoplus.apartfriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twoplus.apartfriend.dto.JSONResult;
import com.twoplus.apartfriend.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@ResponseBody
	@GetMapping("/test")
	public ResponseEntity<JSONResult> getTest() {
		String testString = testService.getTest(); // test01
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success_test_message", testString));
	}
}
