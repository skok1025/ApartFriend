package com.twoplus.apartfriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.twoplus.apartfriend.service.UserService;
import com.twoplus.apartfriend.vo.UserVO;


/**
 * @author pkj
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	//모든 유저정보 get
	@GetMapping("/")
	public String getUserList() throws Exception {

		List<UserVO> userList = userService.getUserList();
		System.out.println("userLIst tostring ::: " + userList);
		return "test";
	}

	//회원가입
	@PostMapping("/addUser")
	public String addUser(UserVO userVO) throws Exception {

		userService.addUser(userVO);

		return null;
	}

}
