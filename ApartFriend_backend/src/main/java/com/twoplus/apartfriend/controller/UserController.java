package com.twoplus.apartfriend.controller;

import java.util.List;import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twoplus.apartfriend.dto.JSONResult;
import com.twoplus.apartfriend.service.UserService;
import com.twoplus.apartfriend.vo.UserVO;

import io.swagger.annotations.ApiOperation;


/**
 * @author pkj
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	String errMsg = "";
	int result = 0;
	
	//모든 유저정보 geta
	@ApiOperation(value="모든 유저정보 리스트")
	@GetMapping("/userList")
	public ResponseEntity<JSONResult> userList() throws Exception {

		List<UserVO> userList = null;
		 errMsg = "";

		try {
			userList = userService.getUserList();
		} catch (Exception e) {
			errMsg = "오류발생";
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail(errMsg));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("유저리스트정보조회 성공", userList));
	}
	@ApiOperation(value="회원가입")
	//회원가입
	@PostMapping("/addUser")
	public ResponseEntity<JSONResult> addUser(@RequestBody UserVO userVO) throws Exception {
		
		try {
			
			result = userService.addUser(userVO);

		} catch (Exception e) {
			errMsg = "오류발생";
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail(errMsg));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("회원가입 성공", result));
		
	}
	@ApiOperation(value="회원정보 수정")
	//회원정보 수정
	@PostMapping("/updateUser")
	public ResponseEntity<JSONResult> updateUser(@RequestBody UserVO userVO) throws Exception {
		System.out.println("userVO check1 ::: " + userVO);
		try {
			result = userService.updateUser(userVO);
			System.out.println("result check ::: " + result);
			System.out.println("userVO check2 ::: " + userVO);
		} catch (Exception e) {
			errMsg = "오류발생";
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail(errMsg));
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("회원수정 성공", result));
	}
	@ApiOperation(value="회원삭제")
	//회원삭제
	@PostMapping("/deleteUser")
	public ResponseEntity<JSONResult> deleteUser(@RequestBody UserVO userVO) throws Exception {
		try {
			result = userService.deleteUser(userVO);
		} catch (Exception e) {
			errMsg = "오류발생";
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail(errMsg));
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("회원삭제 성공", result));
	}
	
	
	

}
