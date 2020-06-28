package com.twoplus.apartfriend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twoplus.apartfriend.dto.JSONResult;
import com.twoplus.apartfriend.service.SampleService;
import com.twoplus.apartfriend.vo.TestVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


//@RestController("AdminAPIController")
//@RequestMapping("/api/test")
public class SampleController {

	@Autowired
	private SampleService testService;
	
	@ApiOperation(value = "샘플 backend API 명")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "testvo", value = "test 를 위한 vo", required = true, dataType = "TestVo", defaultValue = "") 
	})
	@GetMapping("/test")
	public ResponseEntity<JSONResult> getTest(/*@Valid */TestVo testvo) {
		String testString = testService.getTest(); 
		System.out.println("check ::");
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("success_test_message", testString));
	}
}