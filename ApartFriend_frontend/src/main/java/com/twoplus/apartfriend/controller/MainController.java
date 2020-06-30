package com.twoplus.apartfriend.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.twoplus.apartfriend.security.SecurityUser;
import com.twoplus.apartfriend.util.NaverLoginUtil;

@Controller
public class MainController {

	@GetMapping("/login")
	public String getTest(Model model, HttpSession session) {
		String naverLoginApiURL = NaverLoginUtil.getLoginApiUrl(session, "http://localhost:8081/naverlogin/callback");
		model.addAttribute("naverLoginApiURL", naverLoginApiURL);
		return "index/login";
	}

	@GetMapping("/naverlogin/callback")
	@ResponseBody
	public String naverCallback(String code, String state) {
		String response = NaverLoginUtil.getResponse(code, state, "http://localhost:8081/naverlogin/callback");

		//JSONObject jObject = new JSONObject(response);
	    //String access_token = jObject.getString("title");
		return response;
	}

	@GetMapping("/index")
	@ResponseBody
	public String index(@AuthenticationPrincipal SecurityUser user) {
		return user.getName();
	}
}
