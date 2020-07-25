package com.twoplus.apartfriend.controller;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.twoplus.apartfriend.dto.NaverLoginTokenDTO;
import com.twoplus.apartfriend.dto.NaverProfileDTO;
import com.twoplus.apartfriend.security.SecurityUser;
import com.twoplus.apartfriend.service.UserService;
import com.twoplus.apartfriend.util.NaverLoginUtil;
import com.twoplus.apartfriend.vo.UserVO;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String getTest(Model model, HttpSession session) {
		String naverLoginApiURL = NaverLoginUtil.getLoginApiUrl(session, "http://localhost:8081/naverlogin/callback");
		naverLoginApiURL = "javascript:alert('준비중입니다.');"; // 네이버로그인 비활성화
		model.addAttribute("naverLoginApiURL", naverLoginApiURL);
		return "index/login";
	}

	@GetMapping("/naverlogin/callback")
	//@ResponseBody
	public String naverCallback(String code, String state, Model model) {
		NaverLoginTokenDTO response = NaverLoginUtil.getResponse(code, state, "http://localhost:8081/naverlogin/callback");
		
		// 프로필 가져오기
		NaverProfileDTO naverprofile= NaverLoginUtil.getProfile(response);
		
		boolean isFirstTimeAccess = true;
		
		if (isFirstTimeAccess == true) {
			model.addAttribute("naverprofile", naverprofile);
			return "index/first_naver";
		} else {
			// naver email 이 t_user 테이블 상에 id 로 존재하는 경우			
		}
	
		return naverprofile.toString();
	}
	
	@PostMapping("/naverjoin")
	@ResponseBody
	public String join(UserVO userVo/*, @AuthenticationPrincipal SecurityUser user*/) {
		System.out.println(userVo);
		userVo.setUserId(userVo.getEmail());
		Integer result = userService.inserUser(userVo);
		
		return result.toString();
		/*
	
		int result = userService.inserUser(userVo);
		System.out.println(result);
		if (result == 1) { // 회원가입 성공
//			user.setId(email);
//			user.setEmail(email);
//			user.setGender(gender);
//			user.setUnitNo(unitNo);
//			return user.toString();
			return "naver join success";
		} else { 
			return "naver join fail";
		}*/
	}

	@GetMapping("/index")
	@ResponseBody
	public String index(@AuthenticationPrincipal SecurityUser user) {
		return user.toString();
	}
}
