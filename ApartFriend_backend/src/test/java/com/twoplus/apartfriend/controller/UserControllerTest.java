package com.twoplus.apartfriend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.twoplus.apartfriend.vo.UserVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@After
	@Rollback(true)
	public void cleanup() {
	}

	@Test
	public void getAuthUser() throws Exception {
	    UserVO authUser = new UserVO();
	    authUser.setUserId("skok1025");
		
		ResultActions resultActions = 
				mockMvc
				.perform(
						post("/api/user/auth").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(authUser)));
		System.out.println(resultActions);
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.message", is("로그인 성공")));
	}
	
	@Test
	public void inserUser() throws Exception {
		UserVO inserUser = new UserVO();
		inserUser.setUserId("skok0630");
		inserUser.setUnitNo("110-1502");
		inserUser.setName("김석현");
		inserUser.setPwd("1234");
		inserUser.setGender("M");
		inserUser.setPhoneNum("010-6866-9202");
		inserUser.setEmail("skok1025@naver.com");
		inserUser.setAddr("test addr");
		inserUser.setRoll(1);
		inserUser.setHeadHouse(1);
		inserUser.setUseFlag("1");
		inserUser.setSsn("9310214-2131242");
		
		ResultActions resultActions = 
				mockMvc
				.perform(
						post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(inserUser)));
		
		resultActions
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.message", is("회원가입 성공")));
	}


}
