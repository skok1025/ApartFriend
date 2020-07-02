package com.twoplus.apartfriend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twoplus.apartfriend.util.NaverNewsUtil;
import com.twoplus.apartfriend.util.NaverSearchUtil;

@Controller
public class NaverTestController {

	@GetMapping("/naver/search")
	@ResponseBody
	public String naversearch() {
		return NaverSearchUtil.searchResult();
	}
	
	@GetMapping("/naver/news")
	@ResponseBody
	public String navernews() {
		String result =  NaverNewsUtil.response("성수동");
		
		return result;
	}
	
}
