package com.twoplus.apartfriend.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.catalina.User;
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
 * @author shkim
 *
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	String errMsg = "";
	int result = 0;
	
	@ApiOperation(value="로그인")
	@PostMapping("/auth")
	public ResponseEntity<JSONResult> getAuth(@RequestBody UserVO userVo) throws Exception {
		
		UserVO authUser = userService.getAuthUser(userVo);
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserVO>> validatorResults = validator.validateProperty(userVo, "userId");

		if (!validatorResults.isEmpty()) {
			for (ConstraintViolation<UserVO> validatorResult : validatorResults) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(JSONResult.fail(validatorResult.getMessage()));
			}
		}

		return authUser != null ? ResponseEntity.status(HttpStatus.OK).body(JSONResult.success("로그인 성공", authUser))
				: ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("로그인 실패"));
	}

}
