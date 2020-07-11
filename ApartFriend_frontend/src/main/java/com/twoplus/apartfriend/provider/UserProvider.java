package com.twoplus.apartfriend.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.twoplus.apartfriend.dto.JSONResult;
import com.twoplus.apartfriend.vo.UserVO;

@Repository
public class UserProvider {
	

	@Autowired
	RestTemplateBuilder restTemplateBuilder;

	public UserVO getAuth(String username) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		UserVO vo = new UserVO();
		vo.setUserId(username);
		
		JSONResultUser jsonresult = restTemplate.postForObject("http://localhost:8080/api/user/auth",vo,
				JSONResultUser.class);
		return jsonresult.getData();
	}
	
	public Integer insertUser(UserVO userVo) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		JSONResultInteger jsonresult = restTemplate.postForObject("http://localhost:8080/api/user/join",userVo,
				JSONResultInteger.class);
		return jsonresult.getData();
	}

	
	private static class JSONResultUser extends JSONResult<UserVO> {
	}
	
	private static class JSONResultInteger extends JSONResult<Integer> {
	}


}
